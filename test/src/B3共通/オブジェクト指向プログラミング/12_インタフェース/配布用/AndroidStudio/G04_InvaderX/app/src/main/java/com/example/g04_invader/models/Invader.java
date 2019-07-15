package com.example.g04_invader.models;

import com.example.g04_invader.models.Launcher.ILauncher;

import java.util.LinkedList;

public class Invader extends GameCharacter implements ITarget {
    private int type = 1;
    private int state = 0;
    private boolean dead = false;
    private ILauncher launcher = null;
    private LinkedList<ITarget> targets = new LinkedList<ITarget>();

    public Invader(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.xSize = 40;
        this.ySize = 25;
        this.type = type;
    }

    public void setLauncher(ILauncher launcher) {
        this.launcher = launcher;
    }

    public void setTarget(ITarget target) {
        targets.add(target);
    }

    public int getType() {
        return type;
    }

    public boolean isDead() {
        return dead;
    }

    public void move(float dx, float dy) {
        x = x + dx;
        y = y + dy;
        attack();
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void move() {
        if (!dead) {
            int r = (int) (Math.random() * 1000);
            if (r == 0) {
                launcher.fire(x + xSize / 2 - 5, y);
            }
        }
    }

    protected void attack() {
        if(dead == false) {
            for (ITarget target : targets) {
                if (target.isDead() == false && isOverlapWith(target)) {
                    target.dead();
                    break;
                }
            }
        }
    }

    @Override
    public void dead() {
        dead = true;
    }
}
