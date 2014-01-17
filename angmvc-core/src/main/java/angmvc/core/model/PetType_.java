package angmvc.core.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PetType.class)
public class PetType_ {
  public static volatile SingularAttribute<PetType, Long> id;
  public static volatile SingularAttribute<PetType, String> name;
}
