package angmvc.core.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "visits")
public class Visit implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Temporal(TemporalType.DATE)
  @Column(name="visit_date", nullable = false)
  @NotNull
  private Date visitDate;

  @Column(nullable = false, length = 255)
  @NotNull
  @Size(min=1, max=255)
  private String description;

  @ManyToOne
  @JoinColumn(name="pet_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Pet pet;

  @Column(name = "pet_id")
  @NotNull
  private Long petId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getVisitDate() {
    return visitDate;
  }

  public void setVisitDate(Date visitDate) {
    this.visitDate = visitDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

  public Long getPetId() {
    return petId;
  }

  public void setPetId(Long petId) {
    this.petId = petId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Visit visit = (Visit) o;

    if (description != null ? !description.equals(visit.description) : visit.description != null) return false;
    if (id != null ? !id.equals(visit.id) : visit.id != null) return false;
    if (pet != null ? !pet.equals(visit.pet) : visit.pet != null) return false;
    if (visitDate != null ? !visitDate.equals(visit.visitDate) : visit.visitDate != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (visitDate != null ? visitDate.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (pet != null ? pet.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Visit{" +
            "id=" + id +
            ", visitDate=" + visitDate +
            ", description='" + description + '\'' +
            ", petId=" + getPetId() +
            '}';
  }
}
