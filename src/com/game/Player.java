package com.game;

import com.fields.Property;

import java.util.ArrayList;

/**
 * Diese Klasse stellt die Logik der Spieler bereit.
 * Dazu zählt die Initaliserung der Spieler, das  transferieren von Geldern, usw.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class Player {
    public enum color {
        RED, GREEN, BLUE, YELLOW, ORANGE, BLACK;
    }

    private int money;
    private String name;
    private color color;
    private boolean inJail;
    private int position;
    private int roundsPlayerInJail; //Anzahl der Runden, in der der Spieler im Gefängnis sitz
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

    public void transferMoney(int getMoney) {
        money = money + getMoney;
    }

    public boolean isBankrupt() {
        if (money <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void takeTurn(Die die1, Die die2) {
        die1.roll();
        die2.roll();
        int resultDies = die1.getEyeCount() + die2.getEyeCount();
        this.setPosition(getPosition() + resultDies);
    }

    public void removeAllPropertys(Player player) {
        player.playerPropertyList.clear();
    }

    public void purchaseProperty(Player player, Property property, int purchasePrice) {
        player.playerPropertyList.add(property);
        player.transferMoney(purchasePrice*(-1));
        property.setOwner(player);
    }

    public void payRent(Player player, Property property,int rentalFee){
        player.transferMoney(rentalFee*(-1));
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
