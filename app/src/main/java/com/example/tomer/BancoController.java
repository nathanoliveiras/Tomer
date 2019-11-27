package com.example.tomer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tomer.database.DataOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BancoController {
    private SQLiteDatabase db;
    private DataOpenHelper banco;
    public BancoController(Context context){
        banco = new DataOpenHelper(context);
    }
    public void insereDado(String conteudo){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DataOpenHelper.getCONTEUDO(), conteudo);
        valores.put(DataOpenHelper.getPONTOS(), 0);
        resultado = db.insert(DataOpenHelper.getTABELA(), null, valores);
        db.close();
    }

    public List<Frase> carregaDados(){
        Cursor cursor;

        List<Frase> frases = new ArrayList<>();
        String[] campos = {DataOpenHelper.getID(),DataOpenHelper.getPONTOS(),DataOpenHelper.getCONTEUDO()};

        db = banco.getReadableDatabase();
        cursor = db.query(DataOpenHelper.getTABELA(), campos, null, null, null, null, null, null);
        int iid = cursor.getColumnIndex(DataOpenHelper.getID());
        int ipontos = cursor.getColumnIndex(DataOpenHelper.getPONTOS());
        int iconteudo = cursor.getColumnIndex(DataOpenHelper.getCONTEUDO());

        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            int id = cursor.getInt(iid);
            int pontos = cursor.getInt(ipontos);
            String conteudo = cursor.getString(iconteudo);
            frases.add(new Frase(id, conteudo,pontos));
        }
        
        db.close();

        return frases;
    }

    public void alteraRegistro(int id, int pontos)
    {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = DataOpenHelper.getID() + "=" + id;

        valores = new ContentValues();
        valores.put(DataOpenHelper.getPONTOS(), pontos);

        db.update(DataOpenHelper.getTABELA(),valores,where,null);
        db.close();
    }
}