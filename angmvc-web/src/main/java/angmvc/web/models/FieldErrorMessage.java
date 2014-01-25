package angmvc.web.models;

import java.io.Serializable;

public class FieldErrorMessage implements Serializable {
  private String field;
  private String code;
  private String message;

  public FieldErrorMessage(String field, String code, String message) {
    this.field = field;
    this.code = code;
    this.message = message;
  }

  public String getField() {
    return field;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "FieldErrorMessage{" +
      "field='" + field + '\'' +
      ", code='" + code + '\'' +
      ", message='" + message + '\'' +
      '}';
  }
}
