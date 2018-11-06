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
import view.CreateDB;

/**
 *
 * @author LinhDzai
 */
public class StringDB extends javax.swing.JFrame {

    DefaultTableModel model;

    /**
     * Creates new form CreateDB
     */
    public StringDB() {
        initComponents();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
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
        jButtonOK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDB = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonOK.setText("OK");
        jButtonOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOKMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 110, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("NAME DB:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 20));

        jTextFieldDB.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDBActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 170, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOKMouseClicked

        try {
            new Controllerv2("create database "+jTextFieldDB.getText(), "NORETURN");
        } catch (SQLException ex) {
            Logger.getLogger(StringDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        link2Form(jTextFieldDB.getText());
    }//GEN-LAST:event_jButtonOKMouseClicked

    private void jTextFieldDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDBActionPerformed

    }//GEN-LAST:event_jTextFieldDBActionPerformed

    public void link2Form(String nameDB) {
        CreateDB m = new CreateDB(nameDB);
        m.setVisible(true);
        m.pack();
        m.setLocationRelativeTo(null);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

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
            java.util.logging.Logger.getLogger(StringDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StringDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StringDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StringDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StringDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldDB;
    // End of variables declaration//GEN-END:variables
}
