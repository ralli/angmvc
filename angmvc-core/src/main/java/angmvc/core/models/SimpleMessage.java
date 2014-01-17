package angmvc.core.models;

import java.io.Serializable;

public class SimpleMessage implements Serializable {
  public String message;

  public SimpleMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
