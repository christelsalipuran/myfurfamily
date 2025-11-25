
package myfurfamily.dash;

public class Dashboard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());

    public Dashboard() {
        initComponents();
        
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        dashboard = new javax.swing.JPanel();
        petrecords_btn = new javax.swing.JButton();
        petgallery_btn = new javax.swing.JButton();
        appointment_btn = new javax.swing.JButton();
        medications_btn = new javax.swing.JButton();
        contacts_btn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        dashboard.setBackground(new java.awt.Color(153, 153, 153));
        dashboard.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        dashboard.setMinimumSize(new java.awt.Dimension(0, 0));
        dashboard.setPreferredSize(new java.awt.Dimension(800, 500));

        petrecords_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        petrecords_btn.setText("PET RECORDS");
        petrecords_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petrecords_btnActionPerformed(evt);
            }
        });

        petgallery_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        petgallery_btn.setText("PET GALLERY");
        petgallery_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petgallery_btnActionPerformed(evt);
            }
        });

        appointment_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        appointment_btn.setText("APPOINTMENT SCHEDULING");
        appointment_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointment_btnActionPerformed(evt);
            }
        });

        medications_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        medications_btn.setText("MEDICATIONS / HEALTH TRACKING");
        medications_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medications_btnActionPerformed(evt);
            }
        });

        contacts_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contacts_btn.setText("EMERGENCY CONTACTS & VET INFO");
        contacts_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contacts_btnActionPerformed(evt);
            }
        });

        logout_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logout_btn.setText("LOGOUT");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(petrecords_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(appointment_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(petgallery_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(contacts_btn))
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(medications_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(119, 119, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logout_btn)
                .addGap(25, 25, 25))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(logout_btn)
                .addGap(88, 88, 88)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(petrecords_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appointment_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(petgallery_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(contacts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(medications_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 765;
        gridBagConstraints.ipady = 459;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 33, 0, 19);
        getContentPane().add(dashboard, gridBagConstraints);
        dashboard.getAccessibleContext().setAccessibleName("dashboard");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void petrecords_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petrecords_btnActionPerformed
    myfurfamily.dash.PetRecords dash = new myfurfamily.dash.PetRecords();
            dash.setVisible(true);
            this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_petrecords_btnActionPerformed

    private void petgallery_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petgallery_btnActionPerformed
    myfurfamily.dash.PetPhotos dash = new myfurfamily.dash.PetPhotos();
            dash.setVisible(true);
            this.dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_petgallery_btnActionPerformed

    private void appointment_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointment_btnActionPerformed
    myfurfamily.dash.AppointmentSched dash = new myfurfamily.dash.AppointmentSched();
            dash.setVisible(true);
            this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_appointment_btnActionPerformed

    private void medications_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medications_btnActionPerformed
    myfurfamily.dash.Medications dash = new myfurfamily.dash.Medications();
            dash.setVisible(true);
            this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_medications_btnActionPerformed

    private void contacts_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contacts_btnActionPerformed
    myfurfamily.dash.Contacts dash = new myfurfamily.dash.Contacts();
            dash.setVisible(true);
            this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_contacts_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
    myfurfamily.auth.LoginForm dash = new myfurfamily.auth.LoginForm();
            dash.setVisible(true);
            this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_logout_btnActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new Dashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appointment_btn;
    private javax.swing.JButton contacts_btn;
    private javax.swing.JPanel dashboard;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton medications_btn;
    private javax.swing.JButton petgallery_btn;
    private javax.swing.JButton petrecords_btn;
    // End of variables declaration//GEN-END:variables
}
