/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraGeneticos;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author tapia
 */
public class Individuo {



    private int genotipo[];
    private int fenotipo;
    private int fitness;
    
    public Individuo(){
        do{
        this.genotipo = generarGenotipoAleatorio();
        this.fenotipo = calcularFenotipo();
        this.fitness = calcularFitness();
        }while(this.fenotipo<400);
    }

    public Individuo(int genotipo[]){
        this.genotipo = genotipo.clone();
        this.fenotipo = calcularFenotipo();
        this.fitness = calcularFitness();
    }
    private int[] generarGenotipoAleatorio() {
        int genAux[] = new int[9];  //Hay 9 Choferes disponibles
        int a = 0;  //Camión tipo A - 40 Plazas $60 - 8 disponibles
        int b = 0;  //Camión tipo B - 50 Plazas $80 - 10 disponibles
        Random ran = new Random();
        for (int x = 0; x<genAux.length;x++){
            if (a<9){
            genAux[x] = ran.nextInt(2);
            }else{
                genAux[x] = ran.nextInt(1);
            }
        }
        return genAux;
    }

    private int calcularFenotipo() {
        int fenotipoAux = 0;
        for (int x=0;x<this.getGenotipo().length;x++){
            if (this.genotipo[x]==0){
                fenotipoAux += 40;
            } else{
                fenotipoAux += 50;
            }
        }
        return fenotipoAux;
    }
    
    public void actualizarIndividuo(){
        this.fenotipo = calcularFenotipo();
        this.fitness = calcularFitness();
    }

    private int calcularFitness() {
        int fitnessAux = 0;
        for (int x=0;x<this.getGenotipo().length;x++){
            if (this.genotipo[x]==0){
                fitnessAux += 60;
            } else{
                fitnessAux += 80;
            }
        }
        return fitnessAux;
    }
    
        /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }

    /**
     * @return the fenotipo
     */
    public int getFenotipo() {
        return fenotipo;
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        return fitness;
    }
    
    /*public static void main(String[] args) {
        Individuo indd = new Individuo();
        System.out.println(Arrays.toString(indd.genotipo));
        System.out.println(indd.fenotipo);
        System.out.println(indd.fitness);
    }*/
}
