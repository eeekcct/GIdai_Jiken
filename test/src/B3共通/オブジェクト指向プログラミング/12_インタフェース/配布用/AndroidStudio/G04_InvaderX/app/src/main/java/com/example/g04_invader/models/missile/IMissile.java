package com.example.g04_invader.models.missile;

import com.example.g04_invader.models.IGameCharacter;
import com.example.g04_invader.models.ITarget;

public interface IMissile extends ITarget, IGameCharacter {
    public void setTarget(ITarget target);
    public void fire(float x, float y, float ySpeed);
    public void move();
    public boolean isActive();
}
