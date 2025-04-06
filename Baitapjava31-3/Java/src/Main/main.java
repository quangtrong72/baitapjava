package Main;
import java.util.*;
import Model.Order;
import Service.OrderService;
public class main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        // Thêm đơn hàng mới
        Map<Integer, Integer> products = new HashMap<>();
        products.put(1, 1); // 1 laptop
        products.put(2, 2); // 2 mouse
        Order order = orderService.addOrder(101, products);

        // Truy xuất đơn hàng của khách hàng
        List<Order> orders = orderService.getOrdersByCustomer(101);
        for (Order o : orders) {
            System.out.println("don hang ID: " + o.getId());
        }

        // Tính tổng tiền
        double total = orderService.calculateTotal(order);
        System.out.println("tong tien don hang: " + total);
    }
}