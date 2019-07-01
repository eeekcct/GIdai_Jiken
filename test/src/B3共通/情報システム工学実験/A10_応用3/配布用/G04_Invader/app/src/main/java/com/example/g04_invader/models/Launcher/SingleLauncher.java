package com.example.g04_invader.models.Launcher;

import com.example.g04_invader.models.Missile;

public class SingleLauncher extends Launcher {
    private float ySpeed=0;
    Missile missile = null;

    public void setMissile(Missile missile) {
        this.missile = missile;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed=ySpeed;
    }

    public void fire(float x, float y) {
        missile.fire(x, y,ySpeed);
    }
}
