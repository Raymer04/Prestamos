/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Application.java
 *
 * Created on May 20, 2011, 10:35:40 PM
 */
package com.wiled.ubicame.prestamos.forms;

import org.jdesktop.swingx.JXLoginPane.Status;
import org.jdesktop.swingx.auth.LoginService;
import com.wiled.ubicame.prestamo.security.PrestamoLoginService;
import org.jdesktop.swingx.JXLoginPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import com.wiled.ubicame.prestamo.utils.PrestamoConstants;
import com.wiled.ubicame.prestamos.datalayer.Controller;
import com.wiled.ubicame.prestamos.entidades.Cliente;
import com.wiled.ubicame.prestamos.entidades.CriterioBusqueda;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import static com.wiled.ubicame.prestamo.utils.PrestamoUtils.containsOnlyNumbers;
import static com.wiled.ubicame.prestamo.utils.PrestamoUtils.isCedulaSizeValid;
import static com.wiled.ubicame.prestamo.utils.PrestamoUtils.isTelefonoSizeValid;

/**
 *
 * @author edgar
 */
public class Application extends javax.swing.JFrame {
    private JFrame getJFrame() {
        return this;
    }
    
    /** Creates new form Application */
    public Application() {
        initComponents();
        controller = Controller.getInstance(PrestamoConstants.PROD_PU);
        resultTable.setModel(new ResultTableModel());       
        resultTable.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() > 1) {
                    int rowNum = resultTable.getSelectedRow();
                    Cliente cliente = ((ResultTableModel) resultTable.getModel()).clientes.get(rowNum);
                    controller.refresh(cliente);
                    
                    if(cliente.getPrestamos().isEmpty()) {
                        JOptionPane.showMessageDialog(getJFrame(), "Este cliente no posee prestamos", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                        
                        AdministrarCliente form = new AdministrarCliente(getJFrame(), true, cliente);
                        form.setLocationRelativeTo(null);
                        form.setVisible(true);
                                                
                    } else {
                        valorBusquedaTxt.setText("");
                        ((ResultTableModel) resultTable.getModel()).clientes.clear();
                        resultTable.updateUI();
                        
                        PagoForm form = new PagoForm(getJFrame(), true, cliente);
                        form.setLocationRelativeTo(null);
                        form.setVisible(true);                                                
                        
                        valorBusquedaTxt.grabFocus();
                    }                    
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
        valorBusquedaTxt.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    onBuscar();
                }                
            }            
        });
        
        criterioBusquedaCombo.insertItemAt(CriterioBusqueda.CEDULA, 0);
        criterioBusquedaCombo.insertItemAt(CriterioBusqueda.TELEFONO, 1);
        criterioBusquedaCombo.insertItemAt(CriterioBusqueda.NOMBRE, 2);
        criterioBusquedaCombo.insertItemAt(CriterioBusqueda.APELLIDO, 3);
        
        criterioBusquedaCombo.setSelectedIndex(0);
        
        valorBusquedaTxt.grabFocus();   
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        criterioBusquedaCombo = new javax.swing.JComboBox();
        valorBusquedaTxt = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        backupMenu = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        crearCliente = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        amortizarPrestamo = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Presamos");
        setResizable(false);

        jLabel1.setText("Criterio de Busqueda:");

        buscarBtn.setBackground(java.awt.Color.green);
        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Telefono", "Cedula"
            }
        ));
        resultTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(resultTable);
        resultTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jMenu1.setText("Operaciones");
        jMenu1.setToolTipText("Opciones Generales");

        backupMenu.setText("Realizar Backup");
        backupMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupMenuActionPerformed(evt);
            }
        });
        jMenu1.add(backupMenu);

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Clientes");

        crearCliente.setText("Crear");
        crearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearClienteActionPerformed(evt);
            }
        });
        jMenu4.add(crearCliente);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Utilidades");

        amortizarPrestamo.setText("Amortizar Prestamo");
        amortizarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amortizarPrestamoActionPerformed(evt);
            }
        });
        jMenu3.add(amortizarPrestamo);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Reportes");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(criterioBusquedaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorBusquedaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(criterioBusquedaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorBusquedaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearClienteActionPerformed
        // TODO add your handling code here:
        CrearClientes form = new CrearClientes(this, true);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        
        if(form.getClienteCreado() != null) {
            Cliente cliente = form.getClienteCreado();
            
            CrearPrestamo crearPrestamoForm = new CrearPrestamo(null, true, cliente);
            crearPrestamoForm.setLocationRelativeTo(null);
            crearPrestamoForm.setVisible(true);
            
            
        }
    }//GEN-LAST:event_crearClienteActionPerformed

    private void amortizarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amortizarPrestamoActionPerformed
        // TODO add your handling code here:
        AmortizarPrestamo form = new AmortizarPrestamo(this, true);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }//GEN-LAST:event_amortizarPrestamoActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        onBuscar();
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void onBuscar() {
            //Obtener criterio de busqueda
        CriterioBusqueda criterioBusqueda = (CriterioBusqueda) criterioBusquedaCombo.getSelectedItem();
        String valorDeBusqueda = valorBusquedaTxt.getText();
        
        if(valorDeBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduzca un valor de busqueda", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            List<Cliente> listaClientes= null;
        
            switch(criterioBusqueda) {
                case APELLIDO:
                    listaClientes = controller.buscarClientePorApellido("%"+valorDeBusqueda+"%");
                    break;
                case CEDULA:
                    if(containsOnlyNumbers(valorDeBusqueda) && isCedulaSizeValid(valorDeBusqueda)) {
                        listaClientes = controller.buscarClientePorCedula(valorDeBusqueda);
                    } else {
                        JOptionPane.showMessageDialog(this, "Introduzca un numero de cedula valido", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
                case NOMBRE:
                    listaClientes = controller.buscarClientePorApellido("%"+valorDeBusqueda+"%");
                    break;
                case TELEFONO:
                    if(containsOnlyNumbers(valorDeBusqueda) && isTelefonoSizeValid(valorDeBusqueda)) {
                        listaClientes = controller.buscarClientePorTelefono(valorDeBusqueda);
                    } else {
                        JOptionPane.showMessageDialog(this, "Introduzca un numero de telefono valido", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    listaClientes = controller.buscarClientePorTelefono(valorDeBusqueda);
                    break;
                default:
                    listaClientes = new ArrayList<Cliente>();
            }
            
            if(!listaClientes.isEmpty()) {
                ((ResultTableModel) resultTable.getModel()).clientes.clear();
                ((ResultTableModel) resultTable.getModel()).clientes.addAll(listaClientes);
                resultTable.updateUI();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron clientes", "BUSQUEDA", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
        
    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void backupMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupMenuActionPerformed
        ExportForm form = new ExportForm(this, true);
        form.setLocationRelativeTo(null);
        form.setVisible(true);                
    }//GEN-LAST:event_backupMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {        
        final LoginService loginService = new PrestamoLoginService();
        
        UIManager.put("JXLoginPane.banner.darkBackground", Color.ORANGE);
        UIManager.put("JXLoginPane.banner.lightBackground", Color.ORANGE.brighter());
        UIManager.put("JXLoginPane.banner.font", new Font("Arial", Font.ITALIC, 35));
        UIManager.put("JXLoginPane.banner.foreground", Color.WHITE);
        
        Status status = JXLoginPane.showLoginDialog(null, loginService);
        
        if(status == JXLoginPane.Status.SUCCEEDED) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Application a = new Application();
                    a.setLocationRelativeTo(null);
                    a.setVisible(true);
                }
            });
        } else {
            System.exit(0);
        }
    }
    
    private class ResultTableModel extends AbstractTableModel {
        List<Cliente> clientes;
        String[] columns = {"Nombre", "Telefono", "Cedula"};

        public ResultTableModel() {
            clientes = new ArrayList<Cliente>();
        }
                
        public ResultTableModel(List<Cliente> clientes) {
            this.clientes = clientes;
        }
                        
        @Override
        public int getRowCount() {
            return clientes.size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public String getColumnName(int column) {
            return columns[column];
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            String valueAt = null;
            
            switch(columnIndex) {
                case 0:
                    valueAt =  clientes.get(rowIndex).getNombre() + " " + clientes.get(rowIndex).getApellido();
                    break;
                case 1:
                    valueAt = clientes.get(rowIndex).getTelefono();
                    break;
                case 2:
                    valueAt =  String.valueOf(clientes.get(rowIndex).getCedula());
                    break;
            }
            
            return valueAt;
        }
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem amortizarPrestamo;
    private javax.swing.JMenuItem backupMenu;
    private javax.swing.JButton buscarBtn;
    private javax.swing.JMenuItem crearCliente;
    private javax.swing.JComboBox criterioBusquedaCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField valorBusquedaTxt;
    // End of variables declaration//GEN-END:variables
    private Controller controller;
}
