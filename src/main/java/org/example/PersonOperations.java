package org.example;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

public class PersonOperations {
    private static final Logger logger = Logger.getLogger(PersonOperations.class.getName());


    public void applyOperations(List<Person> persons) {
        Predicate<Person> isAdult = person -> person.getAge() > 18;
        Function<Person, String> personInfo = person -> person.getName() + " (" + person.getEmail() + ")";
        Consumer<String> printInfo = info -> logger.info(info);

        persons.stream()
                .filter(isAdult)
                .map(personInfo)
                .forEach(printInfo);
    }
}
