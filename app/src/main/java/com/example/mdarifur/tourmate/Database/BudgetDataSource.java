package com.example.mdarifur.tourmate.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mdarifur.tourmate.Model.Budget;
import com.example.mdarifur.tourmate.Model.PhotoData;

/**
 * Created by MD.Arifur on 8/26/2016.
 */
public class BudgetDataSource {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private PhotoData photoData;

    public BudgetDataSource(Context context) {
        databaseHelper=new DatabaseHelper(context);
    }

    public void open(){
        database=databaseHelper.getWritableDatabase();
    }
    public void close(){
        databaseHelper.close();
    }

    public boolean addBudget(Budget budget){
        this.open();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.budget_cost,budget.getCost());
        contentValues.put(DatabaseHelper.budget_EventID,budget.getEventID());
        long inserted=database.insert(DatabaseHelper.TABLE_BUDGET,null,contentValues);
        this.close();
        if(inserted>0){
            return true;
        }else {
            return false;
        }
    }
    public int getTotalSpend(String eventID){
        this.open();
        int amount;
        Cursor c = database.rawQuery("select sum("+DatabaseHelper.budget_cost+") from "+DatabaseHelper.TABLE_BUDGET+" where "+DatabaseHelper.budget_EventID+" = "+eventID+" ;", null);
        if(c.moveToFirst())
            amount = c.getInt(0);
        else
            amount = -1;
        c.close();
        return amount;
    }

}
