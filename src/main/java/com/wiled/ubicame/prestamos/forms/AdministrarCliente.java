/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdministrarCliente.java
 *
 * Created on May 21, 2011, 12:26:10 PM
 */
package com.wiled.ubicame.prestamos.forms;

import com.wiled.ubicame.prestamos.utils.PrestamoConstants;
import com.wiled.ubicame.prestamos.datalayer.Controller;
import com.wiled.ubicame.prestamos.entidades.Cliente;
import javax.swing.JOptionPane;
import static com.wiled.ubicame.prestamos.utils.PrestamoUtils.containsOnlyNumbers;
import static com.wiled.ubicame.prestamos.utils.PrestamoUtils.isCedulaSizeValid;
import static com.wiled.ubicame.prestamos.utils.PrestamoUtils.isTelefonoSizeValid;
/**
 *
 * @author edgar
 */
public class AdministrarCliente extends javax.swing.JDialog {
    private boolean clienteEliminado;

    public boolean isClienteEliminado() {
        return clienteEliminado;
    }
        
    /** Creates new form AdministrarCliente */
    public AdministrarCliente(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        controller = Controller.getInstance(PrestamoConstants.PROD_PU);        
        this.cliente = cliente;
        
        controller.refresh(cliente);
        
        nombreTxt.setText(cliente.getNombre());
        apellidoTxt.setText(cliente.getApellido());
        cedulaTxt.setText(String.valueOf(cliente.getCedula()));
        telefonoTxt.setText(cliente.getTelefono());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        telefonoTxt = new javax.swing.JFormattedTextField();
        cedulaTxt = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        apellidoTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        actualizarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        cerrarBtn = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administracion de Clientes");
        setResizable(false);

        jLabel3.setText("Cedula:");

        jLabel4.setText("Telefono:");

        jLabel2.setText("Apellido:");

        jLabel5.setText("Nombre:");

        actualizarBtn.setBackground(java.awt.Color.green);
        actualizarBtn.setText("Actualizar");
        actualizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarBtnActionPerformed(evt);
            }
        });

        eliminarBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("ToolBar.dockingForeground"));
        eliminarBtn.setText("Eliminar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        cerrarBtn.setText("CERRAR");
        cerrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(nombreTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                            .addComponent(apellidoTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(cedulaTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(telefonoTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(actualizarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cerrarBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(apellidoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cedulaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(telefonoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarBtn)
                    .addComponent(eliminarBtn)
                    .addComponent(cerrarBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarBtnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cerrarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        try {
            controller.remove(cliente);
            JOptionPane.showMessageDialog(rootPane, "Cliente eliminado exitosamente", "ELIMINANACION DE CLIENTE", JOptionPane.INFORMATION_MESSAGE);
            
            clienteEliminado = true;
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "ERROR ELIMINANDO CLIENTE", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBtnActionPerformed
        if(nombreTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor introduzca un nombre", "ERROR", JOptionPane.ERROR_MESSAGE);
            nombreTxt.grabFocus();
            return;
        }
        
        if(apellidoTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor introduzca un apellido", "ERROR", JOptionPane.ERROR_MESSAGE);
            apellidoTxt.grabFocus();
            return;
        }
        
        if(cedulaTxt.getText().isEmpty() || !containsOnlyNumbers(cedulaTxt.getText()) || !isCedulaSizeValid(cedulaTxt.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Por favor introduzca una cedula valida", "ERROR", JOptionPane.ERROR_MESSAGE);
            cedulaTxt.grabFocus();
            return;            
        }
        
        if(telefonoTxt.getText().isEmpty() || !containsOnlyNumbers(telefonoTxt.getText()) || !isTelefonoSizeValid(telefonoTxt.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Por favor introduzca un telefono valida", "ERROR", JOptionPane.ERROR_MESSAGE);
            telefonoTxt.grabFocus();
            return;            
        }
        
        cliente.setNombre(nombreTxt.getText());
        cliente.setApellido(apellidoTxt.getText());
        cliente.setCedula(cedulaTxt.getText());
        cliente.setTelefono(telefonoTxt.getText());
        
        controller.merge(cliente);
        JOptionPane.showMessageDialog(rootPane, "Cliente actualizado exitosamente", "ACTUALIZACION DE CLIENTE", JOptionPane.INFORMATION_MESSAGE);
        
        dispose();
    }//GEN-LAST:event_actualizarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarBtn;
    private javax.swing.JTextField apellidoTxt;
    private javax.swing.JFormattedTextField cedulaTxt;
    private javax.swing.JButton cerrarBtn;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JFormattedTextField telefonoTxt;
    // End of variables declaration//GEN-END:variables
    private Cliente cliente;
    private Controller controller;
}
