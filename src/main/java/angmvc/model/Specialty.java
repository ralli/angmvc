package angmvc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="specialties")
public class Specialty implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Specialty specialty = (Specialty) o;

    if (id != null ? !id.equals(specialty.id) : specialty.id != null) return false;
    if (name != null ? !name.equals(specialty.name) : specialty.name != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Specialty{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
