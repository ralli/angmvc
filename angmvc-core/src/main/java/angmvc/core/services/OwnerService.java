package angmvc.core.services;

import angmvc.core.models.OwnerData;
import angmvc.core.models.OwnerInfo;

import java.util.List;

public interface OwnerService {
  /**
   * Returns a list of owners with matching last name.
   *
   * @param lastName
   *            the pattern to match like in a SQL-Like clause
   * @return the list of matching owners
   */
  List<OwnerInfo> findOwnersByName(String lastName);

  /**
   * Finds an owner by its id
   * @param id the id of the owner
   * @return the owner found or <code>null</code> of no owner was found
   */
  OwnerData findById(long id);
}
