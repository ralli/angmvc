package angmvc.web.controllers.api;

import angmvc.core.dao.PetTypeDao;
import angmvc.core.entities.PetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping(value = "/api/pettypes")
public class PetTypeApiController extends ApiController {
  @Autowired
  private PetTypeDao petTypeDao;

  @Transactional
  @RequestMapping(method = RequestMethod.GET)
  public
  @ResponseBody
  List<PetType> findAll() {
    return petTypeDao.findAll();
  }
}
