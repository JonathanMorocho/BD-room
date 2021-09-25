package com.example.listcontactos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.listcontactos.database.ContactLab;
import com.example.listcontactos.database.Contacto;

public class DetailContact extends AppCompatActivity implements View.OnClickListener {

    private TextView Nombre, Telefono,Ciudad, Descripcion;
    private ImageView imagen;
    private Button btnEliminar;
    private ContactLab contactLab;
    Contacto contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_contact);

        //Obtener los datos
        String direccion = getIntent().getStringExtra("Direccion");
        String nombre = getIntent().getStringExtra("Nombre");
        String apellidos = getIntent().getStringExtra("Apellidos");
        String telefono = getIntent().getStringExtra("Telefono");
        String foto = getIntent().getStringExtra("Foto");
        String correo = getIntent().getStringExtra("Correo");

        //ubicacion = findViewById(R.id.deta)
        imagen = findViewById(R.id.detailContactImage);
        Nombre = findViewById(R.id.detailContactName);
        Ciudad = findViewById(R.id.detailContactCity);
        Descripcion = findViewById(R.id.detailContactDescription);
        Telefono = findViewById(R.id.detailContactNumber);
        Descripcion = findViewById(R.id.detailContactDescription);
        btnEliminar = findViewById(R.id.eliminar);

        btnEliminar.setOnClickListener(this);

        Nombre.setText(nombre +" "+ apellidos+"\n");
        Telefono.setText(telefono);
        Ciudad.setText(direccion);
        Descripcion.setText(correo);
        Glide.with(this)
                .load(foto)
                .into(imagen);
    }


    @Override
    public void onClick(View v) {
        if (btnEliminar == btnEliminar){
            contactLab.eliminar(contact);
            Toast.makeText(this, "Eliminar", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

}
