package angmvc.core.dao.impl;

import angmvc.core.dao.SpecialtyDao;
import angmvc.core.entities.Specialty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SpecialtyDaoImpl implements SpecialtyDao {
  @PersistenceContext
  private EntityManager em;
  public static final Logger log = LoggerFactory.getLogger(SpecialtyDaoImpl.class);

  @Override
  public List<Specialty> findAll() {
    final String ql = "select sp from Specialty sp order by sp.name";
    final TypedQuery<Specialty> q = em.createQuery(ql, Specialty.class);
    final List<Specialty> specialties = q.getResultList();
    log.debug("findAll(): size = {}", specialties.size());
    return specialties;
  }
}
