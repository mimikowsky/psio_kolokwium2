package Controller;

import Observable.Observable;
import View.View;

public class Controller {

    private static Observable obs;

    public static void setObservable(Observable o){
        obs = o;
    }

    private static String row;

    public static void putDataToModel(){
        obs.setMeasurement(row);
    }

    public static void setRowValueFromView(String row1){

        row = row1;

        putDataToModel();
    }


    public static void dataToView(String result) {

        View.setTextfield2_Text(result);

    }

    public static void setDataFromModel(String result) {

        if (result != null)
            dataToView(result);
    }
}
