package com.example.kirubasanam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAcess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAcess instance;
    Cursor c = null;

    //private Constructor so that object creation from outside the class is avoided
    private DatabaseAcess(Context context){
        this.openHelper=new DatabaseOpenHelper(context);

    }
    //to return the single instance of database
    public static DatabaseAcess getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAcess(context);
        }
        return instance;
    }
    //to open the database
    public void open(){
        this.db=openHelper.getWritableDatabase();
    }
    //closing the database connection

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }
    // create a method to query and return the result from database
    //query for address by passing names
    public String getAdress(String name){
        c=db.rawQuery("select booknames from configuration",null);
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String address = c.getString(0);
            buffer.append(""+address);
        }
        return buffer.toString();
    }
}
