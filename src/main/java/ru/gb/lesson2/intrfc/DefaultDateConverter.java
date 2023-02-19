package ru.gb.lesson2.intrfc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DefaultDateConverter implements DateConverter, DateTimeConverter {
    @Override
    public String convert(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Override
    public String convert(LocalDateTime date) {
        return null;
    }
}
