package com.example.g02_dragon.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.g02_dragon.BaseActivity;
import com.example.g02_dragon.MainActivity;
import com.example.g02_dragon.R;

import java.util.LinkedList;

public class ImageViewManager {

    // ビュー
    private ImageView playerImageView;
    private ImageView block1ImageView;
    private ImageView block2ImageView;
    private ImageView boardImageView;
    private ImageView leverImageView;
    private ImageView dragonImageView;
    private ImageView princessImageView;
    private ImageView cageImageView;
    private ImageView fireImageView;
    private TextView gameOverTextView;
    private TextView gameClearTextView;
    private TextView timeTextView;

    public ImageViewManager(MainActivity activity) {
        loadImageView(activity);
    }

    public void loadImageView(MainActivity activity) {
        playerImageView = activity.findViewById(R.id.playerImageView);
        block1ImageView = activity.findViewById(R.id.block1ImageView);
        block2ImageView = activity.findViewById(R.id.block2ImageView);
        boardImageView = activity.findViewById(R.id.boardImageView);
        leverImageView = activity.findViewById(R.id.leverImageView);
        dragonImageView = activity.findViewById(R.id.dragonImageView);
        princessImageView = activity.findViewById(R.id.princessImageView);
        cageImageView = activity.findViewById(R.id.cageImageView);
        fireImageView = activity.findViewById(R.id.fireImageView);
        gameClearTextView = activity.findViewById(R.id.gameClearTextView);
        gameOverTextView = activity.findViewById(R.id.gameOverTextView);
        timeTextView = activity.findViewById(R.id.timeTextView);
    }

    public ImageView getPlayerImageView() {
        return playerImageView;
    }

    public ImageView getBlock1ImageView() {
        return block1ImageView;
    }

    public ImageView getBlock2ImageView() {
        return block2ImageView;
    }

    public ImageView getBoardImageView() {
        return boardImageView;
    }

    public ImageView getLeverImageView() {
        return leverImageView;
    }

    public ImageView getDragonImageView() {
        return dragonImageView;
    }

    public ImageView getPrincessImageView() {
        return princessImageView;
    }

    public ImageView getCageImageView() {
        return cageImageView;
    }

    public ImageView getFireImageView() {
        return fireImageView;
    }

    public TextView getGameOverTextView() {
        return gameOverTextView;
    }

    public TextView getGameClearTextView() {
        return gameClearTextView;
    }

    public TextView getTimeTextView() {
        return timeTextView;
    }
}
