package com.example.g02_dragon.views;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.example.g02_dragon.MainActivity;
import com.example.g02_dragon.models.Block;
import com.example.g02_dragon.models.Board;
import com.example.g02_dragon.models.Cage;
import com.example.g02_dragon.models.Dragon;
import com.example.g02_dragon.models.Fire;
import com.example.g02_dragon.models.GameCharacter;
import com.example.g02_dragon.models.Lever;
import com.example.g02_dragon.models.Player;
import com.example.g02_dragon.models.Princess;
import com.example.g02_dragon.models.World;


public class MainView {
    MainActivity activity;

    // ビュー
    ImageManager imageManager;
    ImageViewManager imageViewManager;

    public MainView(MainActivity activity) {
        this.activity = activity;

        // ビュー
        imageManager = new ImageManager(activity);
        imageViewManager = new ImageViewManager(activity);
    }

    public void draw(World world) {
        Player player = world.player;
        Princess princess = world.princess;

        // キャラクタ描画
        drawPlayer(player);
        drawPrincess(princess);
        drawBoard(world.board);
        drawLever(world.lever);
        drawFire(world.fire);
        drawDragon(world.dragon);
        drawCage(world.cage);
        drawBlock1(world.block1);
        drawBlock2(world.block2);

        // タイマー描画
        imageViewManager.getTimeTextView().setText(""+princess.getTimeLimit());

        // GameOver or GameClear 描画
        if (player.isDead()) {
            imageViewManager.getGameOverTextView().setVisibility(View.VISIBLE);
        }else if(princess.isRescued()){
            imageViewManager.getGameClearTextView().setVisibility(View.VISIBLE);
        }
    }

    // プレーヤの描画
    public void drawPlayer(Player player) {
        Bitmap image = imageManager.getPlayerImage(player);
        ImageView imageView = imageViewManager.getPlayerImageView();
        drawActiveCharacter(player, image, imageView);
    }

    // ブロック1の描画
    public void drawBlock1(Block block) {
        Bitmap image = imageManager.getBlockImage(block);
        ImageView imageView = imageViewManager.getBlock1ImageView();
        drawActiveCharacter(block, image, imageView);
    }

    // ブロック2の描画
    public void drawBlock2(Block block) {
        Bitmap image = imageManager.getBlockImage(block);
        ImageView imageView = imageViewManager.getBlock2ImageView();
        drawActiveCharacter(block, image, imageView);
    }

    // レバーの描画
    public void drawLever(Lever lever) {
        Bitmap image = imageManager.getLeverImage(lever);
        ImageView imageView = imageViewManager.getLeverImageView();
        drawActiveCharacter(lever, image, imageView);
    }

    // ボードの描画
    public void drawBoard(Board board) {
        Bitmap image = imageManager.getBoardImage(board);
        ImageView imageView = imageViewManager.getBoardImageView();
        drawActiveCharacter(board, image, imageView);
    }

    // ドラゴンの描画
    public void drawDragon(Dragon dragon) {
        Bitmap image = imageManager.getDragonImage(dragon);
        ImageView imageView = imageViewManager.getDragonImageView();
        drawActiveCharacter(dragon, image, imageView);
    }

    // 炎の描画
    public void drawFire(Fire fire) {
        Bitmap image = imageManager.getFireImage(fire);
        ImageView imageView = imageViewManager.getFireImageView();
        drawActiveCharacter(fire, image, imageView);
    }

    // プリンセスの描画
    public void drawPrincess(Princess princess) {
        Bitmap image = imageManager.getPrincessImage(princess);
        ImageView imageView = imageViewManager.getPrincessImageView();
        drawActiveCharacter(princess, image, imageView);
    }

    // 檻の描画
    public void drawCage(Cage cage) {
        Bitmap image = imageManager.getCageImage(cage);
        ImageView imageView = imageViewManager.getCageImageView();
        drawActiveCharacter(cage, image, imageView);
    }

    // Activeなキャラクタのみ描画
    protected void drawActiveCharacter(GameCharacter character, Bitmap image, ImageView imageView) {
        if (character.isActive()) {
            imageView.setVisibility(View.VISIBLE);
            drawCharacter(character, image, imageView);
        } else {
            imageView.setVisibility(View.GONE);
        }
    }

    // キャラクターの描画
    protected void drawCharacter(GameCharacter character, Bitmap image, ImageView imageView) {
        int x = character.getX();
        int y = character.getY();
        int xSize = character.getxSize();
        int ySize = character.getySize();
        activity.drawImage(x, y, xSize, ySize, image, imageView);
    }
}
