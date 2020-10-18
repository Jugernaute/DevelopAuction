package ua.com.method.subscribers;

import org.springframework.stereotype.Component;

@Component
public interface Observed {

    public void addObserved(Observer observer);

    public void removeObserved(Observer observer);

    public void notifyObservers() throws InterruptedException;
}
