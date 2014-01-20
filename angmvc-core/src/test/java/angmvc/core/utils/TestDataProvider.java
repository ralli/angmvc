package angmvc.core.utils;

import angmvc.core.entities.Owner;
import angmvc.core.entities.Pet;
import angmvc.core.entities.PetType;
import angmvc.core.entities.Visit;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestDataProvider {
  public Date createDate(int year, int month, int day) {
    Calendar c = Calendar.getInstance();
    c.setTime(new Date(0L));
    c.set(Calendar.YEAR, year);
    c.set(Calendar.MONTH, month + 1);
    c.set(Calendar.DAY_OF_MONTH, day);
    return c.getTime();
  }

  public PetType createPetType(long id) {
    final PetType petType = new PetType();
    petType.setId(id);
    petType.setName("Test");
    return petType;
  }

  public Visit createVisit(Long id, Pet pet) {
    Visit visit = new Visit();
    visit.setId(id);
    visit.setDescription("Test description");
    visit.setPet(pet);
    visit.setPetId(pet.getId());
    return visit;
  }

  public Set<Visit> createVisits(Pet pet) {
    List<Visit> result = new ArrayList<>();
    result.add(createVisit(1L, pet));
    return new LinkedHashSet<>(result);
  }

  public Pet createPet(Long id, Owner owner) {
    Pet pet = new Pet();
    pet.setId(id);
    pet.setBirthDate(createDate(1981, 3, 12));
    pet.setName("Bello");
    pet.setOwner(owner);
    pet.setOwnerId(owner.getId());
    final long petTypeId = 10L;
    pet.setPetType(createPetType(petTypeId));
    pet.setPetTypeId(petTypeId);
    pet.setVisits(createVisits(pet));
    return pet;
  }

  private Set<Pet> createPets(Owner owner) {
    Pet pet = createPet(1L, owner);
    Set<Pet> result = new LinkedHashSet<>();
    result.add(pet);
    return result;
  }

  public Owner createOwner(Long id) {
    Owner owner;
    owner = new Owner();
    owner.setId(id);
    owner.setFirstName("Charly");
    owner.setLastName("Chan");
    owner.setAddress("21 Jump Street");
    owner.setCity("Beverly Hills");
    owner.setTelephone("1231312312");
    if(id == null)
      owner.setPets(new LinkedHashSet<Pet>());
    else
      owner.setPets(createPets(owner));
    return owner;
  }


}
