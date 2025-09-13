package ecommerce;

import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

    public List<String> getHighValueCustomers(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getTotalAmount() > 10000)
                .map(Order::getCustomerName)
                .toList();
    }

    public boolean hasCancelledOrders(List<Order> orders) {
        return orders.stream()
                .anyMatch(o -> "CANCELLED".equalsIgnoreCase(o.getStatus()));
    }

    public Optional<Double> getMinimumOrderAmount(List<Order> orders) {
        return orders.stream()
                .map(Order::getTotalAmount)
                .min(Double::compare);
    }

    public Set<String> getUniqueStatuses(List<Order> orders) {
        return orders.stream()
                .map(Order::getStatus)
                .collect(Collectors.toSet());
    }
}
