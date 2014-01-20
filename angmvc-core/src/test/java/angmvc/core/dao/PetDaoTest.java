package angmvc.core.dao;

import angmvc.TestContext;
import angmvc.core.config.DataSourceConfig;
import angmvc.core.entities.Pet;
import angmvc.core.utils.TestDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataSourceConfig.class, TestContext.class })
@Transactional
public class PetDaoTest {
  @Autowired
  private PetDao petDao;
  @Autowired
  private TestDataProvider testDataProvider;

  @Test
  public void testFindByOwner() {
    final Long ownerId = 1L;
    List<Pet> pets = petDao.findByOwner(ownerId);
    assertFalse(pets.isEmpty());
  }

  @Test
  public void testFindById() {
    final Long petId = 1L;
    Pet pet = petDao.findById(petId);
    assertNotNull(pet);
  }

  @Test
  public void testInsertUpdateDelete() {
    Pet pet = testDataProvider.createPet(null, testDataProvider.createOwner(1L));
    petDao.insert(pet);
    assertNotNull(pet.getId());
    Long id = pet.getId();
    pet.setName("Bello");
    petDao.update(pet);
    pet = petDao.findById(id);
    assertNotNull(pet);
    assertEquals("Bello", pet.getName());
    petDao.delete(pet);
    pet = petDao.findById(id);
    assertNull(pet);
  }
}
