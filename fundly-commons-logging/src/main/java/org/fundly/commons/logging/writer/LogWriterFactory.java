package org.fundly.commons.logging.writer;

import org.slf4j.Logger;

public class LogWriterFactory {

  public LogWriter getLogWriter(Class<?> declaredClass){
    return new LogWriterImpl(declaredClass);
  }
}
