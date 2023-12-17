package org.fundly.commons.logging.writer;

import org.fundly.commons.logging.DefaultMessageLogger;
import org.fundly.commons.logging.MessageLogger;
import org.slf4j.LoggerFactory;

public class LogWriterImpl extends BaseLogWriter implements LogWriter{
  public LogWriterImpl(Class<?> classForWhichLogginIsRquested) {
    super(LoggerFactory.getLogger(classForWhichLogginIsRquested));
  }

  @Override
  public MessageLogger info() {
    return new DefaultMessageLogger(getLogger());

  }
}
