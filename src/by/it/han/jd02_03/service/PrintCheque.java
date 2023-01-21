package by.it.han.jd02_03.service;

import by.it.han.jd02_03.model.Customer;

import java.util.Map;

import static by.it.han.jd02_03.util.StringsConstantUtils.NAME_AND_PRICE_OF_GOOD;

public class PrintCheque implements Runnable {
    private final Map<String, Integer> customerGoods;
    private final Customer customer;

    public PrintCheque(Map<String, Integer> customerGoods, Customer customer) {
        this.customerGoods = customerGoods;
        this.customer = customer;
    }


    @Override
    public void run() {
        printCheque();
    }

    public void printCheque() {
        System.out.println(customer + ":");
        for (Map.Entry<String, Integer> good : customerGoods.entrySet()) {
            System.out.printf(NAME_AND_PRICE_OF_GOOD, good.getKey(), good.getValue());
        }
    }
}
