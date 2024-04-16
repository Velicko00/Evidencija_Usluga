/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dokument implements OpstiDomenskiObjekat {

    private int dokumentID;
    private double ukupnaCena;
    private Date datum;
    private String tipDokumenta;
    private String statusDokumenta;
    private Zaposleni zaposleni;
    private Klijent klijent;
    ArrayList<StavkaDokumenta> listaStavki;

    public Dokument() {
    }

    public Dokument(int dokumentID, double ukupnaCena, Date datum, String tipDokumenta, String statusDokumenta, Zaposleni zaposleni, Klijent klijent, ArrayList<StavkaDokumenta> listaStavki) {
        this.dokumentID = dokumentID;
        this.ukupnaCena = ukupnaCena;
        this.datum = datum;
        this.tipDokumenta = tipDokumenta;
        this.statusDokumenta = statusDokumenta;
        this.zaposleni = zaposleni;
        this.klijent = klijent;
        this.listaStavki = listaStavki;
    }

    public int getDokumentID() {
        return dokumentID;
    }

    public void setDokumentID(int dokumentID) {
        this.dokumentID = dokumentID;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getTipDokumenta() {
        return tipDokumenta;
    }

    public void setTipDokumenta(String tipDokumenta) {
        this.tipDokumenta = tipDokumenta;
    }

    public String getStatusDokumenta() {
        return statusDokumenta;
    }

    public void setStatusDokumenta(String statusDokumenta) {
        this.statusDokumenta = statusDokumenta;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public ArrayList<StavkaDokumenta> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(ArrayList<StavkaDokumenta> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public String vratiNazivTabele() {
        return "Dokument";
    }

    @Override
    public String vratiNaziveKolona() {
        return "ukupnaCena,datum,tipDokumenta,statusDokumenta,zaposleniID,klijentID";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return ukupnaCena + ",'" + new java.sql.Date(datum.getTime()) + "','" + tipDokumenta + "','" + statusDokumenta + "'," + zaposleni.getZaposleniID() + "," + klijent.getKlijentID();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "ukupnaCena=" + ukupnaCena + ",datum='" + new java.sql.Date(datum.getTime()) + "',tipDokumenta='" + tipDokumenta + "',statusDokumenta='" + statusDokumenta + "'";
    }

    @Override
    public String vratiWhereUslov() {

        if (klijent != null) {
            return " klijentID=" + klijent.getKlijentID() + " AND dokumentID=" + dokumentID;
        }

        return "";
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return "*";
    }

    @Override
    public String vratiAlijas() {
        return "d";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " join klijent k on d.klijentID=k.klijentID join zaposleni z on d.zaposleniID=z.zaposleniID ";
    }

    @Override
    public String vratiWhereUslovSelect() {
        if (klijent != null) {
            return "where nazivKlijenta LIKE '%" + klijent.getNazivKlijenta() + "%'";
        }

        return "";
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaDokumenata = new ArrayList<>();
        while (rs.next()) {
            Zaposleni zaposleni = new Zaposleni(rs.getInt("zaposleniID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("z.email"), rs.getString("korisnickoIme"), rs.getString("lozinka"));
            Klijent klijent = new Klijent(rs.getInt("klijentID"), rs.getString("nazivKlijenta"), rs.getString("adresa"), rs.getString("grad"), rs.getString("k.email"), rs.getString("brojTelefona"));
            Dokument dokument = new Dokument(rs.getInt("dokumentID"), rs.getDouble("ukupnaCena"), rs.getDate("datum"), rs.getString("tipDokumenta"), rs.getString("statusDokumenta"), zaposleni, klijent, listaStavki);
            listaDokumenata.add(dokument);
        }

        return listaDokumenata;
    }

    @Override
    public String vratiMaxPrimarni() {
        return "dokumentID";
    }

}
