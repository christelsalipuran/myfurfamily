
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


public class PetRecords extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PetRecords.class.getName());

    public PetRecords() {
    initComponents();
    loadPets();
    tbl_pets.setDefaultEditor(Object.class, null); // disable editing inside table
}
    private void loadPets() {
    DefaultTableModel model = (DefaultTableModel) tbl_pets.getModel();
    model.setRowCount(0);

    String sql = "SELECT * FROM tbl_pets";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("pet_name"),
                rs.getString("species"),
                rs.getString("breed"),
                rs.getInt("age"),
                rs.getString("med_notes")
            });
        }
        tbl_pets.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = tbl_pets.getSelectedRow();

        pet_name.setText(tbl_pets.getValueAt(row, 0).toString());
        species.setText(tbl_pets.getValueAt(row, 1).toString());
        breed.setText(tbl_pets.getValueAt(row, 2).toString());
        age.setText(tbl_pets.getValueAt(row, 3).toString());
        med_notes.setText(tbl_pets.getValueAt(row, 4).toString());
    }
});


    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading pets: " + e.getMessage());
    }
}
    
    private void addPet() {
    String sql = "INSERT INTO tbl_pets (pet_name, species, breed, age, med_notes) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, pet_name.getText());
        ps.setString(2, species.getText());
        ps.setString(3, breed.getText());
        ps.setInt(3, Integer.parseInt(age.getText()));
        ps.setString(5, med_notes.getText());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Pet added successfully!");

        loadPets();
     

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error adding pet: " + e.getMessage());
    }
}
    
    private void updatePet() {
    String sql = "UPDATE tbl_pets SET species=?, breed=?, age=?, med_notes=? WHERE pet_name=?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, species.getText());
        ps.setString(2, breed.getText());
        ps.setInt(3, Integer.parseInt(age.getText()));
        ps.setString(4, med_notes.getText());
        ps.setString(5, pet_name.getText());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Pet updated successfully!");

        loadPets();
        

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error updating pet: " + e.getMessage());
    }
}

    private void deletePet() {
    String sql = "DELETE FROM tbl_pets WHERE pet_name=?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, pet_name.getText());
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Pet deleted successfully!");
        loadPets();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error deleting pet: " + e.getMessage());
    }
}

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PetRecords = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logout_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        PetForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pet_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        species = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        med_notes = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        add_pet = new javax.swing.JButton();
        update_pet = new javax.swing.JButton();
        delete_pet = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        breed = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pets = new javax.swing.JTable();

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

        jLabel1.setText("Pet Name:");

        pet_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pet_nameActionPerformed(evt);
            }
        });

        jLabel2.setText("Species:");

        species.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speciesActionPerformed(evt);
            }
        });

        jLabel3.setText("Breed:");

        jLabel4.setText("Medicine Notes:");

        add_pet.setText("ADD");
        add_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_petActionPerformed(evt);
            }
        });

        update_pet.setText("UPDATE");
        update_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_petActionPerformed(evt);
            }
        });

        delete_pet.setText("DELETE");
        delete_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_petActionPerformed(evt);
            }
        });

        jLabel5.setText("Age:");

        javax.swing.GroupLayout PetFormLayout = new javax.swing.GroupLayout(PetForm);
        PetForm.setLayout(PetFormLayout);
        PetFormLayout.setHorizontalGroup(
            PetFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PetFormLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PetFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PetFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jLabel1)
                        .addGroup(PetFormLayout.createSequentialGroup()
                            .addComponent(add_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(update_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(delete_pet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(med_notes, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pet_name, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addGroup(PetFormLayout.createSequentialGroup()
                            .addGroup(PetFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(species, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(PetFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(breed, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        PetFormLayout.setVerticalGroup(
            PetFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PetFormLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pet_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PetFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PetFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(species, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(breed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(med_notes, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(PetFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_pets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "pet_name", "species", "breed", "age", "med_notes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_pets);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logout_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PetForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PetForm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PetRecordsLayout = new javax.swing.GroupLayout(PetRecords);
        PetRecords.setLayout(PetRecordsLayout);
        PetRecordsLayout.setHorizontalGroup(
            PetRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 911, Short.MAX_VALUE)
            .addGroup(PetRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE))
        );
        PetRecordsLayout.setVerticalGroup(
            PetRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(PetRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );

        getContentPane().add(PetRecords, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
    myfurfamily.dash.Dashboard dash = new myfurfamily.dash.Dashboard();
            dash.setVisible(true);
            this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_back_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
    myfurfamily.auth.LoginForm dash = new myfurfamily.auth.LoginForm();
            dash.setVisible(true);
            this.dispose();           // TODO add your handling code here:
    }//GEN-LAST:event_logout_btnActionPerformed

    private void add_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_petActionPerformed
        addPet();// TODO add your handling code here:
    }//GEN-LAST:event_add_petActionPerformed

    private void update_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_petActionPerformed
        updatePet();        // TODO add your handling code here:
    }//GEN-LAST:event_update_petActionPerformed

    private void delete_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_petActionPerformed
    deletePet();        // TODO add your handling code here:
    }//GEN-LAST:event_delete_petActionPerformed

    private void pet_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pet_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pet_nameActionPerformed

    private void speciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speciesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_speciesActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new PetRecords().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PetForm;
    private javax.swing.JPanel PetRecords;
    private javax.swing.JButton add_pet;
    private javax.swing.JTextField age;
    private javax.swing.JButton back_btn;
    private javax.swing.JTextField breed;
    private javax.swing.JButton delete_pet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JTextField med_notes;
    private javax.swing.JTextField pet_name;
    private javax.swing.JTextField species;
    private javax.swing.JTable tbl_pets;
    private javax.swing.JButton update_pet;
    // End of variables declaration//GEN-END:variables

    
}

