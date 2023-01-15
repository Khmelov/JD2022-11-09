package by.it.samatokhin.jd02_03.service;

import by.it.samatokhin.jd02_03.entity.Good;

public interface CustomerAction {
    void enteredStore();

    Good chooseGood();

    void goToQueue();

    void goOut();
}