package com.edu.isc.tesoem.francisco.finaltesoem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gvDatos;
    EditText txtnombre, txtmatricula, txtcorreo, txtpromediofinal;
    List<Datos> datos = new ArrayList<>();
    AdaptadorBase adaptadorBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvDatos =findViewById(R.id.gvDatos);
        txtnombre = findViewById(R.id.txtNombre);
        txtmatricula = findViewById(R.id.txtMatricula);
        txtcorreo = findViewById(R.id.txtCorreo);
        txtpromediofinal = findViewById(R.id.txtPromediofinal);

        Verifica();

        gvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Datos dato = (Datos) adaptadorBase.getItem(position);
                DatosParcelable datosParcelable = new DatosParcelable(dato.getNombre(),dato.getMatricula(),dato.getCorreo(),dato.getPromediofinal());
                Intent intent = new Intent(MainActivity.this, DetallesActivity2.class);
                intent.putExtra("Nombre",dato.getNombre());
                intent.putExtra("DatosParcelable",datosParcelable);
                startActivity(intent);
            }
        });
    }

    public void Verifica(){
        Almacen conexion = new Almacen();

        if (conexion.Existe(this)){
            if (conexion.Leer(this)){
                datos = conexion.getDatos();
                adaptadorBase = new AdaptadorBase(datos,this);
                gvDatos.setAdapter(adaptadorBase);
            }else{
                Toast.makeText(this, "No se pudo leer la informacion", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "No existe el archivo , favor de grabar informacion", Toast.LENGTH_SHORT).show();
        }
    }

    public void Registra(View v){
        Datos dato = new Datos();
        Almacen conexion = new Almacen();

        dato.setNombre(txtnombre.getText().toString());
        dato.setMatricula(txtmatricula.getText().toString());
        dato.setCorreo(txtcorreo.getText().toString());
        dato.setPromediofinal(txtpromediofinal.getText().toString());

        datos.add(dato);
        if (conexion.Escribir(this,datos)){
            Toast.makeText(this, "Se escribieron correctamente", Toast.LENGTH_SHORT).show();
            Verifica();
        }else{
            Toast.makeText(this, "Error al escribir..", Toast.LENGTH_SHORT).show();
        }

    }
}