package by.it.han.jd02_03.service;

import by.it.han.jd02_03.model.Good;

public interface CustomerAction {
    void enteredStore();
    Good chooseGood();
    void goOut();
    void goToQueue();
}
