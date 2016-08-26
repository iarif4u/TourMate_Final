package com.example.mdarifur.tourmate.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mdarifur.tourmate.Constant.Constant;
import com.example.mdarifur.tourmate.Database.BudgetDataSource;
import com.example.mdarifur.tourmate.Model.Budget;
import com.example.mdarifur.tourmate.Preference;
import com.example.mdarifur.tourmate.R;
import com.example.mdarifur.tourmate.TimeAndDate.DateOperation;

/**
 * Created by MD.Arifur on 8/26/2016.
 */
public class Expend extends Fragment {

    BudgetDataSource budgetDataSource;
    Preference preference;
    Button updatebtn;
    TextView totalBudget, spendTV, remainingTV,addTV;
    EditText addSpend;
    String eventID, spend;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_expend, container, false);
        totalBudget = (TextView) rootView.findViewById(R.id.totalBudget);
        spendTV = (TextView) rootView.findViewById(R.id.spendTV);
        remainingTV = (TextView) rootView.findViewById(R.id.remainingTV);
        addTV = (TextView) rootView.findViewById(R.id.addTV);
        addSpend = (EditText) rootView.findViewById(R.id.addSpend);
        updatebtn = (Button) rootView.findViewById(R.id.updatebtn);
        preference = new Preference(getActivity());
        if (isUpdate()==false){
            updatebtn.setVisibility(View.GONE);
            addSpend.setVisibility(View.GONE);
            addSpend.setVisibility(View.GONE);
            addTV.setVisibility(View.GONE);
        }
        Calculation();
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spend = addSpend.getText().toString();
                if (spend.length() == 0) {
                    Toast.makeText(getActivity(), "Invalid Entry", Toast.LENGTH_SHORT).show();
                } else {
                    boolean result = budgetDataSource.addBudget(new Budget(spend, eventID));
                    if (result == true) {
                        addSpend.setText("");
                        Calculation();
                        Toast.makeText(getActivity(), "Update Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Update Fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return rootView;
    }

    private void Calculation() {
        budgetDataSource = new BudgetDataSource(getActivity());
        eventID = preference.getUserData(Constant.EVENT_ID);
        String totalAmount = preference.getUserData(Constant.EVENT_BUDGET);
        int totalSpend = budgetDataSource.getTotalSpend(eventID);
        int remaining = Integer.parseInt(totalAmount) - totalSpend;

        totalBudget.setText(totalAmount);
        spendTV.setText(String.valueOf(totalSpend));
        remainingTV.setText(String.valueOf(remaining));
    }

    private boolean isUpdate() {
        DateOperation dateOperation = new DateOperation();
        String current = dateOperation.getCurrentDate();
        String start = preference.getUserData(Constant.START_JOURNEY);
        String end = preference.getUserData(Constant.END_JOURNEY);
        long currentTimeStamp = dateOperation.getTimestamp(current);
        long startTimeStamp = dateOperation.getTimestamp(start);
        long endTimeStamp = dateOperation.getTimestamp(end);
        if (startTimeStamp <= currentTimeStamp && currentTimeStamp <= endTimeStamp) {
            return true;
        } else {
            return false;
        }

    }
}
