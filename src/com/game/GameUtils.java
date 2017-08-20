package com.game;

/**
 * Stellt verschiedene Hilfsunktionen für das komplette Spiel bereit
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class GameUtils {

    /**
     * Generiert eine Zufallszahl zwischen 0 und 200 (in Zehnerschritten) oder
     * eine negative Zufallszahl zwischen 0 und -300 (in Zehnerschritten).
     * Wird für das Feld 'Chance' benötigt.
     *
     * @return gibt eine Zufallszahl (Betrag) zurück (Entweder negativ, positiv oder 0)
     */
    public static int randomMoney() {
        return ((int) ((Math.random()) * 50 - 30)) * 10;
    }
}
