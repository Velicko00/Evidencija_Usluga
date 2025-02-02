/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import domen.OpstiDomenskiObjekat;
import java.io.Serializable;

public class KlijentskiObjekat implements Serializable {

    private int operacija;
    private OpstiDomenskiObjekat parametar;

    public KlijentskiObjekat() {
    }

    public KlijentskiObjekat(int operacija, OpstiDomenskiObjekat parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public OpstiDomenskiObjekat getParametar() {
        return parametar;
    }

    public void setParametar(OpstiDomenskiObjekat parametar) {
        this.parametar = parametar;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

}
