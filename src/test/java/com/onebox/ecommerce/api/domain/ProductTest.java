package com.onebox.ecommerce.api.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProductTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Product#Product()}
     *   <li>{@link Product#setAmount(int)}
     *   <li>{@link Product#setDescription(String)}
     *   <li>{@link Product#setId(int)}
     *   <li>{@link Product#toString()}
     *   <li>{@link Product#getAmount()}
     *   <li>{@link Product#getDescription()}
     *   <li>{@link Product#getId()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Product actualProduct = new Product();
        actualProduct.setAmount(10);
        actualProduct.setDescription("The characteristics of someone or something");
        actualProduct.setId(1);
        String actualToStringResult = actualProduct.toString();
        int actualAmount = actualProduct.getAmount();
        String actualDescription = actualProduct.getDescription();

        // Assert that nothing has changed
        assertEquals("Product(id=1, description=The characteristics of someone or something, amount=10)",
                actualToStringResult);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(1, actualProduct.getId());
        assertEquals(10, actualAmount);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Product#Product(int, String, int)}
     *   <li>{@link Product#setAmount(int)}
     *   <li>{@link Product#setDescription(String)}
     *   <li>{@link Product#setId(int)}
     *   <li>{@link Product#toString()}
     *   <li>{@link Product#getAmount()}
     *   <li>{@link Product#getDescription()}
     *   <li>{@link Product#getId()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        Product actualProduct = new Product(1, "The characteristics of someone or something", 10);
        actualProduct.setAmount(10);
        actualProduct.setDescription("The characteristics of someone or something");
        actualProduct.setId(1);
        String actualToStringResult = actualProduct.toString();
        int actualAmount = actualProduct.getAmount();
        String actualDescription = actualProduct.getDescription();

        // Assert that nothing has changed
        assertEquals("Product(id=1, description=The characteristics of someone or something, amount=10)",
                actualToStringResult);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(1, actualProduct.getId());
        assertEquals(10, actualAmount);
    }
}
