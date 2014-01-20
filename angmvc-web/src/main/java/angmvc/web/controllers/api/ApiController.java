package angmvc.web.controllers.api;

import angmvc.web.exceptions.NotFoundException;
import angmvc.web.models.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ApiController {
  private static final Logger log = LoggerFactory.getLogger(ApiController.class);

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public
  @ResponseBody
  ErrorMessage notFoundHandler(NotFoundException notFoundException) {
    log.debug("not found exception: {}", notFoundException.getMessage());
    return new ErrorMessage(notFoundException.getMessage());
  }
}
