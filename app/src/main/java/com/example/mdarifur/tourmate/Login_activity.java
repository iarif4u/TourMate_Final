package com.example.mdarifur.tourmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mdarifur.tourmate.Constant.Constant;
import com.example.mdarifur.tourmate.Database.ContactDatabaseSource;
import com.example.mdarifur.tourmate.Model.Contact;

public class Login_activity extends AppCompatActivity {
    public Preference preference;
    private EditText usernameLET,passwordLET;
    private String usernameLI,passwordLI;
    private ContactDatabaseSource contactDatabaseSource;
    private Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        getVariable();
    }

    private void getVariable() {
        usernameLET = (EditText) findViewById(R.id.usernameLET);
        passwordLET = (EditText) findViewById(R.id.passwordLET);
    }

    public void SignupAcc(View view) {
        Intent signup = new Intent(this,Signup_activity.class);
        startActivity(signup);
    }

    public void LoginUser(View view) {
        contactDatabaseSource = new ContactDatabaseSource(this);
        setVariable();
        contact=contactDatabaseSource.Login(usernameLI,passwordLI);
        if(contact==null){
            Toast.makeText(Login_activity.this, "Username or Password doesn't match", Toast.LENGTH_SHORT).show();
        }else {
            preference = new Preference(this);
            preference.saveUserData(Constant.ID, contact.getId());
            preference.saveUserData(Constant.EMAIL,contact.getEmailId());
            preference.saveUserData(Constant.NAME,contact.getName());
            preference.saveUserData(Constant.PHONE,contact.getPhoneNub());
            preference.saveUserData(Constant.IMAGE,contact.getPhoto());
            preference.saveUserData(Constant.EMERZENCY,contact.getEmerzencyPhnoeNub());
            Toast.makeText(Login_activity.this,"Login Success", Toast.LENGTH_SHORT).show();
            Intent loginSuccess = new Intent(this,TourMate.class);
            startActivity(loginSuccess);
        }

    }

    private void setVariable() {
        usernameLI = usernameLET.getText().toString();
        passwordLI = passwordLET.getText().toString();
    }
}
