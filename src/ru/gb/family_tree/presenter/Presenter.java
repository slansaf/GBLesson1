package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.save.FileHandler;
import ru.gb.family_tree.model.save.Writable;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Human human;
    private FamilyTree familyTree;
    String filePath = "src/ru/gb/family_tree/model/save/tree.txt";

    public Presenter(View view) {
        this.view = view;
        familyTree  = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate date) {
        familyTree.addHuman(new Human(name, gender,  date));
        getHumanInfo();
    }

    public void getHumanInfo(){
        String answar = familyTree.getInfo();
        view.printAnswer(answar);
    }

    public void sotrByName() {
        familyTree.sotrByName();
        getHumanInfo();
    }

    public void saveFamaleTree() {
        save(familyTree, filePath);
    }

    public void loadFamaleTree() {
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


}
