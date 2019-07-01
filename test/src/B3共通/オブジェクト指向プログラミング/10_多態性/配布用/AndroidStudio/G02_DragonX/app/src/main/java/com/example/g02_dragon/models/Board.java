package com.example.g02_dragon.models;

public class Board extends GameCharacter {
    private boolean active = true;
    private Lever lever = null;

    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        this.xSize = 310;
        this.ySize = 40;
    }

    public void setLever(Lever lever) {
        this.lever = lever;
    }

    public boolean isActive() {
        return active;
    }

    public void move() {
        if (lever.isActive() == false) {
            active = false;
        }
    }
}
