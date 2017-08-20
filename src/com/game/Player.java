package com.game;

/**
 * Diese Klasse stellt die Logik der Spieler bereit.
 * Dazu zählt die Initaliserung der Spieler, das  transferieren von Geldern, usw.
 *
 * @author Marco Hügin
 * @version 1.0
 */


//privat collection


public class Player {
    public enum color {
        RED, GREEN, BLUE, YELLOW, ORANGE, BLACK;
    }

    private int money;
    private String name;
    private color color;
    private boolean inJail;
    private int position;

    public Player(String name, color pcolor) {
        this.name = name;
        this.color = pcolor;
        inJail = false;
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
        int result = die1.getEyeCount() + die2.getEyeCount();
        this.setPosition(position+result);
    }

//    public int getColor() {
//        return color;
//    }

//    public void setColor(int color) {
//        this.color = color;
//    }

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
}
