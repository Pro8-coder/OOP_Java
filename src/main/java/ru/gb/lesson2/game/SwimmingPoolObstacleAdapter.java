package ru.gb.lesson2.game;

public class SwimmingPoolObstacleAdapter implements Obstacle {

    private final SwimmingPoll swimmingPoll;

    public SwimmingPoolObstacleAdapter(SwimmingPoll swimmingPoll) { this.swimmingPoll = swimmingPoll; }

    @Override
    public boolean pass(Participant participant) { return swimmingPoll.pass(participant); }

}
