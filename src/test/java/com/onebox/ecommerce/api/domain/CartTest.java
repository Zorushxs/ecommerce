package com.onebox.ecommerce.api.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CartTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Cart#Cart()}
     *   <li>{@link Cart#setId(String)}
     *   <li>{@link Cart#setLastActivityTime(long)}
     *   <li>{@link Cart#setProducts(List)}
     *   <li>{@link Cart#toString()}
     *   <li>{@link Cart#getId()}
     *   <li>{@link Cart#getLastActivityTime()}
     *   <li>{@link Cart#getProducts()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Cart actualCart = new Cart();
        actualCart.setId("42");
        actualCart.setLastActivityTime(1L);
        ArrayList<Product> products = new ArrayList<>();
        actualCart.setProducts(products);
        String actualToStringResult = actualCart.toString();
        String actualId = actualCart.getId();
        long actualLastActivityTime = actualCart.getLastActivityTime();

        // Assert that nothing has changed
        assertEquals("42", actualId);
        assertEquals("Cart(id=42, products=[], lastActivityTime=1)", actualToStringResult);
        assertEquals(1L, actualLastActivityTime);
        assertSame(products, actualCart.getProducts());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Cart#Cart(String, List, long)}
     *   <li>{@link Cart#setId(String)}
     *   <li>{@link Cart#setLastActivityTime(long)}
     *   <li>{@link Cart#setProducts(List)}
     *   <li>{@link Cart#toString()}
     *   <li>{@link Cart#getId()}
     *   <li>{@link Cart#getLastActivityTime()}
     *   <li>{@link Cart#getProducts()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange
        ArrayList<Product> products = new ArrayList<>();

        // Act
        Cart actualCart = new Cart("42", products, 1L);
        actualCart.setId("42");
        actualCart.setLastActivityTime(1L);
        ArrayList<Product> products2 = new ArrayList<>();
        actualCart.setProducts(products2);
        String actualToStringResult = actualCart.toString();
        String actualId = actualCart.getId();
        long actualLastActivityTime = actualCart.getLastActivityTime();
        List<Product> actualProducts = actualCart.getProducts();

        // Assert that nothing has changed
        assertEquals("42", actualId);
        assertEquals("Cart(id=42, products=[], lastActivityTime=1)", actualToStringResult);
        assertEquals(1L, actualLastActivityTime);
        assertEquals(products, actualProducts);
        assertSame(products2, actualProducts);
    }
}
