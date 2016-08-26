package com.example.mdarifur.tourmate.Fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mdarifur.tourmate.Adapter.EventList_Adapter;
import com.example.mdarifur.tourmate.Constant.Constant;
import com.example.mdarifur.tourmate.Database.EventDatabaseSource;
import com.example.mdarifur.tourmate.Model.Event_Contact;
import com.example.mdarifur.tourmate.Preference;
import com.example.mdarifur.tourmate.R;

import java.util.ArrayList;

/**
 * Created by MD.Arifur on 8/24/2016.
 */
public class EventList extends Fragment {
    TextView empty_view;
    RecyclerView eventListRV;
    RecyclerView.Adapter eventListAdapter;
    RecyclerView.LayoutManager eventListManager;
    EventDatabaseSource eventDatabaseSource;
    Preference preference;
    ArrayList<Event_Contact> event_contactsList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.content_Frame, new EventShow());
        preference = new Preference(getActivity());
        eventDatabaseSource = new EventDatabaseSource(getActivity());
        event_contactsList = eventDatabaseSource.getEvent(preference.getUserData(Constant.ID));
        View rootView = inflater.inflate(R.layout.fragment_eventlist, container, false);
        eventListManager = new LinearLayoutManager(getActivity());
        empty_view = (TextView) rootView.findViewById(R.id.empty_view);
        eventListRV = (RecyclerView) rootView.findViewById(R.id.eventListRV);
        if (event_contactsList.isEmpty()) {
            eventListRV.setVisibility(View.GONE);
            empty_view.setVisibility(View.VISIBLE);
        } else {
            eventListRV.setVisibility(View.VISIBLE);
            empty_view.setVisibility(View.GONE);
            eventListRV.setLayoutManager(eventListManager);
            eventListRV.setHasFixedSize(true);
            eventListAdapter = new EventList_Adapter(event_contactsList, getActivity(), preference, fragmentTransaction);
            eventListRV.setAdapter(eventListAdapter);
        }
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getFragmentManager().beginTransaction().replace(R.id.content_Frame, new AddEvent()).commit();
            }
        });
        return rootView;

    }


}
