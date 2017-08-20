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
        player.transferMoney(randomMoney());
        System.out.println("Spieler " + player + " ist auf dem Feld 'Chance' und bekommt " + randomMoney() + " €");
    }

    @Override
    public void walkOver(Player player) {
        //Keine Aktion nötig, wenn Spieler über diese Feld geht!
    }
}
