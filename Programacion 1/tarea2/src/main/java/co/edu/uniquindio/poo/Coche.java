package co.edu.uniquindio.poo;

public class Coche {
    String marca;
    String modelo;
    //un constructor es un método para inicializar objetos de una clase:
    Coche(String marca, String modelo){
        /*this se utiliza para referirse a los atributos del objeto actual cuando
        *los nombres de los parámetros o variables locales son iguales a los nombres de los atributos
        */
        this.marca = marca;
        this.modelo= modelo;
    }
}

