package com.edu.isc.tesoem.francisco.finaltesoem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetallesActivity2 extends AppCompatActivity {

    TextView lblnombre, lblmatricula, lblcorreo, lblpromediofinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles2);

        lblnombre = findViewById(R.id.dlblNombre);
        lblmatricula = findViewById(R.id.dlblMatricula);
        lblcorreo = findViewById(R.id.dlblCorreo);
        lblpromediofinal = findViewById(R.id.dlblPromediofinal);

        String nombre = getIntent().getExtras().get("Nombre").toString();
        DatosParcelable dato = getIntent().getParcelableExtra("DatosParcelable");

        lblnombre.setText(dato.getNombre());
        lblmatricula.setText(dato.getMatricula());
        lblcorreo.setText(dato.getCorreo());
        lblpromediofinal.setText(dato.getPromediofinal());

        getSupportActionBar().setTitle(nombre);
    }
}