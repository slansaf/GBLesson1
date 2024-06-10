package ru.gb.family_tree;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.save.FileHandler;
import ru.gb.family_tree.model.save.Writable;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();

    }
//        String filePath = "src/ru/gb/family_tree/save/tree.txt";
//        FamilyTree tree = testTree();
//        //FamilyTree tree  = load(filePath);
//        System.out.println(tree);
//        tree.sotrByName();
//        System.out.println(tree);
//        tree.sortByBirthDate();
//        System.out.println(tree);
//        //save(tree, filePath);
//
//    }
//
//    private static FamilyTree load(String filePath){
//        Writable writable = new FileHandler();
//        return (FamilyTree) writable.read(filePath);
//    }
//
//    private static void save(FamilyTree familyTree, String filePath){
//        Writable writable = new FileHandler();
//        writable.save(familyTree, filePath);
//    }
//
//    private static FamilyTree testTree() {
//        FamilyTree familyTree = new FamilyTree();
//
//        Human human1 = new Human("Oleg", Gender.Male, LocalDate.of(1985, 12, 12));
//        Human human2 = new Human("Olga", Gender.Female, LocalDate.of(1984, 6, 18));
//        Human human3 = new Human("Ruslan", Gender.Male, LocalDate.of(2006, 10, 10), human1, human2);
//        Human human4 = new Human("Lena", Gender.Female, LocalDate.of(2016, 5, 4), human1, human2);
//
//
//        familyTree.addHuman(human1);
//        familyTree.addHuman(human2);
//        familyTree.addHuman(human3);
//        familyTree.addHuman(human4);
//
//        familyTree.setWedding(human1.getId(), human2.getId());
//
//        return familyTree;
//    }
}
