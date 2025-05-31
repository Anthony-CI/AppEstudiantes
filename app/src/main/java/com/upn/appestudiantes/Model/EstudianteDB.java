package com.upn.appestudiantes.Model;

import androidx.annotation.NonNull;

public class EstudianteDB {
    private int IdEstudiante;
    private String NombreEstudiante;
    private String tipoCarrera;
    private String sexo;
    private boolean  ninguno;

    private boolean carreraTec;


    public EstudianteDB(String nombreEstudiante, String tipoCarrera, String sexo, boolean ninguno, boolean carreraTec) {
        NombreEstudiante = nombreEstudiante;
        this.tipoCarrera = tipoCarrera;
        this.sexo = sexo;
        this.ninguno = ninguno;
        this.carreraTec = carreraTec;
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
    public String toString() {
        return NombreEstudiante+": "+tipoCarrera+" Sexo "+sexo+" y "+(ninguno?"es":"no es")+" Ninguno"+(carreraTec?"es":"no es")+" CarreraTecnica";
    }


}
