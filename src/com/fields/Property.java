package com.fields;

import com.game.Player;

/**
 * Diese Klasse stellt das Verhalten bereit, wenn ein Spiel auf das Feld 'Grundstück' kommt.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class Property implements Sqaure{
    private String name;
    private int price;
    private int category;
    private Player owner;

    public void purchaseProperty(int balance, Player color){
        owner= color;
        
    }

    public Property(String name, int price, int category) {
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
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
        return "Property";
    }

    @Override
    public void walkOn(final Player player) {
        // if null==owner
        // if (p.getBalance ()> price
        // p.offerProperty (this)
        //else if (p!= owner)
        //1,5fachen Preis zahlen
    }

    @Override
    public void walkOver(Player player) {

    }
}
