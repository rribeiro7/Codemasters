package pt.andreiaribeiro.com.andreiaribeiro.utils;

/**
 * Created by Rui on 03/12/2017.
 */

public class StringUtils {

    public static final String COMMA = ",";
    public static final String DOT = ".";
    public static final String EMPTY_SPACE = "";

    public static boolean isNullOrEmpty(String s){
        return s == null || s.trim().isEmpty();
    }

    public static String strValue(String s)
    {
        if (isNullOrEmpty(s))
        return EMPTY_SPACE;
        else
            return s;
    }

    /*
    private String getStringResourceByName(String aString) {
        String packageName = getActivity().getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }*/
}
