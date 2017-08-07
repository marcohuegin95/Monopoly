package com.game;

/**
 * Created by marco on 25.07.17.
 */
public class Die {
    private int eyeCount;

    public Die() {
        roll();
    }

    public void roll(){
        eyeCount=(int)((Math.random()) * 6 + 1);
    }

    public int getEyeCount() {
        return eyeCount;
    }

    public void setEyeCount(int eyeCount) {
        this.eyeCount = eyeCount;
    }
}
