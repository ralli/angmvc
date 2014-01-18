package angmvc.core.dao.impl;

import angmvc.core.dao.VetDao;
import angmvc.core.entities.Vet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VetDaoImpl implements VetDao {
  @PersistenceContext
  private EntityManager em;
  private Logger logger = LoggerFactory.getLogger(VetDaoImpl.class);

  @Override
  public List<Vet> findAll() {
    final String ql = "select distinct v from Vet v left outer join fetch v.specialties s order by v.lastName, s.name";
    logger.debug("Loading Vets");
    TypedQuery<Vet> q = em.createQuery(ql, Vet.class);
    List<Vet> vets = q.getResultList();
    logger.debug("{} Vets loaded", vets.size());
    return vets;
  }

  @Override
  public Vet findById(long id) {
    final String ql = "select v from Vet v left outer join fetch v.specialties s where v.id = :id order by s.name";
    TypedQuery<Vet> q = em.createQuery(ql, Vet.class);
    q.setParameter("id", id);
    List<Vet> v = q.getResultList();
    Vet vet = v.isEmpty() ? null : v.get(0);
    logger.debug("loadVet: id={}, vet={}", id, vet);
    return vet;
  }
}
