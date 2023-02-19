package ru.gb.lesson2.game;

public class LongJampObstacleAdapter implements Obstacle{

    private final Long longJump;

    public LongJampObstacleAdapter(Long longJump) { this.longJump = longJump; }

    @Override
    public boolean pass(Participant participant) { return longJump.pass(participant); }
}
