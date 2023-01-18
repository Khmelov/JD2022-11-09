package by.it.han.jd02_02;

public interface CustomerAction {
    void enteredStore(); //вошел в магазин (мгновенно)
    void chooseGood(); //выбрал товар (от 0,5 до 2 секунд)
    void goOut(); //отправился на выход(мгновенно)
    void goToQueue(); //отправился на выход(мгновенно)
}
