package angmvc.core.services;

import angmvc.SimpleTestContext;
import angmvc.core.dao.OwnerDao;
import angmvc.core.entities.Owner;
import angmvc.core.models.*;
import angmvc.core.services.impl.OwnerServiceImpl;
import angmvc.core.utils.TestDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.util.ReflectionTestUtils.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SimpleTestContext.class})
public class OwnerServiceTest {
  private OwnerDao ownerDao;
  private OwnerService ownerService;
  @Autowired
  private TestDataProvider testDataProvider;

  @Before
  public void setUp() {
    ownerDao = Mockito.mock(OwnerDao.class);
    ownerService = new OwnerServiceImpl();
    setField(ownerService, "ownerDao", ownerDao);
  }

  @Test
  public void findByIdShouldReturnNullIfNoOwnerFound() {
    final long id = 1L;
    Mockito.when(ownerDao.findById(id)).thenReturn(null);
    assertNull(ownerService.findById(id));
  }

  @Test
  public void findByIdResultShouldHaveSameAttributesAsOwner() {
    final long id = 1L;
    final Owner owner = testDataProvider.createOwner(id);
    Mockito.when(ownerDao.findById(id)).thenReturn(owner);
    OwnerData ownerData = ownerService.findById(id);
    assertEquals(owner.getId(), ownerData.getId());
    assertEquals(owner.getFirstName(), ownerData.getFirstName());
    assertEquals(owner.getLastName(), ownerData.getLastName());
    assertEquals(owner.getAddress(), ownerData.getAddress());
    assertEquals(owner.getCity(), ownerData.getCity());
    assertEquals(owner.getTelephone(), ownerData.getTelephone());
  }

  @Test
  public void findOwnersByNameShouldHaveSameAttributesAsOwner() {
    final Long ownerId = 1L;
    final Owner owner = testDataProvider.createOwner(ownerId);
    final List<Owner> owners = new ArrayList<>();
    owners.add(owner);
    final String lastNamePattern = "A%";
    Mockito.when(ownerDao.findByLastName(lastNamePattern)).thenReturn(owners);
    List<OwnerInfo> ownerInfos = ownerService.findOwnersByName(lastNamePattern);
    OwnerInfo ownerInfo = ownerInfos.get(0);
    assertEquals(owner.getId(), ownerInfo.getId());
    assertEquals(owner.getFirstName(), ownerInfo.getFirstName());
    assertEquals(owner.getLastName(), ownerInfo.getLastName());
    assertEquals(owner.getAddress(), ownerInfo.getAddress());
    assertEquals(owner.getCity(), ownerInfo.getCity());
    assertEquals(owner.getTelephone(), ownerInfo.getTelephone());
    assertEquals(owner.getPets().get(0).getName(), ownerInfo.getPetNames().get(0));
  }

  @Test
  public void createOwnerShouldSucceed() {
    final Owner owner = testDataProvider.createOwner(1L);

    final OwnerCommand ownerCommand = createOwnerCommand(owner);

    CreateOwnerResponse response = ownerService.createOwner(ownerCommand);
    assertTrue(response.getErrorMessages().isEmpty());
  }

  private OwnerCommand createOwnerCommand(Owner owner) {
    final OwnerCommand ownerCommand = new OwnerCommand();
    ownerCommand.setFirstName(owner.getFirstName());
    ownerCommand.setLastName(owner.getLastName());
    ownerCommand.setAddress(owner.getAddress());
    ownerCommand.setCity(owner.getCity());
    ownerCommand.setTelephone(owner.getTelephone());
    return ownerCommand;
  }

  @Test
  public void ownerCommandShouldSucceed() {
    final long ownerId = 10L;
    final Owner owner = testDataProvider.createOwner(ownerId);
    Mockito.when(ownerDao.findById(ownerId)).thenReturn(owner);
    OwnerCommand ownerCommand = createOwnerCommand(owner);
    BasicResponse response = ownerService.updateOwner(ownerId, ownerCommand);
    assertTrue(response.isValid());
  }

  @Test
  public void ownerCommandShouldFailIfOwnerNotFound() {
    final long ownerId = 10L;
    final Owner owner = testDataProvider.createOwner(ownerId);
    Mockito.when(ownerDao.findById(ownerId)).thenReturn(null);
    OwnerCommand ownerCommand = createOwnerCommand(owner);
    BasicResponse response = ownerService.updateOwner(ownerId, ownerCommand);
    assertFalse(response.isValid());
    assertTrue(response.containsErrorCode("notfound"));
  }

}
