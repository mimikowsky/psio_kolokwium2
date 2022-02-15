package Observer;

import Controller.Controller;
import Observable.Subject;
import Exception.MyException;

public class Observer3 implements Observer{

    private Subject sub;

    public Observer3(Subject sub) {

        this.sub = sub;
        this.sub.registerObserver(this);
    }


    @Override
    public void update(String row) {
        Controller.setDataFromModel("Negatywny");
        System.out.println("trzeci obserwer");
        if (row.contains("bomba") || row.contains("zamach") || row.contains("pistolet") ){
            try {
                throw new MyException();
            } catch (MyException e) {
                //Controller.setDataFromModel("Pozytywny");  // we can catch exception and set label or in myexception constructior set the label to positive
            }
        }

    }
}
