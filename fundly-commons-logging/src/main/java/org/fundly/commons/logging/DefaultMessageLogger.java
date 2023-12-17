package org.fundly.commons.logging;

import org.fundly.commons.logging.model.MessageLogEntry;
import org.slf4j.Logger;

public class DefaultMessageLogger extends BaseLogger<MessageLogEntry> implements MessageLogger, LoggerType<MessageLogger>{

  MessageLogEntry messageLogEntry;

  public DefaultMessageLogger(Logger logger){
    super(logger, createBaseLogEntry());
    this.messageLogEntry = getBaseLogEntry();
  }

  private static MessageLogEntry createBaseLogEntry() {
    return new MessageLogEntry(LogEntryType.STANDARD);
  }

  @Override
  public MessageLogger withObject(String attributeName, Object value) {
    return null;
  }

  @Override
  public void logMessage(String message) {
    //TODO STANDARD log entry will be removed and an aspect has to be created which runtime decides the type of logs being written
    this.messageLogEntry.setMessage(message);
    flushLogs();
  }

  @Override
  public void logException(String message, Throwable throwable) {

  }

  @Override
  public MessageLogger withType(LogEntryType type) {
    //TODO THIS has to be handled by aspects
    return this;
  }
}
