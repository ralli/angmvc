package angmvc.core.models;

import java.io.Serializable;
import java.util.List;

public class OwnerInfo implements Serializable {
  private Long id;
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String telephone;
  private List<String> petNames;

  public OwnerInfo(Long id, String firstName, String lastName, String address, String city, String telephone, List<String> petNames) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.telephone = telephone;
    this.petNames = petNames;
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

  public List<String> getPetNames() {
    return petNames;
  }

  @Override
  public String toString() {
    return "OwnerInfo{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", telephone='" + telephone + '\'' +
            ", petNames=" + petNames +
            '}';
  }
}
