package com.designpatternproxy;

public class MetierImpl implements IMetier {
    private int metierImplValueTest = 5;

    @Override
    public int calculeValue() {
        final int value = 22;
        System.out.println("value = :" + value);²
        return value;
    }
}
