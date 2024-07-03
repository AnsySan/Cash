package ru.AsnySan;

public enum Operation {
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i ){
        if(i == LOGIN.ordinal()){
            throw new IllegalArgumentException();
        }
        for(Operation op : values()){
            if(op.ordinal() == i){
                return op;
            }
        }
        throw new IllegalArgumentException();
    }
}
