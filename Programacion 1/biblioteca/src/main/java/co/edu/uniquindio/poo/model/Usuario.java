package co.edu.uniquindio.poo.model;

public class Usuario {
    private String nombre;
    private String id;
    private String correo;

    public Usuario (String nombre, String id, String correo){
        this.nombre=nombre;
        this.id=id;
        this.correo=correo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

}
