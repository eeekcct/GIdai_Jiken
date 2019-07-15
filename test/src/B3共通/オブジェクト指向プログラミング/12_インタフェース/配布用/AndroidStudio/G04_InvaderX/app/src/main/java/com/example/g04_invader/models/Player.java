package com.example.g04_invader.models;

import com.example.g04_invader.models.Launcher.ILauncher;

public class Player extends GameCharacter implements ITarget {
    private boolean dead = false;
    private ILauncher launcher = null;

    public Player() {
        x = 284;
        y = 0;
        xSize = 32;
        ySize = 20;
    }

    public void setLauncher(ILauncher launcher) {
        this.launcher = launcher;
    }

    public void dead() {
        dead = true;
    }

    public boolean isDead() {
        return dead;
    }

    public void goRight() {
        x = x + 10;
    }

    public void goLeft() {
        x = x - 10;
    }

    public void fire() {
        launcher.fire(x + xSize / 2 - 5, y + ySize);
    }

    public void move() {
        x = x + xSpeed;
        if (x < 0) {
            x = 0;
        }
        if (x > World.WIDTH - xSize + 1) {
            x = World.WIDTH - xSize + 1;
        }
    }


}
