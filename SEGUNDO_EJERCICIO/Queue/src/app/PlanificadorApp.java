/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import co.edu.unicartagena.queue.Tarea;
import co.edu.unicartagena.queue.PlanificadorCPU;
import co.edu.unicartagena.queue.DiagramaGantt;
/**
 *
 * @author Carlos Mouthon
 */
public class PlanificadorApp {
    
    public static void main(String[] args) {
        // Crear el planificador
        PlanificadorCPU planificador = new PlanificadorCPU();
        
        System.out.println("==== SISTEMA DE PLANIFICACION DE TAREAS ====");
        
        // Agregar tareas al planificador (id, prioridad, tiempoLlegada, duracion)
        planificador.agregarTarea(new Tarea("Tarea-1", 7, 1, 2));
        planificador.agregarTarea(new Tarea("Tarea-2", 3, 2, 4));
        planificador.agregarTarea(new Tarea("Tarea-3", 9, 2, 1));
        planificador.agregarTarea(new Tarea("Tarea-4", 2, 4, 5));
        planificador.agregarTarea(new Tarea("Tarea-5", 8, 1, 2));
        planificador.agregarTarea(new Tarea("Tarea-6", 6, 5, 1));
        planificador.agregarTarea(new Tarea("Tarea-7", 4, 3, 3));
        planificador.agregarTarea(new Tarea("Tarea-8", 1, 2, 4));
        planificador.agregarTarea(new Tarea("Tarea-9", 10, 1, 2));
        planificador.agregarTarea(new Tarea("Tarea-10", 5, 4, 3));
        
        // Ejecutar la planificación
        planificador.ejecutarPlanificacion();
        
        // Mostrar estadísticas de ejecución
        System.out.println("\n==== ESTADISTICAS DE EJECUCION ====");
        System.out.println("Tiempo total de ejecucion: " + planificador.obtenerTiempoTotal() + " unidades");
        
        Tarea tareaMasBeneficiada = planificador.obtenerTareaMasBeneficiada();
        System.out.println("Tarea mas beneficiada por su prioridad: " + tareaMasBeneficiada.getId() + 
                           " (Prioridad: " + tareaMasBeneficiada.getPrioridad() + 
                           ", Tiempo de espera: " + tareaMasBeneficiada.getTiempoEspera() + ")");
        
        Tarea tareaMenosBeneficiada = planificador.obtenerTareaMenosBeneficiada();
        System.out.println("Tarea menos beneficiada por su prioridad: " + tareaMenosBeneficiada.getId() + 
                           " (Prioridad: " + tareaMenosBeneficiada.getPrioridad() + 
                           ", Tiempo de espera: " + tareaMenosBeneficiada.getTiempoEspera() + ")");
        
        // Mostrar el diagrama de Gantt
        DiagramaGantt diagrama = new DiagramaGantt(planificador.obtenerTareasEjecutadas());
        diagrama.mostrar();
        
        // Mostrar análisis de complejidad
        System.out.println("\n==== ANALISIS DE COMPLEJIDAD ====");
        System.out.println("Complejidad temporal: O(n log n) debido al algoritmo de ordenacion");
        System.out.println("Complejidad espacial: O(n) donde n es el numero de tareas");
    }
}
