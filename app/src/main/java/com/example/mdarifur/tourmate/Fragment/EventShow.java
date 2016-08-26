package com.example.mdarifur.tourmate.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mdarifur.tourmate.Adapter.TimeLine_Adapter;
import com.example.mdarifur.tourmate.Constant.Constant;
import com.example.mdarifur.tourmate.Database.PhotoDataSource;
import com.example.mdarifur.tourmate.FileOperation.FileSystem;
import com.example.mdarifur.tourmate.Model.Event_Contact;
import com.example.mdarifur.tourmate.Model.PhotoData;
import com.example.mdarifur.tourmate.Preference;
import com.example.mdarifur.tourmate.R;

import java.util.ArrayList;

/**
 * Created by MD.Arifur on 8/25/2016.
 */
public class EventShow extends Fragment {
    TextView isTimelineEmpty;
    RecyclerView eventTimeline;
    RecyclerView.Adapter timeLineAdapter;
    RecyclerView.LayoutManager timeLineManager;
    PhotoDataSource photoDataSource;
    Preference preference;
    ArrayList<PhotoData> photoDataSourceList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_show, container, false);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabevent);
        FloatingActionButton spendFAP = (FloatingActionButton) rootView.findViewById(R.id.spendFAP);
        preference = new Preference(getActivity());
        photoDataSource = new PhotoDataSource(getActivity());
        photoDataSourceList = photoDataSource.getTimeLine(preference.getUserData(Constant.EVENT_ID));
        isTimelineEmpty = (TextView) rootView.findViewById(R.id.isTimelineEmpty);
        eventTimeline = (RecyclerView) rootView.findViewById(R.id.timeLineRV);
        if (photoDataSourceList.isEmpty()) {
            eventTimeline.setVisibility(View.GONE);
            isTimelineEmpty.setVisibility(View.VISIBLE);
        } else {
            eventTimeline.setVisibility(View.VISIBLE);
            isTimelineEmpty.setVisibility(View.GONE);
            timeLineManager = new LinearLayoutManager(getActivity());
            eventTimeline.setLayoutManager(timeLineManager);
            eventTimeline.setHasFixedSize(true);
            timeLineAdapter = new TimeLine_Adapter(photoDataSourceList);
            eventTimeline.setAdapter(timeLineAdapter);

        }


        spendFAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.content_Frame, new Expend()).commit();
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    getFragmentManager().beginTransaction().replace(R.id.content_Frame, new TakePhoto()).commit();
            }
        });
        return rootView;
    }
}
