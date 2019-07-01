package com.example.g02_dragon.models;

public class Princess extends GameCharacter {
    private int timeLimit=3000;
    private boolean rescued=false;
    private Player player = null;

    public Princess(int x, int y) {
        this.x=x;
        this.y=y;
        this.xSize=32;
        this.ySize=32;
    }

    public boolean isRescued() {
        return rescued;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void move(){
        if (isOverlapWith(player)) {
            rescued=true;
        }

        if(!rescued) {
            timeLimit--;
        }
    }
}
