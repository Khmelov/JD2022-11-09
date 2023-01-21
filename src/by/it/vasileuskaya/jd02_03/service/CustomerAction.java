package by.it.vasileuskaya.jd02_03.service;

import by.it.vasileuskaya.jd02_03.model.Good;

public interface CustomerAction {
    void enteredStore();

    Good chooseGood();

    void goToQueue();

    void goOut();
}
