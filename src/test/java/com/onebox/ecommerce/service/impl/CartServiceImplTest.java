package com.onebox.ecommerce.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.onebox.ecommerce.api.domain.Cart;
import com.onebox.ecommerce.api.domain.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {CartServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CartServiceImplTest {
    @Autowired
    private CartServiceImpl cartServiceImpl;

    /**
     * Method under test: {@link CartServiceImpl#getCarts()}
     */
    @Test
    void testGetCarts() {
        // Arrange, Act and Assert
        assertTrue(cartServiceImpl.getCarts().isEmpty());
    }

    /**
     * Method under test: {@link CartServiceImpl#createCart()}
     */
    @Test
    void testCreateCart() {
        // Arrange
        CartServiceImpl cartServiceImpl = new CartServiceImpl();

        // Act
        Cart actualCreateCartResult = cartServiceImpl.createCart();

        // Assert
        assertEquals(1, cartServiceImpl.getCarts().size());
        assertTrue(actualCreateCartResult.getProducts().isEmpty());
    }

    /**
     * Method under test: {@link CartServiceImpl#createCart()}
     */
    @Test
    void testCreateCart2() {
        // Arrange
        CartServiceImpl cartServiceImpl = new CartServiceImpl();
        cartServiceImpl.addProductToCart("42", mock(Product.class));

        // Act
        Cart actualCreateCartResult = cartServiceImpl.createCart();

        // Assert
        assertEquals(1, cartServiceImpl.getCarts().size());
        assertTrue(actualCreateCartResult.getProducts().isEmpty());
    }

    /**
     * Method under test: {@link CartServiceImpl#getCart(String)}
     */
    @Test
    void testGetCart() {
        // Arrange, Act and Assert
        assertNull(cartServiceImpl.getCart("42"));
    }

    /**
     * Method under test: {@link CartServiceImpl#addProductToCart(String, Product)}
     */
    @Test
    void testAddProductToCart() {
        // Arrange, Act and Assert
        assertNull(
                cartServiceImpl.addProductToCart("42", new Product(1, "Blue Jacket", 10)));
        assertNull(cartServiceImpl.addProductToCart("42", mock(Product.class)));
    }

    /**
     * Method under test: {@link CartServiceImpl#deleteCart(String)}
     */
    @Test
    void testDeleteCart() {
        // Arrange and Act
        cartServiceImpl.deleteCart("42");

        // Assert
        assertTrue(cartServiceImpl.getCarts().isEmpty());
    }
}
