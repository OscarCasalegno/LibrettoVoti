package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

    Libretto lib;

    private void run() {
        this.lib = new Libretto(); // crea libretto vuoto

        // 1. inserire alcuni voti
        Voto v1 = new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15));
        Voto v2 = new Voto("Analisi II", 28, LocalDate.of(2020, 06, 28));

        lib.add(v1);
        lib.add(v2);
        if (lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14))) == false) {
            System.out.println("Errore nell'inserimento di Economia");
        }
        System.out.println(this.lib);

        // 2. stampa tutti i voti uguali a 28
        System.out.println(this.lib.stampaVotiUguali(28));

        System.out.println(this.lib.estraiVotiUguali(28));

        // 3. cerca un esame superato conoscendo il corso

        String nomeCorso = "Analisi II";
        Voto votoAnalisi = lib.cercaNomeCorso(nomeCorso);
        System.out.println("Il voto di " + nomeCorso + " e' " + votoAnalisi.getVoto());
        Voto votoMancante = lib.cercaNomeCorso("Fisica I");
        System.out.println("Il voto di Fisica I e' " + votoMancante);

        // 4. Verifica voto già esistente
        // 5. Verifica conflitto voti

        Voto economia2 = new Voto("Economia", 24, LocalDate.now());
        Voto economia3 = new Voto("Economia", 21, LocalDate.now());
        System.out.println("Economia con 24 è duplicato: " + lib.isDuplicato(economia2)
                + " /conflitto: " + lib.isConflitto(economia2));
        System.out.println("Economia con 21 è duplicato: " + lib.isDuplicato(economia3)
                + " /conflitto: " + lib.isConflitto(economia3));

        // 6. Evitare votazioni duplicate(modifica add in libretto)

        // 7. libretto migliorato

        Libretto migliorato = lib.creaLibrettoMigliorato();
        System.out.println("\nMiglioramento del liberetto");
        System.out.println(lib);
        System.out.println(migliorato);

        // 8. stampa in ordine alfabetico
        Libretto alfabetico = new Libretto(lib);
        alfabetico.ordinaPerCorso();
        System.out.println(alfabetico);
        // 8. stampa in ordine di voto
        Libretto votiDecrescenti = new Libretto(lib);
        alfabetico.ordinaPerVoto();
        System.out.println(votiDecrescenti);

        // 9 Elimina voti bassi
        lib.add(new Voto("Chimica", 19, LocalDate.now()));
        lib.ordinaPerCorso();
        System.out.println(lib);
        lib.cancellaVotiScarsi();
        System.out.println(lib);
    }

    public static void main(String[] args) {
        TestLibretto test = new TestLibretto();
        test.run();
    }

}
