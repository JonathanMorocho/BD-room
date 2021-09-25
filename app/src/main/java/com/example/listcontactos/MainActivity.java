package com.example.listcontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listcontactos.database.ContactLab;
import com.example.listcontactos.database.Contacto;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {


    private ListView list;
    private ContactLab contactoLab;
    private Button btnGuardar;
    private TextView textView;
    ContactAdapter adapter;
    ArrayList<Contacto> arrayList = new ArrayList<Contacto>();
    ArrayList<Contacto> listContacto = new ArrayList<Contacto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGuardar = findViewById(R.id.buttonGuardar);
        list = (ListView) findViewById(R.id.listView);
        textView = findViewById(R.id.textViewNoItems);
        contactoLab = new ContactLab(this);


        //ArrayAdapter adpter = new ArrayAdapter(this, android.R.layout.activity_list_item,nombres);
        //setListAdapter(adpter);

        llenarDatosCodigo();

        //lleno la lista de contacto
        if(listContacto != null && listContacto.size() > 0){
            textView.setVisibility(View.GONE);
            list.setVisibility(View.VISIBLE);
            adapter = new ContactAdapter(this, listContacto);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Contacto selectItem = (Contacto) adapter.getItem(position);
                    /*oast.makeText( MainActivity.this, "El alumno:"+ selectItem.getNombre()+"" +
                            "\nCon apellido:" +selectItem.getApellido()+ "" +
                            "\nSu direccion es:"+selectItem.getDireccion(), Toast.LENGTH_LONG).show();*/


                    //Intent intent = new Intent(MainActivity.this, DetailContact.class);
                    Intent intent = new Intent(getApplicationContext(), DetailContact.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Contacto", selectItem);
                    intent.putExtras(bundle);
                    intent.putExtra("Nombre", selectItem.getNombre());
                    intent.putExtra("Apellidos", selectItem.getApellido());
                    intent.putExtra("Direccion", selectItem.getDireccion());
                    intent.putExtra("Telefono", selectItem.getTelefono());
                    intent.putExtra("Foto", selectItem.getUrl());
                    intent.putExtra("Correo", selectItem.getEmail());
                    startActivity(intent);
                }
            });
        }else{
            list.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }



    }

    public void Registro(View view){
        Intent intent = new Intent(this, registro_user.class);
        startActivity(intent);
    }

    private void llenarDatosCodigo(){
        listContacto.clear();
        try {
            listContacto.addAll(contactoLab.getContactos());
        }catch (Exception e){

        }


    }

    // con este metodo llenos los datos desde la base de datos
    private  void llenarDatosBase(ArrayList <Contacto> list){
        list.clear();
        list.addAll(contactoLab.getContactos());
    }

    @Override
    public void onClick(View v) {
        if(btnGuardar == v){
            //Toast.makeText(this, "ok", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, registro_user.class);
            startActivity(intent);


        }
    }
    protected void onRestart(){
        super.onRestart();
        llenarDatosCodigo();
        adapter.notifyDataSetChanged();

    }
}

