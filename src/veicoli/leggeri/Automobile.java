/*
 */
package veicoli.leggeri;

import veicoli.IVeicoloLeggero;
import veicoli.Veicolo;

/**
 *
 * @author GI.AIROLDI
 */
public class Automobile extends Veicolo implements IVeicoloLeggero{

    public Automobile(String targa, Float tempoTransito, Integer priorita) {
        super(targa, tempoTransito, priorita);
    }

    @Override
    public String getDescrizione() {
        return "Automobile: " + super.getDescrizione();
    }
    
}
