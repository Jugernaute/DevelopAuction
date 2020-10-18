package ua.com.method.subscribers;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BetLot implements Observed {

    private int currentPrice;
    private String productName;
    private String productModel;

    List<Observer> subscribers = new ArrayList<>();

    public  void changeCurrentPrice(String productName, String productModel, int currentPrice) throws InterruptedException {
        this.productName = productName;
        this.productModel = productModel;
        this.currentPrice = currentPrice;
        notifyObservers();
    }

    @Override
    public void addObserved(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserved(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() throws InterruptedException {
        for (Observer observer: subscribers){
            observer.handleEvent(this.productName, this.productModel, this.currentPrice);
            }
    }
}
