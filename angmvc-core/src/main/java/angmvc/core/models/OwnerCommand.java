package angmvc.core.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class OwnerCommand implements Serializable {
  @NotBlank
  @Size(max = 30)
  private String firstName;
  @NotBlank
  @Size(max = 30)
  private String lastName;
  @NotBlank
  @Size(max = 255)
  private String address;
  @NotBlank
  @Size(max = 80)
  private String city;
  @NotBlank
  @Size(max = 30)
  private String telephone;

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
}
