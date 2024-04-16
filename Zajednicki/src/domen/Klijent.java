/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stefa
 */
public class Klijent implements OpstiDomenskiObjekat {

    private int klijentID;
    private String nazivKlijenta;
    private String adresa;
    private String grad;
    private String email;
    private String brojTelefona;

    public Klijent() {
    }

    public Klijent(int klijentId, String nazivKlijenta, String adresa, String grad, String email, String brojTelefona) {
        this.klijentID = klijentId;
        this.nazivKlijenta = nazivKlijenta;
        this.adresa = adresa;
        this.grad = grad;
        this.email = email;
        this.brojTelefona = brojTelefona;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    public String getNazivKlijenta() {
        return nazivKlijenta;
    }

    public void setNazivKlijenta(String nazivKlijenta) {
        this.nazivKlijenta = nazivKlijenta;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return nazivKlijenta;
    }

    @Override
    public String vratiNazivTabele() {
        return "Klijent";
    }

    @Override
    public String vratiNaziveKolona() {
        return "nazivKlijenta,adresa,grad,email,brojTelefona";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return "'" + nazivKlijenta + "','" + adresa + "','" + grad + "','" + email + "','" + brojTelefona + "'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " nazivKlijenta='" + nazivKlijenta + "',adresa='" + adresa + "',grad='" + grad + "',email='" + email + "',brojTelefona='" + brojTelefona + "'";
    }

    @Override
    public String vratiWhereUslov() {
        return "klijentID=" + klijentID;
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return "*";
    }

    @Override
    public String vratiAlijas() {
        return "k";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
    }

    @Override
    public String vratiWhereUslovSelect() {
        if (nazivKlijenta != null) {
            return " WHERE nazivKlijenta LIKE '%" + nazivKlijenta + "%'";
        }

        return "";
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaKlijenata = new ArrayList<>();
        while (rs.next()) {
            Klijent klijent = new Klijent(rs.getInt("klijentID"), rs.getString("nazivKlijenta"), rs.getString("adresa"), rs.getString("grad"), rs.getString("email"), rs.getString("brojTelefona"));
            listaKlijenata.add(klijent);
        }

        return listaKlijenata;
    }

    @Override
    public String vratiMaxPrimarni() {
        return "";
    }

}
