package ru.gb.family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Oleg", Gender.Male, LocalDate.of(1985, 12, 12));
        Human human2 = new Human("Olga", Gender.Female, LocalDate.of(1984, 6, 18));
        Human human3 = new Human("Ruslan", Gender.Male, LocalDate.of(2006, 10, 10), human1, human2);
        Human human4 = new Human("Lena", Gender.Female, LocalDate.of(2016, 5, 4), human1, human2);


        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);

        familyTree.setWedding(human1.getId(), human2.getId());


        System.out.println(familyTree);

        System.out.println(familyTree.findByName("olga"));

    }
}
