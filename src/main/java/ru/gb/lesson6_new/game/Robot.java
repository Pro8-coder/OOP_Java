package ru.gb.lesson6_new.game;

public class Robot implements RobotInterface {

    public static final Direction DEFAULT_DIRECTION = Direction.TOP;

    private static Long idCounter = 1L;

    final Long id;
    private Direction direction;
    Point point;

//    private void validatePointIsFree(Point point) {
//        for (Robot robot : RobotMap.robots) {
//            Point robotPoint = robot.point;
//            if (robotPoint.equals(point)) {
//                throw new IllegalStateException("Точка " + point + " занята!");
//            }
//        }
//    }

    public Robot(Point point) {
        this.id = idCounter++;
        this.direction = DEFAULT_DIRECTION;
        this.point = point;
    }

    @Override
    public void changeDirection(Direction direction) {
        this.direction = direction;
        System.out.println("Робот " + id + " развёрнут в " + direction);
    }

    @Override
    public void move() {
        Point newPoint = switch (direction) {
            case TOP -> new Point(point.x() - 1, point.y());
            case RIGHT -> new Point(point.x(), point.y() + 1);
            case BOTTOM -> new Point(point.x() + 1, point.y());
            case LEFT -> new Point(point.x(), point.y() - 1);
        };
        RobotMap.validatePoint(newPoint);

        System.out.println("Робот " + id + " переместился с " + point + " на " + newPoint);
        this.point = newPoint;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + point.toString() + " [" + direction.name() + "]";
    }
}
