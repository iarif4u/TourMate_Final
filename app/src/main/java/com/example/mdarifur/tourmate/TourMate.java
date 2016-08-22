package com.example.mdarifur.tourmate;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mdarifur.tourmate.Constant.Constant;
import com.example.mdarifur.tourmate.FileOperation.FileSystem;

public class TourMate extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActionBarDrawerToggle toggle;
    TextView userNamePro, emailPro;
    ImageView profilePhoto;
    Preference preference;
    String id, username, email, phone, emerzency, image;
    String TAG="Image Tag: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_mate);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigainView);
        navigationView.setNavigationItemSelectedListener(this);
        setField(navigationView);
        setValueToField();
    }

    private void setValueToField() {
        id = preference.getUserData(Constant.ID);
        email = preference.getUserData(Constant.EMAIL);
        username = preference.getUserData(Constant.NAME);
        phone = preference.getUserData(Constant.PHONE);
        emerzency = preference.getUserData(Constant.EMERZENCY);
        image = preference.getUserData(Constant.IMAGE);
        userNamePro.setText(username);
        emailPro.setText(email);
        if (!image.equals(null)&&image!="null"&&!image.equals("null")&&image.length()>5) {
            profilePhoto.setImageBitmap(FileSystem.decodeBase64(image));
        } else {
            Log.e(TAG,"Cann't Set the image");
        }
    }

    private void setField(NavigationView navigationView) {
        View hView = navigationView.getHeaderView(0);
        userNamePro = (TextView) hView.findViewById(R.id.userNamePro);
        emailPro = (TextView) hView.findViewById(R.id.emailPro);
        profilePhoto = (ImageView) hView.findViewById(R.id.profilePhoto);
        preference = new Preference(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_menu_1:
                Toast.makeText(TourMate.this, "Nav Menu 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_menu_2:
                Toast.makeText(TourMate.this, "Nav Menu 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_menu_3:
                Toast.makeText(TourMate.this, "Nav Menu 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_menu_4:
                Toast.makeText(TourMate.this, "Nav Menu 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_menu_5:
                Toast.makeText(TourMate.this, "Nav Menu 5", Toast.LENGTH_SHORT).show();
                break;

        }

        DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (dl.isDrawerOpen(GravityCompat.START))
            dl.closeDrawer(GravityCompat.START);

        return false;
    }
}
