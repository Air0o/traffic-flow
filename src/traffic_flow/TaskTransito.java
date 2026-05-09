/*
 */
package traffic_flow;

import veicoli.Veicolo;

/**
 *
 * @author GI.AIROLDI
 */
public class TaskTransito implements Runnable{
    private Veicolo v;

    public TaskTransito(Veicolo v) {
        this.v = v;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
