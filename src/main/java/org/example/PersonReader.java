package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;


public class PersonReader {
    private static final Logger logger = Logger.getLogger(PersonReader.class.getName());



    public List<Person> readPersonsFromJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Регистрируем модуль для работы с Java 8 датами
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();

        try {
            List<Person> persons = objectMapper.readValue(new File(filePath),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class));
            logger.info("Чтение данных из JSON успешно завершено.");
            return persons;
        } catch (Exception e) {
            logger.severe("Ошибка при чтении данных из JSON: " + e.getMessage());
            return null;
        }
    }
}



