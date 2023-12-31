package co.edu.unicauca.openmarket.presentation;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class GUICategoriesFind extends javax.swing.JDialog {
    private CategoryService categoryService;
    /**
     * Creates new form GUIProductsFind
     */
    public GUICategoriesFind(java.awt.Frame parent, boolean modal,CategoryService categoryService) {
        super(parent, modal);
        initComponents();
        initializeTable();
        this.categoryService = categoryService;
        setLocationRelativeTo(null); //centrar al ventana
    }
    
    private void initializeTable() {
        tblCategories.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Name"
                }
        ));
    }
    
        private void fillTable(List<Category> listCategories) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblCategories.getModel();

        Object rowData[] = new Object[3];//No columnas
        for (int i = 0; i < listCategories.size(); i++) {
            rowData[0] = listCategories.get(i).getCategoryId();
            rowData[1] = listCategories.get(i).getName();
            
            model.addRow(rowData);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategories = new javax.swing.JTable();
        pnlNorth = new javax.swing.JPanel();
        btnSearchAll = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Búsqueda de productos");

        pnlCenter.setLayout(new java.awt.BorderLayout());

        tblCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCategories);

        pnlCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        btnSearchAll.setText("Buscar Todos");
        btnSearchAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAllActionPerformed(evt);
            }
        });
        pnlNorth.add(btnSearchAll);

        getContentPane().add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAllActionPerformed
        fillTable(categoryService.findAllCategories());
    }//GEN-LAST:event_btnSearchAllActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearchAll;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JTable tblCategories;
    // End of variables declaration//GEN-END:variables
}
