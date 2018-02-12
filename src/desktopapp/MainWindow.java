package desktopapp;

import static desktopapp.MyConnection.getConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
        getConnection();
        showProductInTable();
        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    
    public boolean checkInputs() {
        if (nameTxt.getText() == null
                || priceTxt.getText() == null
                || descriptionTxt.getText() == null) {
            return false;
        } else {
            try {
                Float.parseFloat(priceTxt.getText());
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    public ArrayList<Product> getProductList() {

        ArrayList<Product> productList = new ArrayList<Product>();
        Connection con = MyConnection.getConnection();
        String query = "Select * From PRODUCTS";

        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product product;

            while (rs.next()) {
                product = new Product(rs.getLong("id"), rs.getString("name"),
                        rs.getFloat("price"), rs.getString("description"));
                productList.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    public void showProductInTable() {

        ArrayList<Product> list = getProductList();
        Connection con = MyConnection.getConnection();
        DefaultTableModel model = (DefaultTableModel) tableProduct.getModel();

        model.setRowCount(0);
        Object[] row = new Object[4];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getPrice();
            row[3] = list.get(i).getDescription();
            model.addRow(row);
        }

        JComboBox combo = new JComboBox<>();
        combo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        TableColumn col = tableProduct.getColumnModel().getColumn(3);
        TableCellEditor tce = new DefaultCellEditor(combo);
        col.setCellEditor(tce);
    }



    public void showItem(int index) {
        idTxt.setText(Long.toString(getProductList().get(index).getId()));
        nameTxt.setText(getProductList().get(index).getName());
        priceTxt.setText(Float.toString(getProductList().get(index).getPrice()));
        descriptionTxt.setText(getProductList().get(index).getDescription());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        panel1 = new javax.swing.JPanel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        priceTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        descriptionTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nameTable = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuOrderPosition = new javax.swing.JMenu();
        menu = new javax.swing.JMenuItem();
        menuOrderTable = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(236, 236, 236));
        panel1.setName(""); // NOI18N

        label2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label2.setText("Name:");

        label3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label3.setText("Price:");

        priceTxt.setBackground(new java.awt.Color(218, 223, 225));
        priceTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        priceTxt.setForeground(new java.awt.Color(34, 49, 63));

        nameTxt.setBackground(new java.awt.Color(218, 223, 225));
        nameTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nameTxt.setForeground(new java.awt.Color(34, 49, 63));

        btnAdd.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        label1.setText("Enter the data: ");

        label4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label4.setText("ID:");

        idTxt.setBackground(new java.awt.Color(218, 223, 225));
        idTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        idTxt.setForeground(new java.awt.Color(154, 18, 179));
        idTxt.setEnabled(false);

        tableProduct.setBackground(new java.awt.Color(218, 223, 225));
        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Description"
            }
        ));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduct);

        btnUpdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        descriptionTxt.setBackground(new java.awt.Color(218, 223, 225));
        descriptionTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        descriptionTxt.setForeground(new java.awt.Color(34, 49, 63));
        descriptionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTxtActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Description:");

        jPanel1.setBackground(new java.awt.Color(25, 181, 254));

        nameTable.setBackground(new java.awt.Color(255, 255, 255));
        nameTable.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nameTable.setForeground(new java.awt.Color(255, 255, 255));
        nameTable.setText("Table Product:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameTable)
                .addContainerGap(452, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameTable)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(label4))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(label2))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(label3))
                            .addComponent(jLabel1))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(17, 17, 17)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(label1)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(descriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnAdd))
                                    .addComponent(btnDelete)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label4)
                                .addGap(23, 23, 23)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        menuOrderPosition.setText("Table Selection");

        menu.setText("Order");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        menuOrderPosition.add(menu);

        menuOrderTable.setText("Order Position");
        menuOrderTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOrderTableActionPerformed(evt);
            }
        });
        menuOrderPosition.add(menuOrderTable);

        jMenuBar1.add(menuOrderPosition);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (checkInputs() == true) {
            try {

                Connection con = MyConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("Insert into PRODUCTS(Name,Price,Description)"
                        + " values(?,?,?)");

                ps.setString(1, nameTxt.getText());
                ps.setString(2, priceTxt.getText());
                ps.setString(3, descriptionTxt.getText());

                ps.executeUpdate();
                showProductInTable();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Not all fields are filled");
        }
    }//GEN-LAST:event_btnAddActionPerformed


    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        if (checkInputs() == true) {

            String updateQuery = null;
            PreparedStatement ps = null;
            Connection con = MyConnection.getConnection();
            try {
                updateQuery = "Update PRODUCTS SET name=?,price=?, description=? where id=?";
                ps = con.prepareStatement(updateQuery);

                ps.setString(1, nameTxt.getText());
                ps.setString(2, priceTxt.getText());
                ps.setString(3, descriptionTxt.getText());
                ps.setLong(4, Long.parseLong(idTxt.getText()));
                ps.executeUpdate();
                showProductInTable();
                JOptionPane.showMessageDialog(null, "Product Update.");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or more fields are empty or wrong.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed


    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        if (!idTxt.getText().equals(" ")) {
            try {
                Connection con = MyConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("Delete from PRODUCTS where id=?");
                long id = Long.parseLong(idTxt.getText());
                ps.setLong(1, id);
                ps.executeUpdate();
                showProductInTable();
                JOptionPane.showMessageDialog(null, "Product Deleted.");
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Product not deleted.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Product not deleted: enter the product ID");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        int index = tableProduct.getSelectedRow();
        showItem(index);
    }//GEN-LAST:event_tableProductMouseClicked

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        OrderTable ot = new OrderTable();
                    ot.setVisible(true);
                    ot.pack();
                    ot.setLocationRelativeTo(null);
                    ot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
    }//GEN-LAST:event_menuActionPerformed

    private void descriptionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionTxtActionPerformed

    private void menuOrderTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOrderTableActionPerformed
       OrderPositionTable op = new OrderPositionTable ();
                    op.setVisible(true);
                    op.pack();
                    op.setLocationRelativeTo(null);
                    op.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
    }//GEN-LAST:event_menuOrderTableActionPerformed

    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField descriptionTxt;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JMenuItem menu;
    private javax.swing.JMenu menuOrderPosition;
    private javax.swing.JMenuItem menuOrderTable;
    private javax.swing.JLabel nameTable;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JPanel panel1;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JTable tableProduct;
    // End of variables declaration//GEN-END:variables
}