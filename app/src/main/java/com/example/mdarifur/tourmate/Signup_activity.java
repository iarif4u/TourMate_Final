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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mdarifur.tourmate.Database.ContactDatabaseSource;
import com.example.mdarifur.tourmate.FileOperation.FileSystem;
import com.example.mdarifur.tourmate.Model.Contact;

public class Signup_activity extends AppCompatActivity {
    private Contact contact;
    private ContactDatabaseSource contactDatabaseSource;
    private FileSystem fileSystem;
    private Is_Valid isValid;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int RESULT_LOAD_IMAGE = 1;
    private boolean isCamera,result;
    private EditText usernameET,passwordET,emailET,phoneET,emergencyET;
    private String userName,email,passWord,phone,imageName,emergency;
    private ImageView profile_image;
    private Bitmap bitmapImg = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);
        getFieldVariable();
    }

    private void getFieldVariable() {
        fileSystem = new FileSystem(this);
        isValid = new Is_Valid(this);
        usernameET = (EditText) findViewById(R.id.usernameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        emailET = (EditText) findViewById(R.id.emailET);
        phoneET = (EditText) findViewById(R.id.phoneET);
        profile_image = (ImageView) findViewById(R.id.profile_image);
        emergencyET = (EditText) findViewById(R.id.emergencyET);
    }
    private void setValue() {
        userName = usernameET.getText().toString();
        passWord = passwordET.getText().toString();
        email    = emailET.getText().toString();
        phone    = phoneET.getText().toString();
        emergency    = emergencyET.getText().toString();
        if(bitmapImg==null){
            imageName = null;
        }else{
            imageName = fileSystem.saveToInternalStorage(bitmapImg);
        }
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
                bitmapImg = (Bitmap) extras.get("data");
                profile_image.setImageBitmap(ImageResize.scaleDown(bitmapImg,620,true));
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
                bitmapImg = BitmapFactory.decodeFile(picturePath);
                profile_image.setImageBitmap(ImageResize.scaleDown(bitmapImg,620,true));
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
        setValue();
        result = isValid.CheckData(userName,passWord,email,phone);
        if(result==true){
            contact = new Contact(userName, passWord, imageName, phone, email,emergency);
            contactDatabaseSource = new ContactDatabaseSource(this);
            boolean result_show = contactDatabaseSource.addContact(contact);
            Toast.makeText(Signup_activity.this, String.valueOf(result_show), Toast.LENGTH_SHORT).show();
        }
    }

}
