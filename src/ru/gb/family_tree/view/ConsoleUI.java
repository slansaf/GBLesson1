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

    public void loadTree() {
        presenter.loadFamaleTree();
    }

    public void saveTree() {
        presenter.saveFamaleTree();
    }

    public void sotrByName() {
        presenter.sotrByName();
    }

    public void getHumanInfo() {
        presenter.getHumanInfo();
    }

    public void finish() {
        work = false;
    }


    public void addHuman(){
        Gender gender;
        System.out.println("Укажите имя");
        String name = scanner.nextLine();

        System.out.println("Укажите пол Male или Female:");
        String genderStr = scanner.nextLine();
        gender = getGenderFromString(genderStr);

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

        LocalDate date = LocalDate.of(year, month, day);
        presenter.addHuman(name, gender, date);
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

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
