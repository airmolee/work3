package org.example;

import java.util.List;

public class AverageAgeCalculator {
    public double calculateAverageAge(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }
}
