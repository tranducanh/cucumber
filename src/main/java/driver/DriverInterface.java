package driver;

import org.openqa.selenium.By;

import java.util.List;

public interface DriverInterface<T> {
    void initPageFactoryElements(Object object);

    void longPress(T element, int duration);

    void swipeDown();

    void swipeLeft();

    void swipeRight();

    void swipeUp();

    T waitAndFindElement(By by);

    List<T> waitAndFindElements(By by);

    void sendText(By by,String str);

    boolean isPresented(By by);

    boolean isNotPresented(By by);

    void waitAndClick(By by);

}
