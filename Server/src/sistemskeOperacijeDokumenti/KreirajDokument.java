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
public class KreirajDokument extends OpstaSistemskaOperacija {

    @Override
    public ServerskiObjekat izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiObjekat transferObjekat = new ServerskiObjekat();
        try {
            DBBroker.getInstance().insert(odo);
            Dokument d = (Dokument) odo;
            d.setDokumentID(DBBroker.getInstance().vratiID(odo));
            for (StavkaDokumenta sd : d.getListaStavki()) {
                sd.setDokument(d);
                DBBroker.getInstance().insert(sd);
            }
            transferObjekat.setOdgovor(null);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Novi dokument je uspesno kreiran!");
        } catch (SQLException ex) {
            Logger.getLogger(KreirajDokument.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da kreira dokument");
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
