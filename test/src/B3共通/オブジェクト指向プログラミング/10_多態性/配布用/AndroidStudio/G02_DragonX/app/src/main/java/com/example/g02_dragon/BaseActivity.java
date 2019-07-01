package com.example.g02_dragon;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.g02_dragon.controllers.AccelerationController;
import com.example.g02_dragon.controllers.GpsController;
import com.example.g02_dragon.controllers.TouchController;

public class BaseActivity extends AppCompatActivity implements Runnable, MediaPlayer.OnCompletionListener {

    // スレッド処理用
    Handler handler = null;
    long startTime = 0;

    // 画面の幅、高さ、基準座標
    int canvasBaseX = 0;
    int canvasBaseY = 0;
    int canvasWindowWidth;
    int canvasWindowHeight;

    // デバイスの表示領域
    int deviceWindowWidth;
    int deviceWindowHeight;

    // 表示倍率
    private float windowScaleX;
    private float windowScaleY;

    // センサー制御用コントローラ
    AccelerationController accelerationController = null;
    GpsController gpsController = null;
    TouchController touchController = null;

    // センサー設定
    boolean gravityEnabled = false;
    boolean gpsEnabled = false;
    int orientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;

    // 音楽設定
    boolean mediaPlayerIsInitialized = false;
    MediaPlayer mediaPlayer = null;
    SoundPool soundPool = null;

    //=========================
    //  ライフサイクル用関数
    //=========================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ステータスバーを非表示
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // タイトルを非表示
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 初期設定
        initializeWindow();
        initializeAccelerationController();
        initializeGpsController();
        initializeOrientation();
        initializeTouchController();
        initializeMusic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (gravityEnabled && accelerationController != null) {
            accelerationController.start();
        }
        if (gpsEnabled && gpsController != null) {
            gpsController.start();
        }
        startThread();
        continueThread();
    }

    @Override
    protected void onPause() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (gravityEnabled) {
            accelerationController.stop();
        }
        if (gpsEnabled) {
            gpsController.stop();
        }
        stopThread();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //=========================
    //  スレッド処理用の関数
    //=========================
    @Override
    public void run() {
        float deltaTime = (System.nanoTime() - startTime) / 1000000000.0f;
        updateModel();
        updateView();
        continueThread();
    }

    private void startThread() {
        handler = new Handler();
        startTime = System.nanoTime();
    }

    private void continueThread() {
        handler.postDelayed(this, 10);
    }

    private void stopThread() {
        handler.removeCallbacks(this);
    }

    //=========================
    //  更新処理用の関数
    //=========================
    // モデルの更新処理
    protected void updateModel() {
    }

    // ビューの更新処理
    protected void updateView() {
    }

    //=========================
    //  初期化用の関数
    //=========================
    private void setDeviceWindowSize() {
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display dp = wm.getDefaultDisplay();
        Point point = new Point();
        dp.getSize(point);
        deviceWindowWidth = point.x;
        deviceWindowHeight = point.y;
    }

    private void setCanvasWindowSize() {
        if (deviceWindowHeight > deviceWindowWidth) {
            canvasWindowHeight = 600;
            canvasWindowWidth = 360;
        } else {
            canvasWindowHeight = 360;
            canvasWindowWidth = 600;
        }
        windowScaleX = (float) deviceWindowWidth / canvasWindowWidth;
        windowScaleY = (float) deviceWindowHeight / canvasWindowHeight;
    }

    private void initializeWindow() {
        setDeviceWindowSize();
        setCanvasWindowSize();
    }

    protected void initializeAccelerationController() {
        if (gravityEnabled) {
            accelerationController = new AccelerationController(
                    (SensorManager) getSystemService(Context.SENSOR_SERVICE));
            accelerationController.start();
        } else {
            accelerationController = null;
        }
    }

    protected void initializeGpsController() {
        if (gpsEnabled) {
//            gpsController = new GpsController((LocationManager) getSystemService(Context.LOCATION_SERVICE));
        }
    }

    protected void initializeTouchController() {
        touchController = new TouchController();
//        layout.setOnTouchListener(touchController);
    }

    protected void initializeOrientation() {
        setRequestedOrientation(orientation);
    }

    protected void initializeMusic() {
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = buildSoundPool(20);
    }

    //=========================
    //  画像表示用の関数
    //=========================
    // 画像サイズの変更
    protected Bitmap changeSize(int width, int height, Bitmap image) {
        Matrix m = new Matrix();
        m.postScale(width / (float) image.getWidth(), height / (float) image.getHeight());
        return Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), m, true);
    }

    // 画像の読み込み
    public Bitmap loadImage(int id, int xSize, int ySize) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
        int bitmapXSize = bitmap.getWidth();
        int bitmapYSize = bitmap.getHeight();
        float deviceXSize = (float) xSize / bitmapXSize * windowScaleX;
        float deviceYSize = (float) ySize / bitmapYSize * windowScaleY;
        Matrix m = new Matrix();
        m.postScale(deviceXSize, deviceYSize);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmapXSize, bitmapYSize, m, true);
    }

    // 画像の描画
    public void drawImage(int x, int y, int xSize, int ySize, Bitmap bitmap, ImageView imageView) {
        int canvasX = x - canvasBaseX;
        int canvasY = canvasWindowHeight - ySize - y + canvasBaseY;
        int deviceX = (int) (canvasX * windowScaleX);
        int deviceY = (int) (canvasY * windowScaleY);
//        int deviceXSize = (int) (xSize * windowScaleX);
//        int deviceYSize = (int) (ySize * windowScaleY);
//        Bitmap resizeBitmap = changeSize(deviceXSize, deviceYSize, bitmap);
        imageView.setImageBitmap(bitmap);
        imageView.setTranslationX(deviceX);
        imageView.setTranslationY(deviceY);
    }

    //=========================
    //  サウンド用の関数
    //=========================
    @SuppressWarnings("deprecation")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected SoundPool buildSoundPool(int poolMax) {
        SoundPool pool = null;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            pool = new SoundPool(poolMax, AudioManager.STREAM_MUSIC, 0);
        } else {
            AudioAttributes attr = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            pool = new SoundPool.Builder()
                    .setAudioAttributes(attr)
                    .setMaxStreams(poolMax)
                    .build();
        }

        return pool;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        synchronized (this) {
            mediaPlayerIsInitialized = false;
        }
    }

    protected void loadMusic(int id) {
        mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setLooping(true);
    }

    protected void setMusicVolume(float volume) {
        mediaPlayer.setVolume(volume, volume);
    }

    protected void startMusic() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    protected void stopMusic() {
        mediaPlayer.stop();
    }

    protected int loadSound(int id) {
        return soundPool.load(this, id, 1);
    }

    protected void playSound(int soundId, float volume) {
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }

}
