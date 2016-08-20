package com.example.mdarifur.tourmate;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by MD.Arifur on 7/25/2016.
 */
public class Preference {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public Preference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUserData(String key,String data) {
        editor.putString(key,data);
        editor.commit();
    }
    public void saveUserData(String key,int data) {
        editor.putInt(key,data);
        editor.commit();
    }
    public int getUserData(String key,boolean id) {
        int dataTobeShown = sharedPreferences.getInt(key, 0);
        return dataTobeShown;
    }
    public String getUserData(String key) {
        String dataTobeShown = sharedPreferences.getString(key, "false");
        return dataTobeShown;
    }
}
