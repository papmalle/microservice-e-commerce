package com.designpatternproxy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proxy implements IMetier {
    private MetierImpl metierImpl = new MetierImpl();

    @Override
    public int calculeValue() {
        return metierImpl.calculeValue();
    }
}
