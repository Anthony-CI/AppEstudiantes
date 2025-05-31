package com.upn.appestudiantes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upn.appestudiantes.Access.DAOEstudiante;
import com.upn.appestudiantes.Access.DAOEstudianteBD;
import com.upn.appestudiantes.Model.Estudiante;
import com.upn.appestudiantes.Model.EstudianteDB;

public class ActividadMostrar extends AppCompatActivity {

    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.lymostrar);

        Toolbar toolbar = findViewById(R.id.tbMostrar);
        setSupportActionBar(toolbar);
        //se modifica el archivo manifieto para mostrar la flecha de regreso
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lista = findViewById(R.id.lvListaEstudiante);
        /*
        lista.setAdapter(new ArrayAdapter<Estudiante>(this,
                android.R.layout.simple_list_item_1,
                DAOEstudiante.getInstacia().mostrarEstudiante()));

         */

        DAOEstudianteBD oBD = new DAOEstudianteBD(this);
        lista.setAdapter(new ArrayAdapter<EstudianteDB>(this,
                android.R.layout.simple_list_item_1,
                oBD.getListadoEmergencia()));

    }
}