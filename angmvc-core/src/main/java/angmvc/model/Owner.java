package angmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name", length = 30)
  @NotNull
  @Size(min = 1, max = 30)
  private String firstName;

  @Column(name = "last_name", length = 30)
  @NotNull
  @Size(min = 1, max = 30)
  private String lastName;

  @Column(length = 255)
  @NotNull
  @Size(min = 1, max = 255)
  private String address;

  @Column(length = 80)
  @NotNull
  @Size(min = 1, max = 80)
  private String city;

  @Column(length = 30)
  @NotNull
  @Size(min = 1, max = 30)
  private String telephone;

  @OneToMany(mappedBy = "owner")
  private Set<Pet> pets;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public List<Pet> getPets() {
    return new ArrayList<>(pets);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Owner owner = (Owner) o;

    if (address != null ? !address.equals(owner.address) : owner.address != null) return false;
    if (city != null ? !city.equals(owner.city) : owner.city != null) return false;
    if (firstName != null ? !firstName.equals(owner.firstName) : owner.firstName != null) return false;
    if (id != null ? !id.equals(owner.id) : owner.id != null) return false;
    if (lastName != null ? !lastName.equals(owner.lastName) : owner.lastName != null) return false;
    if (telephone != null ? !telephone.equals(owner.telephone) : owner.telephone != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (city != null ? city.hashCode() : 0);
    result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Owner{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", telephone='" + telephone + '\'' +
            '}';
  }
}
