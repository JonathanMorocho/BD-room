package com.example.listcontactos.database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "contacto")
public class Contacto implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "Nombre")
    private String nombre;

    @ColumnInfo(name = "Apellidos")
    private String apellido;

    @ColumnInfo(name = "Direccion")
    private String direccion;

    @ColumnInfo(name = "Email")
    private String email;

    @ColumnInfo(name = "Telefono")
    private String telefono;

    @ColumnInfo(name = "url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public Contacto(String id, String nombre, String apellido, String direccion, String email, String telefono, String url) {
//        this.id = id;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.direccion = direccion;
//        this.email = email;
//        this.telefono = telefono;
//        this.url = url;
//    }
}
