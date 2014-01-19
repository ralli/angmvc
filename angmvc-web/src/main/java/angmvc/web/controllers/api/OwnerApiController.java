package angmvc.web.controllers.api;

import angmvc.core.models.OwnerData;
import angmvc.core.models.OwnerInfo;
import angmvc.core.services.OwnerService;
import angmvc.web.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/owners")
public class OwnerApiController extends ApiController {
  @Autowired
  private OwnerService ownerService;

  @RequestMapping(method = RequestMethod.GET)
  public
  @ResponseBody
  List<OwnerInfo> findByLastName(@RequestParam(value = "name", required = false, defaultValue = "%") String name) {
    return ownerService.findOwnersByName(name);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public
  @ResponseBody
  OwnerData findById(@PathVariable long id) {
    OwnerData ownerData = ownerService.findById(id);
    if (ownerData == null)
      throw new NotFoundException("owner not found");
    return ownerData;
  }
}
