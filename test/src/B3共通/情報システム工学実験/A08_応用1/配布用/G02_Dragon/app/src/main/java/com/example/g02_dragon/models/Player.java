package com.example.g02_dragon.models;

public class Player extends GameCharacter {
    private int xSpeed = 0;

    public Player() {
        this.x = 0;
        this.y = 100;
        this.xSize = 32;
        this.ySize = 32;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void turnRight() {
        xSpeed = 3;
    }

    public void turnLeft() {
        xSpeed = -3;
    }

    public void stop() {
        xSpeed = 0;
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
