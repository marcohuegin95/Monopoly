package com.fields;

import com.game.Player;

/**
 * Diese Klasse stellt das Verhalten bereit, wenn ein Spiel auf das Feld 'Grundstück' kommt.
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

    /**
     * Methode, um bereits verkaufte Objekt wieder freizugeben
     */

    public void propertyFree(Player player, Property property){
        player.getPlayerPropertyList().remove(this);
        // TODO fertigstellen!
    }


    @Override
    public String name() {
        return "Property: "+getName();
    }

    @Override
    public void walkOn(Player player) {

        if (getOwner() == null) {
            if (player.getMoney() > getPrice()) {
                player.purchaseProperty(player,this,getPrice());
            } else {
                System.out.println("Spieler " + player + " hat nicht genug Geld um das Grundstück zu erwerben");
            }
        } else if (player != owner) {
            int newPrice = (int) (getPrice() * (1.5)); // Spieler muss 1,5 mal so viel zahlen wie der eigentliche Grundstückspreis war
            player.payRent(player,this,newPrice);
        }
        // if null==owner
        // if (p.getBalance ()> price
        // p.offerProperty (this)
        //else if (p!= owner)
        //1,5fachen Preis zahlen
    }

    @Override
    public void walkOver(Player player) {
        //Keine Aktion nötig, wenn Spieler über diese Feld geht!
    }
}
