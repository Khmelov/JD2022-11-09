package by.it.han.jd02_01;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину

    int putToCart(Good good, int indexGood); //положил товар в корзину(возвращает число товаров)
}
