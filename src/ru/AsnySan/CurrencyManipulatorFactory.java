package ru.AsnySan;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<String, CurrencyManipulator>();

    private CurrencyManipulatorFactory() {}

    public static CurrencyManipulator getManipulatorByCurrencyCOde(String currency) {
        currency = currency.toUpperCase();
        if(!map.containsKey(currency)) {
            CurrencyManipulator cm = new CurrencyManipulator(currency);
            map.put(cm.getCurrencyCode(), cm);
        }
        return map.get(currency);
    }

    public static Collection<CurrencyManipulator> getAllManipulators() {
        return map.values();
    }
}
