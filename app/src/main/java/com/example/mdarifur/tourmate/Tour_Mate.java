package com.example.mdarifur.tourmate;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mdarifur.tourmate.Constant.Constant;
import com.example.mdarifur.tourmate.FileOperation.FileSystem;
import com.example.mdarifur.tourmate.Fragment.EventList;
import com.example.mdarifur.tourmate.Fragment.Weather;

public class Tour_Mate extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView userNamePro, emailPro;
    ImageView profilePhoto;
    Preference preference;
    String id, username, email, phone, emerzency, image;
    String TAG = "Image Tag: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tour__mate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (null == savedInstanceState) {

            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.content_Frame, new EventList()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setField(navigationView);
        setValueToField();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_Frame, new EventList()).commit();

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
        if (image != null && !image.isEmpty()) {
            profilePhoto.setImageBitmap(FileSystem.decodeBase64(image));
        } else {
            Toast.makeText(this, "Yet, Profile photo doesn't set", Toast.LENGTH_SHORT).show();
        }
    }

    private void setField(NavigationView navigationView) {
        View hView = navigationView.getHeaderView(0);
        userNamePro = (TextView) hView.findViewById(R.id.usernameNH);
        emailPro = (TextView) hView.findViewById(R.id.emailNH);
        profilePhoto = (ImageView) hView.findViewById(R.id.imageViewNH);
        preference = new Preference(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tour__mate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            fragmentManager.beginTransaction().replace(R.id.content_Frame, new EventList()).commit();
        } else if (id == R.id.nav_gallery) {
            fragmentManager.beginTransaction().replace(R.id.content_Frame, new Weather()).commit();
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_logout) {
            preference.saveLoginData(Constant.IS_LOGIN, false);
            preference.saveUserData(Constant.ID, "");
            preference.saveUserData(Constant.EMAIL, "");
            preference.saveUserData(Constant.NAME, "");
            preference.saveUserData(Constant.PHONE, "");
            preference.saveUserData(Constant.IMAGE, "");
            preference.saveUserData(Constant.EMERZENCY, "");
            Intent logOutSuccess = new Intent(this, Login_activity.class);
            startActivity(logOutSuccess);
        } else if (id == R.id.nav_exit) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
