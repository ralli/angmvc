package angmvc.core.models;

import java.util.Date;

public class VisitData {
  private Long id;
  private Date visitDate;
  private String description;

  public VisitData(Long id, Date visitDate, String description) {
    this.id = id;
    this.visitDate = visitDate;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public Date getVisitDate() {
    return visitDate;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "VisitData{" +
            "id=" + id +
            ", visitDate=" + visitDate +
            ", description='" + description + '\'' +
            '}';
  }
}
