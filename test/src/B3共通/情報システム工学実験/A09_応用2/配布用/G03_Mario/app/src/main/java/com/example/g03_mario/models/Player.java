package com.example.g03_mario.models;

public class Player extends MoveCharacter {
    private int score = 0;
    private boolean jump = false;
    private boolean dead = false;

    public Player(float x, float y) {
        this.xSize = 24;
        this.ySize = 24;
        this.x = x;
        this.y = y;
    }

    public void turnRight() {
        xSpeed = 3;
    }

    public void turnLeft() {
        xSpeed = -3;
    }

    public void stop() {
        xSpeed = 0;
    }

    // ジャンプ！
    public void jump() {
        if (jump == false) {
            ySpeed = 12.0f;
            jump = true;
        }
    }

    // 着地！
    public void stopJump() {
        jump = false;
    }

    public void move() {
        // X方向
        x = x + xSpeed;

        if (x < 0) {
            x = 0;
        }
        if (x > World.WIDTH - xSize + 1) {
            x = World.WIDTH - xSize + 1;
        }

        // Y方向
        y = (int) (y + ySpeed);
        ySpeed = ySpeed + World.GRAVITY;

        if (y < 0) {
            y = 0;
            ySpeed = 0;
            jump = false;
        }
    }

}
