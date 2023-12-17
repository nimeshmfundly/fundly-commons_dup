package org.fundly.commons.logging.model;

import java.io.Serializable;
import org.fundly.commons.logging.LogEntryType;
import org.springframework.boot.logging.LogLevel;

public abstract class BaseLogEntry implements Serializable {
  //default to STANDARD if not set explicitly
  private LogEntryType logEntryType = LogEntryType.STANDARD;
  private String message;
  private LogLevel logLevel;

  public LogEntryType getLogEntryType() {
    return logEntryType;
  }

  public void setLogEntryType(LogEntryType logEntryType) {
    this.logEntryType = logEntryType;
  }

  public LogLevel getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(LogLevel logLevel) {
    this.logLevel = logLevel;
  }

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
