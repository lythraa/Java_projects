package co.edu.uniquindio.poo.model;

public class Canasta {
    public String codigo;
    public double peso;
    public String tipo;
    public Canasta(String codigo, double peso, String tipo) {
        this.codigo = codigo;
        this.peso = peso;
        this.tipo = tipo;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    


}