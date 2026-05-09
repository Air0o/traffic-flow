/*
 */
package veicoli.leggeri;

import veicoli.IVeicoloLeggero;
import veicoli.Veicolo;

/**
 *
 * @author GI.AIROLDI
 */
public class Motocicletta extends Veicolo implements IVeicoloLeggero {
    
    public Motocicletta(String targa, Float tempoTransito, Integer priorita) {
        super(targa, tempoTransito, priorita);
    }
    
    @Override
    public String getDescrizione() {
        return "Motocicletta: " + super.getDescrizione();
    }
}
