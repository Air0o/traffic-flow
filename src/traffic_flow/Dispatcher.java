package traffic_flow;

import java.util.concurrent.*;
import transito.*;
import veicoli.*;

public class Dispatcher {
    
    private final Integer NUM_THREAD = 4;
    
    private final ExecutorService pool = Executors.newFixedThreadPool(NUM_THREAD);
    
    public void arrivo(Veicolo v, DirezioneTransito direzioneTransito, Incrocio incrocio){
        pool.submit(new TaskTransito(v, direzioneTransito, incrocio));
    }

    public void spegni(){
        pool.shutdown();
    }
}
