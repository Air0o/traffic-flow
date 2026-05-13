/*
 */
package traffic_flow;

import semaforo.FaseSemaforo;

/**
 *
 * @author GI.AIROLDI
 */
public class MonitorTrafficale extends Thread{
    private SimulazioneTrafficale sim;

    private Dispatcher dispatcher;
    private Incrocio incrocio;

    public MonitorTrafficale(SimulazioneTrafficale sim){
        this.sim = sim;

        dispatcher = sim.getDispatcher();
        incrocio = sim.getIncrocio();
    }

    @Override
    public void run() {
        //logga tutto
        while (true) { 
            try {   
                Thread.sleep(1000);
                
                System.out.printf("Stato semafori:\n");
                
                FaseSemaforo fase = incrocio.getSemaforo().getFaseAttuale();

                
                //System.out.printf("NS: %s\tEO: %s\n", );

            } catch (InterruptedException ex) {
                System.getLogger(MonitorTrafficale.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }
    
}
