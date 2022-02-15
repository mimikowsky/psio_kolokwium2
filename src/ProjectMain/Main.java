package ProjectMain;

import Observable.Observable;
import Observer.Observer1;
import Observer.Observer2;
import Observer.Observer3;
import Controller.Controller;
import View.View;


public class Main {

    public static void main(String[] args) {

        Observable observable1 = new Observable();

        Controller.setObservable(observable1);

        Observer1 observer1 = new Observer1(observable1);

        Observer2 observer2 = new Observer2(observable1);

        Observer3 observer3 = new Observer3(observable1);

        new View().GUI_Create();

    }
}
