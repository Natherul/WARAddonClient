/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

/**
 *
 * @author BJ
 */
public class Wrapper extends javax.swing.JFrame {
    Data.AddonList addons=new Data.AddonList();
    javax.swing.table.TableRowSorter sorter;
    /**
     * Creates new form Wrapper
     */
    public Wrapper() {
        initComponents();
        makeAddonList();
        finishGuiBuilding();
        processPosition();
    }
    protected final void finishGuiBuilding() {
        this.AddonList.getSelectionModel().addListSelectionListener(new tableListener());
        Description.setText("<html><h1>Welcome to the client.</h1><p>To get something more useful here, select an addon to the right</p>");
        InstallButton.setEnabled(false);
        RemoveButton.setEnabled(false);
        this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/logo.png")));
        sorter = new javax.swing.table.TableRowSorter(this.AddonList.getModel());
        this.AddonList.setRowSorter(sorter);
    }
    private void newFilter() {
        javax.swing.RowFilter rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = javax.swing.RowFilter.regexFilter(Search.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
    protected final void makeAddonList() {
        javax.json.JsonArray parse = request.getAddonList();
        int counter=0;
        javax.swing.table.DefaultTableModel model=(javax.swing.table.DefaultTableModel) this.AddonList.getModel();
        while(parse.size()>counter) {
            addons.add(new Data.Addon(parse.getJsonObject(counter)));
            model.addRow(addons.get(counter).getTableRow());
            counter++;
        }
    }
    protected final void processPosition() {
        String errors = "";
        if(!new java.io.File("./WAR.exe").exists()) {
            errors+="Missing WAR.exe here, please put this file in the Warhammer Online directory.";
        }
        if(!new java.io.File("./RoRLauncher.exe").exists()) {
            errors+="Missing RoRLauncher.exe here, please put this file in the Warhammer Online directory.";
        }
        if(errors.length()>0) {
            javax.swing.JOptionPane.showMessageDialog(this,errors);
            this.dispose();
            System.exit(0);
        }
    }
    class tableListener implements javax.swing.event.ListSelectionListener {
        public void valueChanged(javax.swing.event.ListSelectionEvent event) {
            Description.setText(addons.get(AddonList.getSelectedRow()).getDescription());
            Title.setText(addons.get(AddonList.getSelectedRow()).getName());
            InstallButton.setEnabled(true);
            RemoveButton.setEnabled(true);
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

        jSplitPane2 = new javax.swing.JSplitPane();
        leftSide = new javax.swing.JPanel();
        Search = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        AddonList = new javax.swing.JTable();
        rightSide = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Description = new javax.swing.JLabel();
        InstallButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        Title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane2.setDividerLocation(200);
        jSplitPane2.setToolTipText("");
        jSplitPane2.setMinimumSize(new java.awt.Dimension(300, 200));
        jSplitPane2.setName(""); // NOI18N

        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchKeyReleased(evt);
            }
        });

        AddonList.setAutoCreateRowSorter(true);
        AddonList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Version", "Installed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AddonList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        AddonList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(AddonList);
        AddonList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (AddonList.getColumnModel().getColumnCount() > 0) {
            AddonList.getColumnModel().getColumn(0).setResizable(false);
            AddonList.getColumnModel().getColumn(1).setResizable(false);
            AddonList.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout leftSideLayout = new javax.swing.GroupLayout(leftSide);
        leftSide.setLayout(leftSideLayout);
        leftSideLayout.setHorizontalGroup(
            leftSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Search, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        leftSideLayout.setVerticalGroup(
            leftSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSideLayout.createSequentialGroup()
                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(leftSide);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Description.setBackground(new java.awt.Color(255, 255, 255));
        Description.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Description.setAlignmentX(0.5F);
        Description.setAutoscrolls(true);
        Description.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Description.setOpaque(true);
        jScrollPane1.setViewportView(Description);

        InstallButton.setText("(Re)Install");
        InstallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstallButtonActionPerformed(evt);
            }
        });

        RemoveButton.setText("Remove");

        Title.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(InstallButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(RemoveButton)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RemoveButton)
                    .addComponent(InstallButton)
                    .addComponent(Title))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        rightSide.addTab("Main", jPanel1);

        jSplitPane2.setRightComponent(rightSide);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InstallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstallButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InstallButtonActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        newFilter();
    }//GEN-LAST:event_SearchActionPerformed

    private void SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyReleased
        newFilter();
    }//GEN-LAST:event_SearchKeyReleased

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
            java.util.logging.Logger.getLogger(Wrapper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wrapper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wrapper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wrapper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wrapper().setVisible(true);
            }
        });
    }
    protected Web.Request request=new Web.Request();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AddonList;
    private javax.swing.JLabel Description;
    private javax.swing.JButton InstallButton;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JTextField Search;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JPanel leftSide;
    private javax.swing.JTabbedPane rightSide;
    // End of variables declaration//GEN-END:variables
}
