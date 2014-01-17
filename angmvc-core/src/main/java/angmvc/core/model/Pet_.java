package angmvc.core.model;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Pet.class)
public class Pet_ {
  public static volatile SingularAttribute<Pet, Long> id;
  public static volatile SingularAttribute<Pet, String> name;
  public static volatile SingularAttribute<Pet, Date> birthDate;
  public static volatile SingularAttribute<Pet, Long> ownerId;
  public static volatile SingularAttribute<Pet, Owner> owner;
  public static volatile SingularAttribute<Pet, Long> petTypeId;
  public static volatile SingularAttribute<Pet, PetType> petType;
  public static volatile SetAttribute<Pet, Visit> visits;
}
