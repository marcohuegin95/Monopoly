package com.game;

/**
 * Diese Klasse stellt die Logik der Spielwürfel bereit.
 *
 * @author Marco Hügin
 * @version 1.0
 */

public class Die {
    private int eyeCount;

    public Die() {
        roll();
    }

    public void roll() {
        setEyeCount((int) ((Math.random()) * 6 + 1));
    }

    public int getEyeCount() {
        return eyeCount;
    }

    public void setEyeCount(int eyeCount) {
        this.eyeCount = eyeCount;
    }
}
