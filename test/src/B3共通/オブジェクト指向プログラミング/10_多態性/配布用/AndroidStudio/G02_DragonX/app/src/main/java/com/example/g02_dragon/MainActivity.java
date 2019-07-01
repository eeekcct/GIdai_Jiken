package com.example.g02_dragon;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.g02_dragon.models.World;
import com.example.g02_dragon.views.MainView;

public class MainActivity extends BaseActivity {

    //-----------------------------
    // 変数宣言
    //-----------------------------
    // ビュー
    MainView view;

    // モデル
    World world;

    //-----------------------------
    // 起動時の処理
    //-----------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        gravityEnabled = true;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ビュー
        view = new MainView(this);

        // オブジェクトの生成
        world = new World();
    }

    //-----------------------------
    // モデルの更新
    //-----------------------------
    protected void updateModel() {
        world.move();
    }

    //-----------------------------
    // ビューの更新
    //-----------------------------
    protected void updateView() {
        view.draw(world);
    }

    //-----------------------------
    // 画面をタッチした時の処理
    //-----------------------------
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                if (event.getX(event.getActionIndex()) < 640) {
                    world.player.turnLeft();
                } else {
                    world.player.turnRight();
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                if (event.getPointerCount() == 1) {
                    world.player.stop();
                }
                break;
        }
        return true;
    }
}
