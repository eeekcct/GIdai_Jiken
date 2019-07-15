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

import com.example.g04_invader.models.IGameCharacter;
import com.example.g04_invader.models.Invader;
import com.example.g04_invader.models.InvaderManager;
import com.example.g04_invader.models.Launcher.DoubleLauncher;
import com.example.g04_invader.models.Launcher.ILauncher;
import com.example.g04_invader.models.Launcher.SingleLauncher;
import com.example.g04_invader.models.Launcher.TripleLauncher;
import com.example.g04_invader.models.Player;
import com.example.g04_invader.models.Torchka;
import com.example.g04_invader.models.Ufo;
import com.example.g04_invader.models.missile.IMissile;
import com.example.g04_invader.models.missile.NormalMissile;
import com.example.g04_invader.models.missile.PenetrationMissile;

import java.util.LinkedList;

public class MainActivity extends BaseActivity {
    // 定数
    final int PLAYER_MISSILE_COUNTS = 3;
    final int INVADER_MISSILE_COUNTS = 48;
    final int INVADER_COUNTS = 48;
    final int TOCHKA_COUNTS = 56;

    // リソース（画像）
    Bitmap canonImage;
    Bitmap invader11Image;
    Bitmap invader12Image;
    Bitmap invader21Image;
    Bitmap invader22Image;
    Bitmap invader31Image;
    Bitmap invader32Image;
    Bitmap playerMissileImage;
    Bitmap enemyMissileImage;
    Bitmap ufoImage;
    Bitmap torchkaImage;

    // イメージビュー
    RelativeLayout relativeLayout;
    ImageView canonImageView;
    ImageView ufoImageView;
    LinkedList<ImageView> invaderImageViews;
    LinkedList<ImageView> playerMissileImageViews;
    LinkedList<ImageView> invaderMissileImageViews;
    LinkedList<ImageView> torchkaImageViews;
    TextView gameOverTextView;
    TextView gameClearTextView;
    TextView singleTextView;
    TextView doubleTextView;
    TextView tripleTextView;
    TextView normalTextView;
    TextView penetrationTextView;

    // オブジェクト
    Player player;
    ILauncher playerLauncher;
    LinkedList<IMissile> normalMissiles;
    LinkedList<IMissile> penetrationMissiles;
    LinkedList<IMissile> playerMissiles;
    LinkedList<Torchka> torchkas;

    InvaderManager invaderManager;
    LinkedList<Invader> invaders;
    LinkedList<ILauncher> invaderLaunchers;
    LinkedList<IMissile> invaderMissiles;
    Ufo ufo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        gravityEnabled = true;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------------------
        // リソース（画像）の読み込み
        //-------------------------------
        canonImage = loadImage(R.drawable.canon, 32, 20);
        invader11Image = loadImage(R.drawable.invader11, 40, 25);
        invader12Image = loadImage(R.drawable.invader12, 40, 25);
        invader21Image = loadImage(R.drawable.invader21, 40, 25);
        invader22Image = loadImage(R.drawable.invader22, 40, 25);
        invader31Image = loadImage(R.drawable.invader31, 40, 25);
        invader32Image = loadImage(R.drawable.invader32, 40, 25);
        playerMissileImage = loadImage(R.drawable.missile, 10, 20);
        enemyMissileImage = loadImage(R.drawable.missile_enemy, 10, 20);
        ufoImage = loadImage(R.drawable.ufo, 64, 30);
        torchkaImage = loadImage(R.drawable.torchka, 10, 10);

        //--------------------
        // イメージビューの読み込み
        //--------------------
        relativeLayout = findViewById(R.id.relativeLayout);
        canonImageView = findViewById(R.id.canonImageView);
        ufoImageView = findViewById(R.id.ufoImageView);
        gameOverTextView = findViewById(R.id.gameOverTextView);
        gameClearTextView = findViewById(R.id.gameClearTextView);
        singleTextView = findViewById(R.id.singleTextView);
        doubleTextView = findViewById(R.id.doubleTextView);
        tripleTextView = findViewById(R.id.tripleTextView);
        normalTextView = findViewById(R.id.normalTextView);
        penetrationTextView = findViewById(R.id.penetrationTextView);

        //--------------------
        // イメージビューの生成
        //--------------------
        playerMissileImageViews = createImageViews(PLAYER_MISSILE_COUNTS);
        torchkaImageViews = createImageViews(TOCHKA_COUNTS);
        invaderImageViews = createImageViews(INVADER_COUNTS);
        invaderMissileImageViews = createImageViews(INVADER_MISSILE_COUNTS);

        //--------------------
        // Modelの生成
        //--------------------
        player = new Player();
        playerLauncher = new SingleLauncher(6);
        torchkas = createTorchka(TOCHKA_COUNTS);
        normalMissiles = createNormalMissiles(PLAYER_MISSILE_COUNTS);
        penetrationMissiles = createPenetrationMissiles(PLAYER_MISSILE_COUNTS);
        invaderMissiles = createNormalMissiles(INVADER_MISSILE_COUNTS);
        invaderManager = new InvaderManager();
        invaders = createInvaders();
        invaderLaunchers = createLaunchers(INVADER_COUNTS);
        ufo = new Ufo();

        //--------------------
        // Modelの接続
        //--------------------
        // プレーヤのミサイルとランチャー
        playerMissiles = normalMissiles;
        setMissilesToPlayerLauncher();
        player.setLauncher(playerLauncher);

        // プレーヤの通常ミサイルに標的設定
        for (int i = 0; i < PLAYER_MISSILE_COUNTS; i++) {
            setTargetOfPlayerMissile(normalMissiles.get(i));
        }

        // プレーヤの貫通ミサイルに標的設定
        for (int i = 0; i < PLAYER_MISSILE_COUNTS; i++) {
            setTargetOfPlayerMissile(penetrationMissiles.get(i));
        }

        // インベーダーに標的設定
        for (int i = 0; i < INVADER_COUNTS; i++) {
            setTargetOfInvader(invaders.get(i));
        }

        // インベーダーのミサイルに標的設定
        for (int i = 0; i < INVADER_MISSILE_COUNTS; i++) {
            setTargetOfInvaderMissile(invaderMissiles.get(i));
        }

        // インベーダーとミサイルとランチャー
        for (int i = 0; i < INVADER_COUNTS; i++) {
            invaderLaunchers.get(i).setMissile(invaderMissiles.get(i));
            invaders.get(i).setLauncher(invaderLaunchers.get(i));
            invaderManager.addInvader(invaders.get(i));
        }

        //--------------------
        // リスナーの登録
        //--------------------
        gameOverTextView.setOnClickListener(new RestartOnClickListener());
        singleTextView.setOnClickListener(new SingleOnClickListener());
        doubleTextView.setOnClickListener(new DoubleOnClickListener());
        tripleTextView.setOnClickListener(new TripleOnClickListener());
        normalTextView.setOnClickListener(new NormalOnClickListener());
        penetrationTextView.setOnClickListener(new PenetrationOnClickListener());
    }

    //====================
    // Modelの更新
    //====================
    protected void updateModel() {
        float speed = accelerationController.y;
        if (-1 < speed && speed < 1) {
            speed = 0;
        }
        player.setxSpeed(2 * speed);

        player.move();
        for (IMissile missile : playerMissiles) {
            missile.move();
        }

        invaderManager.move();
        for (Invader invader : invaders) {
            invader.move();
        }
        for (IMissile missile : invaderMissiles) {
            missile.move();
        }
        ufo.move();
    }

    //====================
    // Viewの更新
    //====================
    protected void updateView() {
        drawCharacter(player, canonImage, canonImageView);
        for (int i = 0; i < PLAYER_MISSILE_COUNTS; i++) {
            drawMissile(playerMissiles.get(i), playerMissileImageViews.get(i));
        }
        for (int i = 0; i < TOCHKA_COUNTS; i++) {
            drawTorchka(torchkas.get(i), torchkaImageViews.get(i));
        }

        for (int i = 0; i < INVADER_COUNTS; i++) {
            drawInvader(invaders.get(i), invaderImageViews.get(i));
        }

        for (int i = 0; i < INVADER_MISSILE_COUNTS; i++) {
            drawMissile(invaderMissiles.get(i), invaderMissileImageViews.get(i));
        }

        drawUfo(ufo);

        if (player.isDead() || invaderManager.isWin()) {
            gameOverTextView.bringToFront();
            gameOverTextView.setVisibility(View.VISIBLE);
        } else if (invaderManager.remaining() == 0) {
            gameClearTextView.bringToFront();
            gameClearTextView.setVisibility(View.VISIBLE);
        }
    }

    //------------------------------
    // イメージビュー生成用関数
    //------------------------------
    // 複数のイメージビューを生成
    private LinkedList<ImageView> createImageViews(int num) {
        LinkedList imageViews = new LinkedList<ImageView>();
        for (int i = 0; i < num; i++) {
            ImageView imageView = new ImageView(this);
            imageViews.add(imageView);
            relativeLayout.addView(imageView);
        }
        return imageViews;
    }

    //------------------------------
    // オブジェクト生成用関数
    //------------------------------
    // 通常ミサイルの生成
    public LinkedList<IMissile> createNormalMissiles(int num) {
        LinkedList<IMissile> missiles = new LinkedList<IMissile>();
        for (int i = 0; i < num; i++) {
            IMissile missile = new NormalMissile();
            missiles.add(missile);
        }
        return missiles;
    }

    // 貫通ミサイルの生成
    public LinkedList<IMissile> createPenetrationMissiles(int num) {
        LinkedList<IMissile> missiles = new LinkedList<IMissile>();
        for (int i = 0; i < num; i++) {
            IMissile missile = new PenetrationMissile();
            missiles.add(missile);
        }
        return missiles;
    }

    // トーチカの生成
    public LinkedList<Torchka> createTorchka(int num) {
        LinkedList<Torchka> torchkas = new LinkedList<Torchka>();
        for (int i = 0; i < num; i++) {
            int size = 10;
            int x = 100 + (100 - size * 6) / 2 + 100 * i;
            int y = 40;
            torchkas.add(new Torchka(x, y));
            torchkas.add(new Torchka(x, y + size));
            torchkas.add(new Torchka(x + size, y));
            torchkas.add(new Torchka(x + size, y + size));
            torchkas.add(new Torchka(x + size, y + 2 * size));
            torchkas.add(new Torchka(x + 2 * size, y + size));
            torchkas.add(new Torchka(x + 2 * size, y + 2 * size));
            torchkas.add(new Torchka(x + 3 * size, y + size));
            torchkas.add(new Torchka(x + 3 * size, y + 2 * size));
            torchkas.add(new Torchka(x + 4 * size, y));
            torchkas.add(new Torchka(x + 4 * size, y + size));
            torchkas.add(new Torchka(x + 4 * size, y + 2 * size));
            torchkas.add(new Torchka(x + 5 * size, y));
            torchkas.add(new Torchka(x + 5 * size, y + size));
        }
        return torchkas;
    }

    // インベーダーの生成
    public LinkedList<Invader> createInvaders() {
        LinkedList<Invader> invaders = new LinkedList<Invader>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                Invader invader = new Invader(120 + j * 45, 140 + 30 * i, i / 2 + 1);
                invaders.add(invader);
            }
        }
        return invaders;
    }

    // インベーダー用ランチャーの生成
    public LinkedList<ILauncher> createLaunchers(int num) {
        LinkedList<ILauncher> launchers = new LinkedList<ILauncher>();
        for (int i = 0; i < num; i++) {
            ILauncher launcher = new SingleLauncher(-6);
            launchers.add(launcher);
        }
        return launchers;
    }

    //------------------------------
    // オブジェクト接続用関数
    //------------------------------
    // プレーヤのミサイルにターゲットを設定
    private void setTargetOfPlayerMissile(IMissile missile) {
        missile.setTarget(ufo);
        for (int i = 0; i < TOCHKA_COUNTS; i++) {
            missile.setTarget(torchkas.get(i));
        }
        for (int i = 0; i < INVADER_COUNTS; i++) {
            missile.setTarget(invaders.get(i));
        }
        for (int i = 0; i < INVADER_MISSILE_COUNTS; i++) {
            missile.setTarget(invaderMissiles.get(i));
        }
    }

    // インベーダーのミサイルにターゲットを設定
    private void setTargetOfInvaderMissile(IMissile missile) {
        missile.setTarget(player);
        for (int i = 0; i < TOCHKA_COUNTS; i++) {
            missile.setTarget(torchkas.get(i));
        }
        for (int i = 0; i < PLAYER_MISSILE_COUNTS; i++) {
            missile.setTarget(playerMissiles.get(i));
        }
    }

    // インベーダーにターゲットを設定
    private void setTargetOfInvader(Invader invader) {
        invader.setTarget(player);
        for (int i = 0; i < TOCHKA_COUNTS; i++) {
            invader.setTarget(torchkas.get(i));
        }
    }

    // プレーヤのランチャーにミサイルを装填
    private void setMissilesToPlayerLauncher() {
        playerLauncher.clearMissile();
        for (int i = 0; i < PLAYER_MISSILE_COUNTS; i++) {
            playerLauncher.setMissile(playerMissiles.get(i));
        }
    }

    //------------------------------
    // 描画用関数
    //------------------------------
    // ミサイルの描画
    protected void drawMissile(IMissile missile, ImageView missileImageView) {
        if (!missile.isDead()) {
            missileImageView.setVisibility(View.VISIBLE);
            Bitmap image = getImage(missile);
            drawCharacter(missile, image, missileImageView);
        } else {
            missileImageView.setVisibility(View.GONE);
        }
    }

    // トーチカの描画
    protected void drawTorchka(Torchka torchka, ImageView imageView) {
        if (!torchka.isDead()) {
            imageView.setVisibility(View.VISIBLE);
            drawCharacter(torchka, torchkaImage, imageView);
        } else {
            imageView.setVisibility(View.GONE);
        }
    }

    // UFOの描画
    protected void drawUfo(Ufo ufo) {
        if (ufo.isActive()) {
            ufoImageView.setVisibility(View.VISIBLE);
            drawCharacter(ufo, ufoImage, ufoImageView);
        } else {
            ufoImageView.setVisibility(View.GONE);
        }
    }

    // インベーダーの描画
    protected void drawInvader(Invader invader, ImageView imageView) {
        if (invader.isDead() == false) {
            imageView.setVisibility(View.VISIBLE);
            Bitmap image = getImage(invader);
            drawCharacter(invader, image, imageView);
        } else {
            imageView.setVisibility(View.GONE);
        }
    }

    // キャラクターの描画
    protected void drawCharacter(IGameCharacter character, Bitmap image, ImageView imageView) {
        float x = character.getX();
        float y = character.getY();
        int xSize = character.getxSize();
        int ySize = character.getySize();
        drawImage((int) x, (int) y, xSize, ySize, image, imageView);
    }

    //------------------------------
    // 画像取得用関数
    //------------------------------
    protected Bitmap getImage(IMissile missile) {
        if (missile.getySpeed() > 0) {
            return playerMissileImage;
        } else {
            return enemyMissileImage;
        }
    }

    protected Bitmap getImage(Invader invader) {
        int state = invader.getState();
        switch (invader.getType()) {
            case 1:
                if (state == 1) {
                    return invader11Image;
                } else {
                    return invader12Image;
                }
            case 2:
                if (state == 1) {
                    return invader21Image;
                } else {
                    return invader22Image;
                }
            default:
                if (state == 1) {
                    return invader31Image;
                } else {
                    return invader32Image;
                }
        }
    }

    //------------------------------
    // リスナー
    //------------------------------
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if(event.getY()<800) {
                player.fire();
            }else if(event.getX()<800){
                player.goLeft();
            }else{
                player.goRight();
            }
        }
        return false;
    }

    private class RestartOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        }
    }

    private class NormalOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // プレーヤのミサイルを貫通ミサイルに変更
            playerMissiles = normalMissiles;

            // プレーヤのランチャーに、生成したミサイルを登録
            setMissilesToPlayerLauncher();
        }
    }

    private class PenetrationOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // プレーヤのミサイルを貫通ミサイルに変更
            playerMissiles = penetrationMissiles;

            // プレーヤのランチャーに、生成したミサイルを登録
            setMissilesToPlayerLauncher();
        }
    }

    private class SingleOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 新しいランチャーを生成
            playerLauncher = new SingleLauncher(6);
            player.setLauncher(playerLauncher);

            // プレーヤのランチャーに、生成したミサイルを登録
            setMissilesToPlayerLauncher();
        }
    }

    private class DoubleOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 新しいランチャーを生成
            playerLauncher = new DoubleLauncher(6);
            player.setLauncher(playerLauncher);

            // プレーヤのランチャーに、生成したミサイルを登録
            setMissilesToPlayerLauncher();
        }
    }

    private class TripleOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }




}
