/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Producto {
    
    //Creacion de variables
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidadDisponible;

    //constructor vacio
    public Producto() {
    }//fin del constructor vacio

    
    //constructor de parametros
    public Producto(int codigo, String nombre, double precio, int cantidadDisponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }//fin de constructor con parametros
    
    
    //GET Y SET DE LAS VARIABLES

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    //fin de los get y set
    
    //metodo para mostrar la informacion en la clase inventario
    public void informacionProducto() {
        JOptionPane.showMessageDialog(null, "Informacion del producto" 
                + "\nCodigo: " + codigo
                + "\nNombre: " + nombre
                + "\nPrecio: " + precio
                + "\nCantidad disponible: " + cantidadDisponible);
                
                
    }
    
}
