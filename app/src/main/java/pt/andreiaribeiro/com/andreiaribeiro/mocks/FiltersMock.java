package pt.andreiaribeiro.com.andreiaribeiro.mocks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rui on 22/11/2017.
 */

public class FiltersMock {

    public static List<ObjSpinner> fillActivities() {
        List<ObjSpinner> spinnerArray =  new ArrayList<ObjSpinner>();
        spinnerArray.add(new ObjSpinner(0,"-----"));
        spinnerArray.add(new ObjSpinner(1,"item1"));
        spinnerArray.add(new ObjSpinner(2,"item2"));
        spinnerArray.add(new ObjSpinner(3,"item3"));
        spinnerArray.add(new ObjSpinner(4,"item4"));
        spinnerArray.add(new ObjSpinner(5,"item5"));
        spinnerArray.add(new ObjSpinner(6,"item6"));
        return spinnerArray;
    }

    public static List<String> fillServices(int idActivity) {
        List<String> spinnerArray =  new ArrayList<String>();
        switch (idActivity){
            case 0:
                break;
            case 1:spinnerArray.add("Servicos 10");
                spinnerArray.add("Servicos 11");
                spinnerArray.add("Servicos 12");
                spinnerArray.add("Servicos 13");
                spinnerArray.add("Servicos 14");
                spinnerArray.add("Servicos 15");
                break;
            case 2:spinnerArray.add("Servicos 20");
                spinnerArray.add("Servicos 21");
                spinnerArray.add("Servicos 22");
                spinnerArray.add("Servicos 23");
                spinnerArray.add("Servicos 24");
                break;
            case 3:spinnerArray.add("Servicos 30");

                break;
            case 4:spinnerArray.add("Servicos 40");
                spinnerArray.add("Servicos 41");

                break;
            case 5:spinnerArray.add("Servicos 50");
                spinnerArray.add("Servicos 51");
                spinnerArray.add("Servicos 52");
                spinnerArray.add("Servicos 53");
                spinnerArray.add("Servicos 54");
                spinnerArray.add("Servicos 55");
                break;
            case 6:spinnerArray.add("Servicos 60");
                spinnerArray.add("Servicos 61");
                break;
            default: break;
        }

        return spinnerArray;
    }

    public static List<ObjSpinner> fillCountry() {
        List<ObjSpinner> spinnerArray =  new ArrayList<ObjSpinner>();
        spinnerArray.add(new ObjSpinner(0,"-----"));
        spinnerArray.add(new ObjSpinner(1,"Portugal"));
//        spinnerArray.add(new ObjSpinner(2,"Espanha"));
//        spinnerArray.add(new ObjSpinner(3,"England"));
//        spinnerArray.add(new ObjSpinner(4,"France"));
//        spinnerArray.add(new ObjSpinner(5,"Angola"));
        return spinnerArray;
    }

    public static List<ObjSpinner> fillDistrict(int idCountry) {
        List<ObjSpinner> spinnerArray =  new ArrayList<ObjSpinner>();
        switch (idCountry){
            case 0:
                break;
            case 1:spinnerArray.add(new ObjSpinner(10,"Lisboa"));
                spinnerArray.add(new ObjSpinner(20,"Setubal"));
                spinnerArray.add(new ObjSpinner(30,"Porto"));
                spinnerArray.add(new ObjSpinner(40,"Faro"));
                break;
            default: break;
        }
        return spinnerArray;
    }

    public static List<ObjSpinner> fillCouncil(int idDistrict) {
        List<ObjSpinner> spinnerArray =  new ArrayList<ObjSpinner>();
        switch (idDistrict){
            case 0:
                break;
            case 10:spinnerArray.add(new ObjSpinner(100,"Benfica"));
                spinnerArray.add(new ObjSpinner(101,"Mafra"));
                break;
            case 20:spinnerArray.add(new ObjSpinner(200,"Barreiro"));
                spinnerArray.add(new ObjSpinner(201,"Montijo"));
                break;
            case 30:spinnerArray.add(new ObjSpinner(300,"Afurada"));
                spinnerArray.add(new ObjSpinner(301,"Matosinhos"));
                break;
            case 40:spinnerArray.add(new ObjSpinner(400,"Albufeira"));
                spinnerArray.add(new ObjSpinner(401,"Quarteira"));
                break;
            default: break;
        }
        return spinnerArray;
    }
}
