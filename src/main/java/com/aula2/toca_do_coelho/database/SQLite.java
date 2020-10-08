package com.aula2.toca_do_coelho.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {

    private static SQLite INSTACIA_CONEXAO;
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "toca_do_coelho";

    public SQLite(Context context){
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlTableBebida =
                "CREATE TABLE IF NOT EXISTS bebida" +
                        "("+
                        "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "nome TEXT,"+
                        "valor REAL,"+
                        "descricao TEXT"+
                        ");";

        sqLiteDatabase.execSQL(sqlTableBebida);

        insertBebiba(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public static void insertBebiba(SQLiteDatabase bbd){
        ContentValues drink = new ContentValues();
        ContentValues drink1 = new ContentValues();
        ContentValues drink2 = new ContentValues();

        drink.put("nome", "Shopp do Bom");
        drink.put("valor", 10.5);
        drink.put("descricao", "copo(400ml) de Shopp da marca xxx");


        drink.put("nome", "Suco de Cana");
        drink.put("valor", 7);
        drink.put("descricao", "copo(400ml) caxaxa artesanal");


        drink.put("nome", "Uvinho");
        drink.put("valor", 8.5);
        drink.put("descricao", "copo(400ml) Vinho Branco");


        bbd.insert("bebida",null, drink);

        bbd.insert("bebida",null, drink1);

        bbd.insert("bebida",null, drink2);


    }
}
