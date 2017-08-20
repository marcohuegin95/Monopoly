package com.game;

import com.fields.*;

import java.util.ArrayList;

/**
 * Diese Klasse stellt das Verhalten und Daten bezüglich des Spielfelds (Board) bereit.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class Board {

    private final ArrayList<Sqaure> fields = new ArrayList<>();
    //private final Jail jailSquare ) new Jail();

    public Board() {

        // Verschiedene Kategorieren durch Enum
        // 1-> lila (PURPLE)
        // 2-> orange (ORANGE)
        // 3-> gelb (YELLOW)
        // 4-> blau (BLUE)

        fields.add(new Go());
        fields.add(new Property("Dübendorfstraße", 60, Property.category.PURPLE));
        fields.add(new Property("Winterthurerstraße", 60, Property.category.PURPLE));
        fields.add(new IncomeTax());
        fields.add(new Property("Schwamen-Dingerplatz", 80, Property.category.PURPLE));
        fields.add(new Jail());
        fields.add(new Property("Josefwiese", 100, Property.category.ORANGE));
        fields.add(new Property("Escher-Wyss-Platz", 120, Property.category.ORANGE));
        fields.add(new Chance());
        fields.add(new Property("Langstrasse", 160, Property.category.ORANGE));
        fields.add(new FreeParking());
        fields.add(new Property("Schaffhauser-Platz", 220, Property.category.YELLOW));
        fields.add(new Chance());
        fields.add(new Property("Universitätsstrasse", 260, Property.category.YELLOW));
        fields.add(new Property("Irchelpark", 260, Property.category.YELLOW));
        fields.add(new GoToJail());
        fields.add(new Property("Bellevue", 320, Property.category.BLUE));
        fields.add(new Property("Niederdorf", 350, Property.category.BLUE));
        fields.add(new Chance());
        fields.add(new Property("Bahnhofstrasse", 400, Property.category.BLUE));
    }

}
