package com.exomatik.clickbus.clickbus;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by IrfanRZ on 12/12/2018.
 */

public class UserPreference {
    private String KEY_NAME = "name";
    private SharedPreferences preferences;

    UserPreference(Context context){
        String PREFS_NAME = "UserPref";
        preferences = context.getSharedPreferences(PREFS_NAME
                , Context.MODE_PRIVATE);
    }

    public boolean getKEY_NAME() {
        return preferences.getBoolean(KEY_NAME, false);
    }

    public void setKEY_NAME(boolean NAME) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_NAME, NAME);
        editor.apply();
    }
}
