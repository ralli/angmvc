package angmvc.dao;

import angmvc.TestContext;
import angmvc.config.DataSourceConfig;
import angmvc.model.Owner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataSourceConfig.class, TestContext.class })
@Transactional
public class OwnerDaoTest {
  @Autowired
  private OwnerDao ownerDao;

  @Test
  public void testFindByLastName() {
    List<Owner> owners = ownerDao.findByLastName("%");
    assertFalse(owners.isEmpty());
  }

  @Test
  public void testFindById() {
    final long id = 1L;
    Owner owner = ownerDao.findById(id);
    assertNotNull(owner);
  }
}
