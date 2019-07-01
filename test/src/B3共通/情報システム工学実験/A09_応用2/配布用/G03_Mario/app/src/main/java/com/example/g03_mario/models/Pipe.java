package com.example.g03_mario.models;

public class Pipe extends HardCharacter {

    public Pipe(int x, int y) {
        this.x = x;
        this.y = y;
        this.xSize = 60;
        this.ySize = 120;
    }

    public void move() {
        if (isOverlapWith(player)) {
            // 上から衝突してきたら、（再ジャンプできるように）ジャンプモード終了
            switch (overlapDirectionOf(player)) {
                case Top:
                    player.stopJump();
                    break;
            }

            // プレーヤを跳ね返す
            bounceBack(player);
        }
    }
}
