package com.example.myapplication;



import android.content.Context;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;



public class Conexao extends SQLiteOpenHelper {

    private static final String nome = "banco.db";

    private static final int version = 1;



    public Conexao(Context context){

        super(context, nome, null, version);

    }



    @Override

    public void onCreate(SQLiteDatabase db){

        db.execSQL("create table cliente(" +

                "id integer primary key autoincrement, " + "" +

                "matricula varchar(50), " +

                "nome varchar(50), " +

                "endereco varchar(50), " +

                "numero varchar(50), " +

                "complemento varchar(50), " +

                "cidade varchar(50))");

    }



    @Override

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){



    }

}