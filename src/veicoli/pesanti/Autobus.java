/*
 */
package veicoli.pesanti;

import veicoli.IVeicoloPesante;
import veicoli.Veicolo;

/**
 *
 * @author GI.AIROLDI
 */
public class Autobus extends Veicolo implements IVeicoloPesante {
    
    public Autobus(String targa, Float tempoTransito, Integer priorita) {
        super(targa, tempoTransito, priorita);
    }
    
    @Override
    public String getDescrizione() {
        return "Autobus: " + super.getDescrizione();
    }
}
