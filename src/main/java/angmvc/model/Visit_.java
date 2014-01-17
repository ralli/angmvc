package angmvc.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Visit.class)
public class Visit_ {
  public static volatile SingularAttribute<Visit, Long> id;
  public static volatile SingularAttribute<Visit, Date> visitDate;
  public static volatile SingularAttribute<Visit, String> description;
  public static volatile SingularAttribute<Visit, Pet> pet;
  public static volatile SingularAttribute<Visit, Long> petId;
}
