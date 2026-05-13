/*
 */
package veicoli;

import java.util.Random;
import veicoli.leggeri.Automobile;
import veicoli.leggeri.Motocicletta;
import veicoli.pesanti.Autobus;
import veicoli.pesanti.Camion;

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
    
    public static Veicolo generaVeicolo(){
        Random random = new Random();
        int n = random.nextInt(4);
        Float tempoTransitoRandom = random.nextFloat(8);
        int prioritaRandom = random.nextInt(1);
        
        
        tempoTransitoRandom +=1;
        n +=1;
        switch(n){
            case 1 -> {
                return new Automobile(generaTarga(), tempoTransitoRandom, prioritaRandom);
            }
            case 2 -> {
                return new Motocicletta(generaTarga(), tempoTransitoRandom, prioritaRandom);
            }
            case 3 -> {
                return new Autobus(generaTarga(), tempoTransitoRandom, prioritaRandom);
            }
        }
        return new Camion(generaTarga(), tempoTransitoRandom, prioritaRandom);
    }
    
    private static String generaTarga() {
        Random random = new Random();
        StringBuilder targa = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            targa.append((char) ('A' + random.nextInt(26)));
        }

        for (int i = 0; i < 3; i++) {
            targa.append(random.nextInt(10));
        }

        for (int i = 0; i < 2; i++) {
            targa.append((char) ('A' + random.nextInt(26)));
        }

        return targa.toString();
    }
    
}
