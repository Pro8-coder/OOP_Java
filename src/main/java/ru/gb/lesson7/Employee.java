package ru.gb.lesson7;

// TODO: Создать класс Сотрудник (Employee) с полями:
//  Имя, Фамилия (String)
//  Название отдела (String)
//  Зарплата (double)
//  Реализовать equals и hashCode, который работает только с именем и фамилией

import java.util.Objects;

public class Employee {
    private final String name;
    private final String surname;
    private final String department;
    private final double salary;

    public Employee(String name, String surname, String department, double salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public static Employee createEmployee(String name, String surname, String department, double salary) {
        return new Employee(name, surname, department, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Employee employee)) return false;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return name + " " + surname + ", отдел: " + department + ", зарплата: " + salary;
    }
}
