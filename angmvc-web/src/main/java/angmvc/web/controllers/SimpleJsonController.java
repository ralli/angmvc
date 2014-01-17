package angmvc.web.controllers;

import angmvc.core.models.SimpleMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/simple")
public class SimpleJsonController {
  @RequestMapping(method=RequestMethod.GET)
  public @ResponseBody SimpleMessage getSimpleObject() {
    return new SimpleMessage("This is a test");
  }
}
