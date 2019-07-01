package com.example.g04_invader.models;

import java.util.LinkedList;

public class Missile extends TargetCharacter {
    protected LinkedList<TargetCharacter> targets = new LinkedList<TargetCharacter>();

    public Missile() {
        this.xSize = 10;
        this.ySize = 20;
        this.dead = true;
    }

    public void setTarget(TargetCharacter target) {
        targets.add(target);
    }

    public void fire(float x, float y, float ySpeed) {
        if (dead == true) {
            this.x = x;
            this.y = y;
            this.ySpeed = ySpeed;
            dead = false;
        }
    }

    public void move() {
        if (dead == false) {
            y = y + ySpeed;
            if (y + ySize - 1 < 0 || World.HEIGHT < y) {
                dead = true;
            }

            attack();
        }
    }

    protected void attack() {
        for (int i = 0; i < targets.size(); i++) {
            if (targets.get(i).isDead() == false && isOverlapWith(targets.get(i))) {
                targets.get(i).dead();
                dead = true;
                break;
            }
        }
    }


}
