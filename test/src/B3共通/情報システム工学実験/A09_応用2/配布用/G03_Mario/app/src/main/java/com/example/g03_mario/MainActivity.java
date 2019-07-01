package com.example.g03_mario;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.g03_mario.models.GameCharacter;
import com.example.g03_mario.models.Goal;
import com.example.g03_mario.models.Pipe;
import com.example.g03_mario.models.Player;
import com.example.g03_mario.models.World;

import java.util.LinkedList;

public class MainActivity extends BaseActivity {

    //-----------------------------
    // 変数宣言
    //-----------------------------
    private static final int PIPE_COUNTS = 5;
    private static final int BRIDGE_COUNTS = 20;
    private static final int CONCRETE_COUNTS = 5;
    private static final int BLOCK_COUNTS = 51;
    private static final int ENEMY_COUNTS = 5;
    private static final int COIN_COUNTS = 5;

    //-----------------------------
    // 変数宣言
    //-----------------------------
    // リソース（画像）
    Bitmap goalImage;
    Bitmap playerRightImage;
    Bitmap playerLeftImage;
    Bitmap pipeImage;

    // ビュー
    RelativeLayout relativeLayout;
    TextView gameClearTextView;
    TextView gameOverTextView;
    TextView scoreTextView;
    TextView timeTextView;

    ImageView goalImageView;
    ImageView playerImageView;
    LinkedList<ImageView> pipeImageViews;

    // モデル
    Goal goal;
    Player player;
    LinkedList<Pipe> pipes;

    //-----------------------------
    // 起動時の処理
    //-----------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 画面の向きを横に固定
        orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

        // 加速度センサー有効
        gravityEnabled = true;

        // レイアウトファイルの設定
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // リソース（画像）の読み込み
        goalImage=loadImage(R.drawable.goal,40,60);
        playerRightImage = loadImage(R.drawable.player_right, 24, 24);
        playerLeftImage = loadImage(R.drawable.player_left, 24, 24);
        pipeImage = loadImage(R.drawable.pipe, 60, 120);

        //---------------------
        // ビューの読み込み
        //---------------------
        // レイアウト　
        relativeLayout = findViewById(R.id.relativeLayout);

        // Game Clear, Game Over, 残り時間、スコア
        gameClearTextView = findViewById(R.id.gaemClearTextView);
        gameOverTextView = findViewById(R.id.gameOverTextView);
        timeTextView = findViewById(R.id.timeTextView);
        scoreTextView = findViewById(R.id.scoreTextView);

        // ゴール
        goalImageView = findViewById(R.id.goalImageView);

        // プレーヤ
        playerImageView = findViewById(R.id.playerImageView);

        // パイプ
        pipeImageViews = new LinkedList<ImageView>();
        for (int i = 0; i < PIPE_COUNTS; i++) {
            ImageView imageView = new ImageView(this);
            relativeLayout.addView(imageView);
            pipeImageViews.add(imageView);
        }

        //---------------------
        // オブジェクトの生成
        //---------------------
        // ゴール生成
        goal = new Goal(2400, 24);

        // プレーヤ生成
        player = new Player(500, 100);

        // パイプ生成
        pipes = new LinkedList<Pipe>();
        pipes.add(new Pipe(900, 0));
        pipes.add(new Pipe(1100, 0));
        pipes.add(new Pipe(1370, 0));
        pipes.add(new Pipe(1550, 0));
        pipes.add(new Pipe(1810, 0));

        //---------------------
        //　オブジェクトの接続
        //---------------------
        // パイプの接続
        for (int i = 0; i < PIPE_COUNTS; i++) {
            pipes.get(i).setPlayer(player);
        }
    }

    //-----------------------------
    // モデルの更新
    //-----------------------------
    protected void updateModel() {
        // 加速度センサーでジャンプ
        float speed = accelerationController.y;
        if (speed < -0.5) {
            player.turnLeft();
        } else if (speed > 0.5) {
            player.turnRight();
        } else {
            player.stop();
        }

        // プレーヤ
        player.move();

        // パイプ
        for (int i = 0; i < PIPE_COUNTS; i++) {
            pipes.get(i).move();
        }

    }

    //-----------------------------
    // ビューの更新
    //-----------------------------
    protected void updateView() {
        // スクロール
        if (player.getX() < 280) {
            canvasBaseX = 0;
        } else if (player.getX() < (World.WIDTH - 320)) {
            canvasBaseX = (int) player.getX() - 280;
        } else {
            canvasBaseX = World.WIDTH - 600;
        }

        // ゴールの描画
        drawCharacter(goal, goalImage, goalImageView);

        // プレーヤの描画
        Bitmap pImage = getImage(player);
        drawCharacter(player, pImage, playerImageView);

        // パイプの描画
        for (int i = 0; i < PIPE_COUNTS; i++) {
            drawCharacter(pipes.get(i), pipeImage, pipeImageViews.get(i));
        }

    }

    //-----------------------------
    // 描画処理用関数
    //-----------------------------
    // キャラクターの描画
    protected void drawCharacter(GameCharacter character, Bitmap image, ImageView imageView) {
        int x = (int) character.getX();
        int y = (int) character.getY();
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
                player.jump();
                break;
        }
        return true;
    }
}
