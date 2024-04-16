/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Klijent;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stefa
 */
public class ModelTabeleKlijenti extends AbstractTableModel {

    List<Klijent> listaKlijenata;
    String[] kolone = {"Naziv", "Adresa", "Email", "Broj telefona"};

    public ModelTabeleKlijenti(List<Klijent> lista) {
        this.listaKlijenata = lista;
    }

    @Override
    public int getRowCount() {
        return listaKlijenata.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    public List<Klijent> getListaKlijenata() {
        return listaKlijenata;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent k = listaKlijenata.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getNazivKlijenta();
            case 1:
                return k.getAdresa() + ", " + k.getGrad();
            case 2:
                return k.getEmail();
            case 3:
                return k.getBrojTelefona();
            default:
                return "Default";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Klijent vratiKlijenta(int red) {
        return listaKlijenata.get(red);
    }

}
