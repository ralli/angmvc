package angmvc.core.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="pets")
public class Pet implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 30)
  @NotNull
  @Size(min=1, max=30)
  private String name;
  @Temporal(TemporalType.DATE)
  @Column(name="birth_date")
  private Date birthDate;
  @Column(name="owner_id")
  private long ownerId;
  @ManyToOne
  @JoinColumn(name="owner_id", insertable = false, updatable = false)
  private Owner owner;
  @Column(name="type_id")
  private long petTypeId;
  @ManyToOne
  @JoinColumn(name="type_id", referencedColumnName = "id", insertable = false, updatable = false)
  private PetType petType;

  @OneToMany(mappedBy = "pet")
  private Set<Visit> visits;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PetType getPetType() {
    return petType;
  }

  public void setPetType(PetType petType) {
    this.petType = petType;
    this.petTypeId = petType != null ? petType.getId() : 0;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(long ownerId) {
    this.ownerId = ownerId;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public long getPetTypeId() {
    return petTypeId;
  }

  public void setPetTypeId(long petTypeId) {
    this.petTypeId = petTypeId;
  }

  public void setVisits(Set<Visit> visits) {
    this.visits = visits;
  }

  public List<Visit> getVisits() {
    return new ArrayList<>(visits);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pet pet = (Pet) o;

    if (ownerId != pet.ownerId) return false;
    if (petTypeId != pet.petTypeId) return false;
    if (birthDate != null ? !birthDate.equals(pet.birthDate) : pet.birthDate != null) return false;
    if (id != null ? !id.equals(pet.id) : pet.id != null) return false;
    if (name != null ? !name.equals(pet.name) : pet.name != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
    result = 31 * result + (int) (ownerId ^ (ownerId >>> 32));
    result = 31 * result + (int) (petTypeId ^ (petTypeId >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "Pet{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", birthDate=" + birthDate +
            ", ownerId=" + ownerId +
            ", petTypeId=" + petTypeId +
            '}';
  }
}
