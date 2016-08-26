package com.example.mdarifur.tourmate.Adapter;

import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mdarifur.tourmate.Constant.Constant;
import com.example.mdarifur.tourmate.FileOperation.FileSystem;
import com.example.mdarifur.tourmate.Model.Event_Contact;
import com.example.mdarifur.tourmate.Model.PhotoData;
import com.example.mdarifur.tourmate.Preference;
import com.example.mdarifur.tourmate.R;

import java.util.ArrayList;

/**
 * Created by MD.Arifur on 8/26/2016.
 */
public class TimeLine_Adapter extends RecyclerView.Adapter<TimeLine_Adapter.RecyclerViewholder> {
    ArrayList<PhotoData> photoDataArrayList= new ArrayList<PhotoData>();

    public TimeLine_Adapter(ArrayList<PhotoData> photoDataArrayList) {
        this.photoDataArrayList = photoDataArrayList;
    }

    @Override
    public TimeLine_Adapter.RecyclerViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_time_line,parent,false);
        RecyclerViewholder recyclerViewholder = new RecyclerViewholder(view);
        return recyclerViewholder;
    }

    @Override
    public void onBindViewHolder(TimeLine_Adapter.RecyclerViewholder holder, int position) {
        PhotoData photoData = photoDataArrayList.get(position);
        holder.timeDateTV.setText(photoData.getDate()+" "+photoData.getTime());
        holder.captionTimelineTV.setText(photoData.getCaption());
        holder.timelineImg.setImageBitmap(FileSystem.decodeBase64(photoData.getPhotoName()));
    }

    @Override
    public int getItemCount() {
        return photoDataArrayList.size();
    }

    public static class RecyclerViewholder extends RecyclerView.ViewHolder{
        TextView timeDateTV,captionTimelineTV;
        ImageView timelineImg;
        public RecyclerViewholder(View itemView) {
            super(itemView);
            timeDateTV = (TextView) itemView.findViewById(R.id.timeDateTV);
            timelineImg = (ImageView) itemView.findViewById(R.id.timelineImg);
            captionTimelineTV = (TextView) itemView.findViewById(R.id.captionTimelineTV);
        }
    }
}
