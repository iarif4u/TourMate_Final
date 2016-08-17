package com.example.mdarifur.tourmate;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mdarifur.tourmate.FileOperation.FileSystem;

public class Signup_activity extends AppCompatActivity {
    private boolean isCamera;
    private FileSystem fileSystem;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int RESULT_LOAD_IMAGE = 1;
    ImageView profile_image;
    Bitmap profileIMG = null;
    String imageName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);
        profile_image = (ImageView) findViewById(R.id.profile_image);
        fileSystem = new FileSystem(this);
    }
    public void ImageCapture(View view) {
        isCamera = true;

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (isCamera == true) {
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                profileIMG = (Bitmap) extras.get("data");
                profile_image.setImageBitmap(profileIMG);
            }
        } else {
            if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                profileIMG = BitmapFactory.decodeFile(picturePath);
                profileIMG =ImageResize.scaleDown(profileIMG,620,true);
                //Toast.makeText(Signup_activity.this, String.valueOf(profileIMG.getWidth()), Toast.LENGTH_LONG).show();
                profile_image.setImageBitmap(profileIMG);
            }
        }
    }

    public void PickFromGallery(View view) {
        isCamera = false;
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }


    public void SaveData(View view) {
     /*   imageName = fileSystem.saveToInternalStorage(profileIMG);
        Bitmap b = fileSystem.loadImageFromStorage(imageName);


        profile_image.setImageBitmap(b); */
        Toast.makeText(this, imageName, Toast.LENGTH_SHORT).show();


    }

}
