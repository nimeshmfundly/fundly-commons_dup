package org.fundly.commons.logging.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.fundly.commons.logging.LogEntryType;
import org.fundly.commons.logging.serializer.MessageLogEntrySerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(using = MessageLogEntrySerializer.class)
public class MessageLogEntry extends BaseLogEntry implements ExceptionLogEntry{

  Throwable exception;
  public MessageLogEntry(LogEntryType logEntryType) {
    super(logEntryType);
  }

  @Override
  public Throwable getException() {
    return this.exception;
  }

  public MessageLogEntry setException(Throwable exception) {
    this.exception = exception;
    return this;
  }
}
