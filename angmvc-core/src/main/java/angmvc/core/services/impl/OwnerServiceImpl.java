package angmvc.core.services.impl;

import angmvc.core.dao.OwnerDao;
import angmvc.core.entities.Owner;
import angmvc.core.entities.Pet;
import angmvc.core.entities.Visit;
import angmvc.core.models.OwnerData;
import angmvc.core.models.OwnerInfo;
import angmvc.core.models.PetData;
import angmvc.core.models.VisitData;
import angmvc.core.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
  @Autowired
  private OwnerDao ownerDao;

  private List<OwnerInfo> createOwnerInfos(List<Owner> owners) {
    List<OwnerInfo> result = new ArrayList<>();
    for (Owner owner : owners) {
      result.add(createOwnerInfo(owner));
    }
    return result;
  }

  private OwnerInfo createOwnerInfo(Owner owner) {
    List<String> petNames = new ArrayList<>();
    for (Pet pet : owner.getPets())
      petNames.add(pet.getName());
    return new OwnerInfo(owner.getId(),
            owner.getFirstName(),
            owner.getLastName(),
            owner.getAddress(),
            owner.getCity(),
            owner.getTelephone(),
            petNames);
  }

  private VisitData createVisitData(Visit visit) {
    return new VisitData(visit.getId(), visit.getVisitDate(), visit.getDescription());
  }

  private List<VisitData> createVisitDataList(List<Visit> visits) {
    List<VisitData> result = new ArrayList<>();
    for(Visit visit : visits)
      result.add(createVisitData(visit));
    return result;
  }

  private PetData createPetData(Pet pet) {
    return new PetData(pet.getId(), pet.getName(), pet.getBirthDate(), pet.getPetType(), createVisitDataList(pet.getVisits()));
  }

  private List<PetData> createPetDataList(List<Pet> pets) {
    List<PetData> result = new ArrayList<>();
    for (Pet pet : pets)
      result.add(createPetData(pet));
    return result;
  }

  private OwnerData createOwnerData(Owner owner) {
    return new OwnerData(owner.getId(),
            owner.getFirstName(),
            owner.getLastName(),
            owner.getAddress(),
            owner.getCity(),
            owner.getTelephone(),
            createPetDataList(owner.getPets()));
  }

  @Transactional
  public List<OwnerInfo> findOwnersByName(String lastName) {
    List<Owner> owners = ownerDao.findByLastName(lastName);
    return createOwnerInfos(owners);
  }

  @Transactional
  public OwnerData findById(long id) {
    Owner owner = ownerDao.findById(id);
    return owner != null ? createOwnerData(owner) : null;
  }
}
