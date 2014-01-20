package angmvc.core.dao;

import angmvc.TestContext;
import angmvc.core.config.DataSourceConfig;
import angmvc.core.entities.PetType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataSourceConfig.class, TestContext.class })
@Transactional
public class PetTypeDaoTest {
  @Autowired
  private PetTypeDao petTypeDao;

  @Test
  public void testFindAll() {
    List<PetType> petTypes = petTypeDao.findAll();
    assertTrue(petTypes.size() > 0);
  }

  @Test
  public void testFindById() {
    final long id = 1L;
    PetType petType = petTypeDao.findById(id);
    assertNotNull(petType);
    final long wrongId = -1L;
    petType = petTypeDao.findById(wrongId);
    assertNull(petType);
  }

  @Test
  public void testInsertUpdateDelete() {
    PetType petType = new PetType();
    petType.setName("TestType");
    petTypeDao.insert(petType);
    assertNotNull(petType.getId());
    Long id = petType.getId();
    petType.setName("Different");
    petTypeDao.update(petType);
    petType = petTypeDao.findById(id);
    assertNotNull(petType);
    assertEquals("Different", petType.getName());
    petTypeDao.delete(petType);
    petType = petTypeDao.findById(id);
    assertNull(petType);
  }
}
