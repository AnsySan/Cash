package ru.AsnySan.Command;

import ru.AsnySan.Cash;
import ru.AsnySan.Command.Command;
import ru.AsnySan.ConsoleHelper;
import ru.AsnySan.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(Cash.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(Cash.RESOURCE_PATH + "login");


    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String creditCardNumber = ConsoleHelper.readString();
            String pinStr = ConsoleHelper.readString();
            if (creditCardNumber == null ||  (creditCardNumber = creditCardNumber.trim()).length() != 12 ||
            pinStr == null || (pinStr = pinStr.trim()).length() != 4) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            } else {
                try {
                    if (validCreditCards.containsKey(creditCardNumber) && pinStr.equals(validCreditCards.getString(creditCardNumber))) {
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), creditCardNumber));
                        break;
                    } else {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), creditCardNumber));
                        ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    }
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                }
            }
        }

    }
}
