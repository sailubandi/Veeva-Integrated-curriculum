package assignment3.v3;

import java.util.*;
import java.time.*;

class Item {
    String name;
    double price;
    int quantity;
    int reorderLevel;

    Item(String name, double price, int quantity, int reorderLevel) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }
}

class Customer {
    String name, address, phone, email;

    Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}

class Order {
    int id;
    Customer customer;
    Map<Item, Integer> items;
    LocalDate date;
    double total;

    Order(int id, Customer customer, Map<Item, Integer> items) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.date = LocalDate.now();
        this.total = calculate();
    }

    double calculate() {
        double sum = 0;
        for (Map.Entry<Item, Integer> e : items.entrySet()) {
            sum += e.getKey().price * e.getValue();
        }
        return sum;
    }
}

class OrderSystem {
    List<Item> items = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    List<Order> orders = new ArrayList<>();
    int counter = 1;

    void addItem(Item i) {
        items.add(i);
    }

    void addCustomer(Customer c) {
        customers.add(c);
    }

    void placeOrder(Customer c, Map<Item, Integer> map) {
        for (Map.Entry<Item, Integer> e : map.entrySet()) {
            Item i = e.getKey();
            int q = e.getValue();
            if (i.quantity <= i.reorderLevel || i.quantity < q) {
                System.out.println("Order rejected for " + i.name);
                return;
            }
        }

        for (Map.Entry<Item, Integer> e : map.entrySet()) {
            e.getKey().quantity -= e.getValue();
        }

        Order o = new Order(counter++, c, map);
        orders.add(o);
        System.out.println("Order ID: " + o.id + " Total: " + o.total);
    }

    void findItem(String name) {
        for (Item i : items) {
            if (i.name.equalsIgnoreCase(name)) {
                System.out.println(i.name + " " + i.price + " " + i.quantity);
            }
        }
    }

    void findByPrice(double price) {
        for (Item i : items) {
            if (i.price == price) {
                System.out.println(i.name);
            }
        }
    }

    void findOrder(int id) {
        for (Order o : orders) {
            if (o.id == id) {
                System.out.println(o.id + " " + o.total);
            }
        }
    }

    void ordersByCustomer(String name) {
        for (Order o : orders) {
            if (o.customer.name.equalsIgnoreCase(name)) {
                System.out.println(o.id + " " + o.total);
            }
        }
    }

    void extremeOrders() {
        if (orders.isEmpty()) return;
        Order max = Collections.max(orders, Comparator.comparingDouble(o -> o.total));
        Order min = Collections.min(orders, Comparator.comparingDouble(o -> o.total));
        System.out.println("Max: " + max.id + " " + max.total);
        System.out.println("Min: " + min.id + " " + min.total);
    }

    void lastWeek() {
        LocalDate d = LocalDate.now().minusDays(7);
        for (Order o : orders) {
            if (o.date.isAfter(d)) {
                System.out.println(o.id);
            }
        }
    }

    void lastMonth() {
        LocalDate d = LocalDate.now().minusMonths(1);
        for (Order o : orders) {
            if (o.date.isAfter(d)) {
                System.out.println(o.id);
            }
        }
    }
}

public class question6 {
    public static void main(String[] args) {
        OrderSystem s = new OrderSystem();

        Item a = new Item("Laptop", 50000, 10, 2);
        Item b = new Item("Mouse", 500, 20, 5);

        s.addItem(a);
        s.addItem(b);

        Customer c = new Customer("Sailaja", "AP", "1234567890", "mail@gmail.com");
        s.addCustomer(c);

        Map<Item, Integer> m = new HashMap<>();
        m.put(a, 1);
        m.put(b, 2);

        s.placeOrder(c, m);

        s.findItem("Laptop");
        s.findByPrice(500);
        s.findOrder(1);
        s.ordersByCustomer("Sailaja");

        s.extremeOrders();
        s.lastWeek();
        s.lastMonth();
    }
}