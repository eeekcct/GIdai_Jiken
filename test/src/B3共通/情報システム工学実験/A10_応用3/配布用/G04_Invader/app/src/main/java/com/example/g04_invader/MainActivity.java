package com.example.g04_invader;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.g04_invader.models.GameCharacter;
import com.example.g04_invader.models.Invader;
import com.example.g04_invader.models.Launcher.ILauncher;
import com.example.g04_invader.models.Launcher.SingleLauncher;
import com.example.g04_invader.models.Missile;
import com.example.g04_invader.models.Player;
import com.example.g04_invader.models.Torchka;

import java.util.LinkedList;

public class MainActivity extends BaseActivity {
    // 定数
    final int PLAYER_MISSILE_COUNTS = 1;
    final int INVADER_MISSILE_COUNTS = 1;
    final int INVADER_COUNTS = 1;
    final int TOCHKA_COUNTS = 14;

    // リソース（画像）
    Bitmap playerImage;
    Bitmap invader11Image;
    Bitmap invader12Image;
    Bitmap invader21Image;
    Bitmap invader22Image;
    Bitmap invader31Image;
    Bitmap invader32Image;
    Bitmap playerMissileImage;
    Bitmap enemyMissileImage;
    Bitmap torchkaImage;

    // イメージビュー
    RelativeLayout relativeLayout;
    TextView gameClearTextView;
    TextView gameOverTextView;
    ImageView playerImageView;
    LinkedList<ImageView> invaderImageViews;
    LinkedList<ImageView> torchkaImageViews;


    // オブジェクト
    Player player;

    LinkedList<Torchka> torchkas;

    LinkedList<Invader> invaders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        gravityEnabled = true;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // リソース（画像）の読み込み
        playerImage = loadImage(R.drawable.canon, 32, 20);
        invader11Image = loadImage(R.drawable.invader11, 40, 25);
        invader12Image = loadImage(R.drawable.invader12, 40, 25);
        invader21Image = loadImage(R.drawable.invader21, 40, 25);
        invader22Image = loadImage(R.drawable.invader22, 40, 25);
        invader31Image = loadImage(R.drawable.invader31, 40, 25);
        invader32Image = loadImage(R.drawable.invader32, 40, 25);
        playerMissileImage = loadImage(R.drawable.missile, 10, 20);
        torchkaImage = loadImage(R.drawable.torchka, 10, 10);

        // イメージビューの読み込み
        relativeLayout = findViewById(R.id.relativeLayout);
        gameOverTextView = findViewById(R.id.gameOverTextView);
        gameClearTextView = findViewById(R.id.gameClearTextView);
        playerImageView = findViewById(R.id.playerImageView);

        // イメージビュー（インベーダー）の生成
        invaderImageViews = new LinkedList<ImageView>();
        for (int i = 0; i < INVADER_COUNTS; i++) {
            ImageView invaderImageView = new ImageView(this);
            invaderImageViews.add(invaderImageView);
            relativeLayout.addView(invaderImageView);
        }

        // イメージビュー（トーチカ）の生成
        torchkaImageViews = new LinkedList<ImageView>();
        for (int i = 0; i < TOCHKA_COUNTS; i++) {
            ImageView imageView = new ImageView(this);
            torchkaImageViews.add(imageView);
            relativeLayout.addView(imageView);
        }

        // イメージビュー（プレーヤミサイル）の生成

        // イメージビュー（敵ミサイル）の生成


        //----------------------------
        // Modelの生成
        //----------------------------
        // プレーヤの生成
        player = new Player();

        // インベーダーの生成
        invaders = new LinkedList<Invader>();
        invaders.add(new Invader(120, 140, 1));

        // トーチカの生成
        torchkas = new LinkedList<Torchka>();
        int torchkaSize = 10;
        int torchkaX = 100 + (100 - torchkaSize * 6) / 2 + 100 * 0;
        int torchkaY = 40;
        torchkas.add(new Torchka(torchkaX, torchkaY));
        torchkas.add(new Torchka(torchkaX, torchkaY + torchkaSize));
        torchkas.add(new Torchka(torchkaX + torchkaSize, torchkaY));
        torchkas.add(new Torchka(torchkaX + torchkaSize, torchkaY + torchkaSize));
        torchkas.add(new Torchka(torchkaX + torchkaSize, torchkaY + 2 * torchkaSize));
        torchkas.add(new Torchka(torchkaX + 2 * torchkaSize, torchkaY + torchkaSize));
        torchkas.add(new Torchka(torchkaX + 2 * torchkaSize, torchkaY + 2 * torchkaSize));
        torchkas.add(new Torchka(torchkaX + 3 * torchkaSize, torchkaY + torchkaSize));
        torchkas.add(new Torchka(torchkaX + 3 * torchkaSize, torchkaY + 2 * torchkaSize));
        torchkas.add(new Torchka(torchkaX + 4 * torchkaSize, torchkaY));
        torchkas.add(new Torchka(torchkaX + 4 * torchkaSize, torchkaY + torchkaSize));
        torchkas.add(new Torchka(torchkaX + 4 * torchkaSize, torchkaY + 2 * torchkaSize));
        torchkas.add(new Torchka(torchkaX + 5 * torchkaSize, torchkaY));
        torchkas.add(new Torchka(torchkaX + 5 * torchkaSize, torchkaY + torchkaSize));

        // プレーヤのミサイルの生成

        // インベーダーのミサイルの生成


        //-----------------------
        // Modelの接続
        //-----------------------


        //------------------------
        // Retry用のリスナーの登録
        //------------------------
        gameOverTextView.setOnClickListener(new RetryOnClickListener());
    }

    // プレーヤのミサイルにターゲットを接続
    private void setTargetOfPlayerMissile(Missile missile) {
        for (int i = 0; i < TOCHKA_COUNTS; i++) {
            missile.setTarget(torchkas.get(i));
        }
        for (int i = 0; i < INVADER_COUNTS; i++) {
            missile.setTarget(invaders.get(i));
        }
    }

    // インベーダーのミサイルにターゲットを接続


    //------------------------------
    // Modelの更新
    //------------------------------
    protected void updateModel() {
        // 加速度センサーで左右に移動
        float speed = accelerationController.y;
        if (-1 < speed && speed < 1) {
            speed = 0;
        }
        player.setxSpeed(2 * speed);

        // キャラクターのmove()
        player.move();



    }

    //------------------------------
    // Viewの更新
    //------------------------------
    protected void updateView() {
        // プレーヤの描画
        drawCharacter(player, playerImage, playerImageView);

        // インベーダー描画
        for (int i = 0; i < INVADER_COUNTS; i++) {
            drawInvader(invaders.get(i), invaderImageViews.get(i));
        }

        // トーチカ描画
        for (int i = 0; i < TOCHKA_COUNTS; i++) {
            drawTorchka(torchkas.get(i), torchkaImageViews.get(i));
        }

        // プレーヤのミサイル描画

        // インベーダーのミサイル描画

        // GameOver or GameClearの描画

    }

    // インベーダーの描画処理
    protected void drawInvader(Invader invader, ImageView imageView) {
        if (invader.isDead() == false) {
            imageView.setVisibility(View.VISIBLE);
            Bitmap image = getInvaderImage(invader);
            drawCharacter(invader, image, imageView);
        } else {
            imageView.setVisibility(View.GONE);
        }
    }

    // トーチカの描画処理
    protected void drawTorchka(Torchka torchka, ImageView imageView) {
        if (torchka.isDead() == false) {
            imageView.setVisibility(View.VISIBLE);
            drawCharacter(torchka, torchkaImage, imageView);
        } else {
            imageView.setVisibility(View.GONE);
        }
    }

    // ミサイルの描画処理
    protected void drawMissile(Missile missile, ImageView missileImageView) {
        if (missile.isDead() == false) {
            missileImageView.setVisibility(View.VISIBLE);
            Bitmap image = getMissileImage(missile);
            drawCharacter(missile, image, missileImageView);
        } else {
            missileImageView.setVisibility(View.GONE);
        }
    }

    // インベーダー画像の取得
    protected Bitmap getInvaderImage(Invader invader) {
        switch (invader.getType()) {
            case 1:
                return invader11Image;
            case 2:
                return invader21Image;
            default:
                return invader31Image;
        }
    }

    // ミサイル画像の取得
    protected Bitmap getMissileImage(Missile missile) {
        if (missile.getySpeed() > 0) {
            return playerMissileImage;
        } else {
            return enemyMissileImage;
        }
    }

    // キャラクタの描画処理
    protected void drawCharacter(GameCharacter character, Bitmap image, ImageView imageView) {
        float x = character.getX();
        float y = character.getY();
        int xSize = character.getxSize();
        int ySize = character.getySize();
        drawImage((int) x, (int) y, xSize, ySize, image, imageView);
    }

    //------------------------------
    // 画面をタッチしたときの処理
    //------------------------------
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            player.fire();
        }
        return false;
    }

    //------------------------------
    // リトライ
    //------------------------------
    private class RetryOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        }
    }
}
