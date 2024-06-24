package com.onebox.ecommerce.web;

import com.onebox.ecommerce.api.CartApi;
import com.onebox.ecommerce.api.domain.Cart;
import com.onebox.ecommerce.api.domain.Product;
import com.onebox.ecommerce.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController implements CartApi {

    private static final Logger log = LoggerFactory.getLogger(CartController.class);
    @Autowired
    private CartService cartService;

    @Override
    public ResponseEntity<Cart> createCart() {

        Cart cart = cartService.createCart();
        log.debug("Controller - createCart() - Cart: {}", cart);

        return ResponseEntity.ok(cart);
    }

    @Override
    public ResponseEntity<Cart> getCart(String cartId) {

        Cart cart = cartService.getCart(cartId);
        log.debug("Controller - getCart() - Cart: {}", cart);

        return cart != null ? ResponseEntity.ok(cart) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> addProductToCart(String cartId, Product product) {

        Product productAdded = cartService.addProductToCart(cartId, product);
        log.debug("Controller - addProductToCart() - Cart: {}", cartService.getCart(cartId));

        return productAdded != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteCart(String cartId) {

        cartService.deleteCart(cartId);
        log.debug("Controller - deleteCart() - Carts: {}", cartService.getCarts());

        return ResponseEntity.ok().build();
    }
}
