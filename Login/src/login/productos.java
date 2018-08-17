/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yoselin
 */
public class productos extends javax.swing.JFrame {

    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    
   

    
    
    private void habilitarCajas(){
        
        Jtf_nombre_producto.setEditable(true);
        Jtf_precio_producto.setEditable(true);
        Jtf_existencias.setEditable(true);
    }
   
    private void Guardar(){
        try {
            String id = Jtf_codigo_producto.getText();
            String nombre = Jtf_nombre_producto.getText();
            String precio = Jtf_precio_producto.getText();
            String existencias = Jtf_existencias.getText();
            
            String sql = "INSERT into productos(id,nombre,precio,existencias)"
                    + " values(?,?,?,?);";
            
            pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, nombre);
            pst.setString(3, precio);
            pst.setString(4,existencias);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "El registro ha sido guardado exitosamente");
            seleccionarTodosLosRegistros();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error" + ex.getMessage());
        }
        
    
    }
    private void borrar(){
        try{
            String id = Jtf_codigo_producto.getText();
            pst = cn.prepareStatement("DELETE FROM productos WHERE id=?");
            pst.setString(1, id);
            int res = pst.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Producto eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }catch(Exception e){
            System.err.println(e);
        }
        
    }
    private void actualizar(){
        try{
            String id = Jtf_codigo_producto.getText();
            String nombre = Jtf_nombre_producto.getText();
            String precio = Jtf_precio_producto.getText();
            String existencias = Jtf_existencias.getText();
            String sql="UPDATE productos SET  nombre=?, precio=?, existencias=?"+ "WHERE id=?";
            pst = cn.prepareStatement(sql);
            
            pst.setString(1, nombre);
            pst.setString(2, precio);
            pst.setString(3,existencias);
            pst.setString(4, id);
            
           int res = pst.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Producto actualizado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al atualizar");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se a podido actualizar el preoducto");;
        }
        
    
    }
    
    private void seleccionarTodosLosRegistros(){
        try {
            String sql = "SELECT * FROM productos;";
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error 007" + ex.getMessage());
        }
        
    }
   
    /**
     * Creates new form productos
     */
    public productos() {
        initComponents();
        tabladatos("");
        this.setLocationRelativeTo(null);
    }
     private void tabladatos(String valor){
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("EXISTENCIAS");
        Jt_producto.setModel(modelo);
        String sql="";
        if(valor.equals("")){
            sql="SELECT * FROM productos";
        }else{
            sql="SELECT * FROM productos WHERE id='"+valor+"'";
        }
        String []datos = new String [4];
        try{
            Statement st= (com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                modelo.addRow(datos);
            }
            Jt_producto.setModel(modelo);
        }catch (SQLException ex){
            Logger.getLogger(consultaproducto.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Jl_codigo_producto = new javax.swing.JLabel();
        Jl_nombre_producto = new javax.swing.JLabel();
        Jtf_nombre_producto = new javax.swing.JTextField();
        Jl_precio_producto = new javax.swing.JLabel();
        Jl_existencias = new javax.swing.JLabel();
        Jtf_precio_producto = new javax.swing.JTextField();
        Jtf_existencias = new javax.swing.JTextField();
        Jtf_codigo_producto = new javax.swing.JTextField();
        Jb_nuevo = new javax.swing.JButton();
        Jb_actualizar = new javax.swing.JButton();
        Jb_borrar = new javax.swing.JButton();
        Jb_guardar = new javax.swing.JButton();
        Jb_cancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jt_producto = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        jLabel1.setText("AGREGAR PRODUCTOS");

        Jl_codigo_producto.setText("CODIGO");

        Jl_nombre_producto.setText("NOMBRE");

        Jl_precio_producto.setText("PRECIO");

        Jl_existencias.setText("EXISTENCIAS");

        Jb_nuevo.setText("NUEVO");
        Jb_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_nuevoActionPerformed(evt);
            }
        });

        Jb_actualizar.setText("ACTUALIZAR");
        Jb_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_actualizarActionPerformed(evt);
            }
        });

        Jb_borrar.setText("BORRAR");
        Jb_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_borrarActionPerformed(evt);
            }
        });

        Jb_guardar.setText("GUARDAR");
        Jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_guardarActionPerformed(evt);
            }
        });

        Jb_cancelar.setText("CANCELAR");
        Jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_cancelarActionPerformed(evt);
            }
        });

        Jt_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Jt_producto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Jl_existencias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Jtf_existencias))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jl_codigo_producto)
                            .addComponent(Jl_nombre_producto)
                            .addComponent(Jl_precio_producto))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Jtf_precio_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Jtf_codigo_producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Jtf_nombre_producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(82, 82, 82))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Jb_nuevo)
                                .addGap(18, 18, 18)
                                .addComponent(Jb_guardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jb_actualizar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(Jb_borrar)
                                .addGap(18, 18, 18)
                                .addComponent(Jb_cancelar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jl_codigo_producto)
                    .addComponent(Jtf_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jl_nombre_producto)
                    .addComponent(Jtf_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jl_precio_producto)
                    .addComponent(Jtf_precio_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jl_existencias)
                    .addComponent(Jtf_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jb_nuevo)
                    .addComponent(Jb_actualizar)
                    .addComponent(Jb_guardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jb_cancelar)
                    .addComponent(Jb_borrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jb_nuevoActionPerformed
        // TODO add your handling code here:
        Jtf_codigo_producto.setText("");
        Jtf_nombre_producto.setText("");
        Jtf_precio_producto.setText("");
        Jtf_existencias.setText("");
        
        habilitarCajas();
        tabladatos("");
    }//GEN-LAST:event_Jb_nuevoActionPerformed

    private void Jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jb_guardarActionPerformed
        // TODO add your handling code here:
        Guardar();
       tabladatos("");
    }//GEN-LAST:event_Jb_guardarActionPerformed

    private void Jb_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jb_actualizarActionPerformed
        // TODO add your handling code here:
        actualizar();
        tabladatos("");
    }//GEN-LAST:event_Jb_actualizarActionPerformed

    private void Jb_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jb_borrarActionPerformed
        // TODO add your handling code here:
        borrar();
        tabladatos("");
    }//GEN-LAST:event_Jb_borrarActionPerformed

    private void Jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jb_cancelarActionPerformed
        // TODO add your handling code here:
        dispose();
        tabladatos("");
        inicio inicio=new inicio();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Jb_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jb_actualizar;
    private javax.swing.JButton Jb_borrar;
    private javax.swing.JButton Jb_cancelar;
    private javax.swing.JButton Jb_guardar;
    private javax.swing.JButton Jb_nuevo;
    private javax.swing.JLabel Jl_codigo_producto;
    private javax.swing.JLabel Jl_existencias;
    private javax.swing.JLabel Jl_nombre_producto;
    private javax.swing.JLabel Jl_precio_producto;
    private javax.swing.JTable Jt_producto;
    private javax.swing.JTextField Jtf_codigo_producto;
    private javax.swing.JTextField Jtf_existencias;
    private javax.swing.JTextField Jtf_nombre_producto;
    private javax.swing.JTextField Jtf_precio_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    conectar cc = new conectar();
    Connection cn = cc.conexion();
}
