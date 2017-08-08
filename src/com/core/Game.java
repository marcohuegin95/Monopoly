package com.core;

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
    public int colorPlayer;
    Die die1;
    Die die2;
    Board board;
    Player[]player;

    public Game(int numberOfPlayers) {
        Player[]player= new Player[numberOfPlayers];
        for (int i1=0;i1<numberOfPlayers;i1++){
           Scanner scan = new Scanner(System.in);
           System.out.print("Bitte geben Sie ein Name für Spieler "+i1+" ein: ");
           namePlayer= scan.next();
           //System.out.print("Bitte geben Sie eine Farbe für Spieler "+i1+" ein: ");
           //colorPlayer= scan.nextInt();
           player[i1]=new Player(namePlayer, Player.color.ORANGE);
        }
    die1 = new Die();
    die2 = new Die();
    board = new Board();

    }
}
