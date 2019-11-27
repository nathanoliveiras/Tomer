package com.example.tomer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataOpenHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "DB_TOMER";
    private static final String TABELA = "TABELA";
    private static final String  ID = "_id";
    private static final String  CONTEUDO = "conteudo";
    private static final String  PONTOS = "_pontos";
    private static final int  VERSAO = 1;

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getID() {
        return ID;
    }

    public static String getCONTEUDO() {
        return CONTEUDO;
    }

    public static String getPONTOS() {
        return PONTOS;
    }

    public static int getVERSAO() {
        return VERSAO;
    }


    public DataOpenHelper(Context context) {
        super(context, getNomeBanco(), null, getVERSAO());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "
                + TABELA +"("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CONTEUDO +" text,"
                + PONTOS +" text"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA);
        onCreate(db);
    }
}
