package com.example.g04_invader.models;

import java.util.LinkedList;

public class InvaderManager {
    private LinkedList<Invader> invaders = new LinkedList<Invader>();
    private float xSpeed = 3;
    private float ySpeed = 0;
    private int tempo = 1;
    private int counter = 50;
    private int state = 1;
    private boolean win = false;

    public InvaderManager() {
    }

    public void addInvader(Invader invader) {
        invaders.add(invader);
    }

    public int getState() {
        return state;
    }

    public boolean isWin() {
        return win;
    }

    public int remaining() {
        int count = 0;
        for (Invader invader : invaders) {
            if (invader.isDead() == false) {
                count++;
            }
        }
        return count;
    }

    private float maxX() {
        float maxX = 0;
        for (Invader invader : invaders) {
            if (invader.isDead() == false) {
                float x = invader.x + invader.xSize - 1;
                if (maxX < x) {
                    maxX = x;
                }
            }
        }
        return maxX;
    }

    private float minX() {
        float minX = 1000;
        for (Invader invader : invaders) {
            if (invader.isDead() == false) {
                float x = invader.x;
                if (x < minX) {
                    minX = x;
                }
            }
        }
        return minX;
    }

    public boolean isConquest() {
        for (Invader invader : invaders) {
            if (invader.isDead() == false) {
                if (invader.getY() <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void move() {
        updateTemp();

        // カウントアップ
        if (counter > 0) {
            counter -= tempo;
        } else {
            counter = 50;
            state = -state;

            // 折り返し
            if (minX() < 0 || maxX() > World.WIDTH) {
                xSpeed = -xSpeed;
                ySpeed = -30;
            } else {
                ySpeed = 0;
            }

            if (isConquest()) {
                win = true;
            } else {
                for (Invader invader : invaders) {
                    invader.move(xSpeed * tempo, ySpeed);
                    invader.setState(state);
                }
            }

        }


    }

    private void updateTemp() {
        int live = remaining();
        if (live < 1) {
            tempo = 20;
        } else if (live < 2) {
            tempo = 16;
        } else if (live < 4) {
            tempo = 12;
        } else if (live < 8) {
            tempo = 6;
        } else if (live < 16) {
            tempo = 4;
        } else if (live < 24) {
            tempo = 2;
        } else {
            tempo = 1;
        }
    }
}
