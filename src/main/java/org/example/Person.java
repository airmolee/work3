package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthDate;
    private String email;

    @JsonCreator
    public Person(@JsonProperty("name") String name,
                  @JsonProperty("birthDate") String birthDate,
                  @JsonProperty("email") String email) {
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate); // преобразуем строку в LocalDate
        this.email = email;
    }

    public Person() {
        this("noname", null, "noname@noname.com");
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }


    // Возраст человека
    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}




