package angmvc.core.dao.impl;

import angmvc.core.dao.PetTypeDao;
import angmvc.core.entities.PetType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PetTypeDaoImpl implements PetTypeDao {
  @PersistenceContext
  private EntityManager em;
  private static final Logger log = LoggerFactory.getLogger(PetTypeDaoImpl.class);

  @Override
  public List<PetType> findAll() {
    final String ql = "select pt from PetType pt order by pt.name";
    final List<PetType> petTypes = em.createQuery(ql, PetType.class).getResultList();
    log.debug("findAll(): size = {}", petTypes.size());
    return petTypes;
  }

  @Override
  public PetType findById(long id) {
    final String ql = "select pt from PetType pt where pt.id=:id";
    final TypedQuery<PetType> q = em.createQuery(ql, PetType.class);
    q.setParameter("id", id);
    final List<PetType> petTypes = q.getResultList();
    final PetType petType = petTypes.isEmpty() ? null : petTypes.get(0);
    log.debug("findById({}) = {}", id, petType);
    return petType;
  }

  @Override
  public void insert(PetType petType) {
    log.debug("insert({})", petType);
    em.persist(petType);
  }

  @Override
  public void update(PetType petType) {
    log.debug("update({})", petType);
    em.merge(petType);
  }

  @Override
  public void delete(PetType petType) {
    log.debug("delete({})", petType);
    em.remove(petType);
  }
}
