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
public class Genetico {
    
    public Poblacion pobActual;
    public int numeroGeneraciones;
    public int tamPoblacion;
    public double probMuta;
    
    public Genetico(int nGeneraciones, int tamPob, double probMuta){
        this.numeroGeneraciones = nGeneraciones;
        this.tamPoblacion = tamPob;
        this.probMuta = probMuta;
        this.pobActual = new Poblacion(tamPoblacion);
    }
    
    public void Evolucionar(){
        for(int generacion = 1; generacion < numeroGeneraciones; generacion++){
            ArrayList<Individuo> pob1 = new ArrayList<Individuo>();
            for(int poblacion = 0; poblacion < tamPoblacion; poblacion++){
                Individuo madre = Seleccion.seleccionAleatoria(this.pobActual);
                Individuo padre = Seleccion.seleccionAleatoria(this.pobActual);
                
                Individuo hijo = Cruza.Cruza(new int[]{0,0,1,0,1,0,0,0,1}, padre, madre);
                
                Muta.Muta(probMuta, hijo);
                
                pob1.add(hijo);
            }
            this.pobActual = new Poblacion(pob1);
            System.out.println("Generacion: " + generacion + " Fenotipo: " + this.pobActual.getMejor().getFenotipo() + " Fitness: " + this.pobActual.getMejor().getFitness());
        }
        Individuo mejor = this.pobActual.getMejor();
        System.out.println("El Genotipo fue: " + Arrays.toString(mejor.getGenotipo()));
        System.out.println("Total de alumnos: " + mejor.getFenotipo());
        System.out.println("El dinero gastado fue: " + mejor.getFitness());
    }
    
    public static void main(String[] args) {
        Genetico gen = new Genetico(100, 20, 0.1);
        gen.Evolucionar();
    }
}
