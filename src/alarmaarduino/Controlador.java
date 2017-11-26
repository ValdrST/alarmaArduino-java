/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmaarduino;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.PanamaHitek_MultiMessage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author valdr
 */
public class Controlador {
    protected PanamaHitek_Arduino arduino;
    SerialPortEventListener sl = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };

    protected PanamaHitek_MultiMessage multi;
    static private String puerto;

    public Controlador(int nSensores) {
        this.arduino = new PanamaHitek_Arduino();
        this.multi = new PanamaHitek_MultiMessage(nSensores, arduino);
        }
    
    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
    
    void iniciarConexion(String puerto){
        try {
            arduino.arduinoRXTX(puerto, 9600, sl);
            arduino.flushSerialPort();
        } catch (ArduinoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
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
        for(int i=0; i<lsPuertos.size()-1;i++){
            puertos=puertos+lsPuertos.get(i)+"\n";
        }
        return puertos;
    }
}
