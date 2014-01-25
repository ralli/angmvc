package angmvc.web.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationErrors implements Serializable {
  private List<FieldErrorMessage> fieldErrorsMessages = new ArrayList<>();

  public List<FieldErrorMessage> getFieldErrorMessages() {
    return Collections.unmodifiableList(fieldErrorsMessages);
  }

  public void addFieldError(String field, String code, String message) {
    fieldErrorsMessages.add(new FieldErrorMessage(field, code, message));
  }

  @Override
  public String toString() {
    return "ValidationErrors{" +
      "fieldErrorsMessages=" + fieldErrorsMessages +
      '}';
  }
}
