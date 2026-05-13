package transito;

import traffic_flow.Incrocio;
import traffic_flow.MonitorTrafficale;
import veicoli.*;

/**
 *
 * @author GI.AIROLDI
 */
public class TaskTransito implements Runnable {
    private Veicolo v;
    private DirezioneTransito direzioneTransito;
    private Incrocio incrocio;
    private final long tsArrivo;
    private final traffic_flow.MonitorTrafficale monitor;

    public TaskTransito(Veicolo v, DirezioneTransito direzioneTransito, Incrocio incrocio, long tsArrivo, traffic_flow.MonitorTrafficale monitor) {
        this.v = v;
        this.direzioneTransito = direzioneTransito;
        this.incrocio = incrocio;
        this.tsArrivo = tsArrivo;
        this.monitor = monitor;
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run() {
        try {
            String corsia = direzioneTransito.name();
            // Log di arrivo (prima di attendere il semaforo)
            semaforo.FaseSemaforo faseIniziale = null;
            try {
                if (incrocio != null && incrocio.getSemaforo() != null) faseIniziale = incrocio.getSemaforo().getFaseAttuale();
            } catch (Exception e) {e.printStackTrace();}

            if (faseIniziale == null) {
                System.out.printf("[ARRIVO] %s %s in arrivo corsia %s\n", v.getClass().getSimpleName(), v.getTarga(), corsia);
            } else {
                System.out.printf("[ARRIVO] %s %s in arrivo corsia %s (semaforo %s)\n", v.getClass().getSimpleName(), v.getTarga(), corsia, faseIniziale);
            }

            if (direzioneTransito == DirezioneTransito.NS) {
                incrocio.transitaCorsiaNS(v);
            } else{
                incrocio.transitaCorsiaEO(v);
            }

            long tsInizio = System.currentTimeMillis();
            if (monitor != null) {
                monitor.registraInizioTransito(tsInizio, tsArrivo);
            }

            System.out.printf("[TRANSITO] %s %s in transito corsia %s... (durata stimata: %s s)\n",
                    v.getClass().getSimpleName(), v.getTarga(), corsia, v.getTempoTransito());

            // simula il tempo di transito
            try {
                Thread.sleep(Math.round(v.getTempoTransito() * 1000L));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            long tsFine = System.currentTimeMillis();
            if (monitor != null) {
                monitor.registraFineTransito(tsFine, tsInizio);
            }

            double attesaSec = (tsInizio - tsArrivo) / 1000.0;
            double durataSec = (tsFine - tsInizio) / 1000.0;
            System.out.printf("[FINE] %s %s ha completato il transito corsia %s (attesa: %s s, durata reale: %s s)\n",
                    v.getClass().getSimpleName(), v.getTarga(), corsia,
                    attesaSec, durataSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
