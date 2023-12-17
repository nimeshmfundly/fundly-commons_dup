package org.fundly.commons.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.CompletableFuture;
import org.fundly.commons.logging.config.FundlyLoggingControlProperties;
import org.fundly.commons.logging.model.BaseLogEntry;
import org.fundly.commons.logging.model.LogEntryTypeMarker;
import org.fundly.commons.logging.model.MessageLogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseLogger<T extends MessageLogEntry> {
  private static final Logger logger = LoggerFactory.getLogger(BaseLogger.class);
  private final Logger wrappedLogger;
  private T baseLogEntry;
  private FundlyLoggingControlProperties fundlyLoggingControlProperties;
  protected BaseLogger(Logger logger, T baseLogEntry){
    this.wrappedLogger = logger;
    this.baseLogEntry = baseLogEntry;
  }

  private void writeString(String currentMessage){
    wrappedLogger.info(new LogEntryTypeMarker("logentrytype_standard"), currentMessage);
  }
  public void flushLogs(){
    CompletableFuture.supplyAsync(() -> serializeLogs(baseLogEntry)).thenAccept(log -> {
      writeString(log);
    }).join();
  }

  private String serializeLogs(BaseLogEntry baseLogEntry){
    try {
      return new ObjectMapper().writeValueAsString(baseLogEntry);
    }catch (Exception exception){
      logger.error("IMPORTANT!!! Failed to log through Fundly commons. This requires attention.");
    }
    return null;
  }

  public T getBaseLogEntry(){
    return this.baseLogEntry;
  }
}
