package com.example.g04_invader.models;

public class Torchka extends GameCharacter implements ITarget {
    private int life = 3;

    public Torchka(int x, int y) {
        this.x = x;
        this.y = y;
        this.xSize = 10;
        this.ySize = 10;
    }

    @Override
    public void dead() {
        life--;
    }

    public boolean isDead() {
        return life <= 0;
    }
}
