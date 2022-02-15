package Exception;

import Controller.Controller;
import View.View;

public class MyException extends Exception{

    public MyException(){
        Controller.setDataFromModel("Pozytywny");
    }
}
