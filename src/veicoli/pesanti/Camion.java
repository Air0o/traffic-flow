/*
 */
package veicoli.pesanti;

import veicoli.IVeicoloPesante;
import veicoli.Veicolo;

/**
 *
 * @author GI.AIROLDI
 */
public class Camion extends Veicolo implements IVeicoloPesante {
    
    public Camion(String targa, Float tempoTransito, Integer priorita) {
        super(targa, tempoTransito, priorita);
    }
    
    @Override
    public String getDescrizione() {
        return "Ciamion: " + super.getDescrizione();
    }
    
}
