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
public class Inventario {
    
    //Este es el arreglo de 10 posiciones
    private Producto[] productos = new Producto[3];
    
    //Es la variable cantidad
    private int cantidad;

    
    //Metodos
    public void registrarProducto() {

        if (cantidad < productos.length) {
            

            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto "+(cantidad +1 )+" : "));
           
            int indice = -1;

            // Recorremos el arreglo para buscar si el codigo ya existe
            for (int i = 0; i < productos.length; i++) {

                if (productos[i] != null&& codigo == productos[i].getCodigo()){
                 
                    indice = i;
                    break;
                }
            }

            // Si indice sigue siendo -1, el codigo no existe
            if (indice == -1) {

                String nombre = JOptionPane.showInputDialog( "Ingrese el nombre del producto:");
                
                double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));                          

                int cantidadDispo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible del producto:"));


                productos[cantidad] = new Producto(codigo, nombre,precio,cantidadDispo );


                cantidad++;
                JOptionPane.showMessageDialog( null,"Posiciones del arreglo ocupadas: "+ cantidad+ "\nDe: " +productos.length);

                JOptionPane.showMessageDialog( null,"Producto registrado correctamente" );
            

            } else {

                JOptionPane.showMessageDialog( null,"No se permiten codigos repetidos" );
            
            }

        } else {

            JOptionPane.showMessageDialog(null,"El inventario esta lleno...");
        
        }

    }//Fin del metodo registrarProducto

    public void mostrarProductos() {
        if (productos[0] == null) {
            
            JOptionPane.showMessageDialog(null, "Debe registrar los productos primero");
            
        } else {
            for (int i = 0; i < productos.length; i++) {
                if (productos[i] != null) {
                    productos[i].informacionProducto();
                }

            }
        }
    }//Fin del metodo buscarProducto

    public void buscarProducto() {
        
        if (productos[0] == null) {

            JOptionPane.showMessageDialog(null, "Debe registrar los productos primero");

        } else {
            int buscarCodigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto que desea buscar: "));

            //variable
            int indice = -1;//asume que el producto no existe en el arreglo

            //el ciclo for recorre el arreglo
            for (int i = 0; i < productos.length; i++) {
                if (productos[i] != null && productos[i].getCodigo() == buscarCodigo) {
                    indice = i;
                     break;//porque solo va a buscar 1 producto no todos
                }
           
            }//fin del for

           
            if (indice != -1) {
                JOptionPane.showMessageDialog(null, "El producto que esta  buscando con el codigo  " + buscarCodigo + " \nes: " +productos[indice].getNombre() + "  esta en el indice: " + indice);
            }else{
                 JOptionPane.showMessageDialog(null, "Este codigo no existe");
            }
        }
        
    }//Fin del metodo buscarProducto

    public void venderUnidades() {
       
        if (productos[0] == null) {
            JOptionPane.showMessageDialog(null, "Debe registrar los productos primero");
        } else {
            int codigoParaVender = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto que desea vender:"));

            int indice = -1; // Asume inicialmente que el producto no existe

            //Recorrer el arreglo ÚNICAMENTE para buscar la posición del producto
            for (int i = 0; i < productos.length; i++) {
                if (productos[i] != null && productos[i].getCodigo() == codigoParaVender) {
                    indice = i;
                    break; // Se encontró el producto, detiene la búsqueda
                }
            }

            //Procesar la venta fuera del ciclo según el resultado de la búsqueda
            if (indice != -1) {
                int vender = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese la cantidad de unidades que desea vender:"));

                if (vender > 0 && vender <= productos[indice].getCantidadDisponible()) {
                    int nuevaCantidad = productos[indice].getCantidadDisponible() - vender;
                    productos[indice].setCantidadDisponible(nuevaCantidad);

                    JOptionPane.showMessageDialog(null, "Se vendió el producto correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cantidad no válida o insuficientes unidades disponibles.");
                }
            } else {
                // Este mensaje se muestra SOLO UNA VEZ si recorrió todo el arreglo y no lo halló
                JOptionPane.showMessageDialog(null, "El producto no existe.");
            }
        }
    }//Fin del metodo venderUnidades

    public void reabastecerProducto(){
        
        if (productos[0] == null) {
            
            JOptionPane.showMessageDialog(null, "Debe registrar los productos primero");
            
        }else{
            int codigoProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto que desea vender:"));

            int indice = -1; // Asume inicialmente que el producto no existe

            //Recorrer el arreglo ÚNICAMENTE para buscar la posición del producto
            for (int i = 0; i < productos.length; i++) {
                if (productos[i] != null && productos[i].getCodigo() == codigoProducto) {
                    indice = i;
                    break; // Se encontró el producto, detiene la búsqueda
                }
            }

            //Procesar la venta fuera del ciclo según el resultado de la búsqueda
            if (indice != -1) {
                int reabastecer = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese la cantidad de unidades que desea reabastecer:"));

                if (reabastecer > 0 && reabastecer <= productos[indice].getCantidadDisponible()) {
                    int nuevaCantidad = productos[indice].getCantidadDisponible() + reabastecer;
                    productos[indice].setCantidadDisponible(nuevaCantidad);

                    JOptionPane.showMessageDialog(null, "Se reabastecio el producto correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cantidad no válida ");
                }
            } else {
                // Este mensaje se muestra SOLO UNA VEZ si recorrió todo el arreglo y no lo halló
                JOptionPane.showMessageDialog(null, "El producto no existe.");
            }

        }

    }//Fin del metodo reabastecerProducto
    
    

    public void calcularValor(){
        if (productos[0] == null) {
            JOptionPane.showMessageDialog(null, "Debe registrar los productos primero");
        } else {
            double total = 0;

            for (int i = 0; i < productos.length; i++) {

                if (productos[i] != null) {

                    total = total + (productos[i].getPrecio() * productos[i].getCantidadDisponible());

                }
            }

            JOptionPane.showMessageDialog(null, String.format("El valor total del inventario es: %.2f", total));

        }
    }

}//Fin de la clase
