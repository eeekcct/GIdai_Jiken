package com.example.g04_invader.models;

public class Player extends TargetCharacter {
    private boolean dead = false;

    public Player() {
        x = 300;
        y = 0;
        xSize = 32;
        ySize = 20;
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

    public void fire(){

    }

}
