package angmvc.web.controllers.api;

import angmvc.core.dao.OwnerDao;
import angmvc.core.model.Owner;
import angmvc.core.model.Pet;
import angmvc.web.models.OwnerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/owners")
public class OwnerApiController {
  @Autowired
  private OwnerDao ownerDao;

  private List<OwnerInfo> createOwnerInfos(List<Owner> owners) {
    List<OwnerInfo> result = new ArrayList<>();
    for (Owner owner : owners) {
      List<String> petNames = new ArrayList<>();
      for(Pet pet : owner.getPets())
        petNames.add(pet.getName());
      result.add(new OwnerInfo(owner.getId(), owner.getFirstName(), owner.getLastName(), owner.getAddress(), owner.getCity(), owner.getTelephone(), petNames));
    }
    return result;
  }

  @Transactional
  @RequestMapping(method = RequestMethod.GET)
  public
  @ResponseBody
  List<OwnerInfo> findByLastName(@RequestParam(value = "name", required = false, defaultValue = "%") String name) {
    List<Owner> owners = ownerDao.findByLastName(name);
    return createOwnerInfos(owners);
  }
}
