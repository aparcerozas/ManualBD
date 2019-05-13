/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manualbd;



/**
 *
 * @author aparcerozas
 */
public class ManualBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Metodos obx = new Metodos();
        obx.conectar();
        obx.crearTabla();
        obx.insertar(1, "Pedro", 7);
        obx.insertar(2, "Marta", 9);
        obx.insertar(3, "Jorge", 5);
        obx.consulta(1);
        obx.consulta(2);
        obx.consulta(3);
    }
        
}
