package com.core;

import java.util.Scanner;

/**
 * Created by marco on 25.07.17.
 */
public class Main {

    public static void main(String[] args) {

        int numberOfPlayers;
        System.out.println("----------------Monopoly (WWI16b-SE Marco Huegin)----------------");
        System.out.println("");
        System.out.print("Bitte geben Sie die Anzahl der Spieler an: ");

        Scanner scanner= new Scanner(System.in);
        numberOfPlayers = scanner.nextInt();

        com.core.Game game= new com.core.Game(numberOfPlayers);

    }
}
