package model;

public class Cliente {
    private String nombre;
    private String direccion;
    private int numeroTelefonico;
    private String correoElectronico;
    private String rut;

    public Cliente(String nombre, String direccion, int numeroTelefonico, String correoElectronico, String rut) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroTelefonico = numeroTelefonico;
        this.correoElectronico = correoElectronico;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(int numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String toString(){
        return nombre+","+direccion+","+numeroTelefonico+","+correoElectronico+","+rut;
    }
}