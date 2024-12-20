package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        PersonReader personReader = new PersonReader();
        List<Person> persons = personReader.readPersonsFromJson("Person.json");

        PersonFilter personFilter = new PersonFilter();
        personFilter.filterAdultsAndWriteToJson(persons, "adults.json");

        AverageAgeCalculator ageCalculator = new AverageAgeCalculator();
        double averageAge = ageCalculator.calculateAverageAge(persons);
        System.out.println("Средний возраст: " + averageAge);

        LeapYearFilter leapYearFilter = new LeapYearFilter();
        leapYearFilter.printLeapYearBirthdays(persons);

        AgeGroup ageGroupGroup = new AgeGroup();
        Map<String, List<String>> groupedByAge = ageGroupGroup.groupByAgeGroup(persons);
        System.out.println(groupedByAge);


        PersonOperations personOperations = new PersonOperations();
        personOperations.applyOperations(persons);

    }
}
