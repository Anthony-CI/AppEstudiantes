package com.upn.appestudiantes.Access;

import com.upn.appestudiantes.Model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class DAOEstudiante {

    public static DAOEstudiante instacia;

    private List<Estudiante> lista;

    public DAOEstudiante(){
        lista = new ArrayList<>();
    }

    public static  DAOEstudiante getInstacia(){
        if(instacia == null){
            instacia = new DAOEstudiante();
        }
        return  instacia;
    }

    public void insertarEstudiante(Estudiante oE){
        lista.add(oE);
    }

    public List<Estudiante> mostrarEstudiante(){
        return lista;
    }


}
