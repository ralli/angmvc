package angmvc.dao.impl;

import angmvc.dao.PetDao;
import angmvc.model.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PetDaoImpl implements PetDao {
  @PersistenceContext
  private EntityManager em;
  private static final Logger logger = LoggerFactory.getLogger(PetDaoImpl.class);

  @Override
  public List<Pet> findByOwner(long ownerId) {
    final String ql = "select p from Pet p join fetch p.owner join fetch p.petType where p.ownerId=:ownerId";
    TypedQuery<Pet> q = em.createQuery(ql, Pet.class);

    q.setParameter("ownerId", ownerId);
    List<Pet> pets = q.getResultList();
    logger.debug("findByOwner({}): size = {}", ownerId, pets);
    return pets;
  }

  @Override
  public Pet findById(long id) {
    final String ql = "select p from Pet p join fetch p.owner join fetch p.petType where p.id=:id";
    TypedQuery<Pet> q = em.createQuery(ql, Pet.class);
    q.setParameter("id", id);
    List<Pet> pets = q.getResultList();
    Pet pet = pets.isEmpty() ? null : pets.get(0);
    logger.debug("findById({}): {}", id, pet);
    return pet;
  }

  @Override
  public void insert(Pet pet) {
    logger.debug("insert({})", pet);
    em.persist(pet);
  }

  @Override
  public void update(Pet pet) {
    logger.debug("update({})", pet);
    em.merge(pet);
  }

  @Override
  public void delete(Pet pet) {
    logger.debug("delete({})", pet);
    em.remove(pet);
  }
}
