package angmvc.core.entities;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Owner.class)
public class Owner_ {
  public static volatile SingularAttribute<Owner, Long> id;
  public static volatile SingularAttribute<Owner, String> firstName;
  public static volatile SingularAttribute<Owner, String> lastName;
  public static volatile SingularAttribute<Owner, String> address;
  public static volatile SingularAttribute<Owner, String> city;
  public static volatile SingularAttribute<Owner, String> telephone;
  public static volatile SetAttribute<Owner, Pet> pets;
}
