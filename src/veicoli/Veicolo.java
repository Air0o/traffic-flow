/*
 */
package veicoli;

/**
 *
 * @author GI.AIROLDI
 */
public abstract class Veicolo {
    private String targa;
    private Float tempoTransito;
    private Integer priorita;

    public Veicolo(String targa, Float tempoTransito, Integer priorita) {
        this.targa = targa;
        this.tempoTransito = tempoTransito;
        this.priorita = priorita;
    }
    
    public String getDescrizione(){
        return "targa: " + targa + 
                ", tempoTransito: " + tempoTransito +
                ", priorita': " + priorita;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Float getTempoTransito() {
        return tempoTransito;
    }

    public void setTempoTransito(Float tempoTransito) {
        this.tempoTransito = tempoTransito;
    }

    public Integer getPriorita() {
        return priorita;
    }

    public void setPriorita(Integer priorita) {
        this.priorita = priorita;
    }
    
    
}
