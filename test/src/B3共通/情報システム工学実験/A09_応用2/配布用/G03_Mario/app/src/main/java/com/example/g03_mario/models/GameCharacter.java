package com.example.g03_mario.models;

public class GameCharacter {
    protected float x = 0;
    protected float y = 0;
    protected int xSize = 0;
    protected int ySize = 0;

    public GameCharacter() {

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

    public float getTop() {
        return y + ySize - 1;
    }

    public float getBottom() {
        return y;
    }

    public float getRight() {
        return x + xSize - 1;
    }

    public float getLeft() {
        return x;
    }

    public void setTop(float y) {
        this.y = y - ySize + 1;
    }

    public void setBottom(float y) {
        this.y = y;
    }

    public void setRight(float x) {
        this.x = x - xSize + 1;
    }

    public void setLeft(float x) {
        this.x = x;
    }

    // 衝突判定
    protected boolean isOverlapWith(GameCharacter gameCharacter) {
        float cx = gameCharacter.getX();
        float cy = gameCharacter.getY();
        float cxSize = gameCharacter.getxSize();
        float cySize = gameCharacter.getySize();

        // 相手が自分よりも左にいたら衝突していない
        if (cx + cxSize - 1 < x) {
            return false;
        }

        // 相手が自分よりも右にいたら衝突していない
        if (x + xSize - 1 < cx) {
            return false;
        }

        // 相手が自分よりも下にいたら衝突していない
        if (cy + cySize - 1 < y) {
            return false;
        }

        // 相手が自分よりも上にいたら衝突していない
        if (y + ySize - 1 < cy) {
            return false;
        }

        return true;
    }

    // 自分から見て、相手がどの方向にいるか判定する処理
    protected Direction directionOf(GameCharacter c) {
        // 上下左右の端と相手との距離を計算
        float[] distances = new float[4];
        float topDistance = c.getBottom() - getTop();
        float bottomDistance = getBottom() - c.getTop();
        float rightDistance = c.getLeft() - getRight();
        float leftDistance = getLeft() - c.getRight();

        // 右端との距離が正で、右端との距離が上or下との距離よりも大きければ右にいる
        if (rightDistance >= 0 && topDistance < rightDistance && bottomDistance < rightDistance) {
            return Direction.Right;
        }
        if (leftDistance >= 0 && topDistance < leftDistance && bottomDistance < leftDistance) {
            return Direction.Left;
        }
        if (topDistance >= 0 && rightDistance < topDistance && leftDistance < topDistance) {
            return Direction.Top;
        }
        if (bottomDistance >= 0 && rightDistance < bottomDistance && leftDistance < bottomDistance) {
            return Direction.Bottom;
        }

        return Direction.None;
    }



    //    // 自分の右端から相手までの距離
//    protected float getRightDistanceOf(GameCharacter c) {
//        return c.getLeft() - getRight();
//    }
//
//    // 自分の左端から相手までの距離
//    protected float getLeftDistanceOf(GameCharacter c) {
//        return getLeft() - c.getRight();
//    }
//
//    // 自分の上端から相手までの距離
//    protected float getTopDistanceOf(GameCharacter c) {
//        return c.getBottom() - getTop();
//    }
//
//    // 自分の下端から相手までの距離
//    protected float getBottomDistanceOf(GameCharacter c) {
//        return getBottom() - c.getTop();
//    }
}
