package Dao;

import Model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> findAll() {
        return orders;
    }

    public List<Order> findByCustomerId(int customerId) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerId() == customerId) {
                result.add(order);
            }
        }
        return result;
    }
}