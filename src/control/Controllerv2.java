package control;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import view.Main;

public class Controllerv2 extends javax.swing.JFrame {

    private Connection conn = ConnectionSQL.getConnection();
    DefaultTableModel model;
    int xMouse, yMouse;

    public Controllerv2(String x, String y) {
        initComponents();
        querySQL(x,y);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        model = (DefaultTableModel) jTableTable.getModel();
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.MAGENTA));
        
    }

  /**
   *
   @param s:là tên database
   @param condition : là hành động nó thực hiện,edit,xóa,..
   @return  a string query!
   */
    public void querySQL(String s, String condition) {
        switch (condition) {
            case "DROP":
                String sql ="DROP DATABASE "+ s;
                setInfo(sql);
                System.out.println(sql);
                dispose();
                break;
            case "EDIT":break;
            case "UPDATE":break;
            case "CREATE":
                setInfo(s);
                break;
            default:getInfoDB(s);
        }
       
    }
    /**
     @param sql : là 1 câu lệnh query
     @deprecated : thực hiện câu lệnh sql trả về từ  hàm querySQL
     * @return :null
     */
    private void setInfo(String sql){
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
               int rs = ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane,"Thành Công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Câu truy Vấn sai");
        }
    }
      /*
    Hàm getInfoDB1 dùng rất nhiều với các ý tưởng khác nhau tùy vào điều
    kiện if
    -với đầu đủ đầu vào 2 tham số t thực hiện bitnh thường
   - với đầi vào là 1 có 1 rỗng thực hiện theo câu truy vấn...
    
     */
    private void getInfoDB(String sql) {
        System.out.println(sql);
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (!rs.equals(null)) {
                //System.out.println(rs.getArray(1));
                jTableTable.setModel(DbUtils.resultSetToTableModel(rs));
                jTableTable.setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Câu truy vấn không đúng!");
            this.dispose();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(2, 2, 2, 2));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("X");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 40, 30));

        jLabel1.setText("TABLE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableTable);
        jTableTable.getAccessibleContext().setAccessibleParent(this);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 480, 305));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x1 = evt.getXOnScreen();
        int y1 = evt.getYOnScreen();
        setLocation(x1 - xMouse, y1 - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTable;
    // End of variables declaration//GEN-END:variables
}
