/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraGeneticos;

import java.util.Random;

/**
 *
 * @author tapia
 */
public class Seleccion {
    public static Individuo seleccionTorneo(Poblacion pob){
        Individuo aux = new Individuo(pob.getMejor().getGenotipo());
        return aux;
    }
    
    public static Individuo seleccionAleatoria(Poblacion pob){
        Random ran = new Random();
        Individuo aux = new Individuo(pob.individuos.get(ran.nextInt(pob.individuos.size())).getGenotipo());
        
        return aux;
    }
}
