package com.example.g04_invader.models.missile;

import com.example.g04_invader.models.ITarget;

public class NormalMissile extends Missile {
    protected void attack() {
        for (ITarget target : targets) {
            if (target.isDead() == false && isOverlapWith(target)) {
                target.dead();
                active = false;
                break;
            }
        }
    }
}
