package com.onebox.ecommerce.api;

import com.onebox.ecommerce.api.domain.Cart;
import com.onebox.ecommerce.api.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/carts")
public interface CartApi {

    @PostMapping
    ResponseEntity<Cart> createCart();

    @GetMapping("/{cartId}")
    ResponseEntity<Cart> getCart(@PathVariable String cartId);

    @PostMapping("/{cartId}/products")
    ResponseEntity<Void> addProductToCart(@PathVariable String cartId, @RequestBody Product product);

    @PostMapping("/{cartId}")
    ResponseEntity<Void> deleteCart(@PathVariable String cartId);
}
