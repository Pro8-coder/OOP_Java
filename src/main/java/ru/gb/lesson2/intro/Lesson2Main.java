package ru.gb.lesson2.intro;

import ru.gb.lesson2.abs.DefaultStringDateConverter;
import ru.gb.lesson2.abs.IsoStringDateConverter;
import ru.gb.lesson2.intrfc.DateConverter;
import ru.gb.lesson2.intrfc.DateTimeConverter;
import ru.gb.lesson2.intrfc.DefaultDateConverter;
import ru.gb.lesson2.intrfc.IsoDateConverter;

import java.time.LocalDate;

public class Lesson2Main {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(new DefaultStringDateConverter(now).dateAsString());
        System.out.println(new IsoStringDateConverter(now).dateAsString());

        DateConverter dateConverter = new DefaultDateConverter();
        DateTimeConverter dateTimeConverter = new DefaultDateConverter();

        System.out.println(dateConverter.convert(now));
        System.out.println(new IsoDateConverter().convert(now));
    }

}
