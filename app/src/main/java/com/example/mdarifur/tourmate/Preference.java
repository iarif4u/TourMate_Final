package com.example.mdarifur.tourmate;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

import com.example.mdarifur.tourmate.FileOperation.FileSystem;

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
    public void saveLoginData(String key,boolean data) {
        editor.putBoolean(key,data);
        editor.commit();
    }
    public boolean getLoginData(String key){
        return sharedPreferences.getBoolean(key,false);
    }
    public void saveUserData(String key,int data) {
        editor.putString(key,String.valueOf(data));
        editor.commit();
    }
    public String getUserData(String key) {
        String dataTobeShown = sharedPreferences.getString(key, null);
        return dataTobeShown;
    }
}
