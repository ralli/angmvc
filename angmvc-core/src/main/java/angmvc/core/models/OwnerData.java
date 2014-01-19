package angmvc.core.models;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class OwnerData implements Serializable {
  private Long id;
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String telephone;
  private List<PetData> pets;

  public OwnerData(Long id, String firstName, String lastName, String address, String city, String telephone, List<PetData> pets) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.telephone = telephone;
    this.pets = pets;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public String getTelephone() {
    return telephone;
  }

  public List<PetData> getPets() {
    return Collections.unmodifiableList(pets);
  }

  @Override
  public String toString() {
    return "OwnerData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", telephone='" + telephone + '\'' +
            '}';
  }
}
