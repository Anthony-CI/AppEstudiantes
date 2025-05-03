package com.upn.appestudiantes;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.upn.appestudiantes.Access.DAOEstudiante;
import com.upn.appestudiantes.Model.Estudiante;

public class ActividadRegistrar extends AppCompatActivity {


    private TextInputEditText txtNombreEstudiante;
    private AutoCompleteTextView txtTipoCarrera;
    private MaterialRadioButton rbFemenino,rbMasculino;
    private MaterialCheckBox cbxNinguno;

    private MaterialCheckBox cbxCarreTe;

    private String[] vTipoCarrera = {"Ingenieria Sistemas","Derecho","Medicina"};

    private FloatingActionButton btnGrabar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.lyregistrar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Relacionar con la interfaz

        txtNombreEstudiante=findViewById(R.id.txtNombreEstudiante);
        txtTipoCarrera=findViewById(R.id.spListaCarrera);
        rbFemenino = findViewById(R.id.rbFemenino);
        rbMasculino = findViewById(R.id.rbMasculino);
        cbxNinguno = findViewById(R.id.cbxNinguno);
        cbxCarreTe=findViewById(R.id.cbxCarreTe);


        btnGrabar = findViewById(R.id.FAB);

        txtTipoCarrera.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,
                vTipoCarrera));


        //crear un disparador
        btnGrabar.setOnClickListener(v-> {
            grabarObjetoEmergencia();
        });

    }

    private  void  grabarObjetoEmergencia(){
        //validar
        if(txtNombreEstudiante.getText().toString().isEmpty()){
            txtNombreEstudiante.setError("Campo Nombre es obligatorio ");
            txtNombreEstudiante.requestFocus();
            return;
        }
        if(txtTipoCarrera.getText().toString().isEmpty()){
            txtTipoCarrera.setError("Campo  es obligatorio ");
            txtTipoCarrera.requestFocus();
            return;
        }

        if ( ! (rbFemenino.isChecked() || rbMasculino.isChecked()) ) { //cuando ningun radiobuton este seleccionado
            Toast.makeText(this,"Seleccione Sexo",Toast.LENGTH_LONG).show();
            rbFemenino.setChecked(true);
            return;
        }

        //capturar en varibles los datos ingresados por el usuario
        String txtNombre = txtNombreEstudiante.getText().toString();
        String tipoCarrera= txtTipoCarrera.getText().toString();
        String sexo= "";
        if (rbFemenino.isChecked()){
            sexo="Femenino";
        } else if (rbMasculino.isChecked()) {
            sexo="Masculino";
        }

        boolean ninguno = cbxNinguno.isChecked();
        boolean carreraTec= cbxCarreTe.isChecked();

        //Crear modelo antes de crear el objeto y a la par DAO
        Estudiante oE = new Estudiante(txtNombre,tipoCarrera,sexo,ninguno,carreraTec);

        //Utilizar la clase DAOEstudiante para registrar objetoEstudiante a la lista
        DAOEstudiante.getInstacia().insertarEstudiante(oE);
        Toast.makeText(this,"Registro Aceptado",Toast.LENGTH_LONG).show();
        CuadroDialogo();
    }

    private void CuadroDialogo() {
        AlertDialog.Builder oDialogo = new AlertDialog.Builder(this);
        oDialogo.setTitle("Aviso");
        oDialogo.setMessage("¿Desea seguir Registarndo Estudiante?");
        oDialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ActividadRegistrar.this.finish();
            }
        });
        oDialogo.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                limpiar();
            }
        });
        oDialogo.show();
    }

    private void limpiar() {
        txtNombreEstudiante.setText("");
        txtTipoCarrera.setText("");
        rbFemenino.setChecked(false);
        rbMasculino.setChecked(false);

        cbxNinguno.setChecked(false);
        cbxCarreTe.setChecked(false);
    }


}