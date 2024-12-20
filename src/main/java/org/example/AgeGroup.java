package org.example;

import java.util.*;


public class AgeGroup {

    // Метод для группировки людей по возрастным категориям
    public Map<String, List<String>> groupByAgeGroup(List<Person> persons) {
        Map<String, List<String>> groupedByAge = new HashMap<>();

        // Для каждого человека определяем его возрастную группу и добавляем в соответствующую группу
        for (Person person : persons) {
            String ageGroup = getAgeGroup(person);  // Определяем возрастную группу для человека
            groupedByAge.putIfAbsent(ageGroup, new ArrayList<>());  // Если группа не существует, создаем ее
            groupedByAge.get(ageGroup).add(person.getName());  // Добавляем имя человека в соответствующую группу
        }

        return groupedByAge;
    }

    // Метод для определения возрастной группы
    private String getAgeGroup(Person person) {
        int age = person.getAge();

        if (age < 12) {
            return "Дети";
        } else if (age < 60) {
            return "Молодежь";
        } else {
            return "Пожилые";
        }
    }
}


