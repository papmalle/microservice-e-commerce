package com.designpatternproxy;


import org.springframework.beans.factory.annotation.Autowired;

public class Client {

    @Autowired
    private IMetier iMetier;

    Client(){
        iMetier = new Proxy();
    }


}
