/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaDokumenta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stefa
 */
public class ModelTabeleStavke extends AbstractTableModel {

    List<StavkaDokumenta> lista;
    String[] kolone = {"Naziv", "Cena po JM", "Pausalno/po satu", "Kolicina", "Ukupna cena"};

    public ModelTabeleStavke(List<StavkaDokumenta> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    public List<StavkaDokumenta> getListaStavki() {
        return lista;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaDokumenta sd = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sd.getUsluga().getNazivUsluge();
            case 1:
                return sd.getCenaPoJM();
            case 2:
                return sd.getJM();
            case 3:
                return sd.getKolicina();
            case 4:
                return sd.getCenaStavke();
            default:
                return "Default";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public StavkaDokumenta vratiStavku(int red) {
        return lista.get(red);
    }

    public void obrisiStavku(StavkaDokumenta s) {
        lista.remove(s);
        fireTableDataChanged();
    }

}
