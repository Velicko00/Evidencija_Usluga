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
import java.util.List;
import sistemskeOperacije.OpstaSistemskaOperacija;
import transfer.ServerskiObjekat;

/**
 *
 * @author stefa
 */
public class VratiListuKlijenata extends OpstaSistemskaOperacija {

    @Override
    public ServerskiObjekat izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiObjekat transferObjekat = new ServerskiObjekat();
        try {
            List<OpstiDomenskiObjekat> lista = odo.ucitajListu(DBBroker.getInstance().select(odo));
            transferObjekat.setOdgovor(lista);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Sistem je uspesno vratio sve klijente!");
        } catch (SQLException ex) {
            //Logger.getLogger(VratiListuKlijenata.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da nadje klijente");
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
