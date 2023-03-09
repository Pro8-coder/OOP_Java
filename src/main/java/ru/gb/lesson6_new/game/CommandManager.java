package ru.gb.lesson6_new.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CommandManager {

    private final RobotMap map;
    private final List<CommandHandler> handlers;

    public CommandManager(RobotMap map) {
        this.map = map;
        handlers = new ArrayList<>();
        initHandlers();
    }

    private void initHandlers() {
        initCreateCommandHandler();
        initListCommandHandler();
        initMoveCommandHandler();
        initChangeDirCommandHandler();
        initDeleteCommandHandler();
    }

    private void initCreateCommandHandler() {
        handlers.add(new CommandHandler() {
            @Override
            public String name() {
                return "create";
            }

            @Override
            public void runCommand(String[] args) {
                int x = Integer.parseInt(args[0]);
                int y = Integer.parseInt(args[1]);
                Robot robot = map.createRobot(new Point(x, y));
                System.out.println("Робот " + robot + " успешно создан");
            }
        });
    }

    private void initListCommandHandler() {
        handlers.add(new CommandHandler() {
            @Override
            public String name() {
                return "list";
            }

            @Override
            public void runCommand(String[] args) {
                map.acceptRobots(System.out::println);
            }
        });
    }

    private void initMoveCommandHandler() {
        handlers.add(new CommandHandler() {
            @Override
            public String name() {
                return "move";
            }

            @Override
            public void runCommand(String[] args) {
                Long robotId = Long.parseLong(args[0]);
                Optional<Robot> robot = map.getById(robotId);
                robot.ifPresentOrElse(Robot::move, () -> System.out.println("Робот с идентификатором " + robotId + " не найден"));
            }
        });
    }

    private void initChangeDirCommandHandler() {
        handlers.add(new CommandHandler() {
            @Override
            public String name() { return "changedir"; }

            @Override
            public void runCommand(String[] args) {
                Long robotId = Long.parseLong(args[0]);
                Optional<Robot> robot = map.getById(robotId);

                if (robot.isPresent()) {
                    Robot value = robot.get();
                    value.changeDirection(Direction.ofString(args[1]).get());
                } else {
                    System.out.println("Робот с идентификатором " + robotId + " не найден");
                }
            }
        });
    }

    private void initDeleteCommandHandler() {
        handlers.add(new CommandHandler() {
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
        });
    }

    public void acceptCommand(String command) {
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
}
