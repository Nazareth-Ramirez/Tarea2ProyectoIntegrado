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
public class Menu {
    
    private int opcion;
    
    public void menuPrincipal(){
        
        do{
            opcion=Integer.parseInt(JOptionPane.showInputDialog("""
                                                                ---------Menu---------
                                                                1.Registrar producto
                                                                2.Mostrar productos
                                                                3.Buscar producto por codigo
                                                                4.Vender unidades
                                                                5.Rebastecer producto
                                                                6.Calcular valor total del inventario
                                                                7.Salir del sistema
                                                                -----------------------------
                                                                Seleccione una opcion
                                                                
                                                                """));
            
            
        }while(opcion!=7);
        
    }//fin del metodo menuPrincipal
    
}//fin de la clase 
