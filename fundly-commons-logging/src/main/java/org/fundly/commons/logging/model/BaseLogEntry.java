package org.fundly.commons.logging.model;

import java.io.Serializable;
import org.fundly.commons.logging.LogEntryType;

public abstract class BaseLogEntry implements Serializable {
  //default to STANDARD if not set explicitly
  private LogEntryType logEntryType = LogEntryType.STANDARD;
  private String message;


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  BaseLogEntry(LogEntryType logEntryType){
    this.logEntryType = logEntryType;
  }

}
