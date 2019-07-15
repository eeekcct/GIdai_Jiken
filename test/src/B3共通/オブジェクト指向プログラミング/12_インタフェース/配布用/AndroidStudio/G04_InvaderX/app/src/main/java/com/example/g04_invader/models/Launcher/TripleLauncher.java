package com.example.g04_invader.models.Launcher;

import com.example.g04_invader.models.missile.IMissile;

public class TripleLauncher implements ILauncher {
    private float ySpeed = 0;
    private IMissile missile1 = null;
    private IMissile missile2 = null;
    private IMissile missile3 = null;

    public TripleLauncher(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public void clearMissile() {
        missile1 = null;
        missile2 = null;
        missile3 = null;
    }

    @Override
    public void setMissile(IMissile missile) {
        if (missile1 == null) {
            this.missile1 = missile;
        } else if (missile2 == null) {
            this.missile2 = missile;
        } else if (missile3 == null) {
            this.missile3 = missile;
        }
    }

    @Override
    public void fire(float x, float y) {
        if(missile1 != null && missile2 != null && missile3 != null) {
            if (!missile1.isActive() && !missile2.isActive() && !missile3.isActive()) {
                missile1.fire(x + 20, y, ySpeed);
                missile2.fire(x, y, ySpeed);
                missile3.fire(x - 20, y, ySpeed);
            }
        }
    }
}
