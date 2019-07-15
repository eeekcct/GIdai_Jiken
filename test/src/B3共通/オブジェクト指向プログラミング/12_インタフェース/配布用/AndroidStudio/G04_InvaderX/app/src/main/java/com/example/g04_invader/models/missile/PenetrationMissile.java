package com.example.g04_invader.models.missile;

import com.example.g04_invader.models.ITarget;

public class PenetrationMissile extends Missile {
    protected void attack() {
        for (ITarget target : targets) {
            if (isOverlapWith(target)) {
                target.dead();
            }
        }
    }

}
