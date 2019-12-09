package sample.observer;

import java.math.BigDecimal;

public interface Observer {
    public void update(BigDecimal quantity, BigDecimal price, String name);
}
