package com.example.contacosemergencia.Models;
public class Contacto {
    private String Nombre;
    private String Telefono;
    private String Parentesco;
    public Contacto(String nombre, String telefono, String parentesco) {
        this.Nombre = nombre;
        this.Telefono = telefono;
        this.Parentesco = parentesco;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }
    public String getParentesco() {
        return Parentesco;
    }
    public void setParentesco(String parentesco) {
        this.Parentesco = parentesco;
    }
@Override
    public String toString(){
    return Nombre + " " + Telefono + " " + Parentesco + " ";
}

}
