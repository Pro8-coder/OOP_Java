package ru.gb.lesson4.hw;

import java.util.ArrayList;
import java.util.List;

public class Box<F extends Fruit> {

    private List<F> fruits = new ArrayList<>();

    public void add(F fruit) { fruits.add(fruit); }

    public double getWeight() {
        double weight = 0;
        for (F fruit : fruits) { weight += fruit.getWeight(); }
        return weight;
    }

    public void moveTo(Box<? super F> anotherBox) {
        for (F fruit : fruits) { anotherBox.add(fruit); }
        fruits = new ArrayList<>();
    }
}
