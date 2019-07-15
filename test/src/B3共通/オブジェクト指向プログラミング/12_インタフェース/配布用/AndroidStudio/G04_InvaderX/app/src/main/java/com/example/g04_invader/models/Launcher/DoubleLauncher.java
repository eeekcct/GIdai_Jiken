package com.example.g04_invader.models.Launcher;

import com.example.g04_invader.models.missile.IMissile;

public class DoubleLauncher implements ILauncher {
    private float ySpeed = 0;
    private IMissile missile1 = null;
    private IMissile missile2 = null;

    public DoubleLauncher(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public void clearMissile() {
        missile1 = null;
        missile2 = null;
    }

    @Override
    public void setMissile(IMissile missile) {
        if (missile1 == null) {
            this.missile1 = missile;
        } else if (missile2 == null) {
            this.missile2 = missile;
        }
    }

    @Override
    public void fire(float x, float y) {
        if(missile1 != null && missile2 != null) {
            if (missile1.isActive() == false && missile2.isActive() == false) {
                missile1.fire(x + 10, y, ySpeed);
                missile2.fire(x - 10, y, ySpeed);
            }
        }
    }
}
