/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicartagena.queue;

/**
 *
 * @author Carlos Mouthon
 */
public class Cliente {
    // Atributos del cliente
    private String identificador;
    private String nombreCompleto;
    private String cuentaBancaria;
    private double saldoDisponible;
    
    
    public Cliente(String identificador, String nombreCompleto, String cuentaBancaria, double saldoDisponible) {
        this.identificador = identificador;
        this.nombreCompleto = nombreCompleto;
        this.cuentaBancaria = cuentaBancaria;
        this.saldoDisponible = saldoDisponible;
    }
    

    public String getIdentificador() {
        return identificador;
    }
    

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
  
    public String getCuentaBancaria() {
        return cuentaBancaria;
    }
    
   
    public double getSaldoDisponible() {
        return saldoDisponible;
    }
    
    
    @Override
    public String toString() {
        return String.format("Cliente[ID: %s, Nombre: %s, Cuenta: %s, Saldo: $%.2f]", 
                identificador, nombreCompleto, cuentaBancaria, saldoDisponible);
    }
}
