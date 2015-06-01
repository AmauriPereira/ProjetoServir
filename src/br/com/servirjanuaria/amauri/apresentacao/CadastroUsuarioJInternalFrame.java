/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.apresentacao;

import br.com.servirjanuaria.amauri.dataAccess.Usuario1DAO;
import br.com.servirjanuaria.amauri.dataAccess.UsuarioDAO;
import br.com.servirjanuaria.amauri.domainModel.Usuario;
import br.com.servirjanuaria.amauri.domainModel.repositorios.UsuarioRepositorio;
import br.com.servirjanuaria.amauri.excecao.UsuarioExistenteException;
import br.com.servirjanuaria.amauri.negocio.UsuarioBO;
import br.com.servirjanuaria.amauri.utillitarios.CriptografiaUtil;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Amauri
 */
public class CadastroUsuarioJInternalFrame extends javax.swing.JInternalFrame {

    static UsuarioRepositorio usuarios = new Usuario1DAO();

    /**
     * Creates new form CadastroUsuarioJInternalFrame
     */
    public CadastroUsuarioJInternalFrame() {
        initComponents();
        txtDataCadastro.disable();
        DataCadastroUsuario();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        cmbNivelAcesso = new javax.swing.JComboBox();
        txtDataCadastro = new javax.swing.JFormattedTextField();
        txtSenha = new javax.swing.JPasswordField();

        setClosable(true);
        setTitle("Cadastro de Usuário");

        jLabel1.setText("Nome:");

        jLabel2.setText("Usuário:");

        jLabel3.setText("Senha:");

        jLabel4.setText("Nível de Acesso:");

        jLabel5.setText("Data Cadastro:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cmbNivelAcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Administrador", "Secretaria", "Pedagógico" }));

        txtDataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbNivelAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataCadastro))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSenha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbNivelAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtNome.getText().equals("") || txtSenha.getText().equals("") || txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Cadastro de Usuários", JOptionPane.ERROR_MESSAGE);
        } else {
            if (cmbNivelAcesso.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(null, "Selecione uma opção de nivel de acesso!", "Nivel de Acesso", JOptionPane.ERROR_MESSAGE);
            } else {
                String Nome;
                String NomeUsuario;
                String Senha;
                int NivelAcesso;
                Date DataCadastro = null;

                Nome = txtNome.getText();
                NomeUsuario = txtUsuario.getText();
                Senha = txtSenha.getText();

                CriptografiaUtil criptografiaUtil = new CriptografiaUtil();
                Senha = criptografiaUtil.criptografiaSenha(Senha);

                if (cmbNivelAcesso.getSelectedItem().equals("Administrador")) {
                    NivelAcesso = 1;
                } else if (cmbNivelAcesso.getSelectedItem().equals("Secretaria")) {
                    NivelAcesso = 2;
                } else {
                    NivelAcesso = 3;
                }

                try {
                    SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
                    DataCadastro = formatarData.parse(txtDataCadastro.getText());

                } catch (ParseException ex) {
                    Logger.getLogger(CadastroUsuarioJInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao setar a data na variavel DataCadastro!", "Erro", JOptionPane.ERROR_MESSAGE);
                }

                Usuario usuario = new Usuario();

                usuario.setNome(Nome);
                usuario.setNivelUsuario(NivelAcesso);
                usuario.setUsuario(NomeUsuario);
                usuario.setDataCadastro(DataCadastro);
                usuario.setSenha(Senha);

                try {
                    usuarios.salvar(usuario);
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso ao Cadastrar", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha no cadastro!", "Erro ao Cadastrar", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println(e);
                }

            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbNivelAcesso;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtDataCadastro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void DataCadastroUsuario() {
        java.util.Date DataSistema = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        txtDataCadastro.setText(formato.format(DataSistema));
    }

}
