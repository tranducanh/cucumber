package sample.observer;

import java.math.BigDecimal;

public class AdditionalDisplayment implements Observer, DisplayElement {
    private String name;
    private BigDecimal price;
    private BigDecimal quantity;
    private Subject orderData;

    public AdditionalDisplayment(Subject orderData) {
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
        System.out.println("AdditionalDisplayment : " + name + " price: " + price);
    }
}
