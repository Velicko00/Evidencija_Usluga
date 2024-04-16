/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskaOperacijaZaposleni;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Zaposleni;
import java.util.List;
import sistemskeOperacije.OpstaSistemskaOperacija;
import transfer.ServerskiObjekat;

/**
 *
 * @author stefa
 */
public class PrijaviZaposlenog extends OpstaSistemskaOperacija {

    Zaposleni ulogovani;

    @Override
    public ServerskiObjekat izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiObjekat transferObjekat = new ServerskiObjekat();
        try {
            List<OpstiDomenskiObjekat> lista = odo.ucitajListu(DBBroker.getInstance().select(odo));
            if (lista.size() == 0) {
                throw new Exception("Neuspesno prijavljivanje!");
            }
            transferObjekat.setOdgovor(lista);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Uspesno ste se prijavili na sistem!");
        } catch (Exception ex) {
            //Logger.getLogger(PrijaviZaposlenog.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno prijavljivanje!");
        }
        return transferObjekat;
    }

    @Override
    public void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Zaposleni)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zaposleni!");
        }
    }

    public Zaposleni getUlogovani() {
        return ulogovani;
    }

}
