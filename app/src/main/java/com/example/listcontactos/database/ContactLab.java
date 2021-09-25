package com.example.listcontactos.database;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class ContactLab     {

    @SuppressLint("StaticFieldLeak")
    private static ContactLab sContactoLab;

    private ContactDAO mContactoDAO;

    public ContactLab(Context context){
        Context appContext = context.getApplicationContext();
        ContactDataBase dataBase = Room.databaseBuilder(appContext, ContactDataBase.class, "Contacto")
                .allowMainThreadQueries().build();
        mContactoDAO = dataBase.getContactDAO();
    }

    public static ContactLab get(Context context){
        if(sContactoLab == null){
            sContactoLab = new ContactLab(context);
        }
        return sContactoLab;
    }

    public List<Contacto> getContactos(){
        return mContactoDAO.getContactos();
    }

    public Contacto getContacto(String n){
        return mContactoDAO.getContato(n);
    }

    public void addContacto(Contacto c){
        mContactoDAO.addContacto(c);
    }

    public void delete(Contacto c){
        mContactoDAO.deleteContacto(c);
    }


}
