/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicartagena.queue;

/**
 *@param <T> Tipo de dato almacenado en el elemento
 * @author Carlos Mouthon
 */

public class Elemento<T> {
    // Valor almacenado en el elemento
    private T valor;
    
    // Referencia al siguiente elemento en la fila
    private Elemento<T> siguiente;
    
    
    public Elemento(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
    
    
    public Elemento(T valor, Elemento<T> siguiente) {
        this.valor = valor;
        this.siguiente = siguiente;
    }
    

    public T getValor() {
        return valor;
    }
    

    public void setValor(T valor) {
        this.valor = valor;
    }
    

    public Elemento<T> getSiguiente() {
        return siguiente;
    }
    

    public void setSiguiente(Elemento<T> siguiente) {
        this.siguiente = siguiente;
    }
}