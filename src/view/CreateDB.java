/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Controllerv2;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LinhDzai
 */
public class CreateDB extends javax.swing.JFrame {

    DefaultTableModel model;

    /**
     * Creates new form CreateDB
     */
    public CreateDB(String s) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        model = (DefaultTableModel) jTable1.getModel();
        jLabelDB.setText(s);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTB = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonOK = new javax.swing.JButton();
        jButtonADD = new javax.swing.JButton();
        jLabelDB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("NAME TB:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, 20));

        jTextFieldTB.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTBActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 170, 30));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Property", "DataType", "NULL", "Key"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowHeight(28);
        jTable1.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jTable1.setSelectionForeground(new java.awt.Color(204, 204, 255));
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setMinWidth(50);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(3).setMinWidth(50);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 370, 360));

        jButtonOK.setText("OK");
        jButtonOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOKMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 110, 50));

        jButtonADD.setText("ADD");
        jButtonADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonADDMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 70, 40));

        jLabelDB.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabelDB.setText("NAME DB:");
        jPanel1.add(jLabelDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTBActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addThuocTinh();
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButtonOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOKMouseClicked
        //System.out.println(setQuery());
        try {
            link2Form(setQuery(), "CREATE");
            //jTextFieldTB.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(CreateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonOKMouseClicked

    private void jButtonADDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonADDMouseClicked
        addThuocTinh();
    }//GEN-LAST:event_jButtonADDMouseClicked

    public void addThuocTinh() {
        model.addRow(new Object[]{"", "",true,false});
    }

    public String setQuery() {
        String sql = "use "+jLabelDB.getText()+" Create table " + jTextFieldTB.getText() + " (";
        //vì cột bắt đàu từ 0
        int nR = model.getRowCount() - 1;
        int nC = model.getColumnCount() - 1;
        //System.out.println(nR+"   "+nC);
        for (int i = 0; i <= nR; i++) {
            String sRow = "";
            for (int j = 0; j < nC - 1; j++) {
                sRow += model.getValueAt(i, j);
                sRow += " ";
            }
            System.out.println(model.getValueAt(i, nC - 1)+"xxx");
            try {
                //System.out.println("cot=" + nC + "  " + "hang =" + i);
                if (model.getValueAt(i, nC - 1).toString().equals("false")) {
                    sRow += " NOT NULL";
                } else {
                    //System.out.println("view.CreateDB.setQuery()" + model.getValueAt(i, nC - 1));
                }
            } catch (Exception e) {
            }
            sql += sRow;
            sql += ", ";
        }
        
        //them khóa chính cho sql
        for (int i = 0; i <= nR; i++) {
            // System.out.println(model.getValueAt(i,nC));
            try {
                if (model.getValueAt(i, nC).toString().equals("true")) {
                    sql += "CONSTRAINT Khoa" + jTextFieldTB.getText() + " PRIMARY KEY ("
                            + model.getValueAt(i, 0) + ") ";
                }
            } catch (Exception e) {
            }

        }
        sql += " );";
        return sql;
    }

    public void link2Form(String x, String y) throws SQLException {
        new Controllerv2(x, y);
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
            java.util.logging.Logger.getLogger(CreateDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CreateDB().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonADD;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldTB;
    // End of variables declaration//GEN-END:variables
}
