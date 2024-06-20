package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.Service;
import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.save.FileHandler;
import ru.gb.family_tree.model.save.Writable;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }


    public void addHuman(String name, String gender, LocalDate date, int nameFather, int nameMather){
        service.addHuman(name, gender, date, nameFather, nameMather);
        getHumanInfo();
    }
    public void getHumanInfo(){
        view.printAnswer(service.getHumanInfo());
    }

    public void sortByName() {
        service.sotrByName();
        getHumanInfo();
    }

    public void saveFemaleTree() {
        service.saveFemaleTree();
    }

    public void loadFemaleTree() {
        service.loadFemaleTree();
    }

    public void setWedding(int idMale, int idFemale) {
        service.setWedding(idMale, idFemale);
        getHumanInfo();
    }

    public void addChildren(int nameParent, int nameChild) {
        service.addChildren(nameParent, nameChild);
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getHumanInfo();
    }
}
