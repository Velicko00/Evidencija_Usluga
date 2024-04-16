/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeOperacije;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import transfer.ServerskiObjekat;

/**
 *
 * @author stefa
 */
public abstract class OpstaSistemskaOperacija {

    public ServerskiObjekat izvrsiTransakciju(OpstiDomenskiObjekat odo) {
        ServerskiObjekat transferObjekat = new ServerskiObjekat();
        try {
            DBBroker.getInstance().otvoriKonekciju();
            izvrsiValidaciju(odo);
            transferObjekat = izvrsiOperaciju(odo);
            DBBroker.getInstance().commit();
        } catch (Exception ex) {
            //Logger.getLogger(OpstaSistemskaOperacija.class.getName()).log(Level.SEVERE, null, ex);
            DBBroker.getInstance().rollback();
            transferObjekat.setUspesno(false);
            transferObjekat.setPoruka(ex.getMessage());
        } finally {
            try {
                DBBroker.getInstance().zatvoriKonekciju();
            } catch (SQLException ex) {
                transferObjekat.setUspesno(false);
                transferObjekat.setPoruka(ex.getMessage());
            }
        }

        return transferObjekat;
    }

    public abstract ServerskiObjekat izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception;

    public abstract void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception;

}
