package angmvc.core.dao;

import angmvc.TestContext;
import angmvc.core.config.DataSourceConfig;
import angmvc.core.entities.Specialty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataSourceConfig.class, TestContext.class })
@Transactional
public class SpecialtyDaoTest {
  @Autowired
  private SpecialtyDao specialtyDao;

  @Test
  public void testFindAll() {
    List<Specialty> specialties = specialtyDao.findAll();
    assertTrue(specialties.size() > 0);
  }
}
