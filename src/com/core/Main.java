package com.core;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numberOfPlayers;
        System.out.println("----------------Monopoly (WWI16b-SE Marco Huegin)----------------");
        System.out.println("");
        System.out.print("Bitte geben Sie die Anzahl der Spieler an: ");

        Scanner scanner = new Scanner(System.in);
        numberOfPlayers = scanner.nextInt();

        Game game = new Game(numberOfPlayers);

    }
}
