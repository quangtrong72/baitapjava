package Dao;
import java.util.*;
import Model.Product;
public class ProductDAO {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Laptop", 1200.0));
        products.add(new Product(2, "Mouse", 25.0));
        products.add(new Product(3, "Keyboard", 45.0));
    }

    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public List<Product> findAll() {
        return products;
    }
}