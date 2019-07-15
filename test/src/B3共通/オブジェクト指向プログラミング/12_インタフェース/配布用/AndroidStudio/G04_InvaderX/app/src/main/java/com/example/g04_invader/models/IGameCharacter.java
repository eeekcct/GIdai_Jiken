package com.example.g04_invader.models;

public interface IGameCharacter {
    public float getX();
    public float getY();
    public int getxSize();
    public int getySize();
    public float getxSpeed();
    public float getySpeed();
    public void setxSpeed(float xSpeed);
    public void setySpeed(float ySpeed);
    public boolean isOverlapWith(IGameCharacter gameCharacter);
}
