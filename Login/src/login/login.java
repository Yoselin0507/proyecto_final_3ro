/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



/**
 *
 * @author yoselin
 */
public class login extends javax.swing.JFrame {
public inicio inicio;
private Connection conexion;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
public void Conectar() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/papeleria", "root", "");
            st = (Statement) conexion.createStatement();
            rs = st.executeQuery("Select * from productos;");
            rs.next();
            llenarDatos();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error 000" + err.getMessage());
        }

    }
public void llenarDatos() {
        try {
            this.Jtf_usuario.setText(rs.getString("USUARIO"));
            this.Jp_contrasena.setText(rs.getString("CONTRASEÑA"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se podido realizar esta accion" + ex.getMessage());
        }
    }
    /**
     * Creates new form login
     */productos prod=new productos();
    public login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Jl_contraseña = new javax.swing.JLabel();
        Jtf_usuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Jb_salir = new javax.swing.JButton();
        Jp_contrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        jLabel1.setText("INICIAR SESION");

        jLabel3.setText("USUARIO");

        Jl_contraseña.setText("CONTRASEÑA");

        jButton1.setForeground(new java.awt.Color(153, 0, 153));
        jButton1.setText("ENTRAR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Jb_salir.setForeground(new java.awt.Color(102, 0, 102));
        Jb_salir.setText("SALIR");
        Jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(39, 39, 39)
                            .addComponent(Jtf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(Jl_contraseña)
                            .addGap(18, 18, 18)
                            .addComponent(Jp_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(Jb_salir)
                        .addGap(44, 44, 44)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Jtf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jl_contraseña)
                    .addComponent(Jp_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Jb_salir))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String usuario="Administrador";
        String contraseña="dani";
            String passw=new String(Jp_contrasena.getPassword());
            if(Jtf_usuario.getText().equals(usuario)&&passw.equals(contraseña)){
            }
            else{
                JOptionPane.showMessageDialog(this, "Usuario y contraseña incorrectos");
        //char clave[]=Jp_password.getPassword();

//String clavedef=new String(clave);


//if (Jtf_usuario.getText().equals("Administrador") && clavedef.equals("12345")){


                  //  this.dispose();


                  //  JOptionPane.showMessageDialog(null, "Bienvenido\n"
                   // + "Has ingresado satisfactoriamente al sistema",   "Mensaje de bienvenida",
                    //JOptionPane.INFORMATION_MESSAGE);


                    //login login = new login();

                    //login.setVisible(true);


            //}else {


                  //  JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                  //  + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
                  //  JOptionPane.ERROR_MESSAGE);//
           

            }//
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jb_salirActionPerformed
        // TODO add your handling code here:
        this.Jtf_usuario.setText("");
       this.Jp_contrasena.setText("");
    }//GEN-LAST:event_Jb_salirActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        inicio vinicio=new inicio();
        vinicio.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jb_salir;
    private javax.swing.JLabel Jl_contraseña;
    private javax.swing.JPasswordField Jp_contrasena;
    private javax.swing.JTextField Jtf_usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
