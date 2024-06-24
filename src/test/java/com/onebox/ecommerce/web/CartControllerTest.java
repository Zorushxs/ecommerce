package com.onebox.ecommerce.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.onebox.ecommerce.api.domain.Cart;
import com.onebox.ecommerce.api.domain.Product;
import com.onebox.ecommerce.service.CartService;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CartController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class CartControllerTest {
    @Autowired
    private CartController cartController;

    @MockBean
    private CartService cartService;

    /**
     * Method under test: {@link CartController#createCart()}
     */
    @Test
    void testCreateCart() {
        // Arrange
        when(cartService.createCart()).thenReturn(new Cart());

        // Act
        ResponseEntity<Cart> actualCreateCartResult = cartController.createCart();

        // Assert
        verify(cartService).createCart();
        assertEquals(200, actualCreateCartResult.getStatusCodeValue());
        assertTrue(actualCreateCartResult.hasBody());
        assertTrue(actualCreateCartResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link CartController#getCart(String)}
     */
    @Test
    void testGetCart() {
        // Arrange
        when(cartService.getCart(Mockito.<String>any())).thenReturn(new Cart());

        // Act
        ResponseEntity<Cart> actualCart = cartController.getCart("42");

        // Assert
        verify(cartService).getCart(eq("42"));
        assertEquals(200, actualCart.getStatusCodeValue());
        assertTrue(actualCart.hasBody());
        assertTrue(actualCart.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link CartController#getCart(String)}
     */
    @Test
    void testGetCart2() {
        // Arrange
        when(cartService.getCart(Mockito.<String>any())).thenReturn(null);

        // Act
        ResponseEntity<Cart> actualCart = cartController.getCart("42");

        // Assert
        verify(cartService).getCart(eq("42"));
        assertNull(actualCart.getBody());
        assertEquals(404, actualCart.getStatusCodeValue());
        assertTrue(actualCart.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link CartController#addProductToCart(String, Product)}
     */
    @Test
    void testAddProductToCart() {
        // Arrange
        when(cartService.getCart(Mockito.<String>any())).thenReturn(new Cart());
        when(cartService.addProductToCart(Mockito.<String>any(), Mockito.<Product>any()))
                .thenReturn(new Product(1, "The characteristics of someone or something", 10));

        // Act
        ResponseEntity<Void> actualAddProductToCartResult = cartController.addProductToCart("42",
                new Product(1, "The characteristics of someone or something", 10));

        // Assert
        verify(cartService).addProductToCart(eq("42"), isA(Product.class));
        verify(cartService).getCart(eq("42"));
        assertNull(actualAddProductToCartResult.getBody());
        assertEquals(200, actualAddProductToCartResult.getStatusCodeValue());
        assertTrue(actualAddProductToCartResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link CartController#addProductToCart(String, Product)}
     */
    @Test
    void testAddProductToCart2() {
        // Arrange
        when(cartService.getCart(Mockito.<String>any())).thenReturn(new Cart());
        when(cartService.addProductToCart(Mockito.<String>any(), Mockito.<Product>any())).thenReturn(null);

        // Act
        ResponseEntity<Void> actualAddProductToCartResult = cartController.addProductToCart("42",
                new Product(1, "The characteristics of someone or something", 10));

        // Assert
        verify(cartService).addProductToCart(eq("42"), isA(Product.class));
        verify(cartService).getCart(eq("42"));
        assertNull(actualAddProductToCartResult.getBody());
        assertEquals(404, actualAddProductToCartResult.getStatusCodeValue());
        assertTrue(actualAddProductToCartResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link CartController#deleteCart(String)}
     */
    @Test
    void testDeleteCart() {
        // Arrange
        when(cartService.getCarts()).thenReturn(new HashMap<>());
        doNothing().when(cartService).deleteCart(Mockito.<String>any());

        // Act
        ResponseEntity<Void> actualDeleteCartResult = cartController.deleteCart("42");

        // Assert
        verify(cartService).deleteCart(eq("42"));
        verify(cartService).getCarts();
        assertNull(actualDeleteCartResult.getBody());
        assertEquals(200, actualDeleteCartResult.getStatusCodeValue());
        assertTrue(actualDeleteCartResult.getHeaders().isEmpty());
    }
}
