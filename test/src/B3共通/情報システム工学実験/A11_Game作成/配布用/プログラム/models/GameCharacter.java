package com.example.mygame.models;

public class GameCharacter {
    protected float x = 0;
    protected float y = 0;
    protected int xSize = 0;
    protected int ySize = 0;
    protected float xSpeed=0;
    protected float ySpeed=0;

    public GameCharacter(){

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed=xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public boolean isOverlapWith(GameCharacter character) {
        float cx = character.getX();
        float cy = character.getY();
        int cxSize = character.getxSize();
        int cySize = character.getySize();

        // 相手（プレーヤ）が自分よりも左にいたら衝突していない
        if (cx + cxSize - 1 < this.x) {
            return false;
        }

        // 相手（プレーヤ）が自分よりも右にいたら衝突していない
        if (this.x + this.xSize - 1 < cx) {
            return false;
        }

        // 相手（プレーヤ）が自分よりも下にいたら衝突していない
        if (cy + cySize - 1 < this.y) {
            return false;
        }

        // 相手（プレーヤ）が自分よりも上にいたら衝突していない
        if (this.y + this.ySize - 1 < cy) {
            return false;
        }

        return true;
    }
}
