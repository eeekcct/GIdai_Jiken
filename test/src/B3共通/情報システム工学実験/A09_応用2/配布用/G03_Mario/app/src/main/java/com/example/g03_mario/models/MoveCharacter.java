package com.example.g03_mario.models;

public class MoveCharacter extends GameCharacter {

    protected float xSpeed = 0;
    protected float ySpeed = 0;

    public MoveCharacter() {
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public MoveCharacter getOld() {
        MoveCharacter c = new MoveCharacter();
        c.x = x - xSpeed;
        c.y = y - ySpeed;
        c.xSize = xSize;
        c.ySize = ySize;
        c.xSpeed = xSpeed;
        c.ySpeed = ySpeed;
        return c;
    }

}
