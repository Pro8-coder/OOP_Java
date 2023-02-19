package ru.gb.lesson2.game;

public class Long {

    private final int distance;

    public Long(int distance) {
        this.distance = distance;
    }

    public boolean pass(CanLongJump canLongJump) {
        return canLongJump.getLongJump() >= distance;
    }

}
