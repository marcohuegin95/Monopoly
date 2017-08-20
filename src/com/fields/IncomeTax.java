package com.fields;

import com.game.Player;

/**
 * Diese Klasse stellt das Verhalten bereit, wenn ein Spiel auf das Feld 'Einkommenssteuer' kommt.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class IncomeTax implements Sqaure {

    @Override
    public String name() {
        return "Einkommenssteuer";
    }

    @Override
    public void walkOn(Player player) {
        int taxMoney = ((player.getMoney()) * (1 / 10) * (-1)); // Hole Geld, berechne 10% aus und negiere Betrag
        System.out.println("Spieler " + player + " ist auf dem Feld 'Einkommenssteuer' und muss " + taxMoney + "€ zahlen");
        player.transferMoney(taxMoney);
    }

    @Override
    public void walkOver(Player player) {
        //Keine Aktion nötig, wenn Spieler über diese Feld geht!
    }
}
