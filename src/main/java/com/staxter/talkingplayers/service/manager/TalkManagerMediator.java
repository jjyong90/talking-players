package com.staxter.talkingplayers.service.manager;

import com.staxter.talkingplayers.model.Player;

/**
 * The type Talk manager mediator.
 */
public class TalkManagerMediator implements TalkManager {

  private Player initiator;
  private Player replier;

  @Override
  public void registerPlayer(Player player) {
    if (initiator == null) {
      initiator = player;
      return;
    }
    replier = player;
  }

  @Override
  public void sendMessage(String message, Player player) {
    if (incompletePlayers()) {
      return;
    }

    if (validateMessageLimit(player)) {
      System.out.println("Message limit reached");
      return;
    }

    player.receiveMessage(message, getSender(player));
  }

  private boolean incompletePlayers() {
    boolean incomplete = false;
    if (initiator == null) {
      System.out.println("Please register the Player 'initiator'");
      incomplete = true;
    }
    if (replier == null) {
      System.out.println("Please register the Player 'replier'");
      incomplete = true;
    }
    return incomplete;
  }

  private boolean validateMessageLimit(Player player) {
    int messageLimit = 10;
    return player.getSentCount() >= messageLimit && player.getReceivedCount() >= messageLimit;
  }

  private Player getSender(Player to) {
    return to.equals(initiator) ? replier : initiator;
  }

}