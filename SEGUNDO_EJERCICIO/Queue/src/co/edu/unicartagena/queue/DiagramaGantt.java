/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicartagena.queue;

import co.edu.unicartagena.queue.Tarea;
import java.util.List;

/**
 *
 * @author Carlos Mouthon
 */
public class DiagramaGantt {
    
    private List<Tarea> tareas;
    
    private int tiempoTotal;
    

    public DiagramaGantt(List<Tarea> tareas) {
        this.tareas = tareas;
        this.tiempoTotal = calcularTiempoTotal();
    }
    

    private int calcularTiempoTotal() {
        int max = 0;
        for (Tarea tarea : tareas) {
            if (tarea.getTiempoFin() > max) {
                max = tarea.getTiempoFin();
            }
        }
        return max;
    }
    
    public void mostrar() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para mostrar en el diagrama.");
            return;
        }
        
        System.out.println("\n==== DIAGRAMA DE GANTT ====");
        
        System.out.print("Tiempo: ");
        for (int t = 0; t <= tiempoTotal; t++) {
            System.out.print(t + " ");
        }
        System.out.println();
        
        System.out.print("       ");
        for (int t = 0; t <= tiempoTotal; t++) {
            System.out.print("- ");
        }
        System.out.println();
        
        for (Tarea tarea : tareas) {
        
            System.out.printf("%-6s |", tarea.getId());
            
            for (int t = 0; t < tarea.getTiempoInicio(); t++) {
                System.out.print("  ");
            }
            
            for (int t = tarea.getTiempoInicio(); t < tarea.getTiempoFin(); t++) {
                System.out.print("##");
            }
            
            System.out.print("| P:" + tarea.getPrioridad() + 
                            ", L:" + tarea.getTiempoLlegada() + 
                            ", E:" + tarea.getTiempoEspera());
            System.out.println();
        }
        
        System.out.print("       ");
        for (int t = 0; t <= tiempoTotal; t++) {
            System.out.print("- ");
        }
        System.out.println();
    }
}
