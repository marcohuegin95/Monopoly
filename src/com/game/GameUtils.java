package com.game;

/**
 * Stellt verschiedene Hilfsunktionen für das komplette Spiel bereit
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class GameUtils {

    /**
     * Generiert eine Zufallszahl zwischen 0 und 200 (in Zehnerschritten) sowie
     * eine negative Zufallszahl zwischen 0 und -300 (in Zehnerschritten).
     * Wird für das Feld 'Chance' benötigt.
     *
     * @return gibt eine Zufallszahl (Betrag) zurück (Entweder negativ, positiv oder 0)
     */
    public static int randomMoney() {

        int selectRandomAmount = (int) ((Math.random()) * 2 + 1);  // Zufällig 1 oder 2 wählen

        if (selectRandomAmount == 1) {   //Wird für selectRandomAmount 1 gewählt, wird eine positiver Betrag zwischen 0-200 gewählt
            return ((int) ((Math.random()) * 20 + 0)) * 10;
        } else if (selectRandomAmount == 2) { //Wird für selectRandomAmount 2 gewählt, wird eine negativer Betrag zwischen 0-300 gewählt
            return ((int) ((Math.random()) * -30 + 0)) * 10;
        }else{
            return 0;
        }
    }
}
