package angmvc.core.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicResponse implements Serializable {
  private final List<ErrorMessage> errorMessages;

  public BasicResponse() {
    errorMessages = new ArrayList<>();
  }

  public BasicResponse(List<ErrorMessage> errorMessages) {
    this.errorMessages = errorMessages;
  }

  public List<ErrorMessage> getErrorMessages() {
    return Collections.unmodifiableList(errorMessages);
  }

  public void addErrorMessage(String errorCode, String message) {
    errorMessages.add(new ErrorMessage(errorCode, message));
  }

  public boolean containsErrorCode(String errorCode) {
    for(ErrorMessage errorMessage : errorMessages) {
      if(errorCode.equals(errorMessage.getErrorCode()))
        return true;
    }
    return false;
  }

  public boolean isValid() {
    return errorMessages.isEmpty();
  }

  @Override
  public String toString() {
    return "BasicResponse{" +
            "errorMessages=" + errorMessages +
            '}';
  }
}
