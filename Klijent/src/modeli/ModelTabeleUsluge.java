/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Usluga;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stefa
 */
public class ModelTabeleUsluge extends AbstractTableModel {

    List<Usluga> lista;
    String[] kolone = {"Naziv", "Predlozena cena", "Opis"};

    public ModelTabeleUsluge(List<Usluga> lista) {
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

    public List<Usluga> getListaUsluga() {
        return lista;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usluga u = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return u.getNazivUsluge();
            case 1:
                return u.getPredlozenaCena();
            case 2:
                if (u.getOpisUsluge().length() > 17) {
                    return u.getOpisUsluge().substring(0, 17) + " (17+)";
                }
                return u.getOpisUsluge();
            default:
                return "Default";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Usluga vratiUslugu(int red) {
        return lista.get(red);
    }

}
