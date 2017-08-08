package com.fields;

import com.game.Player;

/**
 * Diese Klasse stellt das Verhalten bereit, wenn ein Spiel auf das Feld 'Go' kommt.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class Go implements Sqaure {
    @Override
    public void walkOn(Player player) {
        player.transferMoney(400);
        System.out.println("Spieler " + player + " geht auf das Feld 'Los' und kassiert 400€");
    }

    @Override
    public void walkOver(Player player) {
        player.transferMoney(200);
        System.out.println("Spieler " + player + " geht über 'Los' und kassiert 200€");
    }
}
