package com.example.g02_dragon.models;

public class GameCharacter {
    protected int x = 0;
    protected int y = 0;
    protected int xSize = 0;
    protected int ySize = 0;

    public GameCharacter(){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public void move(){}

    public boolean isActive(){return true;}

    protected boolean isOverlapWith(GameCharacter gameCharacter) {
        int cx = gameCharacter.getX();
        int cy = gameCharacter.getY();
        int cxSize = gameCharacter.getxSize();
        int cySize = gameCharacter.getySize();

        // 相手（プレーヤ）が自分よりも左にいたら衝突していない
        if (cx + cxSize - 1 < x) {
            return false;
        }

        // 相手（プレーヤ）が自分よりも右にいたら衝突していない
        if (x + xSize - 1 < cx) {
            return false;
        }

        // 相手（プレーヤ）が自分よりも下にいたら衝突していない
        if (cy + cySize - 1 < y) {
            return false;
        }

        // 相手（プレーヤ）が自分よりも上にいたら衝突していない
        if (y + ySize - 1 < cy) {
            return false;
        }

        return true;
    }
}
