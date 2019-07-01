package com.example.g03_mario.models;

public class GameCharacterWithP extends GameCharacter{
    protected Player player = null;

    public GameCharacterWithP(){

    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
