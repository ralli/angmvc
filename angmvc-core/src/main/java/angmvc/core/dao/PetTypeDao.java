package angmvc.core.dao;

import java.util.List;

import angmvc.core.entities.PetType;

public interface PetTypeDao {
    /**
     * Returns a list of all pet types
     * 
     * @return the list of all pet types
     */
    List<PetType> findAll();

    /**
     * reads a pet type from the database
     * 
     * @param id
     *            the pet types id
     * @return the pet type read or <code>null</code> if no pet type has been
     *         found
     */
    PetType findById(long id);

    /**
     * inserts a new pet type into the database
     * 
     * @param petType
     *            the pettype to be inserted
     */
    void insert(PetType petType);

    /**
     * updates an existing pet type
     * 
     * @param petType
     *            the pet type to be updated
     */
    void update(PetType petType);

    /**
     * deletes a pet type from the database
     * 
     * @param petType
     *            the pet type to be deleted
     */
    void delete(PetType petType);
}
