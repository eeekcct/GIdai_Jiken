package com.example.g02_dragon.models;

public class Cage extends GameCharacter {
    private int ySpeed = 0;
    private Dragon dragon = null;

    public Cage(int x, int y) {
        this.x = x;
        this.y = y;
        this.xSize = 50;
        this.ySize = 50;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public void move() {
        y = y + ySpeed;
        if (World.HEIGHT < y) {
            y = World.HEIGHT;
        }
        if (dragon.isDead()) {
            ySpeed = 5;
        }
    }
}
