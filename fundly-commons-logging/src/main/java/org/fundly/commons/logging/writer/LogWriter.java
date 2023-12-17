package org.fundly.commons.logging.writer;

import org.fundly.commons.logging.MessageLogger;

public interface LogWriter {
  MessageLogger info();

  MessageLogger warn();

  MessageLogger error();
}
