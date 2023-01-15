package by.it.yaroshevich.jd02_02;

public interface CustomerAction {
    void enteredStore(); //вошел в магазин
    Good chooseGood(); // выбрал товар

    void goToQueue();
    void goOut(); //отправился на выход

}
