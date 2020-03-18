package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * Classe Voto, contiene le informazioni su un esame superato
 * 
 * @author Oscar
 *
 */

public class Voto {

    private String corso; // Nome del corso di cui si è tenuto l'esame
    private int voto; // Voto ottenuto
    private LocalDate data; // Data dell'esame
    
    /**
     * Costruisce un nuovo Voto
     * @param corso nome del corso superato
     * @param voto valore del voto acquisito
     * @param data data di superamento dell'esame
     */
    public Voto(String corso, int voto, LocalDate data) {
        super();
        this.corso = corso;
        this.voto = voto;
        this.data = data;
    }

    public String getCorso() {
        return corso;
    }

    public void setCorso(String corso) {
        this.corso = corso;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return corso + ": " + voto + " (" + data + ")";
    }

    
    
}
