package com.upn.appestudiantes.Access;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.upn.appestudiantes.Model.EstudianteDB;

import java.util.ArrayList;
import java.util.List;

public class DAOEstudianteBD {
    private String nombreBD;
    private int version;
    private BDOpenHelper oBDConstructor;

    public DAOEstudianteBD(Activity contexto) {
        this.nombreBD = "BDEstudiante";
        this.version = 1;
        this.oBDConstructor = new BDOpenHelper(contexto,nombreBD,null,version);
    }

    public String addEstudianteBD(EstudianteDB oE){
        String rpta="";
        SQLiteDatabase oBD = oBDConstructor.getWritableDatabase();
        ContentValues oColumnas = new ContentValues();
        oColumnas.put("NombreEstudiante",oE.getNombreEstudiante());
        oColumnas.put("tipoCarrera",oE.getTipoCarrera());
        oColumnas.put("sexo",oE.getSexo());
        // 0 = Verdadero, 1 = Falso
        oColumnas.put("ninguno",oE.isNinguno()?0:1);
        oColumnas.put("carreraTec",oE.isCarreraTec()?0:1);

        long fila=oBD.insert("Estudiante",null,oColumnas);
        if(fila>0)
            rpta="OK";
        else
            rpta="Error: Registro inválido";
        oBD.close();
        return rpta;
    }
    public List<EstudianteDB> getListadoEmergencia(){
        List<EstudianteDB> lista = new ArrayList<EstudianteDB>();
        SQLiteDatabase oBD = oBDConstructor.getReadableDatabase();
        String sql = "SELECT * FROM Estudiante";
        Cursor oRegistros = oBD.rawQuery(sql,null);
        if(oRegistros.moveToFirst()){
            do {
                String NombreEstudiante = oRegistros.getString(1);
                String tipoCarrera = oRegistros.getString(2);
                String sexo = oRegistros.getString(3);
                boolean ninguno = oRegistros.getInt(4) == 0 ? true : false;
                boolean carreraTec = oRegistros.getInt(4) == 0 ? true : false;
                EstudianteDB oE = new EstudianteDB(NombreEstudiante, tipoCarrera,
                        sexo, ninguno, carreraTec);
                lista.add(oE);
            }while (oRegistros.moveToNext());
            oBD.close();
            oRegistros.close();
        }
        return lista;
    }
}
