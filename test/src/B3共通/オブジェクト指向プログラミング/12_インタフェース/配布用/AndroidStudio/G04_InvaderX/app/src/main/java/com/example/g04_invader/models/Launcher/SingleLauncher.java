package com.example.g04_invader.models.Launcher;

import com.example.g04_invader.models.missile.IMissile;

public class SingleLauncher implements ILauncher {
    private float ySpeed = 0;
    IMissile missile = null;

    public SingleLauncher(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public void clearMissile() {
        missile = null;
    }

    @Override
    public void setMissile(IMissile missile) {
        this.missile = missile;
    }

    @Override
    public void fire(float x, float y) {
        if (missile != null) {
            missile.fire(x, y, ySpeed);
        }
    }
}
