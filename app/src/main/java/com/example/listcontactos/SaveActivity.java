package com.example.listcontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listcontactos.database.Contacto;

public class SaveActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    TextView txtNombre;
    TextView txtApellido;
    TextView txtDireccion;
    TextView txtDescripcion;
    TextView txtTelefono;
    Button btnGuardar;
    Contacto contacto;
//    private String contacto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
    }

    public void guardarBD() {
        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();
        String direccion = txtDireccion.getText().toString();
        String descripcion = txtDescripcion.getText().toString();
        String telefono = txtTelefono.getText().toString();

//        if (!nombre.isEmpty()) {
//            contacto = new Contacto();
//            contacto.setNombre(txtNombre.getText().toString());
//            contacto.setApellido(txtApellido.getText().toString());
//            contacto.setDireccion(txtDireccion.getText().toString());
//            contacto.setEmail(txtDescripcion.getText().toString());
//            contacto.setTelefono(txtTelefono.getText().toString());
//            contacto.addContacto(contacto);
//            String id = database.push().getKey();
//            contacto = new Contacto(id, nombre, apellido, direccion, descripcion, telefono, "");
//            database.child("Datos").child(id).setValue(contacto);
//            Toast.makeText(this, "Guardado con exito", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
//        }

    }

//    @Override
//    public void onClick(View v) {
//        if(btnGuardar == v){
//            guardarBD();
//            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this, "ELSEEE", Toast.LENGTH_SHORT).show();
//        }
//    }
}