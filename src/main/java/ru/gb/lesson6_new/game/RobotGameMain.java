package ru.gb.lesson6_new.game;

import java.util.Scanner;

public class RobotGameMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Приветствуем вас в \"Играх роботов\"");
        System.out.println("Введите размеры карты:");
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        final RobotMap map = new RobotMap(n, m);
        System.out.println("Карта успешно создана");

        final CommandManager manager = new CommandManager(map);
        while (true) {
            System.out.println("""
                    Доступные действия:
                    1. Для создания робота введите create x y, где x и y - координаты для нового робота
                    2. Для вывода списка всех созданных роботов, введите list
                    3. Для перемещения робота введите move id, где id - идентификатор робота
                    4. Для изменения направления введите changedir id DIRECTION, где id - идентификатор робота, DIRECTION - одно из значений {TOP, RIGHT, BOTTOM, LEFT}
                    5. Для удаления робота введите delete id, где id - идентификатор робота
                    6. Для выхода напишите exit
                    ... список будет пополняться
                    """);

            String command = sc.nextLine();
            manager.acceptCommand(command);
        }
    }
}
