package org.example;

import java.util.List;
import java.util.logging.Logger;

public class LeapYearFilter {
    private static final Logger logger = Logger.getLogger(LeapYearFilter.class.getName());

    // Метод для определения високосного года по формуле
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    // Метод для фильтрации и вывода людей, родившихся в високосный год
    public void printLeapYearBirthdays(List<Person> persons) {
        persons.stream()
                .filter(person -> isLeapYear(person.getBirthDate().getYear()))
                .forEach(person -> logger.info(person.getName() + " родился(-ась) в високосный год"));
    }
}

