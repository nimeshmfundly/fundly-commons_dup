package org.fundly.commons.logging.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class FundlyLoggingControlProperties {
  private boolean enableMethodLogging = true;

  public boolean isEnableMethodLogging() {
    return enableMethodLogging;
  }

  public void setEnableMethodLogging(boolean enableMethodLogging) {
    this.enableMethodLogging = enableMethodLogging;
  }
}
