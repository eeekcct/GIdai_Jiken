package com.example.g02_dragon;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.g02_dragon.models.Block;
import com.example.g02_dragon.models.Board;
import com.example.g02_dragon.models.GameCharacter;
import com.example.g02_dragon.models.Player;

public class MainActivity extends BaseActivity {

    //-----------------------------
    // 変数宣言
    //-----------------------------
    // リソース（画像）
    Bitmap playerRightImage;
    Bitmap playerLeftImage;
    Bitmap blockImage;
    Bitmap boardImage;

    // ビュー
    RelativeLayout relativeLayout;
    ImageView playerImageView;
    ImageView block1ImageView;
    ImageView block2ImageView;
    ImageView boardImageView;

    // モデル
    Player player;
    Block block1;
    Block block2;
    Board board;

    //-----------------------------
    // 起動時の処理
    //-----------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        gravityEnabled = true;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // リソースの読み込み
        playerRightImage = loadImage(R.drawable.player_right, 32, 32);
        playerLeftImage = loadImage(R.drawable.player_left, 32, 32);
        blockImage=loadImage(R.drawable.block,150,100);
        boardImage = loadImage(R.drawable.board,310, 40);

        // ビューの読み込み
        relativeLayout = findViewById(R.id.relativeLayout);
        playerImageView = findViewById(R.id.playerImageView);
        block1ImageView = findViewById(R.id.block1ImageView);
        block2ImageView = findViewById(R.id.block2ImageView);
        boardImageView = findViewById(R.id.boardImageView);

        // オブジェクトの生成
        player = new Player();
        block1 = new Block(0, 0);
        block2 = new Block(450, 0);
        board =new Board(145,70);

        //　オブジェクトの接続
    }

    //-----------------------------
    // モデルの更新
    //-----------------------------
    protected void updateModel() {
        player.move();
    }

    //-----------------------------
    // ビューの更新
    //-----------------------------
    protected void updateView() {
        // プレーヤの描画
        Bitmap image = getImage(player);
        drawCharacter(player, image, playerImageView);

        // ブロックの描画
        drawCharacter(block1, blockImage, block1ImageView);
        drawCharacter(block2, blockImage, block2ImageView);

        // ボードの描画
        drawCharacter(board,boardImage,boardImageView);
    }

    //-----------------------------
    // 描画処理用関数
    //-----------------------------
    // キャラクターの描画
    protected void drawCharacter(GameCharacter character, Bitmap image, ImageView imageView) {
        int x = character.getX();
        int y = character.getY();
        int xSize = character.getxSize();
        int ySize = character.getySize();
        drawImage(x, y, xSize, ySize, image, imageView);
    }

    // 表示するプレーヤ画像の取得
    public Bitmap getImage(Player player) {
        if (player.getxSpeed() >= 0) {
            return playerRightImage;
        } else {
            return playerLeftImage;
        }
    }

    //-----------------------------
    // 画面をタッチした時の処理
    //-----------------------------
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                if (event.getX(event.getActionIndex()) < 640) {
                    player.turnLeft();
                } else {
                    player.turnRight();
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                if(event.getPointerCount()==1) {
                    player.stop();
                }
                break;
        }
        return true;
    }
}
