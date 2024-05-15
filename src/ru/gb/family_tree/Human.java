package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.List;

public class Human {
    private String name;
    private LocalDate dob, dod;
    private List<Human> children;
    private Human father, mather;
    private Gender gender;

    public Human(String name, Gender gender, LocalDate dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public Human(String name, Gender gender) {
        this(name, gender, LocalDate.of(1900,12,12));
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Birthday: " + dob;
    }
}
