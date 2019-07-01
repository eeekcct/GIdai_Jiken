package com.example.g02_dragon.models;

public class Dragon extends GameCharacter {
    private boolean dead = false;
    private int ySpeed = 3;
    private Board board = null;
    private Player player=null;
    private Fire fire=null;

    public Dragon(int x, int y) {
        this.x = x;
        this.y = y;
        this.xSize = 100;
        this.ySize = 100;
    }

    public boolean isDead() {
        return dead;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setFire(Fire fire) {
        this.fire = fire;
    }

    public void move() {
        y = y + ySpeed;
        if (y < -100) {
            y = -100;
        }

        if (!dead && board.isActive()) {
            fire.fire(x,y);

            if (y < 100 || World.HEIGHT - ySize + 1 < y) {
                ySpeed = -ySpeed;
            }

            if (isOverlapWith(player)) {
                player.dead();
            }
        } else {
            dead = true;
            ySpeed = -5;
        }
    }
}
