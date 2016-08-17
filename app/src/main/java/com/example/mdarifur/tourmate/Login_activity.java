package com.example.mdarifur.tourmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
    }

    public void SignupAcc(View view) {
        Intent signup = new Intent(this,Signup_activity.class);
        startActivity(signup);
    }
}
