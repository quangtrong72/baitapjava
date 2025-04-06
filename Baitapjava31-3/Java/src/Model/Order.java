package Model;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private int customerId;
    private Date date;
    private List<OrderItem> items;

    public Order(int id, int customerId, Date date, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

   
    
}