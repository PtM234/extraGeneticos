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
public class Muta {
    
    public static void Muta(double probMuta, Individuo ind){
        double aux = Math.random();
        Individuo indAux = new Individuo(ind.getGenotipo());
        if (aux<=probMuta){
                Random ran = new Random();
                int pos = ran.nextInt(ind.getGenotipo().length);
                if(ind.getGenotipo()[pos]==0){
                    ind.getGenotipo()[pos] = 1;
                } else{
                    ind.getGenotipo()[pos] = 0;
                }
                ind.actualizarIndividuo();
        }
        if (ind.getFenotipo()<400){
            ind = new Individuo(indAux.getGenotipo());
        }
    }
}
