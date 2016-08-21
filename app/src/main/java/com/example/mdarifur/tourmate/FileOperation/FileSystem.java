package com.example.mdarifur.tourmate.FileOperation;

import android.Manifest;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by MD.Arifur on 8/15/2016.
 */
public class FileSystem {
;
    static String TAG = "FileOperaion";

    public static String saveFile(Context context,Bitmap b){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_profile.jpg";

        FileOutputStream fos;
        try {
            fos = context.openFileOutput(imageFileName, Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
            b.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        }
        catch (FileNotFoundException e) {
            Log.d(TAG, "file not found");
            e.printStackTrace();
        }
        catch (IOException e) {
            Log.d(TAG, "io exception");
            e.printStackTrace();
        }
        return imageFileName;

    }

    public static String SaveBitmap(Context context,Bitmap bitmap){
        String PictureDirectory = Environment.getExternalStorageDirectory().toString();

        OutputStream fOutputStream = null;

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_Image" + timeStamp + "_profile.jpg";

        File file = new File(PictureDirectory, "screen.jpg");
        try {
            fOutputStream = new FileOutputStream(file);
        }catch (Exception ex){
            Toast.makeText(context, "Outpurstream Error"+ex, Toast.LENGTH_SHORT).show();
        }
        try {

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOutputStream);
            fOutputStream.flush();
            fOutputStream.close();
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
        } catch (Exception e) {
            Toast.makeText(context, "Compress Error"+e, Toast.LENGTH_SHORT).show();
        }
        return imageFileName;
    }

    public static Bitmap loadBitmap(Context context, String picName){
        Bitmap b = null;
        FileInputStream fis;
        try {
            fis = context.openFileInput(picName);
            b = BitmapFactory.decodeStream(fis);
            fis.close();

        }
        catch (FileNotFoundException e) {
            Log.d(TAG, "file not found");
            e.printStackTrace();
        }
        catch (IOException e) {
            Log.d(TAG, "io exception");
            e.printStackTrace();
        }
        return b;
    }

}
