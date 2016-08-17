package com.example.mdarifur.tourmate.FileOperation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by MD.Arifur on 8/15/2016.
 */
public class FileSystem {
    Context context;

    public FileSystem(Context context) {
        this.context = context;
    }

    public String saveToInternalStorage(Bitmap bitmapImage){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_profile.jpg";

        File mypath = new File(context.getFilesDir(), imageFileName);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageFileName;
    }

    public Bitmap loadImageFromStorage(String imageName)
    {

        try {
            File f=new File(context.getFilesDir(), imageName);
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            return b;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }

    }

}
