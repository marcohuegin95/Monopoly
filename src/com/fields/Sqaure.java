package com.fields;

import com.game.*;

/**
 * Dieses Interface stellt Methodenrümpfe für die veschiedenen Aktionen der Felder des Spiels bereit.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public interface Sqaure {

    String name();

    void walkOn(final Player player);

    void walkOver(final Player player);

}

//