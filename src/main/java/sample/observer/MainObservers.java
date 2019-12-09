package sample.observer;

import java.math.BigDecimal;

public class MainObservers {
    public static void main(String[] args) {
        OrderSubject orderSubject = new OrderSubject();
        AdditionalDisplayment additionalDisplayment = new AdditionalDisplayment(orderSubject);
        AgeDisplayment ageDisplayment = new AgeDisplayment(orderSubject);
        orderSubject.setOrderChanged(BigDecimal.valueOf(5), BigDecimal.valueOf(5), "Test 1");
    }
}
