package by.it.bolshakov.jd02_01;

public interface ShoppingCartAction {
    void takeCart(); //взял корзину
    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}