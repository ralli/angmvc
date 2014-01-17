package angmvc.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Specialty.class)
public class Specialty_ {
  public static volatile SingularAttribute<Specialty, Long> id;
  public static volatile SingularAttribute<Specialty, String> name;
}
