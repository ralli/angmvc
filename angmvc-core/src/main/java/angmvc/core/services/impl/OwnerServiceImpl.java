package angmvc.core.services.impl;

import angmvc.core.dao.OwnerDao;
import angmvc.core.entities.Owner;
import angmvc.core.entities.Pet;
import angmvc.core.models.OwnerData;
import angmvc.core.models.OwnerInfo;
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
      List<String> petNames = new ArrayList<>();
      for (Pet pet : owner.getPets())
        petNames.add(pet.getName());
      result.add(new OwnerInfo(owner.getId(), owner.getFirstName(), owner.getLastName(), owner.getAddress(), owner.getCity(), owner.getTelephone(), petNames));
    }
    return result;
  }

  private OwnerData createOwnerData(Owner owner) {
    return new OwnerData(owner.getId(), owner.getFirstName(), owner.getLastName(), owner.getAddress(), owner.getCity(), owner.getTelephone());
  }

  @Transactional
  public List<OwnerInfo> findOwnersByName(String lastName) {
    List<Owner> owners = ownerDao.findByLastName(lastName);
    return createOwnerInfos(owners);
  }

  public OwnerData findById(long id) {
    Owner owner = ownerDao.findById(id);
    return owner != null ? createOwnerData(owner) : null;
  }
}
