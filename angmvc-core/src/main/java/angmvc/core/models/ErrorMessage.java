package angmvc.core.models;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
  private final String errorCode;
  private final String message;

  public ErrorMessage(String errorCode, String message) {
    this.errorCode = errorCode;
    this.message = message;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getMessage() {
    return message;
  }
}
