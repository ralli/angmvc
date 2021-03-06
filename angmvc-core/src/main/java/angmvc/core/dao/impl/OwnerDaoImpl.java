package angmvc.core.dao.impl;

import angmvc.core.dao.OwnerDao;
import angmvc.core.entities.Owner;
import angmvc.core.entities.Owner_;
import angmvc.core.entities.Pet;
import angmvc.core.entities.Pet_;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class OwnerDaoImpl implements OwnerDao {
  @PersistenceContext
  private EntityManager em;
  private Logger logger = LoggerFactory.getLogger(OwnerDaoImpl.class);

  @Override
  public List<Owner> findByLastName(String lastName) {
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Owner> criteriaQuery = builder.createQuery(Owner.class);
    Root<Owner> ownerRoot = criteriaQuery.from(Owner.class);
    Fetch<Owner, Pet> fetch = ownerRoot.fetch(Owner_.pets, JoinType.LEFT);
    fetch.fetch(Pet_.petType, JoinType.LEFT);
    criteriaQuery.where(builder.like(builder.upper(ownerRoot.get(Owner_.lastName)), StringUtils.upperCase(lastName)));
    criteriaQuery.distinct(true).orderBy(builder.asc(ownerRoot.get(Owner_.lastName)));
    List<Owner> owners = em.createQuery(criteriaQuery).getResultList();
    logger.debug("findByLastName({}): {} owners found", lastName, owners.size());
    return owners;
  }

  @Override
  public Owner findById(long id) {
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Owner> criteriaQuery = builder.createQuery(Owner.class);
    Root<Owner> ownerRoot = criteriaQuery.from(Owner.class);
    Fetch<Owner, Pet> fetch = ownerRoot.fetch(Owner_.pets, JoinType.LEFT);
    fetch.fetch(Pet_.petType, JoinType.LEFT);
    fetch.fetch(Pet_.visits, JoinType.LEFT);
    criteriaQuery.where(builder.equal(ownerRoot.get(Owner_.id), id));
    criteriaQuery.distinct(true).orderBy(builder.asc(ownerRoot.get(Owner_.lastName)));
    List<Owner> owners = em.createQuery(criteriaQuery).getResultList();
    Owner owner = owners.isEmpty() ? null : owners.get(0);
    logger.debug("findById({}): {}", id, owner);
    return owner;
  }

  @Override
  public void insert(Owner owner) {
    logger.debug("insert({})", owner);
    em.persist(owner);
  }

  @Override
  public void update(Owner owner) {
    logger.debug("update({})", owner);
    em.merge(owner);
  }

  @Override
  public void delete(Owner owner) {
    logger.debug("delete({})", owner);
    em.remove(owner);
  }
}
