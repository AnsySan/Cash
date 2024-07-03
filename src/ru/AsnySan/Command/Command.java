package ru.AsnySan.Command;


import ru.AsnySan.exception.InterruptOperationException;

interface Command {
     void execute() throws InterruptOperationException;
}
