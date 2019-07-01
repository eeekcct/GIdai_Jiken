package com.example.g03_mario.models;

public class HardCharacter extends GameCharacterWithP{

    public HardCharacter(){

    }

    // 自分から見て、（動いている）相手がどの方向から来たか判定する処理
    protected Direction overlapDirectionOf(MoveCharacter target) {
        // target が１回前にどちらの方向にいたか？
        return directionOf(target.getOld());
    }

    // 相手を跳ね返す処理
    protected void bounceBack(MoveCharacter target) {
        switch (overlapDirectionOf(target)) {
            case Top:
                target.setBottom(getTop() + 1);
                target.setySpeed(0);
                break;
            case Bottom:
                target.setTop(getBottom() - 1);
                target.setySpeed(0);
                break;
            case Right:
                target.setLeft(getRight() + 1);
                target.setxSpeed(0);
                break;
            case Left:
                target.setRight(getLeft() - 1);
                target.setxSpeed(0);
                break;
            default:
        }
    }
}
