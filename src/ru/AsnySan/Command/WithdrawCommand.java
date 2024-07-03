package ru.AsnySan.Command;


import ru.AsnySan.Cash;
import ru.AsnySan.ConsoleHelper;
import ru.AsnySan.CurrencyManipulator;
import ru.AsnySan.CurrencyManipulatorFactory;
import ru.AsnySan.exception.InterruptOperationException;
import ru.AsnySan.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

public class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(Cash.RESOURCE_PATH + "withdraw");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCOde(currencyCode);

        while (true) {
            try {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                String s = ConsoleHelper.readString();
                if (s == null) {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                } else {
                    try {
                        int amount = Integer.parseInt(s);
                        boolean isAmountAvailable = manipulator.isAmountAvailable(amount);
                        if (isAmountAvailable) {
                            Map<Integer, Integer> denominations = manipulator.withdrawAmount(amount);
                            for (Integer item : denominations.keySet()) {
                                ConsoleHelper.writeMessage("\t" + item + " - " + denominations.get(item));
                            }

                            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
                            break;
                        } else {
                            ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                        }
                    } catch (NumberFormatException e) {
                        ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                    }
                }
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }
    }
}

