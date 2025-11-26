
package myfurfamily.dash;


public class Medications extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Medications.class.getName());

    
    public Medications() {
        initComponents();
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
        species = new javax.swing.JTextField();
        frequencytxt = new javax.swing.JLabel();
        notestxtbox = new javax.swing.JTextField();
        add_pet = new javax.swing.JButton();
        update_pet = new javax.swing.JButton();
        delete_pet = new javax.swing.JButton();
        notestxt = new javax.swing.JLabel();
        breed = new javax.swing.JTextField();
        start_datetxt = new javax.swing.JLabel();
        start_datetxtbox = new javax.swing.JTextField();
        end_datetxtbox = new javax.swing.JTextField();
        end_datetxt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        findbutton = new javax.swing.JButton();
        pet_id = new javax.swing.JTextField();
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

        jLabel1.setText("Search Pet By ID:");

        findbutton.setText("Find");

        javax.swing.GroupLayout MedicationsFormLayout = new javax.swing.GroupLayout(MedicationsForm);
        MedicationsForm.setLayout(MedicationsFormLayout);
        MedicationsFormLayout.setHorizontalGroup(
            MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedicationsFormLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(MedicationsFormLayout.createSequentialGroup()
                            .addComponent(start_datetxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(end_datetxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(notestxt)
                        .addComponent(mednametxt)
                        .addGroup(MedicationsFormLayout.createSequentialGroup()
                            .addComponent(add_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(update_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(delete_pet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(medname_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(MedicationsFormLayout.createSequentialGroup()
                            .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(species, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dosagetxt)
                                .addComponent(start_datetxt))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(end_datetxt)
                                .addComponent(frequencytxt)
                                .addComponent(breed, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(notestxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MedicationsFormLayout.createSequentialGroup()
                        .addComponent(pet_id, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(findbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        MedicationsFormLayout.setVerticalGroup(
            MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedicationsFormLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MedicationsFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(findbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(pet_id))
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
                    .addComponent(species, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(breed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(72, Short.MAX_VALUE))
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

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new Medications().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Medications;
    private javax.swing.JPanel MedicationsForm;
    private javax.swing.JButton add_pet;
    private javax.swing.JButton back_btn;
    private javax.swing.JTextField breed;
    private javax.swing.JButton delete_pet;
    private javax.swing.JLabel dosagetxt;
    private javax.swing.JLabel end_datetxt;
    private javax.swing.JTextField end_datetxtbox;
    private javax.swing.JButton findbutton;
    private javax.swing.JLabel frequencytxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JTextField medname_txtbox;
    private javax.swing.JLabel mednametxt;
    private javax.swing.JLabel notestxt;
    private javax.swing.JTextField notestxtbox;
    private javax.swing.JTextField pet_id;
    private javax.swing.JTextField species;
    private javax.swing.JLabel start_datetxt;
    private javax.swing.JTextField start_datetxtbox;
    private javax.swing.JTable tbl_medications;
    private javax.swing.JButton update_pet;
    // End of variables declaration//GEN-END:variables
}
