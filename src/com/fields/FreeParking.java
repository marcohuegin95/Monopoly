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
    public void walkOn(Player player) {
        System.out.println("Spieler " + player + " ist auf dem Feld 'Freies Parken'");
    }

    @Override
    public void walkOver(Player player) {
        System.out.println("Spieler " + player + " geht über das Feld 'Freies Parken'");
    }
}
