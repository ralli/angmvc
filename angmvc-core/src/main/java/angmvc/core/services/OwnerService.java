package angmvc.core.services;

import angmvc.core.models.*;

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

  /**
   * Creates a new owner
   * @param ownerCommand The Data of the owner to be created
   * @return the created owner
   */
  CreateOwnerResponse createOwner(OwnerCommand ownerCommand);

  /**
   * Updates an existing owner
   * @param id the ID of the owner to be updated
   * @param ownerCommand the owners data
   * @return a Repsonse indicating possible errors upon updating
   */
  BasicResponse updateOwner(Long id, OwnerCommand ownerCommand);

    /**
     * Deletes an existing owner
     * @param id the id of the owner to be deleted
     * @return a Repsonse indicating possible errors upon updating
     */
  BasicResponse deleteOwner(Long id);
}
