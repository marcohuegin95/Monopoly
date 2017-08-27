package com.fields;

import com.game.Player;

import java.util.Scanner;

/**
 * Diese Klasse stellt das Verhalten bereit, wenn ein Spiel auf das Feld 'Grundstück' bzw Straße kommt.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class Property implements Sqaure {

    public enum category {
        PURPLE, ORANGE, YELLOW, BLUE;
    }

    private String name;
    private int price;
    private category category;
    private Player owner;

    public Property(String name, int price, category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String name() {
        return "Property: " + getName();
    }

    @Override
    public void walkOn(final Player player) {

        if (getOwner() == null) {
            if (player.getMoney() > getPrice()) {
                player.purchaseProperty(this, getPrice());
            } else {
                System.out.println("Spieler " + player.getName() + " hat nicht genug Geld um das Grundstück zu erwerben");
            }
        } else if (player != owner) {
            System.out.println("Will der Besitzer der Straße (Spieler " + this.getOwner().getName() + ") die Straße an den Spieler " + player.getName() + " abgeben? ('Ja' oder 'Nein' schreiben)");
            Scanner scanner = new Scanner(System.in);   //Benutzer-Interaktion erstmal durch Texteingabe, wird später durch graf. Oberfläche abgelöst
            String eingabeUser = scanner.next();
            while (eingabeUser != "Ja" || eingabeUser != "Nein") {
                System.out.print("Falsche Eingabe! Bitte geben sie 'Ja' oder 'Nein' ein: ");
                eingabeUser = scanner.next();
            }
            if (eingabeUser == "Ja") {
                player.salePropertie(this, this.getOwner());
            } else if (eingabeUser == "Nein") {
                int newPrice = (int) (getPrice() * (1.5)); // Spieler muss 1,5 mal so viel zahlen wie der eigentliche Grundstückspreis war
                this.getOwner().transferMoney(newPrice);
            } else {
                System.out.println("Fehler beim Einlesen des Scanners");
            }
        }
    }

    @Override
    public void walkOver(final Player player) {
        //Keine Aktion nötig, wenn Spieler über diese Feld geht!
    }
}
