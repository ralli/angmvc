package angmvc.core.dao;

import java.util.List;

import angmvc.core.entities.Owner;

public interface OwnerDao {
    /**
     * Returns a list of owners with matching last name.
     * 
     * @param lastName
     *            the pattern to match like in a SQL-Like clause
     * @return the list of matching owners
     */
    public List<Owner> findByLastName(String lastName);

    /**
     * loads an owner by its primary key.
     * 
     * @param id
     *            the owners id
     * @return the owner or <code>null</code> if no matching owner has been
     *         found
     */
    public Owner findById(long id);

    /**
     * saves a new owner in the database
     * 
     * @param owner
     *            the owner to be saved
     */
    public void insert(Owner owner);

    /**
     * updates an existing owner
     * 
     * @param owner
     *            the owner to save
     */
    public void update(Owner owner);

    /**
     * deletes an owner
     * 
     * @param owner
     *            the owner to be deleted
     */
    public void delete(Owner owner);
}
