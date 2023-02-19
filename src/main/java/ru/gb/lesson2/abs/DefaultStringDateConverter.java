package ru.gb.lesson2.abs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DefaultStringDateConverter extends StringDateConverter {

    public DefaultStringDateConverter(LocalDate date) {
        super(date);
    }

    @Override
    public String dateAsString() {
        // dd.MM.yyyy
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

}

