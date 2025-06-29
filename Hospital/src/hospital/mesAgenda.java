/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospital;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Date;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author SBS
 */
public class mesAgenda extends javax.swing.JFrame {

    login l;
    Connection con=null;
    private Preferences prefs;
    /**
     * Creates new form mesAgenda
     */
    public mesAgenda() {
        initComponents();
        centerFrameOnScreen();
        displayRendez_vous();
        l=new login();
        String nom=l.getDoctor();
        medecinNom.setText(nom);
        prefs = Preferences.userNodeForPackage(mesAgenda.class);

        // Set the custom cell renderer based on the stored preferences
        int storedRow = prefs.getInt("storedRow", -1);
        if (storedRow != -1) {
            tablerv.setDefaultRenderer(Object.class, new CustomTableCellRenderer(storedRow));
        }

        // Assuming you have a button named jButton2
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));
    }
private void centerFrameOnScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2;

        int frameWidth = this.getSize().width;
        int frameHeight = this.getSize().height;

        int setLocationX = centerX - frameWidth / 2;
        int setLocationY = centerY - frameHeight / 2;

        this.setLocation(setLocationX, setLocationY);
    }
private void displayRendez_vous() {
        try {
            l=new login();
            String nom=l.getDoctor();
            con = (Connection) connexion.getConnect();
            String sql = "SELECT * FROM patient WHERE mondoc = ?";
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
            statement.setString(1, nom);
            ResultSet resultSet = (ResultSet) statement.executeQuery();

            
            
            String Name=null;
            String prenom=null;
            
            DefaultTableModel model = (DefaultTableModel) tablerv.getModel();
            model.setRowCount(0); // Clear existing rows
            
            while (resultSet.next()) {
                
                Name = resultSet.getString("nom");
                prenom = resultSet.getString("prenom"); 
                String fullname=Name+" "+prenom ;
                String adresse = resultSet.getString("adresse"); 
                String email = resultSet.getString("email"); 
                Date date=null;
                
                String sql1 = "SELECT date FROM rendez_vous WHERE nompatient = ?";
            PreparedStatement statement1 = (PreparedStatement) con.prepareStatement(sql1);
            statement1.setString(1, fullname);
            ResultSet resultSet1 = (ResultSet) statement1.executeQuery();
            
            while (resultSet1.next()) {

                 date = resultSet1.getDate("date");

            }
            System.out.println();
                
                
            }

            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        medecinNom = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        consultation = new javax.swing.JButton();
        patients = new javax.swing.JButton();
        Acceuil = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablerv = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        medecinNom.setBackground(new java.awt.Color(204, 204, 255));
        medecinNom.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        medecinNom.setForeground(new java.awt.Color(51, 0, 255));
        medecinNom.setText("mdecin");
        getContentPane().add(medecinNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 6, 161, 41));

        jButton1.setText("Quitter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, -1));

        consultation.setText("Mon Agenda");
        consultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultationActionPerformed(evt);
            }
        });
        getContentPane().add(consultation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, -1));

        patients.setText("Mes Patients");
        patients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientsActionPerformed(evt);
            }
        });
        getContentPane().add(patients, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));

        Acceuil.setText("Acceuil");
        Acceuil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceuilActionPerformed(evt);
            }
        });
        getContentPane().add(Acceuil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/turn-left.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        jButton2.setText("Accepter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, -1, -1));

        tablerv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "nom", "prenom", "adresse", "e-mail", "date rendez_vous"
            }
        ));
        jScrollPane1.setViewportView(tablerv);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 500, 260));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/doctorr.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void consultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultationActionPerformed

        new mesAgenda().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_consultationActionPerformed

    private void patientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientsActionPerformed
        new mesPatient().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_patientsActionPerformed

    private void AcceuilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceuilActionPerformed

    }//GEN-LAST:event_AcceuilActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        new login().setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        int selectedRowIndex = tablerv.getSelectedRow();

        if (selectedRowIndex != -1) {
            
            DefaultTableModel model = (DefaultTableModel) tablerv.getModel();

            String nom = model.getValueAt(selectedRowIndex, 0).toString();
            String prenom = model.getValueAt(selectedRowIndex, 1).toString();
            
            con = (Connection) connexion.getConnect();
            String sql2 = "insert into boite values (?,?)";
            try {
            PreparedStatement statement2 = (PreparedStatement) con.prepareStatement(sql2);
            statement2.setString(1, nom+" "+prenom);
            statement2.setString(2, "votre rendez_vous est acceptee");
            statement2.executeUpdate();
            JOptionPane.showMessageDialog(null, "rendez_vous accepté");
            } catch (Exception e) {
                e.printStackTrace();
            }
            

            
            
           
            tablerv.setDefaultRenderer(Object.class, (TableCellRenderer) new CustomTableCellRenderer(selectedRowIndex));

            prefs.putInt("storedRow", selectedRowIndex);
            model.fireTableDataChanged();
            
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        int selectedRowIndex = tablerv.getSelectedRow();

        if (selectedRowIndex != -1) {
            
            DefaultTableModel model = (DefaultTableModel) tablerv.getModel();

            String nom = model.getValueAt(selectedRowIndex, 0).toString();
            String prenom = model.getValueAt(selectedRowIndex, 1).toString();
            
            
            con = (Connection) connexion.getConnect();
            String sql2 = "delete from rendez_vous where nompatient=?";
            try {
            PreparedStatement statement2 = (PreparedStatement) con.prepareStatement(sql2);
            statement2.setString(1, nom+" "+prenom);
            statement2.executeUpdate();
            System.out.println(nom+" "+prenom);
            JOptionPane.showMessageDialog(null, "rendez_vous est supprimée !!!");
            model.removeRow(selectedRowIndex);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String sql = "insert into boite values (?,?)";
            try {
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
            statement.setString(1, nom+" "+prenom);
            statement.setString(2, "votre rendez_vous n'est  acceptée");
            statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.fireTableDataChanged();
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private class CustomTableCellRenderer extends DefaultTableCellRenderer {
        private int rowToColor;

        public CustomTableCellRenderer(int rowToColor) {
            this.rowToColor = rowToColor;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (row == rowToColor) {
                cellComponent.setBackground(Color.GREEN);
                cellComponent.setForeground(Color.BLACK);
            } else {
                cellComponent.setBackground(table.getBackground());
                cellComponent.setForeground(table.getForeground());
            }

            return cellComponent;
        }
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
            java.util.logging.Logger.getLogger(mesAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mesAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mesAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mesAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mesAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acceuil;
    private javax.swing.JButton consultation;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel medecinNom;
    private javax.swing.JButton patients;
    private javax.swing.JTable tablerv;
    // End of variables declaration//GEN-END:variables
}
