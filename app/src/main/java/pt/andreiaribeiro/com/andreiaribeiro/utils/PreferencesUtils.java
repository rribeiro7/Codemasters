package pt.andreiaribeiro.com.andreiaribeiro.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Rui on 27/09/2017.
 */

public class PreferencesUtils {

    public static final String PREFERENCES_SONDAGEM = "preferences_sondagem";
    public static final String TAB_OPINIAO = "tab_opiniao";

    public static String getPreferencesString(Context context, String sondagemId) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(sondagemId, null);
    }

    public static boolean setPreferencesString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.edit().putString(key, value).commit();
    }

    public static Boolean getPreferencesBoolean(Context context, String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(key, false);
    }

    public static boolean setPreferencesBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.edit().putBoolean(key, value).commit();
    }


}
