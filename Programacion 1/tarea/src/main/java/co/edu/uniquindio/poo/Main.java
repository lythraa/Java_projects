package co.edu.uniquindio.poo;

public class Main{
    public static void main(String[]args){
        Coche miCoche = new Coche("Toyota", "Corolla");
        //Mostrar los atributos del objeto
        System.out.println("marca: "+ miCoche.marca);
        System.out.println("modelo: "+ miCoche.modelo);
        
    }
}


/* primero se define una clase con los atributos y un constructor
 * luego se crea un objeto de esa clase utilizando el constructor
 * para inicializar los atributos
 */