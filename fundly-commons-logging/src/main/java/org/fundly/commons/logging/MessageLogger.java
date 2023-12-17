package org.fundly.commons.logging;

import org.fundly.commons.ContextLogger;

public interface MessageLogger extends ContextLogger<MessageLogger> {
  void logMessage(String message);
  void logException(String message, Throwable throwable);
}
