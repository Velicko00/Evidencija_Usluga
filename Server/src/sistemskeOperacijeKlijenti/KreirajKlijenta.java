/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeOperacijeKlijenti;

import baza.DBBroker;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemskeOperacije.OpstaSistemskaOperacija;
import transfer.ServerskiObjekat;

/**
 *
 * @author stefa
 */
public class KreirajKlijenta extends OpstaSistemskaOperacija {

    @Override
    public ServerskiObjekat izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiObjekat transferObjekat = new ServerskiObjekat();
        try {
            DBBroker.getInstance().insert(odo);
            transferObjekat.setOdgovor(null);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Novi klijent je uspesno kreiran!");
        } catch (SQLException ex) {
            Logger.getLogger(KreirajKlijenta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da kreira klijenta");
        }
        return transferObjekat;
    }

    @Override
    public void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Klijent)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Klijent!");
        }
    }

}
