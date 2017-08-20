package com.fields;

import com.game.Player;

/**
 * Diese Klasse stellt das Verhalten bereit, wenn ein Spiel auf das Feld 'Gehe ins Gefängnis' kommt.
 *
 * @author Marco Hügin
 * @version 1.0
 */

//

public class GoToJail implements Sqaure {
    @Override
    public String name() {
        return "Geh ins Gefängnis";
    }

    @Override
    public void walkOn(Player player) {
        player.setInJail(true);
        player.setPosition(6);
        System.out.println("Spieler " + player + " geht auf das Feld 'Gehe ins Gefängnis' und geht somit direkt ins Gefängnis");
    }

    @Override
    public void walkOver(Player player) {
        //Keine Aktion nötig, wenn Spieler über diese Feld geht!
    }
}
