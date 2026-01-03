package app;
import co.edu.unicartagena.queue.Cliente;
import co.edu.unicartagena.queue.Cola;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template


/**
 *
 * @author Carlos Mouthon
 */
public class Principal {
    public static void main(String[] args) {
        // Crear una nueva fila de clientes
        Cola<Cliente> colaClientes = new Cola<>();
        
        // Agregar clientes a la fila con sus datos
        colaClientes.agregarCliente(new Cliente("101", "Carlos Perez", "CTA-5501", 3200.0));
        colaClientes.agregarCliente(new Cliente("102", "Maria Rodriguez", "CTA-5502", 1750.5));
        colaClientes.agregarCliente(new Cliente("103", "Jose Lopez", "CTA-5503", 950.75));
        colaClientes.agregarCliente(new Cliente("104", "Gabriela Torres", "CTA-5504", 500.0));
        colaClientes.agregarCliente(new Cliente("105", "Roberto Diaz", "CTA-5505", 2800.25));
        
        // Mostrar información requerida por el gerente
        System.out.println("===== INFORMACION DE LA COLA =====");
        System.out.println("Numero de clientes en espera: " + colaClientes.contarClientes());
        
        Cliente siguiente = colaClientes.obtenerSiguiente();
        if (siguiente != null) {
            System.out.println("Proximo cliente a atender: " + siguiente);
        } else {
            System.out.println("No hay clientes en la fila");
        }
        
        Cliente ultimo = colaClientes.obtenerUltimo();
        if (ultimo != null) {
            System.out.println("Ultimo cliente en la fila: " + ultimo);
        } else {
            System.out.println("No hay clientes en la fila");
        }
        
        // Demostración de atención a clientes
        System.out.println("\n===== DEMOSTRACION DE ATENCION =====");
        System.out.println("Atendiendo al cliente: " + colaClientes.atenderCliente());
        System.out.println("Clientes restantes: " + colaClientes.contarClientes());
        System.out.println("Proximo cliente a atender: " + colaClientes.obtenerSiguiente());
    }
}
