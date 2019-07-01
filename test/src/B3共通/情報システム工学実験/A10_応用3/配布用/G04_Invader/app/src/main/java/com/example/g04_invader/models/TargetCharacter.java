package com.example.g04_invader.models;

public class TargetCharacter extends GameCharacter{
    protected boolean dead=false;

    public boolean isDead() {
        return dead;
    }
    public void dead() {
        dead = true;
    }
}
