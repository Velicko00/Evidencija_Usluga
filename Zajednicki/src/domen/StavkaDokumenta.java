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

public class StavkaDokumenta implements OpstiDomenskiObjekat {

    private int stavkaID;
    private Dokument dokument;
    private double cenaStavke;
    private double cenaPoJM;
    private String JM;
    private int kolicina;
    private Usluga usluga;
    private Boolean postoji = true;

    public StavkaDokumenta() {
    }

    public StavkaDokumenta(int stavkaID, Dokument dokument, double cenaStavke, double cenaPoJM, String JM, int kolicina, Usluga usluga) {
        this.stavkaID = stavkaID;
        this.dokument = dokument;
        this.cenaStavke = cenaStavke;
        this.cenaPoJM = cenaPoJM;
        this.JM = JM;
        this.kolicina = kolicina;
        this.usluga = usluga;
    }

    public StavkaDokumenta(int stavkaID, Dokument dokument, double cenaStavke, double cenaPoJM, String JM, int kolicina, Usluga usluga, Boolean postoji) {
        this.stavkaID = stavkaID;
        this.dokument = dokument;
        this.cenaStavke = cenaStavke;
        this.cenaPoJM = cenaPoJM;
        this.JM = JM;
        this.kolicina = kolicina;
        this.usluga = usluga;
        this.postoji = postoji;
    }

    public Boolean postoji() {
        return postoji;
    }

    public void setPostoji(Boolean postoji) {
        this.postoji = postoji;
    }

    public int getStavkaID() {
        return stavkaID;
    }

    public void setStavkaID(int stavkaID) {
        this.stavkaID = stavkaID;
    }

    public Dokument getDokument() {
        return dokument;
    }

    public void setDokument(Dokument dokument) {
        this.dokument = dokument;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

    public double getCenaPoJM() {
        return cenaPoJM;
    }

    public void setCenaPoJM(double cenaPoJM) {
        this.cenaPoJM = cenaPoJM;
    }

    public String getJM() {
        return JM;
    }

    public void setJM(String JM) {
        this.JM = JM;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    @Override
    public String vratiNazivTabele() {
        return "StavkaDokumenta";
    }

    @Override
    public String vratiNaziveKolona() {
        return "dokumentID,cenaStavke,cenaPoJM,JM,kolicina,uslugaID";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return dokument.getDokumentID() + "," + cenaStavke + "," + cenaPoJM + ",'" + JM + "'," + kolicina + "," + usluga.getUslugaID() + "";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "dokumentID=" + dokument.getDokumentID() + ",cenaStavke=" + cenaStavke + ",cenaPoJM=" + cenaPoJM + ",JM=" + JM + ",kolicina=" + kolicina + ",uslugaID=" + usluga.getUslugaID() + "";
    }

    @Override
    public String vratiWhereUslov() {
        return "stavkaID=" + stavkaID;
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return "*";
    }

    @Override
    public String vratiAlijas() {
        return "sd";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " join dokument d on sd.dokumentID=d.dokumentID join zaposleni z on d.zaposleniID=z.zaposleniID join klijent k on k.klijentID=d.klijentID join usluga u on sd.uslugaID=u.uslugaID";
    }

    @Override
    public String vratiWhereUslovSelect() {
        return "WHERE sd.dokumentID=" + dokument.getDokumentID();
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaSD = new ArrayList<>();
        while (rs.next()) {
            Zaposleni zaposleni = new Zaposleni(rs.getInt("zaposleniID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("z.email"), rs.getString("korisnickoIme"), rs.getString("lozinka"));
            Klijent klijent = new Klijent(rs.getInt("klijentID"), rs.getString("nazivKlijenta"), rs.getString("adresa"), rs.getString("grad"), rs.getString("k.email"), rs.getString("brojTelefona"));
            Dokument dokument = new Dokument(rs.getInt("dokumentID"), rs.getDouble("ukupnaCena"), rs.getDate("datum"), rs.getString("tipDokumenta"), rs.getString("statusDokumenta"), zaposleni, klijent, null);
            Usluga usluga = new Usluga(rs.getInt("uslugaID"), rs.getString("nazivUsluge"), rs.getString("opisUsluge"), rs.getDouble("predlozenaCena"));
            StavkaDokumenta stavka = new StavkaDokumenta(rs.getInt("stavkaID"), dokument, rs.getDouble("cenaStavke"), rs.getDouble("cenaPoJM"), rs.getString("JM"), rs.getInt("kolicina"), usluga);

            listaSD.add(stavka);
        }

        return listaSD;
    }

    @Override
    public String vratiMaxPrimarni() {
        return "";
    }

}
