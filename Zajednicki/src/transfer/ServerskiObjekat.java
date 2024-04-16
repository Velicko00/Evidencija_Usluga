/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

public class ServerskiObjekat implements Serializable {

    private String poruka;
    private Object odgovor;
    private boolean uspesno;

    public ServerskiObjekat() {
    }

    public ServerskiObjekat(String poruka, Object odgovor, boolean uspijesno) {
        this.poruka = poruka;
        this.odgovor = odgovor;
        this.uspesno = uspijesno;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

}
