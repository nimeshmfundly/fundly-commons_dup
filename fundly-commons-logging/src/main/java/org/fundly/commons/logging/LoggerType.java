package org.fundly.commons.logging;

/*
  Used to mark a log entry to specific type.
  Example Business logs, System logs, Downstream Calls etc
 */
public interface LoggerType <T> {
  T withType(LogEntryType type);
}
