package cs108;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSubject implements Subject{
    private final List<Observer> lstObserver;


    public AbstractSubject(){
        lstObserver = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        lstObserver.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        lstObserver.remove(o);
    }

    protected void onChange(){
        for (Observer observer : lstObserver) {
            observer.update();
        }
    }
}
