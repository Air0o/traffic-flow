package transito;

import traffic_flow.Incrocio;
import veicoli.*;

/**
 *
 * @author GI.AIROLDI
 */
public class TaskTransito implements Runnable {
    private Veicolo v;
    private DirezioneTransito direzioneTransito;
    private Incrocio incrocio;

    public TaskTransito(Veicolo v, DirezioneTransito direzioneTransito, Incrocio incrocio) {
        this.v = v;
        this.direzioneTransito = direzioneTransito;
        this.incrocio = incrocio;
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run() {
        try {
            if (direzioneTransito == DirezioneTransito.NS) {
                incrocio.transitaCorsiaNS(v);
            } else{
                incrocio.transitaCorsiaEO(v);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
