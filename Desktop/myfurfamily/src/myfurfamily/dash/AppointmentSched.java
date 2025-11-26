
package myfurfamily.dash;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import myfurfamily.auth.LoginForm;

public class AppointmentSched extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AppointmentSched.class.getName());
    private int selectedAppointmentID = -1; // used for update/delete

    public AppointmentSched() {
        initComponents();
        loadAppointments(); // LOAD TABLE DATA
        addListeners();     // ACTIVATE BUTTONS
    }

    // ------------------------------
    // 🔵 DATABASE CONNECTION
    // ------------------------------
    private Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/myfurfamily_db";
            String user = "root";
            String pass = ""; // change if needed
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Connection Failed!");
            return null;
        }
    }

    // ------------------------------
    // 🔵 LOAD DATA FROM tbl_appointments
    // ------------------------------
    private void loadAppointments() {
        DefaultTableModel model = (DefaultTableModel) tbl_appointments.getModel();
        model.setRowCount(0);

        String query = "SELECT appt_id, pet_id, reason, date, time FROM tbl_appointments";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("appt_id"),
                        rs.getInt("pet_id"),
                        rs.getString("reason"),
                        rs.getString("date"),
                        rs.getString("time")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to load appointments.");
        }
    }

    // ------------------------------
    // 🔵 ADD LISTENERS TO BUTTONS
    // ------------------------------
    private void addListeners() {

        // CLICK TABLE → LOAD DATA TO TEXT FIELDS
        tbl_appointments.getSelectionModel().addListSelectionListener(e -> {
            int row = tbl_appointments.getSelectedRow();
            if (row >= 0) {
                selectedAppointmentID = Integer.parseInt(tbl_appointments.getValueAt(row, 0).toString());
                reasontxtbox.setText(tbl_appointments.getValueAt(row, 2).toString());
                datetxtbox.setText(tbl_appointments.getValueAt(row, 3).toString());
                timetxtbox.setText(tbl_appointments.getValueAt(row, 4).toString());
            }
        });

        // ADD BUTTON
        add_reason.addActionListener(evt -> {
            addAppointment();
        });

        // UPDATE BUTTON
        update_reason.addActionListener(evt -> {
            updateAppointment();
        });

        // DELETE BUTTON
        delete_reason.addActionListener(evt -> {
            deleteAppointment();
        });

        // BACK → Dashboard.java
        back_btn.addActionListener(evt -> {
            new Dashboard().setVisible(true);
            this.dispose();
        });

        // LOGOUT → LoginForm.java
        logout_btn.addActionListener(evt -> {
            new LoginForm().setVisible(true);
            this.dispose();
        });
    }

    // ------------------------------
    // 🔵 ADD APPOINTMENT
    // ------------------------------
    private void addAppointment() {
        String reason = reasontxtbox.getText();
        String date = datetxtbox.getText();
        String time = timetxtbox.getText();

        if (reason.isEmpty() || date.isEmpty() || time.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        String query = "INSERT INTO tbl_appointments (pet_id, reason, date, time) VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, 1); // TEMPORARY: set your selected pet_id here
            ps.setString(2, reason);
            ps.setString(3, date);
            ps.setString(4, time);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Appointment Added!");

            loadAppointments();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to add appointment.");
        }
    }

    // ------------------------------
    // 🔵 UPDATE APPOINTMENT
    // ------------------------------
    private void updateAppointment() {
        if (selectedAppointmentID == -1) {
            JOptionPane.showMessageDialog(this, "Please select an appointment first!");
            return;
        }

        String reason = reasontxtbox.getText();
        String date = datetxtbox.getText();
        String time = timetxtbox.getText();

        String query = "UPDATE tbl_appointments SET reason=?, date=?, time=? WHERE appt_id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, reason);
            ps.setString(2, date);
            ps.setString(3, time);
            ps.setInt(4, selectedAppointmentID);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Appointment Updated!");

            loadAppointments();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to update.");
        }
    }

    // ------------------------------
    // 🔵 DELETE APPOINTMENT
    // ------------------------------
    private void deleteAppointment() {
        if (selectedAppointmentID == -1) {
            JOptionPane.showMessageDialog(this, "Please select an appointment to delete!");
            return;
        }

        String query = "DELETE FROM tbl_appointments WHERE appt_id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, selectedAppointmentID);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Appointment Deleted!");

            loadAppointments();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to delete record.");
        }
    }

    // ------------------------------
    // AUTO-GENERATED CODE (your existing initComponents)
    // ------------------------------

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        AppointmentSched = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logout_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        AppointmentForm = new javax.swing.JPanel();
        new_appointment_txt = new javax.swing.JLabel();
        reasontxtbox = new javax.swing.JTextField();
        datetxt = new javax.swing.JLabel();
        datetxtbox = new javax.swing.JTextField();
        timetxt = new javax.swing.JLabel();
        add_reason = new javax.swing.JButton();
        update_reason = new javax.swing.JButton();
        delete_reason = new javax.swing.JButton();
        timetxtbox = new javax.swing.JTextField();
        pet_id = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        findbutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_appointments = new javax.swing.JTable();

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

        new_appointment_txt.setText("New Appointment:");

        datetxt.setText("Date:");

        timetxt.setText("Time:");

        add_reason.setText("ADD");
        add_reason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_reasonActionPerformed(evt);
            }
        });

        update_reason.setText("UPDATE");

        delete_reason.setText("DELETE");

        jLabel1.setText("Search Pet By ID:");

        findbutton.setText("Find");

        javax.swing.GroupLayout AppointmentFormLayout = new javax.swing.GroupLayout(AppointmentForm);
        AppointmentForm.setLayout(AppointmentFormLayout);
        AppointmentFormLayout.setHorizontalGroup(
            AppointmentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppointmentFormLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(AppointmentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(AppointmentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(AppointmentFormLayout.createSequentialGroup()
                            .addComponent(pet_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(findbutton))
                        .addComponent(new_appointment_txt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AppointmentFormLayout.createSequentialGroup()
                            .addComponent(add_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(update_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(delete_reason, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(reasontxtbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AppointmentFormLayout.createSequentialGroup()
                            .addGroup(AppointmentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(datetxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(datetxt))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(AppointmentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(timetxt)
                                .addComponent(timetxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        AppointmentFormLayout.setVerticalGroup(
            AppointmentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppointmentFormLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AppointmentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(findbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(pet_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(new_appointment_txt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reasontxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AppointmentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datetxt)
                    .addComponent(timetxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AppointmentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datetxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timetxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addGroup(AppointmentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_appointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "pet_id", "reason", "date", "time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_appointments);

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
                .addComponent(AppointmentForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
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
                    .addComponent(AppointmentForm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AppointmentSchedLayout = new javax.swing.GroupLayout(AppointmentSched);
        AppointmentSched.setLayout(AppointmentSchedLayout);
        AppointmentSchedLayout.setHorizontalGroup(
            AppointmentSchedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 911, Short.MAX_VALUE)
            .addGroup(AppointmentSchedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE))
        );
        AppointmentSchedLayout.setVerticalGroup(
            AppointmentSchedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(AppointmentSchedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(AppointmentSched, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
    myfurfamily.dash.Dashboard dash = new myfurfamily.dash.Dashboard();
            dash.setVisible(true);
            this.dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_back_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
    myfurfamily.auth.LoginForm dash = new myfurfamily.auth.LoginForm();
            dash.setVisible(true);
            this.dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_logout_btnActionPerformed

    private void add_reasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_reasonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_reasonActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AppointmentSched().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AppointmentForm;
    private javax.swing.JPanel AppointmentSched;
    private javax.swing.JButton add_reason;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel datetxt;
    private javax.swing.JTextField datetxtbox;
    private javax.swing.JButton delete_reason;
    private javax.swing.JButton findbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JLabel new_appointment_txt;
    private javax.swing.JButton pet_id;
    private javax.swing.JTextField reasontxtbox;
    private javax.swing.JTable tbl_appointments;
    private javax.swing.JLabel timetxt;
    private javax.swing.JTextField timetxtbox;
    private javax.swing.JButton update_reason;
    // End of variables declaration//GEN-END:variables
}
