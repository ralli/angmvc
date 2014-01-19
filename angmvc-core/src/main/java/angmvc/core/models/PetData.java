package angmvc.core.models;

import angmvc.core.entities.PetType;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class PetData implements Serializable {
  private Long id;
  private String name;
  private Date birthDate;
  private PetType petType;
  private List<VisitData> visits;

  public PetData(Long id, String name, Date birthDate, PetType petType, List<VisitData> visits) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
    this.petType = petType;
    this.visits = visits;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public PetType getPetType() {
    return petType;
  }

  public List<VisitData> getVisits() {
    return Collections.unmodifiableList(visits);
  }

  @Override
  public String toString() {
    return "PetData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", birthDate=" + birthDate +
            ", petType=" + petType +
            ", visits=" + visits +
            '}';
  }
}
