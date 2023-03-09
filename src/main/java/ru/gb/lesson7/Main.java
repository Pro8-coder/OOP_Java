package ru.gb.lesson7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Object> employ = new ArrayList<>();

        employ.add(Employee.createEmployee("Иван", "Иванов", "IT", 300000));
        employ.add(Employee.createEmployee("Пётр", "Иванов", "Продажи", 100000));
        employ.add(Employee.createEmployee("Иван", "Александров", "Продажи", 1000000));
        employ.add(Employee.createEmployee("Иван", "Петров", "Закупки", 100000));
        employ.add(Employee.createEmployee("Александр", "Иванов", "HR", 200000));
        employ.add(Employee.createEmployee("Иван", "Иванов", "IT", 330000));
        employ.add(Employee.createEmployee("Максим", "Петров", "IT", 100000));
        employ.add(Employee.createEmployee("Максим", "Иванов", "IT", 300000));

        for (int i = 0; i < employ.size(); i++) {
            for (int j = i + 1; j < employ.size(); j++) {
                if (employ.get(i).equals(employ.get(j))) {
                    System.out.println("Внимание! Сотрудник дублируется: ");
                    System.out.println(employ.get(i) + ", hashCode сотрудника: " + employ.get(i).hashCode());
                    System.out.println(employ.get(j) + ", hashCode сотрудника: " + employ.get(j).hashCode());
                    System.out.println("Для продолжения нажмите Enter");
                    scanner.nextLine();
//                } else {
//                    System.out.println("Дублей нет");
                }
            }
        }

        // TODO: Или так.
//        for (Object employee : employ) {
//            if (employ.indexOf(employee) != employ.lastIndexOf(employee)) {
//                System.out.println("Внимание! Сотрудник дублируется: ");
//                System.out.println(employee + ", hashCode сотрудника: " + employee.hashCode());
//                System.out.println("Для продолженя нажмите Enter");
//                scanner.nextLine();
//            }
//        }

        int duplicates = employ.size() - new HashSet<>(employ).size();
        if (duplicates == 0) {
            System.out.println("Дублей нет");
        } else {
            System.out.println("Всего найдено дублей: " + duplicates);
        }
    }
}


