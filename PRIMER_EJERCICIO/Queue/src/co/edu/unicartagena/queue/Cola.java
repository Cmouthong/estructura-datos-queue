/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicartagena.queue;

/**
 *@param <T> Tipo de dato almacenado en el elemento
 * @author Carlos Mouthon
 */
public class Cola<T> {
    private Elemento<T> primero;   
    private Elemento<T> ultimo;    
    private int cantidadElementos; 
    
    public Cola() {
        inicializar();
    }
    
 
    private void inicializar() {
        primero = null;
        ultimo = null;
        cantidadElementos = 0;
    }
    

    public boolean estaVacia() {
        return cantidadElementos == 0;
    }
    
   
    public boolean agregarCliente(T valor) {
        Elemento<T> nuevoElemento = new Elemento<>(valor);
        
        // Si la fila está vacía, el nuevo elemento es el primero y el último
        if (estaVacia()) {
            primero = nuevoElemento;
            ultimo = nuevoElemento;
        } else {
            // Si no está vacía, agregar al final y actualizar la referencia
            ultimo.setSiguiente(nuevoElemento);
            ultimo = nuevoElemento;
        }
        
        // Incrementar el contador de elementos
        cantidadElementos++;
        return true;
    }
    
    
    public T atenderCliente() {
        // Verificar si hay clientes en la fila
        if (estaVacia()) {
            System.out.println("No hay clientes esperando en la fila");
            return null;
        }
        
        // Obtener el cliente a atender
        T clienteAtendido = primero.getValor();
        
        // Actualizar la referencia al primer cliente
        primero = primero.getSiguiente();
        cantidadElementos--;
        
        // Si la fila quedó vacía, actualizar la referencia al último
        if (primero == null) {
            ultimo = null;
        }
        
        return clienteAtendido;
    }
    

    public int contarClientes() {
        return cantidadElementos;
    }
    

    public T obtenerSiguiente() {
        if (estaVacia()) {
            return null;
        }
        return primero.getValor();
    }
    
    
    public T obtenerUltimo() {
        if (estaVacia()) {
            return null;
        }
        return ultimo.getValor();
    }
    

    public void vaciarFila() {
        inicializar();
    }
}
