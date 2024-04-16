/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import domen.Dokument;
import domen.Klijent;
import domen.StavkaDokumenta;
import domen.Usluga;
import domen.Zaposleni;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.KlijentskiObjekat;
import transfer.ServerskiObjekat;

/**
 *
 * @author stefa
 */
public class Kontroler {

    private static Kontroler instance;
    Zaposleni ulogovan;
    List<Klijent> listaKlijenata;
    List<Usluga> listaUsluga;
    List<Dokument> listaDokumenata;
    List<StavkaDokumenta> listaStavki;

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Zaposleni getUlogovan() {
        return ulogovan;
    }

    public boolean prijaviZaposlenog(Zaposleni z) {
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.PRIJAVIZAPOSLENOG);
        ko.setParametar(z);
        Komunikacija.getInstance().posaljiZahtev(ko);

        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        List<Zaposleni> listaZaposlenih = (List<Zaposleni>) so.getOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());

        if (listaZaposlenih == null || listaZaposlenih.isEmpty()) {
            return false;
        } else {
            ulogovan = listaZaposlenih.get(0);
            return true;
        }
    }

    public List<Klijent> vratiListuKlijenata() {
        Klijent k = new Klijent(-1, "", "", "", "", "");
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.VRATILISTUKLIJENATA);
        ko.setParametar(k);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        //JOptionPane.showMessageDialog(null, so.getPoruka());
        if (!so.isUspesno()) {
            return new ArrayList<>();
        }
        listaKlijenata = (List<Klijent>) so.getOdgovor();

        return listaKlijenata;
    }

    public List<Klijent> nadjiKlijente(String filter) {
        Klijent k = new Klijent(-1, filter, "", "", "", "");
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.NADJIKLIJENTE);
        ko.setParametar(k);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        if (!so.isUspesno()) {
            return new ArrayList<>();
        }
        listaKlijenata = (List<Klijent>) so.getOdgovor();

        return listaKlijenata;
    }

    public List<Usluga> vratiListuUsluga() {
        Usluga u = new Usluga(-1, "", "", Double.NaN);
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.VRATILISTUUSLUGA);
        ko.setParametar(u);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        //JOptionPane.showMessageDialog(null, so.getPoruka());
        if (!so.isUspesno()) {
            return new ArrayList<>();
        }
        listaUsluga = (List<Usluga>) so.getOdgovor();

        return listaUsluga;
    }

    public List<Usluga> nadjiUsluge(String text) {
        Usluga u = new Usluga(-1, text, "", Double.NaN);
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.NADJIUSLUGE);
        ko.setParametar(u);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        if (!so.isUspesno()) {
            return new ArrayList<>();
        }
        listaUsluga = (List<Usluga>) so.getOdgovor();

        return listaUsluga;
    }

    public boolean kreirajDokument(Dokument d) {
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.KREIRAJDOKUMENT);
        ko.setParametar(d);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        return so.isUspesno();
    }

    public boolean kreirajKlijenta(Klijent k) {
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.KREIRAJKLIJENTA);
        ko.setParametar(k);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        return so.isUspesno();
    }

    public boolean kreirajUslugu(Usluga u) {
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.KREIRAJUSLUGU);
        ko.setParametar(u);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        return so.isUspesno();
    }

    public boolean zapamtiKlijenta(Klijent k) {
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.ZAPAMTIKLIJENTA);
        ko.setParametar(k);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        return so.isUspesno();
    }

    public boolean obrisiKlijenta(Klijent k) {
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.OBRISIKLIJENTA);
        ko.setParametar(k);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        return so.isUspesno();
    }

    public boolean zapamtiUslugu(Usluga u) {
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.ZAPAMTIUSLUGU);
        ko.setParametar(u);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        return so.isUspesno();
    }

    public boolean obrisiUslugu(Usluga u) {
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.OBRISIUSLUGU);
        ko.setParametar(u);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        return so.isUspesno();
    }

    public ServerskiObjekat nadjiDokumente(String text) {
        Dokument d = new Dokument(-1, Double.NaN, null, "", "", null, new Klijent(-1, text, "", "", "", ""), null);
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.NADJIDOKUMENTE);
        ko.setParametar(d);
        Komunikacija.getInstance().posaljiZahtev(ko);
        return Komunikacija.getInstance().primiOdgovor();
    }

    public List<StavkaDokumenta> vratiListuStavki(Dokument d) {
        StavkaDokumenta sd = new StavkaDokumenta(-1, d, Double.NaN, Double.NaN, "", 0, null);
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.VRATILISTUSTAVKI);
        ko.setParametar(sd);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        //JOptionPane.showMessageDialog(null, so.getPoruka());
        if (!so.isUspesno()) {
            return new ArrayList<>();
        }
        listaStavki = (List<StavkaDokumenta>) so.getOdgovor();

        return listaStavki;
    }

    public boolean zapamtiDokument(Dokument d) {
        KlijentskiObjekat ko = new KlijentskiObjekat();
        ko.setOperacija(Operacije.ZAPAMTIDOKUMENT);
        ko.setParametar(d);
        Komunikacija.getInstance().posaljiZahtev(ko);
        ServerskiObjekat so = Komunikacija.getInstance().primiOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        return so.isUspesno();
    }

}
