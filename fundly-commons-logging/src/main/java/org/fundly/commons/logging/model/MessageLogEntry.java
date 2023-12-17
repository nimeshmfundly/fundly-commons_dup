package org.fundly.commons.logging.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.fundly.commons.logging.LogEntryType;
import org.fundly.commons.logging.serializer.MessageLogEntrySerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(using = MessageLogEntrySerializer.class)
public class MessageLogEntry extends BaseLogEntry{
  public MessageLogEntry(LogEntryType logEntryType) {
    super(logEntryType);
  }
}
