package ru.gb.lesson3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Notebook {

    private final double price;
    private final int ram;

    public Notebook(double price, int ram) {
        this.price = price;
        this.ram = ram;
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public static void main(String[] args) {
        List<Notebook> list = new ArrayList<>();
        list.add(new Notebook(600.0, 8));
        list.add(new Notebook(800.0, 8));
        list.add(new Notebook(700.0, 4));
        list.add(new Notebook(500.0, 4));
        list.add(new Notebook(700.0, 8));

        // Сортировка по цене
        list.sort(Comparator.comparingDouble(Notebook::getPrice));
        System.out.println("Сортировка по цене: ");
        for (Notebook n : list) {
            System.out.println(n.getPrice() + " " + n.getRam());
        }

        // Сортировка по памяти
        list.sort(Comparator.comparingInt(Notebook::getRam));
        System.out.println("Сортировка по памяти: ");
        for (Notebook n : list) {
            System.out.println(n.getPrice() + " " + n.getRam());
        }

        // Сортировка сначала по памяти, потом по цене
        list.sort(Comparator.comparingInt(Notebook::getRam).thenComparing(Notebook::getPrice));
        System.out.println("Сортировка сначала по памяти, потом по цене: ");
        for (Notebook n : list) {
            System.out.println(n.getPrice() + " " + n.getRam());
        }
    }
}
