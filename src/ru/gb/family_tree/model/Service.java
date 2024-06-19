package ru.gb.family_tree.model;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.save.FileHandler;
import ru.gb.family_tree.model.save.Writable;
import ru.gb.family_tree.presenter.Presenter;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Service {
    private FamilyTree familyTree;
    private String filePath = "src/ru/gb/family_tree/model/save/tree.txt";

    public Service() {
        familyTree  = new FamilyTree<>();
    }

    public void addHuman(String name, String gender, LocalDate date, String nameFather, String nameMather) {
        familyTree.addHuman(new Human(name, getGenderFromString(gender),  date));
    }

   public void addChildren(String nameParent, String nameChild){

   }

    public String getHumanInfo(){
        String answer = familyTree.getInfo();
        return answer;
    }

    public void sotrByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void saveFemaleTree() {
        save(familyTree, filePath);
    }

    public void loadFemaleTree() {
        familyTree = load(filePath);
    }

    private static FamilyTree load(String filePath){
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(filePath);
    }

    private static void save(FamilyTree familyTree, String filePath){
        Writable writable = new FileHandler();
        writable.save(familyTree, filePath);
    }


    public void setWedding(int idMale, int idFemale) {
        familyTree.setWedding(idMale, idFemale);
    }

    public static Gender getGenderFromString(String input) {
        if (input == null) {
            return null;
        }

        try {
            return Gender.valueOf(input);
        } catch (IllegalArgumentException e) {
            // Если введенная строка не соответствует ни одной из констант
            return null;
        }
    }

}
