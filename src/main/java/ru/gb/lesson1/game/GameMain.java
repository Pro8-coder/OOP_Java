package ru.gb.lesson1.game;

public class GameMain {

    public static void main(String[] args) {
        // Карта с роботами.
        // Карта имеет nxm, где n и m - положительные целые числа.
        // Должна быть возможность создания робота на какой-то точке на карте.
        // Точка на карте описывается двумя целочисленными координатами.
        // Роботы могут перемещаться по карте вперед.
        // В одной точке не может находиться несколько роботов.

        // HOMEWORK
        // 0. Разобраться с проектом. Подготовить вопросы к следующему семинару, если возникнут.
        // 1. Добавить валидацию параметров при создании карты
        // 2. Реализовать возможность задать ограничение по количеству создаваемых
        // на карте роботов (в конструкторе карты)
        // При этом если параметр не указан, то используем значение по-умолчанию: 5
        // 3*. Реализовать возможность вызова метода move с параметром - количество шагов вперед
        // Подсказка: можно несколько раз вызвать метод #move

        /*
          * * * * *
          * * * * *
          * * * * *
          * * * * *
          * * * * *
        */

        RobotMap map = new RobotMap(5, 5, 6);

        RobotMap.Robot robot1 = map.createRobot(new Point(2, 3));
        RobotMap.Robot robot2 = map.createRobot(new Point(3, 3));
        RobotMap.Robot robot3 = map.createRobot(new Point(2, 2));
        RobotMap.Robot robot4 = map.createRobot(new Point(1, 1));
        RobotMap.Robot robot5 = map.createRobot(new Point(2, 1));
        RobotMap.Robot robot6 = map.createRobot(new Point(3, 4));
        System.out.println(robot1); // [2, 3], [TOP]
        System.out.println(robot2); // [3, 3], [TOP]
        System.out.println(robot3); // [2, 2], [TOP]
        System.out.println(robot4); // [1, 1], [TOP]
        System.out.println(robot5); // [2, 1], [TOP]
        System.out.println(robot6); // [2, 3], [TOP]
        robot1.move();
        robot1.move();
        robot1.move();
        robot1.move();
        robot1.move();
        System.out.println(robot1); // [1, 3], [TOP]
        robot1.changeDirection(Direction.BOTTOM);
        robot1.move();
//        robot1.move(5);
        robot1.move(); // [3, 3], [BOTTOM]
        robot1.changeDirection(Direction.LEFT);
        robot1.move();
        System.out.println(robot1); // [3, 2], [LEFT]


    }

}
