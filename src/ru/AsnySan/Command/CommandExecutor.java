package ru.AsnySan.Command;

import ru.AsnySan.Operation;
import ru.AsnySan.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> commands = new HashMap<>();

    static {
        commands.put(Operation.LOGIN, new LoginCommand());
        commands.put(Operation.DEPOSIT, new DepositCommand());
        commands.put(Operation.WITHDRAW, new WithdrawCommand());
        commands.put(Operation.INFO, new InfoCommand());
        commands.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor() {}

    public static final void execute(Operation op) throws InterruptOperationException {
        commands.get(op).execute();
    }
}
