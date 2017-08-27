package com.game;

import com.fields.Property;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Diese Klasse stellt die Logik der Spieler bereit.
 * Dazu zählt die Initaliserung der Spieler, das  transferieren von Geldern, usw.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class Player {
    private Player player;

    public enum color {
        RED, GREEN, BLUE, YELLOW, ORANGE, BLACK;
    }

    private int money;
    private String name;
    private color color;
    private boolean inJail;
    private int position;
    private int roundsPlayerInJail;        //Anzahl der Runden, in der der Spieler im Gefängnis sitz
    private final int STARTPOSITION_PLAYER = 0;    //Konstante für das erste Feld
    ArrayList<Property> playerPropertyList = new ArrayList<Property>();

    public Player(String name, color pcolor, int money, int position) {
        this.name = name;
        this.color = pcolor;
        this.money = money;
        this.position = position;
        inJail = false;
        this.playerPropertyList.clear();
        roundsPlayerInJail = 0;
    }

    /**
     * Dem Spieler einen entsprechende Summe auf dem Konto gutschreiben.
     *
     * @param getMoney der zu addierende Betrag des Spiels
     */
    public void transferMoney(int getMoney) {
        money = money + getMoney;
    }


    /**
     * Methode um einen kompletten Spielzug durchzuführen.
     * Dabei wird zuerst geprüft, ob der jeweilige Spieler im Gefängnis ist.
     * Der Spieler geht über die verschiedenen Felder und löst alle nötigen Aktionen aus.
     *
     * @param die1  erstes Würfel-Objekt für den Spielzug
     * @param die2  zweites Würfel-Objekt für den Spielzug
     * @param board Board-Objekt, für den Spielzug
     */
    public void takeTurn(Die die1, Die die2, Board board) {

        if (this.inJail) { // Ist der Spieler im Gefängnis
            this.takeTurnInJail(die1, die2, board);
        } else {
            die1.roll();
            die2.roll();
            int oldPosition = this.getPosition();
            int resultDies = die1.getEyeCount() + die2.getEyeCount();
            int counterPlayer = 1;  //Zusätzlicher Counter der die Felder zählt, wo der Spieler drüberläuft. Ist nötig, da der Counter aus der for-Schleife immer weiter läuft.
            for (int i = 1; i < resultDies; i++) {
                if ((this.getPosition() + counterPlayer) > board.getFields().size()) {
                    this.setPosition(STARTPOSITION_PLAYER);
                    board.getFields().get(STARTPOSITION_PLAYER).walkOver(this);
                    counterPlayer = 1;  // Counter wird auf 1 gesetzt, da ab Position 1 (Feld 0) sonst nicht alle Felder erreicht werden
                } else {
                    board.getFields().get(this.getPosition() + counterPlayer).walkOver(this);
                }
                counterPlayer++;
            }
            if ((oldPosition + resultDies) > board.getFields().size()) {
                this.setPosition(oldPosition + resultDies - board.getFields().size());
            } else {
                this.setPosition(oldPosition + resultDies);
            }
            board.getFields().get(this.getPosition()).walkOn(this);
        }
    }

    /**
     * Methode um einen kompletten Spielzug durchzuführen, wenn der Spieler im Gefängnis ist.
     *
     * @param die1  erstes Würfel-Objekt für den Spielzug im Gefängnis
     * @param die2  zweites Würfel-Objekt für den Spielzug im Gefängnis
     * @param board Board-Objekt, für den Spielzug im Gefängnis
     */
    public void takeTurnInJail(Die die1, Die die2, Board board) {
        if (this.getRoundsPlayerInJail() >= 3) {      // Wenn der Spieler 3 Runden im Gefängnis war, darf er einen normalen Spielzug durchführen
            this.setInJail(false);
            this.setRoundsPlayerInJail(0);
            this.transferMoney(-50);
            this.takeTurnInJail(die1, die2, board);
            System.out.println("Spieler " + this.getName() + " kommt aus dem Gefängnis und zahlt nochmals 50€");
        } else {
            System.out.println("Wollen sie 50€ zahlen um direkt aus dem Gefägnis zu kommen('Ja' oder 'Nein' schreiben)?");
            Scanner scanner = new Scanner(System.in);   //Benutzer-Interaktion erstmal durch Texteingabe, wird später durch graf. Oberfläche abgelöst
            String eingabeUser = scanner.next();
            while (eingabeUser != "Ja" || eingabeUser != "Nein") {
                System.out.println("Falsche Eingabe! Bitte geben sie 'Ja' oder 'Nein' ein! ");
                eingabeUser = scanner.next();
            }
            if (eingabeUser == "Ja") {
                this.transferMoney(-50);
                this.setInJail(false);
                this.setRoundsPlayerInJail(0);
                this.takeTurn(die1, die2, board);
                System.out.println("Der Spieler " + this.getName() + " bezahlt 50€ und geht sofort aus dem Gefängnis!");
            } else if (eingabeUser == "Nein") {
                die1.roll();
                die2.roll();
                if (die1.getEyeCount() == die2.getEyeCount()) {
                    this.setInJail(false);
                    this.setRoundsPlayerInJail(0);
                    this.takeTurn(die1, die2, board);
                    System.out.println("Der Spieler hat einen " + die1.getEyeCount() + "-Pasch und darf das Gefängnis sofort verlassen!");
                } else {
                    this.setRoundsPlayerInJail(this.getRoundsPlayerInJail() + 1);
                }
            } else {
                System.out.println("Fehler beim Einlesen des Scanners");
            }
        }
    }

    /**
     * Prüft ob der Spieler noch genug Geld (mehr als 0€) hat, um am Spiel teilzunehmen
     *
     * @return true wenn Spieler noch genug Geld hat (>0€), false wenn Spieler bankrott ist (0€)
     */
    public boolean isBankrupt() {
        if (money <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Fügt dem aktuellen Spieler ein Grundstück hinzu.
     * Dabei wird er als Besitzer gesetzt und nimmt das Grundstück in seine Grundstücksliste auf.
     * Der Spieler muss den Preis zahlen
     *
     * @param property      das Grundstück, das vom Spieler gekauft wird
     * @param purchasePrice der Kaufpreis des Grundstücks (Straße)
     */
    public void purchaseProperty(Property property, int purchasePrice) {
        this.playerPropertyList.add(property);
        this.transferMoney(-purchasePrice);
        property.setOwner(this);
    }

    /**
     * Führt den verkauf des Grundstücks durch.
     * Dabei wird der Besitzer geändert, der Preis für das Grundstück an den alten Spieler überwiesen
     * und die Grundstückslisten der Spieler aktualisiert.
     *
     * @param property das Grundstück, das vom Spieler verkauft wird
     * @param oldOwner der alte Besitzer des Grundstücks (Straße)
     */
    public void salePropertie(Property property, Player oldOwner) {
        property.setOwner(this);
        this.playerPropertyList.add(property);
        this.transferMoney(-property.getPrice());
        oldOwner.transferMoney(property.getPrice());
        for (int x = 0; x <= oldOwner.playerPropertyList.size(); x++) {
            if (property == oldOwner.playerPropertyList.get(x)) {
                oldOwner.playerPropertyList.remove(x);
                break;
            }
        }
    }

    /**
     * Löscht die komplette Grundstücksliste eines Spiels (Bei Spielaustritt)
     *
     * @param player der jeweilige Spieler, von welchem die Grundstücke gelöscht werden müssen*
     */
    public void deleteProperties(Player player) {
        for (int x = 0; x <= player.playerPropertyList.size() - 1; x++) {
            player.playerPropertyList.get(x).setOwner(null);
        }
        player.playerPropertyList.clear();  // Zur Sicherheit wird hier nochmal alles gecleart. Wird eigentlich schon durch den vorherigen Schritt (alles auf null setzen erreicht)
    }

    public Player.color getColor() {
        return color;
    }

    public int getRoundsPlayerInJail() {
        return roundsPlayerInJail;
    }

    public void setRoundsPlayerInJail(int roundsPlayerInJail) {
        this.roundsPlayerInJail = roundsPlayerInJail;
    }

    public void setColor(Player.color color) {
        this.color = color;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ArrayList<Property> getPlayerPropertyList() {
        return playerPropertyList;
    }

    public void setPlayerPropertyList(ArrayList<Property> playerPropertyList) {
        this.playerPropertyList = playerPropertyList;
    }
}
