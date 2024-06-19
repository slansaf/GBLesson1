package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SetWedding  extends Command {
    public SetWedding(ConsoleUI consoleUI) {
        super("Сыграть свадьбу: ", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().setWedding();
    };

}
