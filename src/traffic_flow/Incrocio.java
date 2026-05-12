/*
 */
package traffic_flow;

import veicoli.Veicolo;

/**
 *
 * @author GI.AIROLDI
 */
public class Incrocio {
    private boolean corsiaNSLibera = false;
    private boolean corsiaEOLibera = false;
    
    public synchronized void transitaCorsiaNS(Veicolo v) throws InterruptedException{
       
    }
    
    public synchronized void transitaCorsiaEO(Veicolo v) throws InterruptedException{
        
    }
}
