package com.onebox.ecommerce.web;

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
public class CartController {

    private static final Logger log = LoggerFactory.getLogger(CartController.class);
    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> createCart() {

        Cart cart = cartService.createCart();
        log.debug("Controller - createCart() - Cart: {}", cart);

        return ResponseEntity.ok(cart);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable String cartId) {

        Cart cart = cartService.getCart(cartId);
        log.debug("Controller - getCart() - Cart: {}", cart);

        return cart != null ? ResponseEntity.ok(cart) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{cartId}/products")
    public ResponseEntity<Void> addProductToCart(@PathVariable String cartId, @RequestBody Product product) {

        cartService.addProductToCart(cartId, product);
        log.debug("Controller - addProductToCart() - Cart: {}", cartService.getCart(cartId));

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable String cartId) {

        cartService.deleteCart(cartId);
        log.debug("Controller - deleteCart() - Carts: {}", cartService.getCarts());

        return ResponseEntity.ok().build();
    }
}
