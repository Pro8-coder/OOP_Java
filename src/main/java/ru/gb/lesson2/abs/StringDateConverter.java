package ru.gb.lesson2.abs;

import java.time.LocalDate;

public abstract class StringDateConverter {

    protected final LocalDate date;

    public StringDateConverter(LocalDate date) {
        this.date = date;
    }

    public abstract String dateAsString();

}
