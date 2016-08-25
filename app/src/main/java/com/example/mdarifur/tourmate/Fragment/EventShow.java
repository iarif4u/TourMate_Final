package com.example.mdarifur.tourmate.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mdarifur.tourmate.R;

/**
 * Created by MD.Arifur on 8/25/2016.
 */
public class EventShow extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_show, container, false);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabevent);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.content_Frame, new TakePhoto()).commit();
            }
        });
        return rootView;
    }
}
