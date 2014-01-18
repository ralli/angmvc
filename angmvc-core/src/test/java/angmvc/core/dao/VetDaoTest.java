package angmvc.core.dao;

import angmvc.TestContext;
import angmvc.core.config.DataSourceConfig;
import angmvc.core.entities.Vet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static junit.framework.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataSourceConfig.class, TestContext.class })
@Transactional
public class VetDaoTest {
  @Autowired
  private VetDao vetDao;

  @Test
  public void testFindAll() {
    List<Vet> vets = vetDao.findAll();
    assertFalse(vets.isEmpty());
  }

  @Test
  public void testFindById() {
    Vet vet = vetDao.findById(1L);
    assertNotNull(vet);
  }
}
