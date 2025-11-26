
package myfurfamily.dash;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.awt.HeadlessException;
import myfurfamily.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Medications extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Medications.class.getName());

    public void loadMedicationTable() {
    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_medications");
         ResultSet rs = ps.executeQuery()) {

        DefaultTableModel model = (DefaultTableModel) tbl_medications.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            model.addRow(new Object[]{
                    rs.getInt("pet_id"),
                    rs.getString("med_name"),
                    rs.getString("dosage"),
                    rs.getString("frequency"),
                    rs.getString("start_date"),
                    rs.getString("end_date"),
                    rs.getString("notes")
            });
        }
    } catch (Exception e) {
        logger.severe("Error loading table: " + e.getMessage());
    }
}

    
    public Medications() {
        initComponents();
        loadMedicationTable();
        add_pet.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        add_petActionPerformed(evt);
    }
});

update_pet.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        update_petActionPerformed(evt);
    }
});

delete_pet.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        delete_petActionPerformed(evt);
    }
});

findbutton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        findbuttonActionPerformed(evt);
    }
});

}
    
    private void add_petActionPerformed(java.awt.event.ActionEvent evt) {
    try (Connection con = DatabaseConnection.getConnection()) {
        String sql = "INSERT INTO tbl_medications (pet_id, med_name, dosage, frequency, start_date, end_date, notes) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(pet_name.getText()));
        ps.setString(2, medname_txtbox.getText());
        ps.setString(3, dosage_txtbox.getText());
        ps.setString(4, frequency_txtbox.getText());
        ps.setString(5, start_datetxtbox.getText());
        ps.setString(6, end_datetxtbox.getText());
        ps.setString(7, notestxtbox.getText());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Medication Added!");
        loadMedicationTable();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}

private void update_petActionPerformed(java.awt.event.ActionEvent evt) {
    try (Connection con = DatabaseConnection.getConnection()) {
        String sql = "UPDATE tbl_medications SET dosage=?, frequency=?, start_date=?, end_date=?, notes=? WHERE pet_id=? AND med_name=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dosage_txtbox.getText());
        ps.setString(2, frequency_txtbox.getText());
        ps.setString(3, start_datetxtbox.getText());
        ps.setString(4, end_datetxtbox.getText());
        ps.setString(5, notestxtbox.getText());
        ps.setInt(6, Integer.parseInt(pet_name.getText()));
        ps.setString(7, medname_txtbox.getText());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Medication Updated!");
        loadMedicationTable();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
private void delete_petActionPerformed(java.awt.event.ActionEvent evt) {
    try (Connection con = DatabaseConnection.getConnection()) {
        String sql = "DELETE FROM tbl_medications WHERE pet_id=? AND med_name=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, Integer.parseInt(pet_name.getText()));
        ps.setString(2, medname_txtbox.getText());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Medication Deleted!");
        loadMedicationTable();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
private void findbuttonActionPerformed(java.awt.event.ActionEvent evt) {
    try (Connection con = DatabaseConnection.getConnection()) {
        String sql = "SELECT * FROM tbl_medications WHERE pet_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(pet_name.getText()));
        ResultSet rs = ps.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tbl_medications.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            model.addRow(new Object[]{
                    rs.getInt("pet_id"),
                    rs.getString("med_name"),
                    rs.getString("dosage"),
                    rs.getString("frequency"),
                    rs.getString("start_date"),
                    rs.getString("end_date"),
                    rs.getString("notes")
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Medications = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logout_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        MedicationsForm = new javax.swing.JPanel();
        mednametxt = new javax.swing.JLabel();
        medname_txtbox = new javax.swing.JTextField();
        dosagetxt = new javax.swing.JLabel();
        dosage_txtbox = new javax.swing.JTextField();
        frequencytxt = new javax.swing.JLabel();
        notestxtbox = new javax.swing.JTextField();
        add_pet = new javax.swing.JButton();
        update_pet = new javax.swing.JButton();
        delete_pet = new javax.swing.JButton();
        notestxt = new javax.swing.JLabel();
        frequency_txtbox = new javax.swing.JTextField();
        start_datetxt = new javax.swing.JLabel();
        start_datetxtbox = new javax.swing.JTextField();
        end_datetxtbox = new javax.swing.JTextField();
        end_datetxt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        findbutton = new javax.swing.JButton();
        pet_name = new javax.swing.JTextField();
        pet_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_medications = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));

        logout_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logout_btn.setText("LOGOUT");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        back_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        back_btn.setText("BACK");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        mednametxt.setText("Medicine Name:");

        dosagetxt.setText("Dosage:");

        frequencytxt.setText("Frequency:");

        add_pet.setText("ADD");

        update_pet.setText("UPDATE");

        delete_pet.setText("DELETE");

        notestxt.setText("Notes:");

        start_datetxt.setText("Medication Start:");

        end_datetxt.setText("Medication End:");

        jLabel1.setText("Search By Pet Name:");

        findbutton.setText("Find");

        pet_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pet_idActionPerformed(evt);
            }
        });

        jLabel2.setText("Pet ID:");

        javax.swing.GroupLayout MedicationsFormLayout = new javax.swing.GroupLayout(MedicationsForm);
        MedicationsForm.setLayout(MedicationsFormLayout);
        MedicationsFormLayout.setHorizontalGroup(
            MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedicationsFormLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MedicationsFormLayout.createSequentialGroup()
                        .addComponent(start_datetxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(end_datetxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(notestxt)
                    .addGroup(MedicationsFormLayout.createSequentialGroup()
                        .addComponent(add_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete_pet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(medname_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MedicationsFormLayout.createSequentialGroup()
                        .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dosage_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dosagetxt)
                            .addComponent(start_datetxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(end_datetxt)
                            .addComponent(frequencytxt)
                            .addComponent(frequency_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(notestxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MedicationsFormLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(pet_name))
                    .addGroup(MedicationsFormLayout.createSequentialGroup()
                        .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MedicationsFormLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pet_id, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(mednametxt, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(findbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        MedicationsFormLayout.setVerticalGroup(
            MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedicationsFormLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pet_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pet_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(findbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mednametxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medname_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dosagetxt)
                    .addComponent(frequencytxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dosage_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frequency_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start_datetxt)
                    .addComponent(end_datetxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start_datetxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(end_datetxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(notestxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notestxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        tbl_medications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "pet_id", "med_name", "dosage", "frequency", "start_date", "end_date", "notes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_medications);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logout_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MedicationsForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(back_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logout_btn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addComponent(MedicationsForm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MedicationsLayout = new javax.swing.GroupLayout(Medications);
        Medications.setLayout(MedicationsLayout);
        MedicationsLayout.setHorizontalGroup(
            MedicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(MedicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
        );
        MedicationsLayout.setVerticalGroup(
            MedicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(MedicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MedicationsLayout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(Medications, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
    myfurfamily.dash.Dashboard dash = new myfurfamily.dash.Dashboard();
            dash.setVisible(true);
            this.dispose();                 // TODO add your handling code here:
    }//GEN-LAST:event_back_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
    myfurfamily.auth.LoginForm dash = new myfurfamily.auth.LoginForm();
            dash.setVisible(true);
            this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_logout_btnActionPerformed

    private void pet_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pet_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pet_idActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new Medications().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Medications;
    private javax.swing.JPanel MedicationsForm;
    private javax.swing.JButton add_pet;
    private javax.swing.JButton back_btn;
    private javax.swing.JButton delete_pet;
    private javax.swing.JTextField dosage_txtbox;
    private javax.swing.JLabel dosagetxt;
    private javax.swing.JLabel end_datetxt;
    private javax.swing.JTextField end_datetxtbox;
    private javax.swing.JButton findbutton;
    private javax.swing.JTextField frequency_txtbox;
    private javax.swing.JLabel frequencytxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JTextField medname_txtbox;
    private javax.swing.JLabel mednametxt;
    private javax.swing.JLabel notestxt;
    private javax.swing.JTextField notestxtbox;
    private javax.swing.JTextField pet_id;
    private javax.swing.JTextField pet_name;
    private javax.swing.JLabel start_datetxt;
    private javax.swing.JTextField start_datetxtbox;
    private javax.swing.JTable tbl_medications;
    private javax.swing.JButton update_pet;
    // End of variables declaration//GEN-END:variables
}
