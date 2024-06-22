package com.onebox.ecommerce.service;

import com.onebox.ecommerce.api.domain.Cart;
import com.onebox.ecommerce.api.domain.Product;

import java.util.Map;

public interface CartService {

    public Cart createCart();

    public Map<String, Cart> getCarts();

    public Cart getCart(String cartId);

    public void addProductToCart(String cartId, Product product);

    public void deleteCart(String cartId);

}
