package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Camion {
    public String placa;
    private Collection<Canasta>listaCanastas;
    
    public Camion(String placa) {
        this.placa = placa;
        listaCanastas = new LinkedList<Canasta>();
    }

    public boolean agregarCanasta(Canasta canasta){
        if (canasta != null) {
            for (Canasta canastaaux : listaCanastas) {
                if (canastaaux.getCodigo().equals(canasta.getCodigo())) {
                    System.out.println("Error: la cansta con código " + canasta.getCodigo() + " ya existe.");
                    return false;
                }
            }
            listaCanastas.add(canasta);
            return true;
        }
        System.err.println("Error: la cansta no puede ser nula.");
        return false;
    }

    public boolean eliminarCanasta(String codigo) throws Exception{

        if (codigo == null) {
            throw new Exception("No se admite codigo nulo.");
        }
        for (Canasta canastaaux : listaCanastas) {
            if(canastaaux.getCodigo()==codigo){
                listaCanastas.remove(canastaaux);
                return true;
            }
        }
        System.out.println("Error: la canasta con codigo " + codigo + "no se encontró.");
        return false;
        
    }

    public Canasta buscarCanasta(String codigo){
        for (Canasta canastaaux : listaCanastas) {
            if(canastaaux.getCodigo()==codigo){
                return canastaaux;
            }
        }
        return null;
    }

    public boolean editarCanasta(String codigo, String codigoNuevo, double pesoNuevo, String tipoNuevo ){
        if (codigo != null && codigoNuevo != null && pesoNuevo != 0 && tipoNuevo != null) {
            for (Canasta canastaaux : listaCanastas) {
                if(canastaaux.getCodigo()==codigo){
                    canastaaux.setCodigo(codigoNuevo);
                    canastaaux.setPeso(pesoNuevo);
                    canastaaux.setTipo(tipoNuevo);
                    return true;
                }
            }
        }
        System.err.println("Error: No se acpetan datos nulos.");
        return false;
    }

    public void cargarCamion(){
        int veces = 10;
        for (int i = 0; i < veces; i++) {
            agregarCanasta(canastaRandom());
        }
    }

    public Canasta canastaRandom(){
        String coidgo = "C" + Double.toString(((Math.random()*(100000-1))+1));
        double codigo = (((Math.random()*(100000-1))+1));
        String tipo = "Plastico";
        Canasta canasta = new Canasta(coidgo, codigo, tipo);
        return canasta;
    }


    public LinkedList<Canasta> canastasPesoMayor100(){
        LinkedList<Canasta> canastas = new LinkedList<Canasta>();
        for (Canasta canastaux : listaCanastas) {
            if (canastaux.getPeso() > 100) {
                canastas.add(canastaux);
            }
        }
        return canastas;
        }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Collection<Canasta> getListaCanastas() {
        return listaCanastas;
    }

    public void setListaCanastas(Collection<Canasta> listaCanastas) {
        this.listaCanastas = listaCanastas;
    }


}