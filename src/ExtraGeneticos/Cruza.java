/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraGeneticos;

/**
 *
 * @author tapia
 */
public class Cruza {
    public static Individuo Cruza(int mask[], Individuo padre, Individuo madre){
        Individuo hijo1, hijo2;
        int genotipo1[] = new int[padre.getGenotipo().length];
        int genotipo2[] = new int[padre.getGenotipo().length];
        for(int x=0; x<mask.length;x++){
            if(mask[x] == 0){
               genotipo1[x] = padre.getGenotipo()[x];
               genotipo2[x] = madre.getGenotipo()[x];
            } else{
               genotipo1[x] = madre.getGenotipo()[x];
               genotipo2[x] = padre.getGenotipo()[x];
            }
        }
        hijo1 = new Individuo(genotipo1);
        hijo2 = new Individuo(genotipo2);
        
        if(hijo1.getFitness()<hijo2.getFitness()){
            if(hijo1.getFenotipo()>399){
            return hijo1;
            } else{
                return padre;
            }
        } else{
            if (hijo2.getFenotipo()>399){
            return hijo2;
            } else{
                return madre;
            }
        }
        
    }
}
