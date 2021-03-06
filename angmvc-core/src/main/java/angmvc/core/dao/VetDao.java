package angmvc.core.dao;

import angmvc.core.entities.Vet;

import java.util.List;

public interface VetDao {
    /**
     * Loads all Vets from the DB
     * 
     * @return the List of all vets
     */
    List<Vet> findAll();

    /**
     * Loads a single vet
     * 
     * @param id
     *            the vets primary key
     * @return the loaded vet or <code>null</code> if no matching vet was found
     */

    Vet findById(long id);
}
