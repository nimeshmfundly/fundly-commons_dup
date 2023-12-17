package org.fundly.commons;

public interface ContextLogger <T> {
  T withObject(String attributeName, Object value);
}
