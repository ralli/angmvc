package angmvc.core.models;

import java.util.List;

public class CreateOwnerResponse extends BasicResponse {
  private Long ownerId;

  public CreateOwnerResponse(List<ErrorMessage> errorMessages, Long ownerId) {
    super(errorMessages);
    this.ownerId = ownerId;
  }

  public CreateOwnerResponse(Long ownerId) {
    this.ownerId = ownerId;
  }

  public CreateOwnerResponse(List<ErrorMessage> errorMessages) {
    super(errorMessages);
  }

  public Long getOwnerId() {
    return ownerId;
  }

  @Override
  public String toString() {
    return "CreateOwnerResponse{" +
            "errorMessages= " + getErrorMessages() +
            ", ownerId=" + ownerId +
            '}';
  }
}
