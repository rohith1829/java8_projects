package ecommerce;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderService service = new OrderService();

    private final List<Order> orders = Arrays.asList(
            new Order(1, "Alice", 12000, "COMPLETED"),
            new Order(2, "Bob", 8000, "PENDING"),
            new Order(3, "Charlie", 15000, "CANCELLED"),
            new Order(4, "David", 5000, "COMPLETED")
    );

    @Test
    void testHighValueCustomers() {
        List<String> result = service.getHighValueCustomers(orders);
        assertEquals(Arrays.asList("Alice", "Charlie"), result);
    }

    @Test
    void testHasCancelledOrders() {
        assertTrue(service.hasCancelledOrders(orders));
    }

    @Test
    void testGetMinimumOrderAmount() {
        Optional<Double> min = service.getMinimumOrderAmount(orders);
        assertTrue(min.isPresent());
        assertEquals(5000, min.get());
    }

    @Test
    void testGetUniqueStatuses() {
        Set<String> statuses = service.getUniqueStatuses(orders);
        assertEquals(Set.of("COMPLETED", "PENDING", "CANCELLED"), statuses);
    }

    @Test
    void testEmptyOrders() {
        List<Order> emptyList = Collections.emptyList();

        assertTrue(service.getHighValueCustomers(emptyList).isEmpty());
        assertFalse(service.hasCancelledOrders(emptyList));
        assertTrue(service.getMinimumOrderAmount(emptyList).isEmpty());
        assertTrue(service.getUniqueStatuses(emptyList).isEmpty());
    }
}
