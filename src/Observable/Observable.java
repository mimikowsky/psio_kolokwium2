package Observable;

import Observer.Observer;

import java.util.ArrayList;

public class Observable implements Subject{

    ArrayList<Observer> ObserverList = new ArrayList<Observer>();

    private String row;

    @Override
    public void registerObserver(Observer observer) {
        ObserverList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        ObserverList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : ObserverList){
            observer.update(row);
        }
    }

    public void measurementChanged(){
        notifyObservers();
    }

    public void setMeasurement(String row){
        this.row = row;
        measurementChanged();
    }
}
