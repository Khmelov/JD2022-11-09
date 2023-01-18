package by.it.han.jd02_03.model;

import static by.it.han.jd02_03.util.StringsConstantUtils.CASHIER_NAME;

public class Cashier {
    private final String name;

    public Cashier(int number) {
        this.name = CASHIER_NAME.formatted(number);
    }

    @Override
    public String toString() {
        return name;
    }
}