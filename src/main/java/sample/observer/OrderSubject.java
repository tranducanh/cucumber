package sample.observer;

import java.math.BigDecimal;
import java.util.ArrayList;


public class OrderSubject implements Subject {
    private ArrayList observers;
    private BigDecimal quantity;
    private BigDecimal price;
    private String name;

    public OrderSubject() {
        observers = new ArrayList();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index > 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(quantity, price, name);
        }
    }

    public void orderChanged() {
        notifyObservers();
    }

    public void setOrderChanged(BigDecimal quantity, BigDecimal price, String name) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        orderChanged();
    }
}
