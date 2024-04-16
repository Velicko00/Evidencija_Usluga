/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeOperacijeDokumenti;

import baza.DBBroker;
import domen.Dokument;
import domen.OpstiDomenskiObjekat;
import domen.StavkaDokumenta;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemskeOperacije.OpstaSistemskaOperacija;
import transfer.ServerskiObjekat;

/**
 *
 * @author stefa
 */
public class ZapamtiDokument extends OpstaSistemskaOperacija {

    @Override
    public ServerskiObjekat izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiObjekat transferObjekat = new ServerskiObjekat();
        try {
            DBBroker.getInstance().update(odo);
            Dokument d = (Dokument) odo;
            for (StavkaDokumenta sd : d.getListaStavki()) {
                if (sd.postoji()) {
                    DBBroker.getInstance().insert(sd);
                }else{
                    DBBroker.getInstance().delete(sd);
                }
            }
            transferObjekat.setOdgovor(null);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Dokument je uspesno zapamcen!");
        } catch (SQLException ex) {
            Logger.getLogger(ZapamtiDokument.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da zapamti dokument");
        }
        return transferObjekat;
    }

    @Override
    public void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Dokument)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Dokument!");
        }
    }

}
