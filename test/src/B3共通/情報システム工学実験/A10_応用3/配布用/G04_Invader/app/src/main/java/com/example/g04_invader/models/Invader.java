package com.example.g04_invader.models;

public class Invader extends TargetCharacter {
    private int type = 1;

    public Invader(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.xSize = 40;
        this.ySize = 25;
        this.xSpeed = 1;
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
