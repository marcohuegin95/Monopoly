package com.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.game.*;

/**
 * Diese Klasse enthält die komplette Spiellogik (Die komplette Durchführung eines Spielzugs).
 * Hier werden die Objekte für die Spieler, Würfel und das Spielboard erzeugt.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class Game {
    public String namePlayer;
    Die die1;
    Die die2;
    public Board board;
    int counter = 1;
    ArrayList<Player> player = new ArrayList<>();

    public Game(int numberOfPlayers) {

        die1 = new Die();
        die2 = new Die();
        board = new Board();

        for (int i1 = 0; i1 < numberOfPlayers; i1++) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Bitte geben Sie ein Name für Spieler " + i1 + " ein: ");
            namePlayer = scan.next();
            player.add(new Player(namePlayer, Player.color.ORANGE, 1000, 0));
        }
    }

    /**
     * Steuert das Spiel, indem die Liste der Spieler nacheinander durchgegangen wird. Ist man am Ende Liste angekommen,
     * ist der erste Spieler der Liste wieder an der Reihe. Ist nur noch ein Spieler im Spiel wird das Spiel beendet.
     */
    public void gameController() {
        System.out.println("");
        while (player.size() >= 2){
        Iterator<Player> iterator = player.iterator();
        while (iterator.hasNext() /*&& player.size() >= 2*/) {
            Player playerOnTurn = iterator.next();
            System.out.println("-----------Spielzug Nr." + counter + " -----------");
            counter++;
            System.out.println("Spieler: " + playerOnTurn.getName() + " ist am Spielzug (Kontostand: " + playerOnTurn.getMoney() + ")");
            playerOnTurn.takeTurn(die1, die2, board);
            if (playerOnTurn.isBankrupt()) {
                iterator.remove();
                playerOnTurn.deleteProperties(playerOnTurn);
                System.out.println("Spieler " + playerOnTurn.getName() + " wird aus dem Spiel entfernt");
            }
        }
        }
        System.out.println("Spieler " + player.get(0).getName() + " hat gewonnen (Mit einem Kontostand von " + player.get(0).getMoney() + "€)");
    }
}
