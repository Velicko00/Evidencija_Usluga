/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class NadjiKlijente extends OpstaSistemskaOperacija {

    @Override
    public ServerskiObjekat izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiObjekat transferObjekat = new ServerskiObjekat();
        try {
            List<OpstiDomenskiObjekat> lista = odo.ucitajListu(DBBroker.getInstance().select(odo));
            transferObjekat.setOdgovor(lista);
            if (lista.isEmpty()) {
                transferObjekat.setUspesno(false);
                transferObjekat.setPoruka("Sistem ne moze da nadje klijente po zadatoj vrednosti");
            } else {
                transferObjekat.setUspesno(true);
                transferObjekat.setPoruka("Pronadjeni su klijenti po zadatoj vrednosti!");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(VratiListuKlijenata.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da nadje klijente po zadatoj vrednosti");
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
