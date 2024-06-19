package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByBirthDate  extends Command{
    public SortByBirthDate(ConsoleUI consoleUI) {
        super("Отсортировать людей по дате рождения: ", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().sortByBirthDate();
    };

}