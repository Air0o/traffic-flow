package transito;

import veicoli.*;
/**
 *
 * @author GI.AIROLDI
 */
public class TaskTransito implements Runnable{
    private Veicolo v;
    private DirezioneTransito direzioneTransito;

    public TaskTransito(Veicolo v, DirezioneTransito direzioneTransito) {
        this.v = v;
        this.direzioneTransito = direzioneTransito;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
