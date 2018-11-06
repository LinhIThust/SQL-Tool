/*

execute:dùng cho câu sql DDL (tạo, xóa, sửa bảng)
executeUpdate: dùng cho câu sql INSERT, UPDATE, DELETE
executeQuery: dùng câu sql SELECT

-Với những trường hợp SQL không cần truyền vào tham số thì 
sẽ sử dụng đối tượng Statement
-Với nhưng trường hợp SQL cần truyền vào tham số để filter trong việc 
select, delete, hay update thì sẽ sử dụng đối tượng PreparedStatement.


 */
package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public final class Controllerv2 extends javax.swing.JFrame {
    
    private final Connection conn = ConnectionSQL.getConnection();
    DefaultTableModel model;
    int xMouse, yMouse;
    
    public Controllerv2(String sql, String typeSQL) throws SQLException {
        initComponents();
        querySQL(sql, typeSQL);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        model = (DefaultTableModel) jTableTable.getModel();
//        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.MAGENTA));     
    }

    /**
     *
     * @param s:là tên database
     * @param condition : là hành động nó thực hiện có trả về hoặc k trả về
     * @return a string query!
     */
    
    public void querySQL(String sql, String condition) throws SQLException {
        switch (condition) {
            case "NORETURN":
                CreateEditDel(sql);
                break;
            case "RETURN":
                getInfo(sql);
                jLabel2.setVisible(false);
                break;
            default:;
        }
    }

    private void CreateEditDel(String sql) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
        jTableTable.setVisible(false);
        jLabel1.setVisible(false);
        
    }

    private void getInfo(String sql) throws SQLException {
        System.out.println(sql);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (!rs.equals(null)) {
            jTableTable.setModel(DbUtils.resultSetToTableModel(rs));
            jTableTable.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "LỖI");
        }
    }

    private void UpdateInsert(String sql) throws SQLException {
        System.out.println(sql);
        Statement st = conn.createStatement();
        int rs = st.executeUpdate(sql);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THÀNH CÔNG!");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 260, 90));

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
// để thực hiện việc di chuyển cửa sổ
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTable;
    // End of variables declaration//GEN-END:variables
}
