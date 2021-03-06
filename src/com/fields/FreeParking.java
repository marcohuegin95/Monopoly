package com.fields;

import com.game.Player;

/**
 * Diese Klasse stellt das Verhalten bereit, wenn ein Spiel auf das Feld 'Freies Parken' kommt.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class FreeParking implements Sqaure {
    @Override
    public String name() {
        return "Frei Parken";
    }

    @Override
    public void walkOn(final Player player) {
        //Bisher keine Aktion erforderlich
        System.out.println("Spieler " + player.getName() + " ist auf dem Feld 'Freies Parken'");
    }

    @Override
    public void walkOver(final Player player) {
        //Keine Aktion nötig, wenn Spieler über diese Feld geht!
    }
}
