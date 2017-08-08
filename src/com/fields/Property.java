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
    private int owner;

    public void purchaseProperty(int balance, int color){
        owner= color;
        
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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    @Override
    public void walkOn(Player player) {

    }

    @Override
    public void walkOver(Player player) {

    }
}