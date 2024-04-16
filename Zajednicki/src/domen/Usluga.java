/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Usluga implements OpstiDomenskiObjekat {

    private int uslugaID;
    private String nazivUsluge;
    private String opisUsluge;
    private Double predlozenaCena;

    public Usluga() {
    }

    public Usluga(int uslugaID, String nazivUsluge, String opisUsluge, Double predlozenaCena) {
        this.uslugaID = uslugaID;
        this.nazivUsluge = nazivUsluge;
        this.opisUsluge = opisUsluge;
        this.predlozenaCena = predlozenaCena;
    }

    public int getUslugaID() {
        return uslugaID;
    }

    public void setUslugaID(int uslugaID) {
        this.uslugaID = uslugaID;
    }

    public String getNazivUsluge() {
        return nazivUsluge;
    }

    public void setNazivUsluge(String nazivUsluge) {
        this.nazivUsluge = nazivUsluge;
    }

    public String getOpisUsluge() {
        return opisUsluge;
    }

    public void setOpisUsluge(String opisUsluge) {
        this.opisUsluge = opisUsluge;
    }

    public Double getPredlozenaCena() {
        return predlozenaCena;
    }

    public void setPredlozenaCena(Double predlozenaCena) {
        this.predlozenaCena = predlozenaCena;
    }

    @Override
    public String toString() {
        return nazivUsluge;
    }

    @Override
    public String vratiNazivTabele() {
        return "Usluga";
    }

    @Override
    public String vratiNaziveKolona() {
        return "nazivUsluge,opisUsluge,predlozenaCena";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return "'" + nazivUsluge + "'," + "'" + opisUsluge + "','" + predlozenaCena + "'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " nazivUsluge='" + nazivUsluge + "',opisUsluge='" + opisUsluge + "',predlozenaCena='" + predlozenaCena + "'";
    }

    @Override
    public String vratiWhereUslov() {
        return "uslugaID=" + uslugaID;
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return "*";
    }

    @Override
    public String vratiAlijas() {
        return "u";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
    }

    @Override
    public String vratiWhereUslovSelect() {
        if (nazivUsluge != null) {
            return " WHERE nazivUsluge LIKE '%" + nazivUsluge + "%'";
        }

        return "";
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaUsluga = new ArrayList<>();
        while (rs.next()) {
            Usluga usluga = new Usluga(rs.getInt("uslugaID"), rs.getString("nazivUsluge"), rs.getString("opisUsluge"), rs.getDouble("predlozenaCena"));
            listaUsluga.add(usluga);
        }

        return listaUsluga;
    }

    @Override
    public String vratiMaxPrimarni() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
