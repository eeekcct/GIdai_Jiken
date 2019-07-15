package com.example.g04_invader.models;

public class Ufo extends GameCharacter implements ITarget {
    private boolean active = false;
    private int counter = 0;

    public Ufo() {
        this.x = 0;
        this.y = 320;
        this.xSize = 64;
        this.ySize = 30;
    }

    public boolean isActive() {
        return active;
    }

    public void move() {
        if (active) {
            x = x + xSpeed;
            if (isOutOfWorld()) {
                dead();
            }
        } else {
            counter--;
            if (counter < 0) {
                active = true;
                if (getRandom0or1() == 0) {
                    xSpeed = 2;
                    x = 0 - xSize;
                } else {
                    xSpeed = -2;
                    x = World.WIDTH;
                }
            }
        }
    }

    private int getRandom0or1() {
        return (int) (Math.random() * 2);
    }

    private boolean isOutOfWorld() {
        return x + xSize - 1 < 0 || World.WIDTH < x;
    }

    @Override
    public void dead() {
        active = false;
        counter = 1000 + (int) (Math.random() * 1000);
    }

    @Override
    public boolean isDead() {
        return !active;
    }
}
