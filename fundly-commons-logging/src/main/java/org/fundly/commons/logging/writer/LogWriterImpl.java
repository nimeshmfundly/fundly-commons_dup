package org.fundly.commons.logging.writer;

import org.fundly.commons.logging.DefaultMessageLogger;
import org.fundly.commons.logging.LogEntryType;
import org.fundly.commons.logging.MessageLogger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;

public class LogWriterImpl extends BaseLogWriter implements LogWriter{
  public LogWriterImpl(Class<?> classForWhichLogginIsRquested) {
    super(LoggerFactory.getLogger(classForWhichLogginIsRquested));
  }

  @Override
  public MessageLogger info() {
    return new DefaultMessageLogger(getLogger(), LogLevel.INFO);

  }

  @Override
  public MessageLogger warn() {
    return new DefaultMessageLogger(getLogger(), LogLevel.WARN);
  }

  @Override
  public MessageLogger error() {
    return new DefaultMessageLogger(getLogger(), LogLevel.ERROR);
  }
}
