package com.example.mdarifur.tourmate.Adapter;

import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mdarifur.tourmate.Constant.Constant;
import com.example.mdarifur.tourmate.Fragment.AddEvent;
import com.example.mdarifur.tourmate.Model.Event_Contact;
import com.example.mdarifur.tourmate.Preference;
import com.example.mdarifur.tourmate.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MD.Arifur on 8/25/2016.
 */
public class EventList_Adapter extends RecyclerView.Adapter<EventList_Adapter.RecyclerViewholder> {
    ArrayList<Event_Contact> arrayList = new ArrayList<>();
    Context context;
    Preference preference;
    FragmentTransaction fragmentTransaction;
    public EventList_Adapter(ArrayList<Event_Contact> arrayList, Context context, Preference preference, FragmentTransaction fragmentTransaction) {
        this.context=context;
        this.arrayList = arrayList;
        this.preference = preference;
        this.fragmentTransaction = fragmentTransaction;
    }

    @Override
    public RecyclerViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_event_list,parent,false);
        RecyclerViewholder recyclerViewholder = new RecyclerViewholder(view,this.context,this.arrayList,this.preference,this.fragmentTransaction);
        return recyclerViewholder;
    }


    @Override
    public void onBindViewHolder(RecyclerViewholder holder, int position) {
        Event_Contact Event_Contact = arrayList.get(position);
        holder.nameEL.setText(Event_Contact.getEventname());
        holder.placeEL.setText(Event_Contact.getTo());
        holder.startEL.setText(Event_Contact.getStartJourney());
        holder.endEL.setText(Event_Contact.getEndjourney());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nameEL,placeEL,startEL,endEL;
        ArrayList<Event_Contact> event_contacts= new ArrayList<Event_Contact>();
        Context context;
        Preference preference;
        FragmentTransaction fragmentTransaction;
        public RecyclerViewholder(View itemView,Context context,ArrayList<Event_Contact> event_contacts,Preference preference,FragmentTransaction fragmentTransaction) {
            super(itemView);
            this.event_contacts = event_contacts;
            this.context = context;
            this.preference = preference;
            this.fragmentTransaction = fragmentTransaction;
            itemView.setOnClickListener(this);
            nameEL = (TextView) itemView.findViewById(R.id.name_eventTV);
            placeEL = (TextView) itemView.findViewById(R.id.place_eventTV);
            startEL = (TextView) itemView.findViewById(R.id.start_eventTV);
            endEL = (TextView) itemView.findViewById(R.id.end_eventTV);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Event_Contact eventContact = this.event_contacts.get(position);
            this.preference.saveUserData(Constant.EVENT_ID,String.valueOf(eventContact.getEventid()));
            this.preference.saveUserData(Constant.EVENT_NAME,eventContact.getEventname());
            this.preference.saveUserData(Constant.EVENT_TO,eventContact.getTo());
            this.preference.saveUserData(Constant.START_JOURNEY,eventContact.getStartJourney());
            this.preference.saveUserData(Constant.END_JOURNEY,eventContact.getEndjourney());
            this.preference.saveUserData(Constant.EVENT_BUDGET,eventContact.getEventbudget());
            this.preference.saveUserData(Constant.CLIENT_EVENT_ID,eventContact.getClinteventId());
            fragmentTransaction.commit();
        }
    }
}
