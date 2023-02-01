package by.it.bolshakov.jd02_02;

public interface ShoppingCartAction {
    void takeCart(); //взял корзину
    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}