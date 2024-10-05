package co.edu.uniquindio.poo.model;

public class Empleado extends Persona{
    private double salario;
    private int antiguedad;

    public Empleado(String nombre, String identificacion, String telefono, double salario, int antiguedad){
        super(nombre, identificacion, telefono);
        this.salario = salario;
        this.antiguedad = antiguedad;

    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Empleado ["+super.toString() + "salario=" + salario + ", antiguedad=" + antiguedad + "]";
    } 

    

}
