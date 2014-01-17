package angmvc.dao;

import java.util.List;

import angmvc.model.Pet;

public interface PetDao {
    /**
     * Returns the list of all pets of a given Owner
     * 
     * @param ownerId
     *            the owners id
     * @return the owners pets
     */
    public List<Pet> findByOwner(long ownerId);

    /**
     * Loads a pet with a given id
     * 
     * @param id
     *            the pets id
     * @return the pet or <code>null</code> if no matching pat has been found
     */
    public Pet findById(long id);

    /**
     * Saves a new pet to the database
     * 
     * @param pet
     *            the pet to be saved
     */
    public void insert(Pet pet);

    /**
     * Updates an existing pet in the database
     * 
     * @param pet
     *            the pet to be updated
     */
    public void update(Pet pet);

    /**
     * Deletes a pet
     * 
     * @param pet
     *            the pet to be deleted
     */
    public void delete(Pet pet);
}
