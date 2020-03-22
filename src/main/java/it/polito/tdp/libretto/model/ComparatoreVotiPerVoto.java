package it.polito.tdp.libretto.model;

import java.util.Comparator;

public class ComparatoreVotiPerVoto implements Comparator<Voto> {

    @Override
    public int compare(Voto v1, Voto v2) {
        return v2.getVoto() - v1.getVoto();
    }

}
