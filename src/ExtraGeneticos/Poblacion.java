/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraGeneticos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author tapia
 */
public class Poblacion {
    public ArrayList <Individuo> individuos = new ArrayList<Individuo>();
    
    public Poblacion(int tPoblacion){
        for (int x=0;x<=tPoblacion;x++){
            individuos.add(new Individuo());
        }
    }
    
    public Poblacion (ArrayList<Individuo> nuevaPoblacion){
        this.individuos = (ArrayList<Individuo>)nuevaPoblacion.clone();
    }
    
    public ArrayList<Individuo> getNMejores(int numero){
        
        if(numero<this.individuos.size()){
            ArrayList<Individuo> aux = new ArrayList<Individuo>();
            ordenarPoblacion();
            for(int x=0;x<numero;x++){
                Individuo e = new Individuo(this.individuos.get(x).getGenotipo());
                aux.add(e);
            }
            return aux;
        }
        return (ArrayList<Individuo>) this.individuos.clone();
    }
    
    public Individuo getMejor (){
        int idMejor = 0;
        for(int x=1;x<this.individuos.size();x++){
            if(this.individuos.get(x).getFitness()<this.individuos.get(idMejor).getFitness()){
            idMejor = x;
            }
        }
        return new Individuo (this.individuos.get(idMejor).getGenotipo());
    }
    
    public void ordenarPoblacion(){
        for (int i = 1; i < this.individuos.size(); i++){
            for (int j = 0; j < (this.individuos.size()-i); j++){
                if (this.individuos.get(j).getFitness() > this.individuos.get(j+1).getFitness()){
                    Individuo aux = new Individuo(this.individuos.get(j).getGenotipo());
                    this.individuos.set(j, new Individuo(this.individuos.get(j+1).getGenotipo()));
                    this.individuos.set(j, aux);
                }
            }
        }            
        }
    
    
    public ArrayList<Individuo> getIndividuos(){
        return individuos;
    }
    
//    public static void main(String[] args) {
//        Poblacion pob = new Poblacion(60);
//        System.out.println("Fitness mejor: " + pob.getMejor().getFitness());
//        System.out.println("Fenotipo mejor: " + pob.getMejor().getFenotipo());
//    }
}
