package com.example.mdarifur.tourmate;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebViewFragment;
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
        if(image != null && !image.isEmpty()) {
            profilePhoto.setImageBitmap(FileSystem.decodeBase64(image));
        } else {
            Toast.makeText(TourMate.this, "Yet, Profile photo doesn't set", Toast.LENGTH_SHORT).show();
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
       int id = item.getItemId();
        if(id == R.id.nav_menu_1){
            int i = getFragmentManager().beginTransaction().replace(R.id.fragment,new EventsFragment()).commit();
            Toast.makeText(TourMate.this, String.valueOf(i)+" value", Toast.LENGTH_SHORT).show();

        }else if(id == R.id.nav_menu_2){
            Toast.makeText(TourMate.this, "Click for Weather", Toast.LENGTH_SHORT).show();
            getFragmentManager().beginTransaction().replace(R.id.fragment,new WeatherFragment()).commit();
        }else if(id == R.id.nav_menu_3){
            Toast.makeText(TourMate.this, "Click for Nothing", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.nav_menu_4){
            Toast.makeText(TourMate.this, "Click for Nothing", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (dl.isDrawerOpen(GravityCompat.START))
            dl.closeDrawer(GravityCompat.START);

        return false;
    }

    public void addEvent(View view) {
        Toast.makeText(TourMate.this, "You Click For Add Event", Toast.LENGTH_LONG).show();
    }
}
