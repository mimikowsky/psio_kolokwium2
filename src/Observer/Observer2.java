package Observer;

import Observable.Subject;

public class Observer2 implements Observer{

    private Subject sub;
    private int counter = 0;
    private String[] words;


    public Observer2(Subject sub) {

        this.sub = sub;
        this.sub.registerObserver(this);
    }

    @Override
    public void update(String row) {
        words = row.split("\\s");
        counter += words.length;
        System.out.println("Number of words: " + counter);
    }
}
