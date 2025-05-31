package com.upn.appestudiantes.Access;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDOpenHelper extends SQLiteOpenHelper {
    String tabla_estudiante="CREATE TABLE Estudiante(IdEstudiante INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
            " NombreEstudiante VARCHAR(100) NOT NULL,tipoCarrera VARCHAR(20) NOT NULL,"+
            " sexo VARCHAR(20) NOT NULL,ninguno INTEGER NOT NULL,carreraTec INTEGER NOT NULL)";


    public BDOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla_estudiante);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Estudiante");
        db.execSQL(tabla_estudiante);
    }
}
