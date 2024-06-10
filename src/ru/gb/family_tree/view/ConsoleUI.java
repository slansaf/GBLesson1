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

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void start() {
        while (work) {
            System.out.println("Создай свое семейное древо!");
            System.out.println("1. Добавить человека");
            System.out.println("2. Получить список  людей");
            System.out.println("3. Отсортировать по имени");
            System.out.println("4. Закончить работу");

            String choise = scanner.nextLine();

            switch (choise) {
                case "1":
                    addHuman();
                    break;
                case "2":
                    getHumanInfo();
                    break;
                case "3":
                    sotrByName();
                    break;
                case "4":
                    finish();
                    break;
                default:
                    System.out.println("Вы ввели некоректные данные.");
            }
        }

    }

    private void sotrByName() {
        presenter.sotrByName();
    }

    private void getHumanInfo() {
        presenter.getHumanInfo();
    }

    private void finish() {
        work = false;
    }


    private void addHuman(){
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
