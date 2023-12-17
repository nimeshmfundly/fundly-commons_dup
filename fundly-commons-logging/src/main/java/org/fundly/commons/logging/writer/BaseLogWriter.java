package org.fundly.commons.logging.writer;

import org.slf4j.Logger;

public abstract class BaseLogWriter {
  private final Logger logger;
  public BaseLogWriter(Logger logger){
    this.logger = logger;
  }

  public Logger getLogger() {
    return logger;
  }


  private void writeLog(){
    System.out.println("writing logs");
    //logger.info(new LogEntryTypeMarker("LogTypeMarker name<undefined>"), );
  }
  /*private String serializeLog(){

  }*/
}
