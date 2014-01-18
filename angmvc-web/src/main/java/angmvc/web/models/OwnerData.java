package angmvc.web.models;

import java.io.Serializable;

public class OwnerData implements Serializable {
  private Long id;
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String telephone;

  public OwnerData(Long id, String firstName, String lastName, String address, String city, String telephone) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.telephone = telephone;
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
