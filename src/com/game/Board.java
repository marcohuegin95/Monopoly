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

    private final ArrayList<Sqaure> fields= new ArrayList<>();
    //Property[] board = new Property[20];
    //private final ArrayList <Square>  squares= new ArrayList<>();
    //private final Jail jailSquare ) new Jail();

    public Board() {

        // Verschiedene Kategorieren (vorübergehend)
        // 1-> lila
        // 2-> orange
        // 3-> gelb
        // 4-> blau

        fields.add(new Go());
        fields.add(new Property("Dübendorfstraße",60, 1));
        fields.add(new Property("Winterthurerstraße",60,1));
        fields.add(new IncomeTax());
        fields.add(new Property("Schwamen-Dingerplatz",80,1));
        fields.add(new Jail());
        fields.add(new Property("Josefwiese",100,2));
        fields.add(new Property("Escher-Wyss-Platz",120,2));
        fields.add(new Chance());
        fields.add(new Property("Langstrasse",160,2));
        fields.add(new FreeParking());
        fields.add(new Property("Schaffhauser-Platz",220,3));
        fields.add(new Chance());
        fields.add(new Property("Universitätsstrasse",260,3));
        fields.add(new Property("Irchelpark",260,3));
        fields.add (new GoToJail());
        fields.add(new Property("Bellevue",320, 4));
        fields.add(new Property("Niederdorf",350,4));
        fields.add(new Chance());
        fields.add(new Property("Bahnhofstrasse",400,4));
    }

}
