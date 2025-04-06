package Service;
import java.util.*;

import Dao.ProductDAO;
import Model.Order;
import Model.Product;
import Model.OrderItem;

public class OrderService {
    private ProductDAO productDAO = new ProductDAO();
    private List<Order> orders = new ArrayList<>();
    private int nextOrderId = 1;

    public Order addOrder(int customerId, Map<Integer, Integer> productQuantities) {
        List<OrderItem> items = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : productQuantities.entrySet()) {
            items.add(new OrderItem(0, nextOrderId, entry.getKey(), entry.getValue()));
        }
        Order order = new Order(nextOrderId++, customerId, new Date(), items);
        orders.add(order);
        return order;
    }

    public List<Order> getOrdersByCustomer(int customerId) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerId() == customerId) {
                result.add(order);
            }
        }
        return result;
    }

    public double calculateTotal(Order order) {
        double total = 0.0;
        for (OrderItem item : order.getItems()) {
            Product product = productDAO.findById(item.getProductId());
            if (product != null) {
                total += product.getPrice() * item.getQuantity();
            }
        }
        return total;
    }
}