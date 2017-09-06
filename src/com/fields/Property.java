package com.fields;

import com.game.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            System.out.print("Will der Besitzer der Straße (Spieler " + this.getOwner().getName() + ") die Straße an den Spieler " + player.getName() + " abgeben? ('1=Ja' oder '2=Nein' schreiben)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int eingabeUser = 0;
            try {
                eingabeUser = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (eingabeUser == 1) {
                player.salePropertie(this, this.getOwner());
            } else if (eingabeUser == 2) {
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
