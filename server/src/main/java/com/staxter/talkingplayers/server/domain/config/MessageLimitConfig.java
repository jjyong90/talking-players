package com.staxter.talkingplayers.server.domain.config;

import com.staxter.talkingplayers.server.AppServer;

/**
 * The type Message limit config.
 */
public class MessageLimitConfig {

  /**
   * Gets message limit.
   *
   * @return the message limit
   */
  public int getMessageLimit() {
    return Integer.parseInt(System.getenv(AppServer.MESSAGE_LIMIT));
  }

}
