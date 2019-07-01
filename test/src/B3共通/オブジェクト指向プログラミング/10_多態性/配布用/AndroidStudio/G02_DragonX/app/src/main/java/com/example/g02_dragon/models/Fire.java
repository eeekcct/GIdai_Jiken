package com.example.g02_dragon.models;

public class Fire extends GameCharacter {
    private int xSpeed = -2;
    private int ySpeed = -2;
    private boolean active = false;
    private Player player = null;

    public Fire(int x, int y) {
        this.x = x;
        this.y = y;
        this.xSize = 40;
        this.ySize = 40;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isActive() {
        return active;
    }

    public void fire(int x, int y) {
        if (!active) {
            this.x = x;
            this.y = y;
            active = true;
        }
    }

    public void move() {
        if (active) {
            x += xSpeed;
            y += ySpeed;
            if (y < 0) {
                active = false;
            }
            if (isOverlapWith(player)) {
                player.dead();
            }
        }
    }

}
