package org.fundly.commons.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import org.fundly.commons.logging.config.FundlyLoggingControlProperties;
import org.fundly.commons.logging.model.BaseLogEntry;
import org.fundly.commons.logging.model.LogEntryTypeMarker;
import org.fundly.commons.logging.model.MessageLogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseLogger<T extends MessageLogEntry> {
  private static final Logger logger = LoggerFactory.getLogger(BaseLogger.class);
  private static final int CONFIGURED_THREAD_POOL_SIZE = 5;
  private final Logger wrappedLogger;

  private Executors executor;
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
    CompletableFuture.supplyAsync(() -> serializeLogs(baseLogEntry), Executors.newFixedThreadPool(
        CONFIGURED_THREAD_POOL_SIZE)).thenAccept(log -> {
      writeString(log);
    });
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

  private Executors retrieveOrCreateExecutor(int threadPoolSize){
    if(executor == null){
      executor = Executors.newFixedThreadPool(CONFIGURED_THREAD_POOL_SIZE, new ThreadFactory() {
        private AtomicInteger commonAsyncLoggingCounter = new AtomicInteger();
        @Override
        public Thread newThread(Runnable r) {
          Thread thread = new Thread(r);
          //Thread names to be used for over all async logging information collection and thread management later on.
          thread.setName("fundly-async-logger-pool" + commonAsyncLoggingCounter.incrementAndGet());
          return thread;
        }
      }
    }
    return executor;
  }
}
