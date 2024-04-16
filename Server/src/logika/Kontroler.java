/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import domen.OpstiDomenskiObjekat;
import sistemskaOperacijaZaposleni.PrijaviZaposlenog;
import sistemskeOperacijeDokumenti.KreirajDokument;
import sistemskeOperacijeDokumenti.NadjiDokumente;
import sistemskeOperacijeDokumenti.VratiListuStavki;
import sistemskeOperacijeDokumenti.ZapamtiDokument;
import sistemskeOperacijeKlijenti.KreirajKlijenta;
import sistemskeOperacijeKlijenti.NadjiKlijente;
import sistemskeOperacijeKlijenti.ObrisiKlijenta;
import sistemskeOperacijeKlijenti.VratiListuKlijenata;
import sistemskeOperacijeKlijenti.ZapamtiKlijenta;
import sistemskeOperacijeUsluge.KreirajUslugu;
import sistemskeOperacijeUsluge.NadjiUsluge;
import sistemskeOperacijeUsluge.ObrisiUslugu;
import sistemskeOperacijeUsluge.VratiListuUsluga;
import sistemskeOperacijeUsluge.ZapamtiUslugu;
import transfer.ServerskiObjekat;

/**
 *
 * @author stefa
 */
public class Kontroler {

    private static Kontroler instance;

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public ServerskiObjekat prijaviZaposlenog(OpstiDomenskiObjekat odo) {
        return new PrijaviZaposlenog().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat vratiListuKlijenata(OpstiDomenskiObjekat odo) {
        return new VratiListuKlijenata().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat nadjiKlijente(OpstiDomenskiObjekat odo) {
        return new NadjiKlijente().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat vratiListuUsluga(OpstiDomenskiObjekat odo) {
        return new VratiListuUsluga().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat nadjiUsluge(OpstiDomenskiObjekat odo) {
        return new NadjiUsluge().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat kreirajDokument(OpstiDomenskiObjekat odo) {
        return new KreirajDokument().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat kreirajKlijenta(OpstiDomenskiObjekat odo) {
        return new KreirajKlijenta().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat kreirajUslugu(OpstiDomenskiObjekat odo) {
        return new KreirajUslugu().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat zapamtiKlijenta(OpstiDomenskiObjekat odo) {
        return new ZapamtiKlijenta().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat obrisiKlijenta(OpstiDomenskiObjekat odo) {
        return new ObrisiKlijenta().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat zapamtiUslugu(OpstiDomenskiObjekat odo) {
        return new ZapamtiUslugu().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat obrisiUslugu(OpstiDomenskiObjekat odo) {
        return new ObrisiUslugu().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat nadjiDokumente(OpstiDomenskiObjekat odo) {
        return new NadjiDokumente().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat vratiListuStavki(OpstiDomenskiObjekat odo) {
        return new VratiListuStavki().izvrsiTransakciju(odo);
    }

    public ServerskiObjekat zapamtiDokument(OpstiDomenskiObjekat odo) {
        return new ZapamtiDokument().izvrsiTransakciju(odo);
    }

}
