package com.example.kirubasanam;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
        private static final String DATABASE_NAME="kjv.db";
        private static final int DATABASE_VERSION =1;

    //constructor

    public DatabaseOpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
}
