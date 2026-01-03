/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicartagena.queue;

/**
 *
 * @author Carlos Mouthon
 */
public class Tarea {
    
    private String id;
    
    private int prioridad;
    
    private int tiempoLlegada;
    
    private int duracion;
    
    private int tiempoInicio;
    
    private int tiempoFin;
    

    public Tarea(String id, int prioridad, int tiempoLlegada, int duracion) {
        this.id = id;
        this.prioridad = prioridad;
        this.tiempoLlegada = tiempoLlegada;
        this.duracion = duracion;
        this.tiempoInicio = -1;  
        this.tiempoFin = -1;     
    }
    

    public int getTiempoEspera() {
        if (tiempoInicio == -1) {
            return -1;  
        }
        return tiempoInicio - tiempoLlegada;
    }
    

    public int getTiempoTotal() {
        if (tiempoFin == -1) {
            return -1;  
        }
        return tiempoFin - tiempoLlegada;
    }
    
 
    public void programarEjecucion(int momento) {
        this.tiempoInicio = momento;
        this.tiempoFin = momento + duracion;
    }
    

    public boolean estaProgramada() {
        return tiempoInicio != -1;
    }
    
   
    public double getIndiceBeneficio() {
        if (getTiempoEspera() <= 0) {
            return prioridad; // No esperó
        }
        return (double) prioridad / getTiempoEspera();
    }
    
    
    public String getId() {
        return id;
    }
    
    public int getPrioridad() {
        return prioridad;
    }
    
    public int getTiempoLlegada() {
        return tiempoLlegada;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public int getTiempoInicio() {
        return tiempoInicio;
    }
    
    public int getTiempoFin() {
        return tiempoFin;
    }
    
    @Override
    public String toString() {
        return id + " (P:" + prioridad + ", L:" + tiempoLlegada + ", D:" + duracion + ")";
    }
}
