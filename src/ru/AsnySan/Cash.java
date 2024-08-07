package ru.AsnySan;

import ru.AsnySan.Command.CommandExecutor;
import ru.AsnySan.exception.InterruptOperationException;

import java.util.Locale;

 public class Cash {
    public static final String RESOURCE_PATH = Cash.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try{
            Operation operation = Operation.LOGIN;
            CommandExecutor.execute(operation);
            do{
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        }catch (InterruptOperationException ignored){
            ConsoleHelper.printExitMessage();
        }
    }

}
