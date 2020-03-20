package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Memorizza e gestisce un insieme di esami superati
 * 
 * @author Oscar
 *
 */

public class Libretto {

    private List<Voto> voti = new ArrayList<>();

    /**
     * Aggiunge un nuovo voto al libretto se non duplicato o conflittuale
     * 
     * @param v Voto da aggiungere
     * @return {@code true} se ha inserito il voto, {@code false} se non lo ha
     *         inserito perchè in conflitto o duplicato
     */
    public boolean add(Voto v) {
        if (this.isDuplicato(v) || this.isConflitto(v)) {
            return false;
        } else {
            this.voti.add(v);
            return true;
        }
    }

    /**
     * Dato un Libretto, restituisce una stringa nella quale vi sono solamente i
     * voti pari al valore passato come parametro
     * 
     * @param voto valore specificato
     * @return stringa formattata per visualizzare sotto-libretto
     */
    public String stampaVotiUguali(int voto) {
        String s = "";
        for (Voto v : this.voti) {
            if (v.getVoto() == voto) {
                s += v.toString() + "\n";
            }
        }
        return s;
    }

    /**
     * Genera un nuovo libretto, a partire da quello esistente che conterrà
     * esclusivamente i voti von votazione pari a quella specificata.
     * 
     * @param voto votazione specificata
     * @return nuovo Libretto "ridotto"
     */
    public Libretto estraiVotiUguali(int voto) {
        Libretto nuovo = new Libretto();
        for (Voto v : this.voti) {
            if (v.getVoto() == voto) {
                nuovo.add(v);
            }
        }
        return nuovo;
    }

    @Override
    public String toString() {
        String s = "";
        for (Voto v : this.voti) {
            s += v.toString() + "\n";
        }
        return s;
    }

    /**
     * Dato il nome di un corso ricerca se quell'esame esiste nel libretto, in caso
     * affermativo restituisce l'oggetto {@link Voto} corrispondente. Se l'esame non
     * esiste restituisce {@code null}.
     * 
     * @param nomeCorso nome esame da cercare
     * @return il {@link Voto} corrispondente oppure {@code null} se inesistente
     */
    public Voto cercaNomeCorso(String nomeCorso) {
        /*
         * for (Voto v : this.voti) { if (nomeCorso.equals(v.getCorso())) { return v; }
         * } return null;
         */
        int pos = this.voti.indexOf(new Voto(nomeCorso, 0, null));
        if (pos != -1) {
            return this.voti.get(pos);
        } else {
            return null;
        }

    }

    /**
     * Ritorna {@code true} se il corso specificato da {@code v} esiste nel libretto
     * con la stessa valuatzione. Se non esiste o se la valutazione è diversa
     * ritorna{@code false}.
     * 
     * @param v il {@link Voto} da ricercare
     * @return l'esistenza di un duplicato
     */
    public boolean isDuplicato(Voto v) {
        Voto esiste = this.cercaNomeCorso(v.getCorso());
        if (esiste == null) {
            return false;
        }
        return (esiste.getVoto() == v.getVoto());
    }

    /**
     * Determina se esiste un voto con lo stesso nome corso ma con valutazione
     * diversa.
     * 
     * @param v
     * @return
     */
    public boolean isConflitto(Voto v) {
        Voto esiste = this.cercaNomeCorso(v.getCorso());
        if (esiste == null) {
            return false;
        }
        return (esiste.getVoto() != v.getVoto());
    }

}
