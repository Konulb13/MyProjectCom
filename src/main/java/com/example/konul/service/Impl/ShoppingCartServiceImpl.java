package com.example.konul.service.Impl;

import com.example.konul.entity.CartItem;
import com.example.konul.entity.Product;
import com.example.konul.entity.ShoppingCart;
import com.example.konul.entity.User;
import com.example.konul.repository.CartItemRepository;
import com.example.konul.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public ShoppingCart getShoppingCart(User user) {
        return new ShoppingCart(cartItemRepository.findAllByUserAndOrderIsNull(user));
    }

    @Override
    @Cacheable("item_count")
    public int getItemsNumber(User user) {
        return cartItemRepository.countDistinctByUserAndOrderIsNull(user);
    }

    @Override
    public CartItem findCartItemById(Long cartItemId) {
        Optional<CartItem> opt = cartItemRepository.findById(cartItemId);
        return opt.get();
    }

    @Override
    @CacheEvict(value = "item_count", allEntries = true)
    public CartItem addArticleToShoppingCart(Product product, User user, int qty, String size) {
        ShoppingCart shoppingCart = this.getShoppingCart(user);
        CartItem cartItem = shoppingCart.findCartItemByProductAndSize(product.getId(), size);
        if (cartItem != null && cartItem.hasSameSizeThan(size)) {
            cartItem.addQuantity(qty);
            cartItem.setSize(size);
            cartItem = cartItemRepository.save(cartItem);
        } else {
            cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(qty);
            cartItem.setSize(size);
            cartItem = cartItemRepository.save(cartItem);
        }
        return cartItem;
    }
    @Override
    @CacheEvict(value = "item_count", allEntries = true)
    public void removeCartItem(CartItem cartItem) {
        cartItemRepository.deleteById(cartItem.getId());
    }

    @Override
    @CacheEvict(value = "item_count", allEntries = true)
    public void updateCartItem(CartItem cartItem, Integer qty) {
        if (qty == null || qty <= 0) {
            this.removeCartItem(cartItem);
        } else if (cartItem.getProduct().hasStock(qty)) {
            cartItem.setQuantity(qty);
            cartItemRepository.save(cartItem);
        }
    }
    @Override
    @CacheEvict(value = "item_count", allEntries = true)
    public void clearShoppingCart(User user) {
        cartItemRepository.deleteAllByUserAndOrderIsNull(user);
    }
}
