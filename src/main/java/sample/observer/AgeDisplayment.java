package sample.observer;

import java.math.BigDecimal;

public class AgeDisplayment implements Observer, DisplayElement {
    private String name;
    private BigDecimal price;
    private BigDecimal quantity;
    private Subject orderData;

    public AgeDisplayment(Subject orderData) {
        this.orderData = orderData;
        orderData.registerObserver(this);
    }

    @Override
    public void update(BigDecimal quantity, BigDecimal price, String name) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        display();
    }

    public void display() {
        System.out.println("Age display : " + name + " price: " + price);
    }
}
