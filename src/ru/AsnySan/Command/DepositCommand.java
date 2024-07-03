package ru.AsnySan.Command;


import ru.AsnySan.Cash;
import ru.AsnySan.ConsoleHelper;
import ru.AsnySan.CurrencyManipulator;
import ru.AsnySan.CurrencyManipulatorFactory;
import ru.AsnySan.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(Cash.RESOURCE_PATH + "deposit");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCOde(currencyCode);

        while (true) {
            String[] split = ConsoleHelper.getValidTwoDigits(currencyCode);
            try {
                int denomination = Integer.parseInt(split[0]);
                int count = Integer.parseInt(split[1]);
                manipulator.addAmount(denomination, count);
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), (denomination * count), currencyCode));
                break;
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }
}