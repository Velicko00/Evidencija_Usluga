/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Dokument;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stefa
 */
public class ModelTabeleDokumenti extends AbstractTableModel {

    List<Dokument> lista;
    String[] kolone = {"Klijent", "Ukupna cena", "Datum", "Tip", "Status", "Zaposleni"};

    public ModelTabeleDokumenti(List<Dokument> lista) {
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

    public List<Dokument> getListaDokumenata() {
        return lista;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dokument d = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getKlijent().getNazivKlijenta();
            case 1:
                return d.getUkupnaCena();
            case 2:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                sdf.setLenient(false);
                return sdf.format(d.getDatum());
            case 3:
                return d.getTipDokumenta();
            case 4:
                return d.getStatusDokumenta();
            case 5:
                return d.getZaposleni().getKorisnickoIme();
            default:
                return "Default";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Dokument vratiDokument(int red) {
        return lista.get(red);
    }

}
