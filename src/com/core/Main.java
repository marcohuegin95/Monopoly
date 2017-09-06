package com.core;

import javax.swing.*;
import java.util.Scanner;

/**
 * Diese Klasse dient dazu, das Spiel zu starten. Dazu wird die Game erzeugt und die Methode gameController() aufgerufen.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) {

        int numberOfPlayers;
        System.out.println("----------------Monopoly (WWI16b-SE Marco Huegin)----------------");
        System.out.println("");
        System.out.print("Bitte geben Sie die Anzahl der Spieler an (Zwischen 2 und 6 Spieler): ");

        Scanner scanner = new Scanner(System.in);
        numberOfPlayers = scanner.nextInt();
        while (numberOfPlayers < 2 || numberOfPlayers > 6) {
            System.out.println("Falsche Anzahl an Spieler angegeben. Bitte eine Spieler-Anzahl zwschen 2-6 angeben!");
            numberOfPlayers = scanner.nextInt();
        }

        Game game = new Game(numberOfPlayers);
        game.gameController();

    }
}
