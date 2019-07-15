package com.example.g04_invader.models.missile;

import com.example.g04_invader.models.GameCharacter;
import com.example.g04_invader.models.ITarget;
import com.example.g04_invader.models.World;

import java.util.LinkedList;

public abstract class Missile extends GameCharacter implements IMissile, ITarget {
    protected boolean active = false;
    protected LinkedList<ITarget> targets = new LinkedList<ITarget>();

    public Missile() {
        this.xSize = 10;
        this.ySize = 20;
    }

    @Override
    public void setTarget(ITarget target) {
        targets.add(target);
    }

    @Override
    public void fire(float x, float y, float ySpeed) {
        if (active == false) {
            this.x = x;
            this.y = y;
            this.ySpeed = ySpeed;
            active = true;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void move() {
        if (active == true) {
            y = y + ySpeed;
            if (y < 0 || World.HEIGHT < y) {
                active = false;
            }

            attack();
        }
    }

    @Override
    public boolean isDead() {
        return !active;
    }

    public void dead() {
        active = false;
    }

    abstract protected void attack();
}
