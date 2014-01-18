package angmvc.core.dao.impl;

import angmvc.core.dao.VisitDao;
import angmvc.core.entities.Visit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VisitDaoImpl implements VisitDao {
  @PersistenceContext
  private EntityManager em;
  public static final Logger log = LoggerFactory.getLogger(VisitDaoImpl.class);

  @Override
  public List<Visit> findByPet(long petId) {
    final String ql = "select v from Visit v where v.petId=:petId order by v.visitDate";
    final TypedQuery<Visit> q = em.createQuery(ql, Visit.class);
    q.setParameter("petId", petId);
    final List<Visit> visits = q.getResultList();
    log.debug("findByPet({}): size = {}", petId, visits.size());
    return visits;
  }

  @Override
  public Visit findById(long id) {
    final String ql = "select v from Visit v where v.id=:id";
    final TypedQuery<Visit> q = em.createQuery(ql, Visit.class);
    q.setParameter("id", id);
    final List<Visit> visits = q.getResultList();
    final Visit visit = visits.isEmpty() ? null : visits.get(0);
    log.debug("findById({}) = {}", id, visit);
    return visit;
  }

  @Override
  public void insert(Visit visit) {
    log.debug("insert({})", visit);
    em.persist(visit);
  }

  @Override
  public void update(Visit visit) {
    log.debug("update({})", visit);
    em.merge(visit);
  }

  @Override
  public void delete(Visit visit) {
    log.debug("delete({})", visit);
    em.remove(visit);
  }
}
