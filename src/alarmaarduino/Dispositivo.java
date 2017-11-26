/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmaarduino;

/**
 *
 * @author valdr
 */
public interface Dispositivo {
    void prender();
    void apagar();
    void reiniciar();
    void detener();
}
