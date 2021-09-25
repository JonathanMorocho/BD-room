package com.example.listcontactos.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {

    @Query("SELECT * FROM contacto")
    List<Contacto> getContactos();

    @Query("SELECT * FROM CONTACTO WHERE id LIKE :uuid")
    Contacto getContato(String uuid);

    @Insert
    void addContacto(Contacto c);

    @Delete
    void deleteContacto(Contacto c);

    @Update
    void updateContacto(Contacto c);

    @Query("DELETE FROM CONTACTO")
    void deleteAllContacto();

}
