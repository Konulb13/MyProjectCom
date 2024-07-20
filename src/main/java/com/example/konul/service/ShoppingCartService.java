package com.example.konul.service;
import com.example.konul.entity.CartItem;
import com.example.konul.entity.Product;
import com.example.konul.entity.ShoppingCart;
import com.example.konul.entity.User;

public interface ShoppingCartService {
    ShoppingCart getShoppingCart(User user);

    int getItemsNumber(User user);

    CartItem findCartItemById(Long cartItemId);

    CartItem addProductToShoppingCart(Product product, User user, int qty, String size);

    void clearShoppingCart(User user);

    void updateCartItem(CartItem cartItem, Integer qty);

    void removeCartItem(CartItem cartItem);
}
