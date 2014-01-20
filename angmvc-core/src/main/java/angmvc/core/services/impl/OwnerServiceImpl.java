package angmvc.core.services.impl;

import angmvc.core.dao.OwnerDao;
import angmvc.core.entities.Owner;
import angmvc.core.entities.Pet;
import angmvc.core.entities.Visit;
import angmvc.core.models.*;
import angmvc.core.services.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
  @Autowired
  private OwnerDao ownerDao;
  private static final Logger log = LoggerFactory.getLogger(OwnerServiceImpl.class);

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
    for (Visit visit : visits)
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

  public CreateOwnerResponse createOwner(OwnerCommand ownerCommand) {
    Owner owner = new Owner();
    owner.setFirstName(ownerCommand.getFirstName());
    owner.setLastName(ownerCommand.getLastName());
    owner.setAddress(ownerCommand.getAddress());
    owner.setCity(ownerCommand.getCity());
    owner.setTelephone(ownerCommand.getTelephone());
    ownerDao.insert(owner);
    CreateOwnerResponse result = new CreateOwnerResponse(owner.getId());
    log.debug("createOwner({}) = {}", ownerCommand, result);
    return result;
  }

  @Override
  public BasicResponse updateOwner(Long id, OwnerCommand ownerCommand) {
    BasicResponse response = new BasicResponse();
    Owner owner = ownerDao.findById(id);

    if (owner == null) {
      response.addErrorMessage("notfound", "Owner not found");
      return response;
    }

    owner.setFirstName(ownerCommand.getFirstName());
    owner.setLastName(ownerCommand.getLastName());
    owner.setAddress(ownerCommand.getAddress());
    owner.setCity(ownerCommand.getCity());
    owner.setTelephone(ownerCommand.getTelephone());

    /*
    * the update call is not necessary. I just do not like these
    * implicit updates in JPA / EJB ...
    */
    ownerDao.update(owner);

    return response;
  }
}
