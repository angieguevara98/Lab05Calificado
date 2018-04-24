package practica.edu.pe.lab05_calificado.Models;

public class Producto {
    public Producto(String name, String phone, String picture, String descripcion) {
        this.name = name;
        this.phone = phone;
        this.picture = picture;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "producto{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", picture='" + picture + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    private  String name;
    private String phone;
    private String picture;
    private String descripcion;



    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


}