package traffic_flow;

/*
SimulazioneTrafficale genera un nuovo Veicolo, crea una TaskTransito e la invia al Dispatcher
TaskTransito contiene la direzione nella quale il veicolo deve transitare (NS/EO)
TaskTransito chiama il corrispettivo metodo di Incrocio
Incrocio ha due Semaforo

 */

public class Traffic_flow {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        SimulazioneTrafficale simulazione = new SimulazioneTrafficale();

        try {
            simulazione.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
