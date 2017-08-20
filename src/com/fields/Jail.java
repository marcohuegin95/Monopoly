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
    public void walkOn(Player player) {
        Die die1 = new Die();    //Hier müssen keine neuen Würfel-Objekte erstellt werden?!?!?!? TODO: Stelle hier ersetzen!!!!!
        Die die2 = new Die();
        if (player.isInJail() == true && player.getRoundsPlayerInJail() <= 3) { //Ist der Spieler im Gefängnis und weniger als 3 Runden im Gefängnis
            System.out.println("Wollen sie 50€ zahlen um direkt aus dem Gefägnis zu kommen('Ja' oder 'Nein' schreiben)?");

            Scanner scanner = new Scanner(System.in);   //Benutzer-Interaktion erstmal durch Texteingabe, wird später durch graf. Oberfläche abgelöst
            String eingabeUser = scanner.next();

            while (eingabeUser != "Ja" || eingabeUser != "Nein") {
                System.out.println("Falsche Eingabe! Bitte geben sie 'Ja' oder 'Nein' ein! ");
                eingabeUser = scanner.next();
            }

            if (eingabeUser == "Ja") {
                player.transferMoney(-50);          // TODO: Workaround hier muss raus!!!!
                die1.roll();
                die2.roll();
                int resultDies = die1.getEyeCount() + die2.getEyeCount();
                player.setPosition(player.getPosition() + resultDies);
                player.setInJail(false);
                player.setRoundsPlayerInJail(0); //Anzahl der Runden im Gefängnis wieder auf 0 setzen
            } else if (eingabeUser == "Nein") {
                die1.roll();
                die2.roll();                                        // TODO: Workaround hier muss raus!!!!
                if (die1.getEyeCount() == die2.getEyeCount()) {     // Wurde ein Pasch gewürfelt?
                    player.setInJail(false);
                    player.setRoundsPlayerInJail(0);
                    player.setPosition(player.getPosition() + die1.getEyeCount());
                } else {
                    player.setRoundsPlayerInJail(player.getRoundsPlayerInJail() + 1);
                }
            } else {
                System.out.println("Fehler beim Einlesen des Scanners");
            }

        } else if (player.getRoundsPlayerInJail() > 3) {                // TODO: Workaround hier muss raus!!!!
            die1.roll();
            die2.roll();
            int resultDies = die1.getEyeCount() + die2.getEyeCount();
            player.setPosition(player.getPosition() + resultDies);
            player.transferMoney(-50);
            player.setInJail(false);
            player.setRoundsPlayerInJail(0);
        }
    }

    @Override
    public void walkOver(Player player) {
        //Keine Aktion nötig, wenn Spieler über diese Feld geht!
    }
}
