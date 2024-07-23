

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 *  customer id, firstname, lastName
 *  order -  id, listOrderLine, customer
 *  orderline - product , quantity
 *  product -  name price
 *  findthree most popular products (streamoforders)
 *

 */
public class Test {
    public static void main(String[] args) {

    }

    Set<Product> findTopThreePopularProducts(List<Order> orders){


        Set<Product> products = orders.stream().flatMap(it -> it.getOrderLines().stream()
                .map(orderLine -> orderLine.product)).collect(Collectors.toSet());

        Map<Product, Long>  countMap= products.stream().collect(Collectors.groupingBy(it -> it, Collectors.counting()));


       return countMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
               .sorted(Map.Entry.comparingByKey(Comparator.comparing(Product::getName))).map(Map.Entry::getKey).limit(3).collect(Collectors.toSet());

    }

    
}

class Customer {
    private int id;
    private String firstName;

    private String lastName;

    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class  Product {
    private String name;
    private int price;


    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class OrderLine {
   Product product;

   int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
class Order {
    private int id;
    private Set<OrderLine> orderLines;
    private Customer customer;

    public Order(int id, Set<OrderLine> orderLines, Customer customer) {
        this.id = id;
        this.orderLines = orderLines;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

