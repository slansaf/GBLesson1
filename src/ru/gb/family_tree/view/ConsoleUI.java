package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI  implements View {
    private Scanner scanner;
    private Presenter  presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Создай свое семейное древо!");
        while (work) {
            System.out.println(mainMenu.menu());
            String choiceStr = scanner.nextLine();
            //метод проверки на валидность
            int choice = Integer.parseInt(choiceStr);
            mainMenu.execute(choice);
        }

    }

    public void setWedding(){
        System.out.println("Введите Id мужчины: ");
        String idMaleStr = scanner.nextLine();
        int  idMale = Integer.parseInt(idMaleStr);
        System.out.println("Введите Id женщины: ");
        String idFimaleStr = scanner.nextLine();
        int  idFimale = Integer.parseInt(idFimaleStr);
        presenter.setWedding(idMale, idFimale);
    }

    public void loadTree() {
        presenter.loadFemaleTree();
    }

    public void saveTree() {
        presenter.saveFemaleTree();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByBirthDate(){
        presenter.sortByBirthDate();
    }

    public void getHumanInfo() {
        presenter.getHumanInfo();
    }

    public void finish() {
        work = false;
    }


    public void addHuman(){

        System.out.println("Укажите имя");
        String name = scanner.nextLine();

        System.out.println("Укажите пол Male или Female:");
        String genderStr = scanner.nextLine();

        System.out.println("Укажите возраст:");
        System.out.println("Введите год рождения:");
        String yearStr = scanner.nextLine();
        int year = Integer.parseInt(yearStr);
        System.out.println("Введите месяц:");
        String monthStr = scanner.nextLine();
        int month = Integer.parseInt(monthStr);
        System.out.println("Введите день:");
        String dayStr = scanner.nextLine();
        int day = Integer.parseInt(dayStr);
        System.out.println("Укажите имя отца: ");
        String nameFather = scanner.nextLine();
        System.out.println("Укажите имя матери: ");
        String nameMather = scanner.nextLine();

        LocalDate date = LocalDate.of(year, month, day);
        presenter.addHuman(name, genderStr, date, nameFather, nameMather);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void addChildren() {
        System.out.println("Укажите имя родителя: ");
        String nameParent = scanner.nextLine();
        System.out.println("Укажите имя ребенка: ");
        String nameChild = scanner.nextLine();
        presenter.addChildren(nameParent, nameChild);
    }
}
