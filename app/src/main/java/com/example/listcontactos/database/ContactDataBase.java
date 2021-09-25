package com.example.listcontactos.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Contacto.class },version = 1)
public abstract class ContactDataBase extends RoomDatabase {

    public abstract ContactDAO getContactDAO();

}
