package com.example.mdarifur.tourmate.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mdarifur.tourmate.Constant.Constant;
import com.example.mdarifur.tourmate.Database.PhotoDataSource;
import com.example.mdarifur.tourmate.FileOperation.FileSystem;
import com.example.mdarifur.tourmate.Model.PhotoData;
import com.example.mdarifur.tourmate.Preference;
import com.example.mdarifur.tourmate.R;
import com.example.mdarifur.tourmate.TimeAndDate.DateOperation;

/**
 * Created by MD.Arifur on 8/25/2016.
 */
public class TakePhoto extends Fragment {
    PhotoDataSource photoDataSource;
    Preference preference;
    DateOperation dateOperation;
    Bitmap bitmapImg=null;
    ImageView takeImg;
    public static int REQUEST_IMAGE_CAPTURE = 1;
    Button savePhotoBTN;
    EditText captionImgET;
    String photoCaption = null;
    String photoName;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        View rootView = inflater.inflate(R.layout.fragment_take_photo, container, false);
        dateOperation = new DateOperation();
        photoDataSource = new PhotoDataSource(getActivity());
        takeImg = (ImageView) rootView.findViewById(R.id.takeImg);
        preference = new Preference(getActivity());
        savePhotoBTN = (Button) rootView.findViewById(R.id.savePhotoBTN);
        captionImgET = (EditText) rootView.findViewById(R.id.captionImgET);
        takeImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
        savePhotoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bitmapImg == null){
                    Toast.makeText(getActivity(), "Take an image", Toast.LENGTH_SHORT).show();
                }else {
                    photoName = FileSystem.encodeTobase64(bitmapImg);
                    String date = dateOperation.getCurrentDate();
                    String time = dateOperation.getCurrentTime();
                    photoCaption = captionImgET.getText().toString();
                    String eventID = preference.getUserData(Constant.EVENT_ID);
                    boolean result  = photoDataSource.addPhotoData(new PhotoData(photoName,photoCaption,time,date,eventID));
                    if(result==true){
                        Toast.makeText(getActivity(), "Photo add to your timeline", Toast.LENGTH_SHORT).show();
                        getFragmentManager().beginTransaction().replace(R.id.content_Frame, new EventShow()).commit();
                    }else{
                        Toast.makeText(getActivity(), "Sorry, Photo doesn't add timeline", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == getActivity().RESULT_OK) {
            Bundle extras = data.getExtras();
            bitmapImg = (Bitmap) extras.get("data");
            takeImg.setImageBitmap(bitmapImg);
        }
    }
}
