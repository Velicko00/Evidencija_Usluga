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

public class Zaposleni implements OpstiDomenskiObjekat {

    private int zaposleniID;
    private String ime;
    private String prezime;
    private String email;
    private String korisnickoIme;
    private String lozinka;

    public Zaposleni() {
    }

    public Zaposleni(int zaposleniID, String ime, String prezime, String email, String korisnickoIme, String lozinka) {
        this.zaposleniID = zaposleniID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "Zaposleni";
    }

    @Override
    public String vratiNaziveKolona() {
        return "ime,prezime,email,korisnickoIme,lozinka";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return ime + "," + prezime + "," + email + "," + korisnickoIme + "," + lozinka;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiWhereUslov() {
        return "";
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return "*";
    }

    @Override
    public String vratiAlijas() {
        return "z";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
    }

    @Override
    public String vratiWhereUslovSelect() {
        return " where korisnickoIme='" + korisnickoIme + "' and lozinka='" + lozinka + "' LIMIT 1";
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaZaposlenih = new ArrayList<>();
        while (rs.next()) {
            Zaposleni zaposleni = new Zaposleni(rs.getInt("zaposleniID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("korisnickoIme"), rs.getString("lozinka"));

            listaZaposlenih.add(zaposleni);
        }

        return listaZaposlenih;
    }

    @Override
    public String vratiMaxPrimarni() {
        return "";
    }

}
