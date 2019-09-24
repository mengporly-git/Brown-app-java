package com.example.browncoffee.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    static private String prefName = "SharedPreferencesHelper";
    static private String TOKEN = "token";
    static private int MODE_PRIVATE = Context.MODE_PRIVATE;

    public static void saveToken(Context context, String token) {
        SharedPreferences.Editor pref = context.getSharedPreferences(prefName, MODE_PRIVATE).edit();
        pref.putString(TOKEN, token).apply();
    }

    public static String getToken(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, MODE_PRIVATE);
        return pref.getString(TOKEN, null);
    }

    public static void removeToken(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(prefName, MODE_PRIVATE).edit();
        editor.remove(TOKEN).apply();
    }
}
