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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView list;
    private ContactLab contactoLab;
    private Button btnGuardar;
    private TextView textView;
    ContactAdapter adapter;
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

        llenarDatosBD();//lleno la lista de contacto
        if(listContacto != null && listContacto.size() > 0){
            textView.setVisibility(View.GONE);
            list.setVisibility(View.VISIBLE);
            adapter = new ContactAdapter(this, listContacto);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Contacto selectItem = (Contacto) adapter.getItem(position);
                    Toast.makeText( MainActivity.this, "El alumno:"+ selectItem.getNombre()+"" +
                            "\nCon apellido:" +selectItem.getApellido()+ "" +
                            "\nSu direccion es:"+selectItem.getDireccion(), Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, DetailContact.class);
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
        }



    }

    private void llenarDatosCodigo(ArrayList<Contacto> list){
//        Contacto contacto1 = new Contacto();
//        contacto1.setNombre("Jonathan");
//        contacto1.setApellido("Morocho");
//        contacto1.setDireccion("El valle");
//        contacto1.setEmail("jamorocho@tecnologicoloja.edu.ec");
//        contacto1.setTelefono("0969084769");
//        contacto1.setUrl("https://image.flaticon.com/icons/png/512/3447/3447687.png");
//        list.add(contacto1);
//
//        Contacto contacto2 = new Contacto();
//        contacto2.setNombre("Soviet");
//        contacto2.setApellido("Cabrera");
//        contacto2.setDireccion("Las Pitas");
//        contacto2.setEmail("sfcabrera@tecnologicoloja.edu.ec");
//        contacto2.setTelefono("0965487985");
//        contacto2.setUrl("https://img-premium.flaticon.com/png/512/3772/3772240.png?token=exp=1631107869~hmac=5ec826b1fe0f754f1ac2ab39f9c378d9");
//        list.add(contacto2);
//
//        Contacto contacto3 = new Contacto();
//        contacto3.setNombre("Carlos");
//        contacto3.setApellido("Caceves");
//        contacto3.setDireccion("Carigan");
//        contacto3.setEmail("cacaceres@tecnologicoloja.edu.ec");
//        contacto3.setTelefono("0952236541");
//        contacto3.setUrl("https://image.flaticon.com/icons/png/512/2991/2991633.png");
//        list.add(contacto3);
//
//        Contacto contacto4 = new Contacto();
//        contacto4.setNombre("Ignacio");
//        contacto4.setApellido("Jumbo");
//        contacto4.setDireccion("El Plateado");
//        contacto4.setEmail("ijjumbo@tecnologicoloja.edu.ec");
//        contacto4.setTelefono("0958744455");
//        contacto4.setUrl("https://image.flaticon.com/icons/png/512/3298/3298123.png");
//        list.add(contacto4);
    }

    public void Registro(View view){
        Intent intent = new Intent(this, registro_user.class);
        startActivity(intent);
    }

    private void llenarDatosBD(){
        listContacto.clear();
        try {
            listContacto.addAll(contactoLab.getContactos());
        }catch (Exception e){

        }


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        llenarDatosBD();
//        adapter.notifyDataSetChanged();

    }

    private void eliminarContacto(Contacto contact, int posicion){
        listContacto.remove(posicion);
        contactoLab.deletePersona(contact);
        adapter.notifyDataSetChanged();
    }

    private void eliminarTodo(){
        listContacto.clear();
        contactoLab.deleteAllPersona();
        adapter.notifyDataSetChanged();
    }
}