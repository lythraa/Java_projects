package co.edu.uniquindio.poo.model;

public class Contacto {
    private String nombres;
    private String alias;
    private String direccion;
    private String telefono;
    private String email;
    private int edad;

    //constructor
    public Contacto(String nombres, String alias, String direccion, String telefono, String email, int edad){
        this.nombres = nombres;
        this.alias = alias;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
    }

    //getters  y setters
    /**
     * Obtener nombres del contacto
     * @return nombres
     */
    public String getNombres() {
        return nombres;
    }


    /**
     * Cambiar nombres del contacto
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    /**
     * Obtener alias del contacto
     * @return alias
     */
    public String getAlias() {
        return alias;
    }


    /**
     * Cambiar alias del contacto
     * @param alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }


    /**
     * Obtener direccion del contacto
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }


    /**
     * Cambiar direccion del contacto
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    /**
     * Obtener telefono del contacto
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }


    /**
     * Cambiar telefono del contacto
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    /**
     * Obtener email del contacto
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Cambiar email del contacto
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    


    @Override
    public String toString() {
        return "Contacto [nombres=" + nombres + ", alias=" + alias + ", direccion=" + direccion + ", telefono="
                + telefono + ", email=" + email + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contacto other = (Contacto) obj;
        if (nombres == null) {
            if (other.nombres != null)
                return false;
        } else if (!nombres.equals(other.nombres))
            return false;
        if (telefono == null) {
            if (other.telefono != null)
                return false;
        } else if (!telefono.equals(other.telefono))
            return false;
        return true;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}

