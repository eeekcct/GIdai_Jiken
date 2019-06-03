package com.example.g01_jumper.controllers;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by fyoshida on 2017/02/18.
 */

public class TouchController implements View.OnTouchListener{
    public View touchView;
    public MotionEvent touchEvent;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            touchView = v;
            touchEvent = event;
        }else if (event.getAction() == MotionEvent.ACTION_UP) {
            touchView = null;
            touchEvent = null;
        }
        return true;
    }
}

