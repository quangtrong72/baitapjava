package Dao;
import Model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static final List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(101, "Nguyễn Văn A", "a@gmail.com"));
        customers.add(new Customer(102, "Trần Thị B", "b@gmail.com"));
    }

    public Customer findById(int id) {
        for (Customer c : customers) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public List<Customer> findAll() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}