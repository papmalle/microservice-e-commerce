package com.designpatternproxy;

public class DesignPatternProxyApplication {
    private static IMetier iMetier;

    public static void main(String[] args) {

        iMetier = new Proxy();
        iMetier.calculeValue();
    }
}

