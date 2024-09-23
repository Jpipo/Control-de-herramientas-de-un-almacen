
package vistas;

import modelo.DAOempleado;
import modelo.DAOempleadoImp;
import modelo.Empleado;
import com.mycompany.almacen.comboBox;
import java.sql.*;
import com.mycompany.almacen.Cconexion;
import java.awt.Color;

/**
 *
 * @author jhomc
 */
public class Fempleado extends javax.swing.JPanel {


    boolean isEdition = false;
    Empleado userEdition;
    
    public Fempleado() {
        initComponents();
        llenarComboCargos();
        InitStyles();
        
    }
    public Fempleado(Empleado empleado) {
        initComponents();
        isEdition = true;
        userEdition = empleado;
        llenarComboCargos();
        InitStyles();
    }
    
       private void InitStyles() {
        jLabel1.putClientProperty("FlatLaf.styleClass", "h1");
        jLabel1.setForeground(Color.black);
        txtCarnet.putClientProperty("JTextField.placeholderText", "Ingrese cédula de identidad.");
        txtNombre.putClientProperty("JTextField.placeholderText", "Ingrese el nombre.");
        txtapPaterno.putClientProperty("JTextField.placeholderText", "Ingrese el apellido paterno.");
        txtApMatrno.putClientProperty("JTextField.placeholderText", "Ingrese el apellido materno.");
        txtTelefono.putClientProperty("JTextField.placeholderText", "Ingrese el teléfono del personal.");
        txtDireccion.putClientProperty("JTextField.placeholderText", "Ingrese la dirección del personal.");
        txtCorreo.putClientProperty("JTextField.placeholderText", "Ingrese el email del personal.");
        
        if (isEdition) {
            jLabel1.setText("Editar Usuario");
            btRegistrar.setText("Guardar");

            if (userEdition != null) {
                txtCarnet.setText(String.valueOf(userEdition.getC_identidad()));
                txtNombre.setText(userEdition.getNombre());
                txtapPaterno.setText(userEdition.getAp_paterno());
                txtApMatrno.setText(userEdition.getAp_materno());
                txtTelefono.setText(String.valueOf(userEdition.getTelefono()));
                txtDireccion.setText(userEdition.getDireccion());
                cbSexo.setSelectedItem(userEdition.getSexo());
                txtCorreo.setText(userEdition.getEmail());
                txtFecha.setText(userEdition.getFecha_ingreso());
                cbCargo.setSelectedItem(String.valueOf(userEdition.getF_cargo()));
            }
        }

    }


    private void llenarComboCargos() {
        comboBox comboBoxHelper = new comboBox();
        try {
            comboBoxHelper.llenarComboBox(cbCargo);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Error al cargar los cargos: " + e.getMessage(), 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEfondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCarnet = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtapPaterno = new javax.swing.JTextField();
        txtApMatrno = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        cbSexo = new javax.swing.JComboBox<>();
        cbCargo = new javax.swing.JComboBox<>();
        btRegistrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(798, 478));

        jpEfondo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Registrar nuevo personal");

        jLabel2.setText("Carnet");

        jLabel3.setText("Nombres");

        jLabel4.setText("Apellido Paterno");

        jLabel5.setText("Apellido Materno");

        jLabel6.setText("Teléfono");

        jLabel7.setText("Dirección");

        jLabel8.setText("Sexo");

        jLabel9.setText("Correo");

        jLabel10.setText("Fecha de Ingreso");

        jLabel11.setText("Cargo");

        txtCarnet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCarnetKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        cbCargo.setToolTipText("");
        cbCargo.setName(""); // NOI18N
        cbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCargoActionPerformed(evt);
            }
        });

        btRegistrar.setBackground(new java.awt.Color(18, 90, 173));
        btRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btRegistrar.setText("Registrar");
        btRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEfondoLayout = new javax.swing.GroupLayout(jpEfondo);
        jpEfondo.setLayout(jpEfondoLayout);
        jpEfondoLayout.setHorizontalGroup(
            jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEfondoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEfondoLayout.createSequentialGroup()
                        .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(134, 134, 134)
                        .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jpEfondoLayout.createSequentialGroup()
                                .addComponent(txtFecha)
                                .addGap(49, 49, 49))))
                    .addGroup(jpEfondoLayout.createSequentialGroup()
                        .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEfondoLayout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(177, 177, 177)
                                .addComponent(btRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpEfondoLayout.createSequentialGroup()
                                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpEfondoLayout.createSequentialGroup()
                                        .addComponent(txtapPaterno)
                                        .addGap(134, 134, 134))
                                    .addGroup(jpEfondoLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(346, 346, 346)))
                                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCorreo)
                                    .addGroup(jpEfondoLayout.createSequentialGroup()
                                        .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel9)
                                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(49, 49, 49))
                    .addGroup(jpEfondoLayout.createSequentialGroup()
                        .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jpEfondoLayout.createSequentialGroup()
                                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCarnet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(134, 134, 134)
                                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(txtApMatrno, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jpEfondoLayout.setVerticalGroup(
            jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEfondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFecha)
                    .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEfondoLayout.createSequentialGroup()
                        .addComponent(txtapPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApMatrno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jpEfondoLayout.createSequentialGroup()
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGroup(jpEfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEfondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEfondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
                                         
    String ci = txtCarnet.getText().trim();
    String nombre = txtNombre.getText().trim();
    String apP = txtapPaterno.getText().trim();
    String apM = txtApMatrno.getText().trim();
    String tel = txtTelefono.getText().trim();
    String dir = txtDireccion.getText().trim();
    String sex = (String) cbSexo.getSelectedItem();
    String email = txtCorreo.getText().trim();
    String fech = txtFecha.getText().trim();
    String carg = (String) cbCargo.getSelectedItem();
    
    if (ci.isEmpty() || nombre.isEmpty() || apP.isEmpty() || apM.isEmpty() || 
        tel.isEmpty() || dir.isEmpty() || sex == null || email.isEmpty() || 
        fech.isEmpty() || carg == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos.", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        txtCarnet.requestFocus();
        return;
    }
    
    try (Connection conn = Cconexion.Conectarbd()) {
        Empleado emplead = isEdition ? userEdition : new Empleado();
        emplead.setC_identidad(Integer.parseInt(ci));
        emplead.setNombre(nombre);
        emplead.setAp_paterno(apP);
        emplead.setAp_materno(apM);
        emplead.setTelefono(Integer.parseInt(tel));
        emplead.setDireccion(dir);
        emplead.setSexo(sex);
        emplead.setEmail(email);
        emplead.setFecha_ingreso(fech);
        
        int cargoId = obtenerIdCargo(conn,carg);
        emplead.setF_cargo(cargoId);
        
        DAOempleado dao = new DAOempleadoImp();
        if (!isEdition)
            dao.registrar(emplead);
        else
            dao.modificar(emplead);
        
        String successMsg = isEdition ? "modificado" : "registrado";
        
        javax.swing.JOptionPane.showMessageDialog(this, "Empleado " + successMsg + " con éxito.", "ÉXITO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        if (!isEdition){
            limpiarCampos();
        }
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error en el formato de los números ingresados.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        String errorsMsg = isEdition ? "modificar" : "registrar";
        javax.swing.JOptionPane.showMessageDialog(this, "Error al " + errorsMsg + " el empleado(Femp): " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

private int obtenerIdCargo(Connection conn, String nombreCargo) throws SQLException {
    
        String sql = "SELECT cod_cargo FROM cargo WHERE nombre_cargo = ?";
        try (PreparedStatement ps =conn.prepareStatement(sql)) {
            ps.setString(1, nombreCargo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("cod_cargo");
                } else {
                    throw new SQLException("No se encontró el cargo: " + nombreCargo);
                }
            }
    }
}

private void limpiarCampos() {
    txtCarnet.setText("");
    txtNombre.setText("");
    txtapPaterno.setText("");
    txtApMatrno.setText("");
    txtTelefono.setText("");
    txtDireccion.setText("");
    cbSexo.setSelectedIndex(0);
    txtCorreo.setText("");
    txtFecha.setText("");
    cbCargo.setSelectedIndex(0);
    txtCarnet.requestFocus();


    }//GEN-LAST:event_btRegistrarActionPerformed

    private void cbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargoActionPerformed

    }//GEN-LAST:event_cbCargoActionPerformed

    private void txtCarnetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCarnetKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCarnetKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegistrar;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jpEfondo;
    private javax.swing.JTextField txtApMatrno;
    private javax.swing.JTextField txtCarnet;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtapPaterno;
    // End of variables declaration//GEN-END:variables
}
