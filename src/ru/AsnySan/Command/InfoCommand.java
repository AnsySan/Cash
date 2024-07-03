package ru.AsnySan.Command;

import ru.AsnySan.Cash;
import ru.AsnySan.ConsoleHelper;
import ru.AsnySan.CurrencyManipulator;
import ru.AsnySan.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(Cash.RESOURCE_PATH + "info");

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean hasMoney = false;
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllManipulators()) {
            if (manipulator.hasMoney()) {
                hasMoney = true;
                ConsoleHelper.writeMessage("\t" + manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }

        if (!hasMoney) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
