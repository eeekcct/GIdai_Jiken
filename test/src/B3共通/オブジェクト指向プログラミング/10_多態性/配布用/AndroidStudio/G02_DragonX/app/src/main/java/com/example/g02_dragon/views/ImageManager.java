package com.example.g02_dragon.views;

import android.graphics.Bitmap;

import com.example.g02_dragon.MainActivity;
import com.example.g02_dragon.R;
import com.example.g02_dragon.models.Block;
import com.example.g02_dragon.models.Board;
import com.example.g02_dragon.models.Cage;
import com.example.g02_dragon.models.Dragon;
import com.example.g02_dragon.models.Fire;
import com.example.g02_dragon.models.Lever;
import com.example.g02_dragon.models.Player;
import com.example.g02_dragon.models.Princess;

public class ImageManager {

    // リソース（画像）
    private Bitmap playerRightImage;
    private Bitmap playerLeftImage;
    private Bitmap blockImage;
    private Bitmap boardImage;
    private Bitmap leverRightImage;
    private Bitmap leverLeftImage;
    private Bitmap dragonImage;
    private Bitmap princessImage;
    private Bitmap cageImage;
    private Bitmap fireImage;

    public ImageManager(MainActivity activity) {
        loadImages(activity);
    }

    // リソースの読み込み
    public void loadImages(MainActivity activity) {
        playerRightImage = activity.loadImage(R.drawable.player_right, 32, 32);
        playerLeftImage = activity.loadImage(R.drawable.player_left, 32, 32);
        blockImage = activity.loadImage(R.drawable.block, 150, 100);
        boardImage = activity.loadImage(R.drawable.board, 310, 40);
        leverRightImage = activity.loadImage(R.drawable.lever_right, 32, 32);
        leverLeftImage = activity.loadImage(R.drawable.lever_left, 32, 32);
        dragonImage = activity.loadImage(R.drawable.dragon, 100, 100);
        princessImage = activity.loadImage(R.drawable.princess, 32, 32);
        cageImage = activity.loadImage(R.drawable.cage, 50, 50);
        fireImage = activity.loadImage(R.drawable.fire, 40, 40);
    }

    // プレーヤ画像の取得
    public Bitmap getPlayerImage(Player player) {
        if (player.getxSpeed() >= 0) {
            return playerRightImage;
        } else {
            return playerLeftImage;
        }
    }

    // ブロック画像の取得
    public Bitmap getBlockImage(Block block) {
        return blockImage;
    }

    // レバー画像の取得
    public Bitmap getLeverImage(Lever lever) {
        if (lever.isActive()) {
            return leverLeftImage;
        } else {
            return leverRightImage;
        }
    }

    // ボード画像の取得
    public Bitmap getBoardImage(Board board) {
        return boardImage;
    }

    // ドラゴン画像の取得
    public Bitmap getDragonImage(Dragon dragon) {
        return dragonImage;
    }

    // 炎画像の取得
    public Bitmap getFireImage(Fire fire) {
        return fireImage;
    }

    // 檻画像の取得
    public Bitmap getCageImage(Cage cage) {
        return cageImage;
    }

    // プリンセス画像の取得
    public Bitmap getPrincessImage(Princess princess) {
        return princessImage;
    }

}
