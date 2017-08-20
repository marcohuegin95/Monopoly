package com.fields;

import com.game.*;

/**
 * Dieses Interface stellt Methodenrümpfe für die veschiedenen Felder des Spiels bereit.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public interface Sqaure {

    String name();

    void walkOn(Player player);

    void walkOver(Player player);

}

//