package com.example.mdarifur.tourmate.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mdarifur.tourmate.R;

/**
 * Created by MD.Arifur on 8/24/2016.
 */
public class AddEvent extends Fragment {
    int year_s,day_s,month;
    static final int DIALOG_ID=0;

    Button addEventBT;
    TextView eventNameET,toET,startjourneyET,endjourneyET,budgetET;
    String eventName,to,startjourney,endjourney,budget;
    View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_addevent, container, false);
        getInstance(rootView);
        return rootView;
    }
    private void getInstance(View rootView){
        eventNameET = (TextView) rootView.findViewById(R.id.evetNameET);
        toET = (TextView) rootView.findViewById(R.id.toET);
        startjourneyET = (TextView) rootView.findViewById(R.id.startjourneyET);
        endjourneyET = (TextView) rootView.findViewById(R.id.endjourneyET);
        budgetET = (TextView) rootView.findViewById(R.id.budgetET);
        addEventBT = (Button) rootView.findViewById(R.id.addeventBTN);
        addEventBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInstance();
                Toast.makeText(getActivity(), eventName+" "+to, Toast.LENGTH_LONG).show();
            }
        });
    }
    private void setInstance(){
        eventName = eventNameET.getText().toString();
        to = toET.getText().toString();
        startjourney = startjourneyET.getText().toString();
        endjourney = endjourneyET.getText().toString();
        budget = budgetET.getText().toString();
    }
    /*
    public Dialog onCreateDialog(int id){
        if(id == DIALOG_ID){
            return new DatePickerDialog(getActivity())
        }

    }
    */

}
