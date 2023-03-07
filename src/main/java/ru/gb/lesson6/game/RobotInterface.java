package ru.gb.lesson6.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface RobotInterface {

    void changeDirection(Direction direction);

    void move();

    static class CommandManager {

        private final RobotMap map;
        private static List<CommandHandler> handlers = null;

        public CommandManager(RobotMap map) {
            this.map = map;
            handlers = new ArrayList<>();
            initHandlers();
        }

        private void initHandlers() {
            handlers.add(new CreateCommandHandler());
            handlers.add(new ListCommandHandler());
            handlers.add(new MoveCommandHandler());
            handlers.add(new ChangeDirCommandHandler());
            handlers.add(new DeleteCommandHandler());
        }

        public static void acceptCommand(String command) {
            String[] split = command.split(" ");
            String commandName = split[0];
            String[] commandArgs = Arrays.copyOfRange(split, 1, split.length);

            boolean found = false;
            for (CommandHandler handler : handlers) {
                if (commandName.equals(handler.name())) {
                    found = true;
                    try {
                        handler.runCommand(commandArgs);
                    } catch (Exception e) {
                        System.err.println("Во время обработки команды \"" + commandName + "\" произошла ошибка: " + e.getMessage());
                    }
                }
            }

            if (!found) {
                System.out.println("Команда не найдена");
            }
        }

        private interface CommandHandler {
            String name();

            void runCommand(String[] args);
        }

        private class CreateCommandHandler implements CommandHandler {
            @Override
            public String name() {
                return "create";
            }

            @Override
            public void runCommand(String[] args) {
                int x = Integer.parseInt(args[0]);
                int y = Integer.parseInt(args[1]);
                RobotMap.Robot robot = map.createRobot(new Point(x, y));
                System.out.println(robot);
            }
        }

        private class ListCommandHandler implements CommandHandler {
            @Override
            public String name() {
                return "list";
            }

            @Override
            public void runCommand(String[] args) {
                map.acceptRobots(System.out::println);
            }
        }

        private class MoveCommandHandler implements CommandHandler {
            @Override
            public String name() {
                return "move";
            }

            @Override
            public void runCommand(String[] args) {
                Long robotId = Long.parseLong(args[0]);
                Optional<RobotMap.Robot> robot = map.getById(robotId);
                robot.ifPresentOrElse(RobotInterface::move, () -> System.out.println(robotId));
            }
        }

        private class ChangeDirCommandHandler implements CommandHandler {
            @Override
            public String name() {
                return "changedir";
            }

            @Override
            public void runCommand(String[] args) {
                Long robotId = Long.parseLong(args[0]);
                Optional<RobotMap.Robot> robot = map.getById(robotId);
                if (robot.isPresent()) {
                    RobotInterface value = robot.get();
                    value.changeDirection(Direction.ofString(args[1]).get());
                } else {
                    System.out.println(robotId);
                }
            }
        }

        private class DeleteCommandHandler implements CommandHandler {
            @Override
            public String name() {
                return "delete";
            }

            @Override
            public void runCommand(String[] args) {
                Long robotId = Long.parseLong(args[0]);
                if (map.delete(robotId)) {
                    System.out.println("Робот " + robotId + " удалён с карты");
                } else {
                    System.out.println("Робот " + robotId + " не найден");
                }
            }
        }
    }
}
