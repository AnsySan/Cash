package ru.AsnySan.Command;


import ru.AsnySan.Cash;
import ru.AsnySan.ConsoleHelper;
import ru.AsnySan.exception.InterruptOperationException;

import java.util.ResourceBundle;

 class ExitCommand implements Command{
     private ResourceBundle resourceBundle = ResourceBundle.getBundle(Cash.RESOURCE_PATH + "exit");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(resourceBundle.getString("exit.question.y.n"));
        String result = ConsoleHelper.readString();
        if(result != null && "y".equals(result.toLowerCase())){
            ConsoleHelper.writeMessage(resourceBundle.getString("thank.message"));
        }else {

        }
    }
}
