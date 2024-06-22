/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JSlider;

/**
 *
 * @author Juan
 */
public class simulationHilos extends Thread{
        private String nombre;
        private int velocidad;
        private int distanciaRecorrida;
        private int distanciaTotal;
        private JSlider progress;
        
        public simulationHilos(String nombre, int velocidad, int distanciaTotal, JSlider progress) {
            this.nombre = nombre;
            this.velocidad = velocidad;
            this.distanciaTotal = distanciaTotal;
            this.distanciaRecorrida = 0;
            this.progress = progress;
        }
        
        public void run() {
            while (distanciaRecorrida < distanciaTotal) {
                distanciaRecorrida += velocidad;
                
                int porcentaje = Integer.parseInt(((distanciaRecorrida*100)/distanciaTotal)+"");
                if(porcentaje<=100){
                    progress.setValue(porcentaje);
                }else{
                    progress.setValue(100);
                }
                        
                System.out.println("Porcentaje: "+ porcentaje);
                
                System.out.println(nombre + " ha recorrido " + distanciaRecorrida + " de " + distanciaTotal + " Kilometros.");
                try {
                    Thread.sleep(1000); // Esperar 1 segundo (simulando el paso del tiempo)
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(nombre + " ha llegado a la Ciudad B.");
        }
}
