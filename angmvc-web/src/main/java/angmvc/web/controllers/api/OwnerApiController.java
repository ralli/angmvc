package angmvc.web.controllers.api;

import angmvc.core.models.*;
import angmvc.core.services.OwnerService;
import angmvc.web.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

  @RequestMapping(method = RequestMethod.POST)
  public
  @ResponseBody
  CreateOwnerResponse
  createOwner(@RequestBody @Valid OwnerCommand ownerCommand) {
    return ownerService.createOwner(ownerCommand);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public
  @ResponseBody
  BasicResponse
  updateOwner(@PathVariable long id, @RequestBody @Valid OwnerCommand ownerCommand) {
    BasicResponse response = ownerService.updateOwner(id, ownerCommand);
    if (response.containsErrorCode("notfound")) {
      throw new NotFoundException("Owner not found");
    }
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public
  @ResponseBody
  BasicResponse deleteOwner(@PathVariable long id) {
    BasicResponse response = ownerService.deleteOwner(id);
    if (response.containsErrorCode("notfound")) {
      throw new NotFoundException("Owner not found");
    }
    return response;
  }
}
