package com.onebox.ecommerce.service.impl;

import com.onebox.ecommerce.api.domain.Cart;
import com.onebox.ecommerce.api.domain.Product;
import com.onebox.ecommerce.service.CartService;
import com.onebox.ecommerce.web.CartController;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

@Service
public class CartServiceImpl implements CartService {

    private static final Logger log = LoggerFactory.getLogger(CartController.class);

    private Map<String, Cart> carts = new ConcurrentHashMap<>();
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private Map<String, ScheduledFuture<?>> cleanupTask = new ConcurrentHashMap<>();

    @Override
    public Map<String, Cart> getCarts() {

        log.debug("Service - getCarts() - Carts: {}", carts);

        return carts;
    }

    @Override
    public Cart createCart() {

        String cartId = UUID.randomUUID().toString();
        Cart cart = new Cart(cartId, new ArrayList<>(), System.currentTimeMillis());
        carts.put(cartId, cart);
        log.debug("Service - createCart() - Carts: {}", carts);
        startCleanupTask(cartId);
        log.debug("Service - createCart() - cleanupTask: {}", cleanupTask);

        return cart;
    }

    @Override
    public Cart getCart(String cartId) {

        Cart cart = carts.get(cartId);
        if (cart != null) {
            cart.setLastActivityTime(System.currentTimeMillis());
            log.debug("Service - getCart() - Carts: {}", carts);
            startCleanupTask(cartId);
            log.debug("Service - getCart() - cleanupTask: {}", cleanupTask);
        }

        return cart;
    }

    @Override
    public void addProductToCart(String cartId, Product product) {

        Cart cart = getCart(cartId);

        if (cart != null) {
            cart.getProducts().add(product);
            cart.setLastActivityTime(System.currentTimeMillis());
            log.debug("Service - addProductToCart() - Carts: {}", carts);
            startCleanupTask(cartId);
            log.debug("Service - addProductToCart() - cleanupTask: {}", cleanupTask);
        }

    }

    @Override
    public void deleteCart(String cartId) {
        carts.remove(cartId);
        cancelCleanupTask(cartId);
        log.debug("Service - deleteCart() - cleanupTask: {}", cleanupTask);
    }

    private void startCleanupTask(String cartId) {
        ScheduledFuture<?> existingTask = cleanupTask.get(cartId);
        if (existingTask != null && !existingTask.isDone()) {
            existingTask.cancel(false); // Cancel the existing task if it's still active, to avoid that executes
        }
        ScheduledFuture<?> newTask = executor.schedule(() -> cleanUp(cartId), 90, TimeUnit.SECONDS);
        cleanupTask.put(cartId, newTask);
    }

    private void cleanUp(String cartId) {
        long now = System.currentTimeMillis();
        log.debug("Service - cleanUp() - now: {}", now);
        Cart cart = carts.get(cartId);
        if (cart != null && now - cart.getLastActivityTime() > 90000) {
            carts.remove(cartId);
            log.debug("Service - cleanUp() - Cart {} removed due to inactivity. - Carts: {}", cartId, carts);
        } else {
            log.debug("Service - cleanUp() - Cart {} still active, not removed. - Carts: {}", cartId, carts);
        }
        cleanupTask.remove(cartId);
    }

    private void cancelCleanupTask(String cartId) {
        ScheduledFuture<?> existingTask = cleanupTask.get(cartId);
        if (existingTask != null) {
            existingTask.cancel(false);
            cleanupTask.remove(cartId);
            log.debug("Service - cancelCleanupTask() - Cleanup task canceled for cartId: {} - cleanupTask: {}", cartId, cleanupTask);
        }
    }

}
