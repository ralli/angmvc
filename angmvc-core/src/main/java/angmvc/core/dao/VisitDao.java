package angmvc.core.dao;

import angmvc.core.entities.Visit;

import java.util.List;

public interface VisitDao {
  /**
   * Returns a list of all Vet Visits of a given Pet
   *
   * @param petId the id of the pet
   * @return the list of visits ordered by their visit date
   */
  List<Visit> findByPet(long petId);

  /**
   * Loads a visit with a given id
   *
   * @param id the visits id
   * @return the visit or <code>null</code> of no visit has been found
   */
  Visit findById(long id);

  /**
   * inserts a new visit into the database
   *
   * @param visit the visit to be inserted
   */
  void insert(Visit visit);

  /**
   * saves the changes of an existing visit into the database
   *
   * @param visit the visit to be updated
   */
  void update(Visit visit);

  /**
   * deletes a visit from the database
   *
   * @param visit the visit to be deleted
   */
  void delete(Visit visit);
}
