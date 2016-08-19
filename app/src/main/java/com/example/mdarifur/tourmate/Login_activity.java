package com.example.mdarifur.tourmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mdarifur.tourmate.Database.ContactDatabaseSource;
import com.example.mdarifur.tourmate.Model.Contact;

public class Login_activity extends AppCompatActivity {
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
            Toast.makeText(Login_activity.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(Login_activity.this, contact.getEmailId(), Toast.LENGTH_SHORT).show();
        }

    }

    private void setVariable() {
        usernameLI = usernameLET.getText().toString();
        passwordLI = passwordLET.getText().toString();
    }
}
