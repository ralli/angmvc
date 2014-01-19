package angmvc.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
  @RequestMapping(method = RequestMethod.GET)
  public String printWelcome() {
    return "index";
  }

  @RequestMapping(value="/owners", method=RequestMethod.GET)
  public String showOwners() {
    return "crud/owners";
  }
}