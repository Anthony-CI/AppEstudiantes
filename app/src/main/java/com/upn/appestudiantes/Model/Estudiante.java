package com.upn.appestudiantes.Model;

import androidx.annotation.NonNull;

public class Estudiante {


    private String NombreEstudiante;
    private String tipoCarrera;
    private String sexo;
    private boolean  ninguno;

    private boolean carreraTec;

    public Estudiante(String NombreEstudiante,String tipoCarrera, String sexo, boolean ninguno , boolean carreraTec){
        this.NombreEstudiante = NombreEstudiante;
        this.tipoCarrera = tipoCarrera;
        this.sexo = sexo;
        this.ninguno = ninguno;
        this.carreraTec= carreraTec;
    }

    public String getNombreEstudiante() {
        return NombreEstudiante;
    }

    public String getTipoCarrera() {
        return tipoCarrera;
    }

    public String getSexo() {
        return sexo;
    }

    public boolean isNinguno() {
        return ninguno;
    }

    public boolean isCarreraTec() {
        return carreraTec;
    }

    @NonNull
    @Override

    public  String toString(){
        return NombreEstudiante+" : "+
                "Carrera " + " :" +
                tipoCarrera + ": "+
                "sexo " +" " + sexo +
                "  " + (ninguno? " Ninguno " : "  ") +
                " " +"  " +
                (carreraTec? "Carrera Técnica" : "" );
    }
}
