package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule; // Импорт модуля для работы с датами и временем
import java.io.File;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PersonFilter {
    private static final Logger logger = Logger.getLogger(PersonFilter.class.getName());

    public void filterAdultsAndWriteToJson(List<Person> persons, String outputFilePath) {
        List<Person> adults = persons.stream()
                .filter(person -> person.getAge() > 18)
                .peek(person -> logger.info("Фильтрация: " + person.getName() + " прошел фильтр"))
                .collect(Collectors.toList());

        // Запись отфильтрованных данных в JSON
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Регистрируем модуль для работы с Java 8 датами
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            // Запись отфильтрованных данных в файл
            objectMapper.writeValue(new File(outputFilePath), adults);
            logger.info("Отфильтрованные данные записаны в JSON.");
        } catch (Exception e) {
            logger.severe("Ошибка при записи данных в JSON: " + e.getMessage());
        }
    }
}


//package org.example;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.File;
//import java.util.List;
//import java.util.logging.Logger;
//import java.util.stream.Collectors;
//
//public class PersonFilter {
//    private static final Logger logger = Logger.getLogger(PersonFilter.class.getName());
//
//
//
//    public void filterAdultsAndWriteToJson(List<Person> persons, String outputFilePath) {
//        List<Person> adults = persons.stream()
//                .filter(person -> person.getAge() > 18)
//                .peek(person -> logger.info("Фильтрация: " + person.getName() + " прошел фильтр"))
//                .collect(Collectors.toList());
//
//        // Запись отфильтрованных данных в JSON
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.writeValue(new File(outputFilePath), adults);
//            logger.info("Отфильтрованные данные записаны в JSON.");
//        } catch (Exception e) {
//            logger.severe("Ошибка при записи данных в JSON: " + e.getMessage());
//        }
//    }
//}
