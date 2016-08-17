package com.example.mdarifur.tourmate;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mdarifur.tourmate.FileOperation.FileSystem;

public class Signup_activity extends AppCompatActivity {
    private FileSystem fileSystem;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView cameraIV;
    Bitmap profileIMG = null;
    String imageName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);
    }
    public void ImageCapture(View view) {
        fileSystem = new FileSystem(this);

        cameraIV = (ImageView) findViewById(R.id.cameraIV);
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            profileIMG = (Bitmap) extras.get("data");
            imageName = fileSystem.saveToInternalStorage(profileIMG);
        }
    }
    public void SaveData(View view) {
        Bitmap b = fileSystem.loadImageFromStorage(imageName);
        Toast.makeText(this, imageName, Toast.LENGTH_SHORT).show();
        cameraIV.setImageBitmap(b);
    }
}
