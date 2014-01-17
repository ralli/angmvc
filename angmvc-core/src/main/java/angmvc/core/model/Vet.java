package angmvc.core.model;


import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vets")
public class Vet implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id = null;

  @Column(name = "first_name", length = 30)
  @Size(min = 1, max = 30)
  private String firstName;

  @Column(name = "last_name", length = 30)
  @Size(min = 1, max = 30)
  private String lastName;

  @ManyToMany
  @JoinTable(name = "vet_specialties",
          joinColumns = {@JoinColumn(name = "vet_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "specialty_id", referencedColumnName = "id")})
  private Set<Specialty> specialties;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }


  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null) {
      return false;
    }
    if (getClass() != that.getClass()) {
      return false;
    }
    if (id != null) {
      return id.equals(((Vet) that).id);
    }
    return super.equals(that);
  }

  @Override
  public int hashCode() {
    if (id != null) {
      return id.hashCode();
    }
    return super.hashCode();
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public List<Specialty> getSpecialties() {
    return new ArrayList<>(specialties);
  }

  @Transient
  public String getSpecialtiesString() {
    List<String> names = new ArrayList<>();
    for(Specialty specialty : getSpecialties())
      names.add(specialty.getName());
    return StringUtils.join(names, ", ");
  }

  @Override
  public String toString() {
    String result = getClass().getSimpleName() + " ";
    if (firstName != null && !firstName.trim().isEmpty())
      result += "firstName: " + firstName;
    if (lastName != null && !lastName.trim().isEmpty())
      result += ", lastName: " + lastName;
    return result;
  }
}
