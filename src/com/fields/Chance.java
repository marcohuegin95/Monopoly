package com.fields;

import com.game.*;

import static com.game.GameUtils.*;

/**
 * Diese Klasse stellt das Verhalten bereit, wenn ein Spiel auf das Feld 'Chance' kommt.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class Chance implements Sqaure {
    @Override
    public String name() {
        return "Chance";
    }

    @Override
    public void walkOn(Player player) {
        int randomMoney = randomMoney();
        player.transferMoney(randomMoney);
        System.out.println("Spieler " + player + " ist auf dem Feld 'Chance' und bekommt " + randomMoney + " €");
    }

    //int amount = ThreadLocalRandom.current()

    @Override
    public void walkOver(Player player) {
        System.out.println("Spieler " + player + " geht über das Feld 'Chance'");
    }
}
