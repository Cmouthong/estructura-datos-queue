/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicartagena.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Carlos Mouthon
 */
public class PlanificadorCPU {
    
    // Lista de todas las tareas ingresadas
    private List<Tarea> tareas;
    
    // Lista de tareas en el orden en que fueron ejecutadas
    private List<Tarea> tareasEjecutadas;
    
    // Cola de prioridad personalizada para la planificación
    private ColaPriorizada<Tarea> colaPrioritaria;
    
    /**
     * Constructor del planificador
     */
    public PlanificadorCPU() {
        this.tareas = new ArrayList<>();
        this.tareasEjecutadas = new ArrayList<>();
        
        // Definir el comparador para la cola priorizada (prioridad descendente, llegada ascendente)
        Comparator<Tarea> comparadorTareas = (t1, t2) -> {
            if (t1.getPrioridad() != t2.getPrioridad()) {
                return Integer.compare(t2.getPrioridad(), t1.getPrioridad()); // Mayor prioridad primero
            }
            return Integer.compare(t1.getTiempoLlegada(), t2.getTiempoLlegada()); // Primera en llegar
        };
        
        this.colaPrioritaria = new ColaPriorizada<>(comparadorTareas);
    }
    
    /**
     * Agrega una nueva tarea al planificador
     * 
     * @param tarea La tarea a agregar
     */
    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }
    
    /**
     * Ejecuta la planificación de todas las tareas registradas
     */
    public void ejecutarPlanificacion() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para planificar.");
            return;
        }
        
        System.out.println("\nIniciando planificacion de " + tareas.size() + " tareas...");
        
        // Ordenar las tareas por tiempo de llegada para simular su entrada al sistema
        List<Tarea> tareasOrdenadas = new ArrayList<>(tareas);
        tareasOrdenadas.sort(Comparator.comparingInt(Tarea::getTiempoLlegada));
        
        int tiempoActual = 0;
        int indiceTarea = 0;
        
        // Mientras haya tareas pendientes o en la cola
        while (indiceTarea < tareasOrdenadas.size() || !colaPrioritaria.estaVacia()) {
            
            // Agregar a la cola todas las tareas que hayan llegado hasta el momento actual
            while (indiceTarea < tareasOrdenadas.size() && 
                   tareasOrdenadas.get(indiceTarea).getTiempoLlegada() <= tiempoActual) {
                colaPrioritaria.insertar(tareasOrdenadas.get(indiceTarea));
                indiceTarea++;
            }
            
            if (colaPrioritaria.estaVacia()) {
                // Si no hay tareas disponibles, avanzar el tiempo hasta la próxima llegada
                if (indiceTarea < tareasOrdenadas.size()) {
                    tiempoActual = tareasOrdenadas.get(indiceTarea).getTiempoLlegada();
                    continue;
                } else {
                    break; // No hay más tareas por procesar
                }
            }
            
            // Obtener la tarea con mayor prioridad
            Tarea tareaActual = colaPrioritaria.extraer();
            
            // Programar su ejecución
            tareaActual.programarEjecucion(tiempoActual);
            
            // Avanzar el tiempo
            tiempoActual = tareaActual.getTiempoFin();
            
            // Registrar la tarea ejecutada
            tareasEjecutadas.add(tareaActual);
            
            System.out.println("Ejecutando " + tareaActual.getId() + 
                              " (Prioridad: " + tareaActual.getPrioridad() + 
                              ", Inicio: " + tareaActual.getTiempoInicio() + 
                              ", Fin: " + tareaActual.getTiempoFin() + ")");
        }
        
        System.out.println("Planificacion completada. Total " + tareasEjecutadas.size() + " tareas procesadas.");
    }
    
    /**
     * Calcula el tiempo total de ejecución de todas las tareas
     * 
     * @return El tiempo total de ejecución
     */
    public int obtenerTiempoTotal() {
        if (tareasEjecutadas.isEmpty()) {
            return 0;
        }
        return tareasEjecutadas.stream()
                .mapToInt(Tarea::getTiempoFin)
                .max()
                .getAsInt();
    }
    
    /**
     * Determina la tarea que más se benefició de su prioridad (menor tiempo de espera)
     * 
     * @return La tarea más beneficiada
     */
    public Tarea obtenerTareaMasBeneficiada() {
        if (tareasEjecutadas.isEmpty()) {
            return null;
        }
        
        return tareasEjecutadas.stream()
                .min(Comparator.comparingInt(Tarea::getTiempoEspera))
                .get();
    }
    
    /**
     * Determina la tarea que menos se benefició de su prioridad (mayor tiempo de espera)
     * 
     * @return La tarea menos beneficiada
     */
    public Tarea obtenerTareaMenosBeneficiada() {
        if (tareasEjecutadas.isEmpty()) {
            return null;
        }
        
        return tareasEjecutadas.stream()
                .max(Comparator.comparingInt(Tarea::getTiempoEspera))
                .get();
    }
    
    /**
     * Devuelve la lista de tareas ejecutadas en orden de ejecución
     * 
     * @return Lista de tareas ejecutadas
     */
    public List<Tarea> obtenerTareasEjecutadas() {
        return new ArrayList<>(tareasEjecutadas);
    }
}
