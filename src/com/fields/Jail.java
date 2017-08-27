package com.fields;

import com.game.Die;
import com.game.Player;

import java.util.Scanner;

/**
 * Diese Klasse stellt das Verhalten bereit, wenn ein Spiel auf das Feld 'Gefängnis' kommt.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class Jail implements Sqaure {
    @Override
    public String name() {
        return "Gefängnis";
    }

    @Override
    public void walkOn(final Player player) {
        //Keien Aktion nötig, wenn Spieler auf dieses Feld geht! (Spieler ist ja nur Besucher)
    }

    @Override
    public void walkOver(final Player player) {
        //Keine Aktion nötig, wenn Spieler über diese Feld geht!
    }
}
