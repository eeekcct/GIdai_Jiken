package com.example.g02_dragon.models;

import java.util.LinkedList;

public class World {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 360;

    // 登場キャラクター
    public Player player;
    public Block block1;
    public Block block2;
    public Board board;
    public Lever lever;
    public Dragon dragon;
    public Princess princess;
    public Cage cage;
    public Fire fire;

    // 登場キャラクターのリスト
    public LinkedList<GameCharacter> gameCharacters;

    public World() {
        createObjects();
        connectObjects();
        registObjects();
    }

    public void move() {
        for (int i=0;i<gameCharacters.size();i++) {
            gameCharacters.get(i).move();
        }
    }

    // オブジェクトの生成
    private void createObjects(){
        player = new Player();
        block1 = new Block(0, 0);
        block2 = new Block(450, 0);
        board = new Board(145, 70);
        lever = new Lever(470, 100);
        dragon = new Dragon(330, 200);
        princess = new Princess(550, 100);
        cage = new Cage(540, 100);
        fire = new Fire(330, 220);
    }

    //　オブジェクトの接続
    private void connectObjects(){
        lever.setPlayer(player);
        board.setLever(lever);
        dragon.setBoard(board);
        cage.setDragon(dragon);
        princess.setPlayer(player);
        dragon.setPlayer(player);
        dragon.setFire(fire);
        fire.setPlayer(player);
    }

    // オブジェクトをリストに登録
    private void registObjects() {
        gameCharacters =new LinkedList<GameCharacter>();
        gameCharacters.add(player);
        gameCharacters.add(block1);
        gameCharacters.add(block2);
        gameCharacters.add(fire);
        gameCharacters.add(lever);
        gameCharacters.add(board);
        gameCharacters.add(dragon);
        gameCharacters.add(princess);
        gameCharacters.add(cage);
    }
}
