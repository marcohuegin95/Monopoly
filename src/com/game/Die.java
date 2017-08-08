package com.game;

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
