package Observer;

import Observable.Subject;

public class Observer1 implements Observer{

    private Subject sub;

    public Observer1(Subject sub) {

        this.sub = sub;
        this.sub.registerObserver(this);
    }


    @Override
    public void update(String row) {
        System.out.println(row);
    }
}
