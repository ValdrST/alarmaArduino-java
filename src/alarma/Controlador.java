/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarma;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.PanamaHitek_MultiMessage;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author Rurik
 */
public class Controlador {
    protected PanamaHitek_Arduino arduino;
    static SerialPortEventListener sl;

    protected PanamaHitek_MultiMessage multi;
    static String strpuerto="";

    public Controlador(int nSensores) {
        this.arduino = new PanamaHitek_Arduino();
        this.multi = new PanamaHitek_MultiMessage(nSensores, arduino);
        }
    
    public String getPuerto() {
        return strpuerto;
    }

    public void setPuerto(String puerto) {
        this.strpuerto = puerto;
    }
    
    void iniciarConexion(String puerto){
        try {
            arduino.arduinoRXTX(puerto,9600,sl);
        } catch (ArduinoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void terminarConexion(){
        try {
            arduino.killArduinoConnection();
        } catch (ArduinoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void enviarDatos(String dato){
        try {
            arduino.sendData(dato);
        } catch (ArduinoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    String recibirDatos(int sensor){
        return multi.getMessage(sensor);
    }
    String verPuertos(){
        String puertos="";
        List<String> lsPuertos;
        lsPuertos=arduino.getSerialPorts();
        for(int i=0; i<lsPuertos.size();i++){
            puertos=puertos+lsPuertos.get(i)+"\n";
        }
        return puertos;
    }
}
