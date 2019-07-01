package com.example.g02_dragon.models;

public class Lever extends GameCharacter {
    private boolean active = true;
    private Player player = null;

    public Lever(int x, int y) {
        this.x = x;
        this.y = y;
        this.xSize = 36;
        this.ySize = 36;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isActive() {
        return active;
    }

    public void move() {
        if (isOverlapWith(player)) {
            active = false;
        }
    }
}
