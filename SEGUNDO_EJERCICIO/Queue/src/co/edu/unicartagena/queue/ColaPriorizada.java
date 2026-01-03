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
public class ColaPriorizada<T> {
    
    private List<T> elementos;
    
    private Comparator<T> comparador;
    
    public ColaPriorizada(Comparator<T> comparador) {
        this.elementos = new ArrayList<>();
        this.comparador = comparador;
    }
    
   
    public void insertar(T elemento) {
        elementos.add(elemento);
        // Restaurar la propiedad de heap tras la inserción
        int posActual = elementos.size() - 1;
        while (posActual > 0) {
            int posPadre = (posActual - 1) / 2;
            
            // Si el elemento actual tiene mayor prioridad que su padre
            if (comparador.compare(elementos.get(posActual), elementos.get(posPadre)) < 0) {
                // Intercambiar
                T temp = elementos.get(posActual);
                elementos.set(posActual, elementos.get(posPadre));
                elementos.set(posPadre, temp);
                
                // Continuar subiendo
                posActual = posPadre;
            } else {
                break;
            }
        }
    }
    
    public T extraer() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        
        T elementoExtraido = elementos.get(0);
        
        T ultimoElemento = elementos.remove(elementos.size() - 1);
        
        if (!elementos.isEmpty()) {
            elementos.set(0, ultimoElemento);

            heapify(0);
        }
        
        return elementoExtraido;
    }
    

    private void heapify(int posicion) {
        int tamano = elementos.size();
        int posicionMayor = posicion;
        int hijoDerecho = 2 * posicion + 2;
        int hijoIzquierdo = 2 * posicion + 1;
        
        if (hijoIzquierdo < tamano && 
            comparador.compare(elementos.get(hijoIzquierdo), elementos.get(posicionMayor)) < 0) {
            posicionMayor = hijoIzquierdo;
        }
        
        if (hijoDerecho < tamano && 
            comparador.compare(elementos.get(hijoDerecho), elementos.get(posicionMayor)) < 0) {
            posicionMayor = hijoDerecho;
        }
        
        // Si la posición de mayor prioridad no es la actual, intercambiar y seguir
        if (posicionMayor != posicion) {
            T temp = elementos.get(posicion);
            elementos.set(posicion, elementos.get(posicionMayor));
            elementos.set(posicionMayor, temp);
            
            heapify(posicionMayor);
        }
    }
    

    public boolean estaVacia() {
        return elementos.isEmpty();
    }
    
    public int tamano() {
        return elementos.size();
    }
    
    public T consultar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos.get(0);
    }
    
    public void vaciar() {
        elementos.clear();
    }
}
