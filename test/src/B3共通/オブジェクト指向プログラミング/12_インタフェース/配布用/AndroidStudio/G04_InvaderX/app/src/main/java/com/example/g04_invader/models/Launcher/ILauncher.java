package com.example.g04_invader.models.Launcher;

import com.example.g04_invader.models.missile.IMissile;

public interface ILauncher {
    public void clearMissile();
    public void setMissile(IMissile missile);
    public void fire(float x, float y);
}
