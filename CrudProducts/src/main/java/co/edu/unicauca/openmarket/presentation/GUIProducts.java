package co.edu.unicauca.openmarket.presentation;

import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.CategoryService;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.infra.Messages;
import javax.swing.JOptionPane;

/**
 *
 * @author Libardo Pantoja
 */
public class GUIProducts extends javax.swing.JFrame {

    private ProductService productService;
    private CategoryService categoryService;
    private boolean addOption;

    /**
     * Creates new form GUIProducts
     */
    public GUIProducts(ProductService productService, CategoryService categoryService) {
        initComponents();
        this.productService = productService;
        this.categoryService = categoryService;
        
        stateInitial();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSouth = new javax.swing.JPanel();
        btnCategoria = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtCategoryId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");

        pnlSouth.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCategoria.setText("Categorías");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        pnlSouth.add(btnCategoria);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlSouth.add(btnNuevo);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnEditar);

        btnSave.setText("Grabar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlSouth.add(btnSave);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnCancelar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnEliminar);

        btnFind.setText("Buscar");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        pnlSouth.add(btnFind);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnCerrar);

        getContentPane().add(pnlSouth, java.awt.BorderLayout.SOUTH);

        pnlCenter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCenter.setLayout(new java.awt.GridLayout(4, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*Id:");
        pnlCenter.add(jLabel1);

        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        pnlCenter.add(txtId);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("*Nombre:");
        pnlCenter.add(jLabel2);
        pnlCenter.add(txtName);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descripción:");
        pnlCenter.add(jLabel3);

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        pnlCenter.add(jScrollPane1);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Categoría");
        pnlCenter.add(jLabel4);
        jLabel4.getAccessibleContext().setAccessibleName("Categoría");

        pnlCenter.add(txtCategoryId);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        stateNew();
        txtName.requestFocus();
        addOption = true;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        stateInitial();
        cleanControls();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtName.getText().trim().equals("")) {
            Messages.showMessageDialog("Debe ingresar el nombre del producto", "Atención");
            txtName.requestFocus();
            return;
        }
        if (addOption) {
            //Agregar
            addProduct();

        } else {
            //Editar
            editProduct();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        addOption = false;
        stateEdit();
        txtId.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        if (txtId.getText().trim().equals("")) {
            return;
        }
        Long productId = Long.parseLong(txtId.getText());
        Product prod = productService.findProductById(productId);
        if (prod == null) {
            Messages.showMessageDialog("El identificador del producto no existe", "Error");
            txtId.setText("");
            txtId.requestFocus();
        } else {
            txtName.setText(prod.getName());
            txtDescription.setText(prod.getDescription());
        }
    }//GEN-LAST:event_txtIdFocusLost

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String id = txtId.getText().trim();
        if (id.equals("")) {
            Messages.showMessageDialog("Debe buscar el producto a eliminar", "Atención");
            txtId.requestFocus();
            return;
        }
        Long productId = Long.parseLong(id);
        if (Messages.showConfirmDialog("Está seguro que desea eliminar este producto?", "Confirmación") == JOptionPane.YES_NO_OPTION) {
            if (productService.deleteProduct(productId)) {
                Messages.showMessageDialog("Producto eliminado con éxito", "Atención");
                stateInitial();
                cleanControls();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        GUIProductsFind instance = new GUIProductsFind(this, true, productService);
        instance.setVisible(true);
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        GUICategories instance = new GUICategories(categoryService);
        instance.setVisible(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed
    private void stateEdit() {
        btnCategoria.setVisible(false);
        btnNuevo.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(true);
        btnCancelar.setVisible(true);
        btnCerrar.setVisible(false);
        btnSave.setVisible(true);
        btnFind.setVisible(false);
        txtId.setEnabled(true);
        txtName.setEnabled(true);
        txtDescription.setEnabled(true);
        txtCategoryId.setEnabled(true);
    }

    private void stateInitial() {
        btnCategoria.setVisible(true);
        btnNuevo.setVisible(true);
        btnEditar.setVisible(true);
        btnEliminar.setVisible(false);
        btnCancelar.setVisible(false);
        btnCerrar.setVisible(true);
        btnSave.setVisible(false);
        btnFind.setVisible(true);
        txtId.setEnabled(false);
        txtName.setEnabled(false);
        txtDescription.setEnabled(false);
        txtCategoryId.setEnabled(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlSouth;
    private javax.swing.JTextField txtCategoryId;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void stateNew() {
        btnCategoria.setVisible(false);
        btnNuevo.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(false);
        btnCancelar.setVisible(true);
        btnCerrar.setVisible(false);
        btnSave.setVisible(true);
        btnFind.setVisible(false);
        txtId.setEnabled(false);
        txtName.setEnabled(true);
        txtDescription.setEnabled(true);
        txtCategoryId.setEnabled(true);

    }

    private void cleanControls() {
        txtId.setText("");
        txtName.setText("");
        txtDescription.setText("");
        txtCategoryId.setText("");
    }

    private void addProduct() {
        String name = txtName.getText().trim();
        String description = txtDescription.getText().trim();
        Long categoryId = (long) 0;
        if(!txtCategoryId.getText().trim().equals(""))
        {
            categoryId = Long.parseLong(txtCategoryId.getText().trim());
        }
        
        System.out.print(description);
        if (productService.saveProduct(name, description, categoryId)) {
            Messages.showMessageDialog("Se grabó con éxito", "Atención");
            cleanControls();
            stateInitial();
        } else {
            Messages.showMessageDialog("Error al grabar, lo siento mucho", "Atención");
        }
    }

    private void editProduct() {
        String id = txtId.getText().trim();
        if (id.equals("")) {
            Messages.showMessageDialog("Debe buscar el producto a editar", "Atención");
            txtId.requestFocus();
            return;
        }
        Long productId = Long.parseLong(id);
        Product prod = new Product();
        prod.setName(txtName.getText().trim());
        prod.setDescription(txtDescription.getText().trim());

        if (productService.editProduct(productId, prod)) {
            Messages.showMessageDialog("Se editó con éxito", "Atención");
            cleanControls();
            stateInitial();
        } else {
            Messages.showMessageDialog("Error al editar, lo siento mucho", "Atención");
        }
    }
}
