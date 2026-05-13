/*
 */
package traffic_flow;

/**
 *
 * @author GI.AIROLDI
 */
public class MonitorTrafficale extends Thread {

    private final SimulazioneTrafficale sim;
    private final Dispatcher dispatcher;
    private final Incrocio incrocio;

    private int veicoliTransitati = 0;

    private final java.util.List<Long> tempiAttesaMs = new java.util.ArrayList<>();
    private final java.util.List<Long> tempiTransitoMs = new java.util.ArrayList<>();

    private final java.util.Map<String, Integer> arriviPerCorsia = new java.util.HashMap<>();

    private int inCodaStimati = 0;

    public MonitorTrafficale(SimulazioneTrafficale sim) {
        this.sim = sim;
        this.dispatcher = sim.getDispatcher();
        this.incrocio = sim.getIncrocio();
        sim.setMonitor(this);
    }

    public void registraArrivo(String corsia) {
        synchronized (this) {
            Integer contatore = arriviPerCorsia.get(corsia);
            if (contatore == null) {
                contatore = 0;
            }
            arriviPerCorsia.put(corsia, contatore + 1);
            inCodaStimati++;
        }
    }

    public void registraInizioTransito(long tsInizio, long tsArrivo) {
        long tempoAttesa = tsInizio - tsArrivo;
        synchronized (this) {
            tempiAttesaMs.add(tempoAttesa);
            if (inCodaStimati > 0) {
                inCodaStimati--;
            }
        }
    }

    public void registraFineTransito(long tsFine, long tsInizio) {
        long durataTransito = tsFine - tsInizio;
        synchronized (this) {
            tempiTransitoMs.add(durataTransito);
            veicoliTransitati++;
        }
    }

    private double media(java.util.List<Long> lista) {
        long somma = 0;
        synchronized (this) {
            for (Long valore : lista) {
                somma += valore;
            }
            return lista.isEmpty()
                    ? 0.0
                    : (double) somma / lista.size();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                semaforo.FaseSemaforo fase = null;
                try {
                    if (incrocio != null
                            && incrocio.getSemaforo() != null) {
                        fase = incrocio
                                .getSemaforo()
                                .getFaseAttuale();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                double attesaMediaSecondi =
                        media(tempiAttesaMs) / 1000.0;
                double transitoMedioSecondi =
                        media(tempiTransitoMs) / 1000.0;
                String faseStr =
                        (fase == null)
                                ? "N/D"
                                : fase.toString().toUpperCase();
                System.out.println("\n========================================");
                System.out.println("         MONITOR TRAFFICO");
                System.out.println("========================================");
                System.out.println("FASE SEMAFORO : " + faseStr);
                System.out.println("VEICOLI       : " + veicoliTransitati);
                System.out.println("IN CODA       : ~" + inCodaStimati);
                System.out.printf(
                        "ATTESA MEDIA  : %.2f s%n",
                        attesaMediaSecondi
                );
                System.out.printf(
                        "TRANSITO MEDIO: %.2f s%n",
                        transitoMedioSecondi
                );
                System.out.println("----------------------------------------");
                arriviPerCorsia.forEach((corsia, contatore) -> {
                    String nomeCorsia;
                    switch (corsia) {
                        case "NS":
                            nomeCorsia = "Nord-Sud";
                            break;
                        case "EO":
                            nomeCorsia = "Est-Ovest";
                            break;
                        default:
                            nomeCorsia = corsia;
                    }
                    System.out.printf("%-15s -> %d arrivi%n", nomeCorsia, contatore);
                });
                System.out.println("========================================");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}