/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Usluga;
import domen.StavkaDokumenta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import logika.Kontroler;
import modeli.ModelTabeleUsluge;

/**
 *
 * @author stefa
 */
public class FrmKreirajStavku extends javax.swing.JDialog {

    StavkaDokumenta sd;

    public FrmKreirajStavku(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        sd = new StavkaDokumenta();
        sd.setJM("Sat");
        popuniTabeluUsluga();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsluge = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        lblKolicina = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        btnIzracunaj = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnDodajStavku = new javax.swing.JButton();
        btnPronadji = new javax.swing.JButton();
        lblUkupno = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCpJM = new javax.swing.JLabel();
        txtCpJM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbTip = new javax.swing.JComboBox<>();
        btnDetalji = new javax.swing.JButton();
        btnPrikaziSve = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblUsluge.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblUsluge);

        jLabel1.setText("Usluge:");

        lblKolicina.setText("Broj radnih sati:");

        btnIzracunaj.setText("Izracunaj");
        btnIzracunaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzracunajActionPerformed(evt);
            }
        });

        jLabel3.setText("Ukupna cena:");

        btnDodajStavku.setText("Dodaj stavku dokumenta");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        btnPronadji.setText("Pronadji");
        btnPronadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPronadjiActionPerformed(evt);
            }
        });

        lblUkupno.setText("0");

        jLabel4.setText("RSD");

        lblCpJM.setText("Cena po satu:");

        jLabel6.setText("Tip naplate:");

        cbTip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Po radnom satu", "Pausalno" }));
        cbTip.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipItemStateChanged(evt);
            }
        });

        btnDetalji.setText("Prikazi opis");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        btnPrikaziSve.setText("Prikazi sve");
        btnPrikaziSve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziSveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbTip, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCpJM)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCpJM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblKolicina)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21)
                                .addComponent(btnIzracunaj))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnPronadji, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnPrikaziSve)))
                                    .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDodajStavku)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFilter)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnPronadji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrikaziSve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDetalji)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCpJM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCpJM)
                            .addComponent(cbTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKolicina)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnIzracunaj)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblUkupno))))
                .addGap(18, 18, 18)
                .addComponent(btnDodajStavku)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzracunajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzracunajActionPerformed

        if (txtKolicina.getText().equals("") || !txtKolicina.getText().matches("[0-9]+") || Integer.parseInt(txtKolicina.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Morate ispravno uneti broj radnih sati", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtCpJM.getText().equals("") || !txtCpJM.getText().matches("[0-9]+") || Integer.parseInt(txtCpJM.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Morate ispravno uneti dogovorenu cenu", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int kolicina = Integer.parseInt(txtKolicina.getText());
        double cenaPoJM = Integer.parseInt(txtCpJM.getText());
        double cenaUkupno = kolicina * cenaPoJM;
        lblUkupno.setText(String.valueOf(cenaUkupno));
    }//GEN-LAST:event_btnIzracunajActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed

        int red = tblUsluge.getSelectedRow();

        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Morate izabrati uslugu", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (lblUkupno.getText().equals("") || Double.parseDouble(lblUkupno.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Morate izracunati ukupnu cenu", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtKolicina.getText().equals("") || !txtKolicina.getText().matches("[0-9]+") || Integer.parseInt(txtKolicina.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Morate ispravno uneti broj radnih sati", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ModelTabeleUsluge mtu = (ModelTabeleUsluge) tblUsluge.getModel();
        Usluga u = mtu.vratiUslugu(red);
        sd.setKolicina(Integer.parseInt(txtKolicina.getText()));
        sd.setCenaPoJM(Integer.parseInt(txtCpJM.getText()));
        sd.setCenaStavke(Integer.valueOf(txtCpJM.getText()) * Integer.valueOf(txtKolicina.getText()));
        sd.setUsluga(u);
        sd.setStavkaID(-1);
        
        if (getParent() instanceof FrmKreirajDokument fd) {
            sd.setDokument(null);
            fd.setSd(sd);
            fd.dodajStavku(sd);
            fd.popuniTabeluStavki();
        }
        if (getParent() instanceof FrmIzmeniDokument fd) {
            sd.setDokument(fd.getDokument());
            fd.setSd(sd);
            fd.dodajStavku(sd);
            fd.popuniTabeluStavki();
        }

        this.dispose();


    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnPronadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPronadjiActionPerformed
        List<Usluga> listaUsluga = Kontroler.getInstance().nadjiUsluge(txtFilter.getText());
        ModelTabeleUsluge mtu = new ModelTabeleUsluge(listaUsluga);
        tblUsluge.setModel(mtu);
    }//GEN-LAST:event_btnPronadjiActionPerformed

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        int red = tblUsluge.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Morate izabrati uslugu!", "Greska", JOptionPane.ERROR_MESSAGE);
        } else {
            ModelTabeleUsluge mtu = (ModelTabeleUsluge) tblUsluge.getModel();
            Usluga u = mtu.vratiUslugu(red);
            if (u.getOpisUsluge().length() > 17) {
                FrmOpisUsluge frm = new FrmOpisUsluge(null, true, u);
                frm.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnDetaljiActionPerformed

    private void btnPrikaziSveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziSveActionPerformed
        popuniTabeluUsluga();
    }//GEN-LAST:event_btnPrikaziSveActionPerformed

    private void cbTipItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipItemStateChanged
        if (cbTip.getSelectedItem().equals("Pausalno")) {
            sd.setJM("Pausalno");
            txtKolicina.setText("1");
            txtKolicina.setVisible(false);
            lblKolicina.setVisible(false);
            lblCpJM.setText("Cena usluge:");
        }
        if (cbTip.getSelectedItem().equals("Po radnom satu")) {
            sd.setJM("Sat");
            txtKolicina.setText("");
            txtKolicina.setVisible(true);
            lblKolicina.setVisible(true);
            lblCpJM.setText("Cena po satu:");
        }
    }//GEN-LAST:event_cbTipItemStateChanged

    private ArrayList<Usluga> popuniTabeluUsluga() {
        List<Usluga> usluge = Kontroler.getInstance().vratiListuUsluga();
        tblUsluge.setModel(new ModelTabeleUsluge(usluge));
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajStavku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajStavku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajStavku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajStavku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmKreirajStavku dialog = new FrmKreirajStavku(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnIzracunaj;
    private javax.swing.JButton btnPrikaziSve;
    private javax.swing.JButton btnPronadji;
    private javax.swing.JComboBox<String> cbTip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpJM;
    private javax.swing.JLabel lblKolicina;
    private javax.swing.JLabel lblUkupno;
    private javax.swing.JTable tblUsluge;
    private javax.swing.JTextField txtCpJM;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtKolicina;
    // End of variables declaration//GEN-END:variables

}
