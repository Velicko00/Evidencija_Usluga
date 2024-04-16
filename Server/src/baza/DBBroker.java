/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.OpstiDomenskiObjekat;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stefa
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection konekcija;
    Properties properties = new Properties();
    ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<OpstiDomenskiObjekat>();

    public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    private DBBroker() {
        try {
            properties.load(new FileInputStream("dbconfig.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("user");
            String password = properties.getProperty("password");
            konekcija = DriverManager.getConnection(url, username, password);
            konekcija.setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public void otvoriKonekciju() throws SQLException {
        konekcija = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
        konekcija.setAutoCommit(false);
    }

    public void zatvoriKonekciju() throws SQLException {
        konekcija.close();
    }

    public void commit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getKonekcija() {
        return konekcija;
    }

    public ResultSet select(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT " + odo.vratiKoloneZaSelektovanje() + " FROM " + odo.vratiNazivTabele() + " as " + odo.vratiAlijas()
                + odo.vratiUslovZaJoin() + " " + odo.vratiWhereUslovSelect() + odo.vratiGrupisanje();
        //System.out.println(upit);
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        return rs;
    }

    public void insert(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiNaziveKolona() + ")" + " VALUES (" + odo.vratiVrednostiZaUnos() + ")";
        // System.out.println(upit);
        Statement statement = konekcija.createStatement();
        statement.executeUpdate(upit);
        statement.close();
    }

    public void update(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " + odo.vratiWhereUslov();
        //System.out.println(upit);
        Statement statement = konekcija.createStatement();
        statement.executeUpdate(upit);
        statement.close();
    }

    public void delete(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiWhereUslov();
        //System.out.println(upit);
        Statement statement = konekcija.createStatement();
        statement.executeUpdate(upit);
        statement.close();
    }

    public int vratiID(OpstiDomenskiObjekat odo) throws SQLException {
        int maks = 0;
        String upit = "SELECT max(" + odo.vratiMaxPrimarni() + ") as maksKljuc FROM " + odo.vratiNazivTabele();
        //System.out.println(upit);
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        while (rs.next()) {
            maks = rs.getInt("maksKljuc");
        }
        return maks;
    }

}
