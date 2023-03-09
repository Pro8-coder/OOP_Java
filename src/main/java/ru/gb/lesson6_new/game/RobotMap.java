package ru.gb.lesson6_new.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class RobotMap {

    private static int n;
    private static int m;
    static List<Robot> robots = null;

    public RobotMap(int n, int m) {
        RobotMap.n = n;
        RobotMap.m = m;
        robots = new ArrayList<>();
    }

    public Robot createRobot(Point point) {
        validatePoint(point);
        Robot robot = new Robot(point);
        robots.add(robot);

        return robot;
    }

    public void acceptRobots(Consumer<Robot> robotAcceptor) {
        for (Robot robot : robots) {
            robotAcceptor.accept(robot);
        }
    }

    public Optional<Robot> getById(Long id) {
        for (Robot robot : robots) {
            if (id.equals(robot.id)) {
                return Optional.of(robot);
            }
        }

        return Optional.empty();
    }

    static void validatePoint(Point point) {
        validatePointIsCorrect(point);
        validatePointIsFree(point);
    }

    private static void validatePointIsCorrect(Point point) {
        if (point.x() < 0 || point.x() > n || point.y() < 0 || point.y() > m) {
            throw new IllegalStateException("Некоректное значение точки!");
        }
    }

    private static void validatePointIsFree(Point point) {
        for (Robot robot : robots) {
            Point robotPoint = robot.point;
            if (robotPoint.equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята!");
            }
        }
    }

    public boolean delete(Long id) {
        Optional<Robot> robot = this.getById(id);
        if (robot.isPresent()) {
            Robot value = robot.get();
            robots.remove(value);
            return true;
        }
        return false;
    }
}
