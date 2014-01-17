package angmvc.core.model;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Vet.class)
public class Vet_ {
  public static volatile SingularAttribute<Vet, Long> id;
  public static volatile SingularAttribute<Vet, String> firstName;
  public static volatile SingularAttribute<Vet, String> lastName;
  public static volatile SetAttribute<Vet, Specialty> specialties;
}
