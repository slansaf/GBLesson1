package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Human human;
    private FamilyTree familyTree;

    public Presenter(View view) {
        this.view = view;
        familyTree  = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate date) {
        Human human = new Human(name, gender, date);
        familyTree.addHuman(human);
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
}
