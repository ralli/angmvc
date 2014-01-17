package angmvc.dao;

import angmvc.TestContext;
import angmvc.config.DataSourceConfig;
import angmvc.model.Pet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
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

  private Date createDate(int year, int month, int day) {
    Calendar c = Calendar.getInstance();
    c.setTime(new Date(0L));
    c.set(Calendar.YEAR, year);
    c.set(Calendar.MONTH, month+1);
    c.set(Calendar.DAY_OF_MONTH, day);
    return c.getTime();
  }

  @Test
  public void testInsertUpdateDelete() {
       Pet pet = new Pet();
    pet.setName("Hansi");
    pet.setBirthDate(createDate(2011, 1, 21));
    pet.setOwnerId(1L);
    pet.setPetTypeId(1L);
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
