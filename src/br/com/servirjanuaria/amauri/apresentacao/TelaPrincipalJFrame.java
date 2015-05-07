/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.apresentacao;

import static br.com.servirjanuaria.amauri.apresentacao.LoginJFrame.getInstancia;
import br.com.servirjanuaria.amauri.domainModel.Usuario;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Amauri
 */
public class TelaPrincipalJFrame extends javax.swing.JFrame {

    /* metodo abaixo instancia um Painel de Area de Trabalho(AreaPrincipalDesktopPane1).
     O painel AreaPrincipalDesktopPane1 é area onde os formularios internos vão ser instanciados*/
    public static JDesktopPane getPainel() {

        return getInstancia().AreaPrincipalDesktopPane1;

    }

    private static Usuario usuarioLogado;

    /**
     * Creates new form TelaPrincipalJFrame
     *
     * @param usuarioLogado
     */
    public TelaPrincipalJFrame(Usuario usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        configuraBarraStatus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /*Metodo que configura as insformações da barra de status do sistema
     (UsuarioLogado, Deparatmento, Função) - hora e data*/
    private void configuraBarraStatus() {
        this.txtUsuario.setText(usuarioLogado.getUsuario());

        String nivelAcesso = null;
        if (usuarioLogado.getNivelUsuario() == 1) {
            nivelAcesso = "Administrador";
        } else if (usuarioLogado.getNivelUsuario() == 2) {
            nivelAcesso = "Secretaria";
        } else {
            nivelAcesso = "Pedagógico";
        }
        this.txtNivelAcessoUsuario.setText(nivelAcesso);

    }

    //Metodo configura a posição do formularios internos em relação ao painel(CENTRO)
    //ESSE METODO É CHAMADO SEMPRE QUE O USUARIO ABRE ALGUMA TELA DE FORMULARIO(Cadastro Gerente, Diretor e outras);
    private void centralizaForm(JInternalFrame frame) {

        Dimension desktopSize = AreaPrincipalDesktopPane1.getSize();
        Dimension jInternalFrameSize = frame.getSize();

        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DadosUsuarioLogado = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        lblNivelAcessoUsuario = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        txtNivelAcessoUsuario = new javax.swing.JLabel();
        txtData = new javax.swing.JLabel();
        txtHora = new javax.swing.JLabel();
        AreaPrincipalDesktopPane1 = new javax.swing.JDesktopPane();
        MenuAcessoRapido = new javax.swing.JPanel();
        btnBackup = new javax.swing.JButton();
        btnPresenca = new javax.swing.JButton();
        btnRelatorios = new javax.swing.JButton();
        btnRenovacao = new javax.swing.JButton();
        btnMatricula = new javax.swing.JButton();
        BarraMenu = new javax.swing.JMenuBar();
        mnuMatricula = new javax.swing.JMenu();
        mnuCadastro = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuPresenca = new javax.swing.JMenu();
        mnuPlanoEnsino = new javax.swing.JMenu();
        mnuRelatorios = new javax.swing.JMenu();
        mnuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        DadosUsuarioLogado.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        DadosUsuarioLogado.setToolTipText("");

        lblUsuario.setText("Usuário:");

        lblNivelAcessoUsuario.setText("Nível de Acesso:");

        lblHora.setText("Hora:");

        lblData.setText("Data:");

        javax.swing.GroupLayout DadosUsuarioLogadoLayout = new javax.swing.GroupLayout(DadosUsuarioLogado);
        DadosUsuarioLogado.setLayout(DadosUsuarioLogadoLayout);
        DadosUsuarioLogadoLayout.setHorizontalGroup(
            DadosUsuarioLogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DadosUsuarioLogadoLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(lblNivelAcessoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNivelAcessoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(lblHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        DadosUsuarioLogadoLayout.setVerticalGroup(
            DadosUsuarioLogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DadosUsuarioLogadoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(DadosUsuarioLogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DadosUsuarioLogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNivelAcessoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNivelAcessoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblHora, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        AreaPrincipalDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout AreaPrincipalDesktopPane1Layout = new javax.swing.GroupLayout(AreaPrincipalDesktopPane1);
        AreaPrincipalDesktopPane1.setLayout(AreaPrincipalDesktopPane1Layout);
        AreaPrincipalDesktopPane1Layout.setHorizontalGroup(
            AreaPrincipalDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        AreaPrincipalDesktopPane1Layout.setVerticalGroup(
            AreaPrincipalDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        MenuAcessoRapido.setBorder(javax.swing.BorderFactory.createTitledBorder("Acesso Rápido"));

        btnBackup.setText("Backup");

        btnPresenca.setText("Presença");

        btnRelatorios.setText("Relatórios");

        btnRenovacao.setText("Renovação");
        btnRenovacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenovacaoActionPerformed(evt);
            }
        });

        btnMatricula.setText("Matrícula");
        btnMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuAcessoRapidoLayout = new javax.swing.GroupLayout(MenuAcessoRapido);
        MenuAcessoRapido.setLayout(MenuAcessoRapidoLayout);
        MenuAcessoRapidoLayout.setHorizontalGroup(
            MenuAcessoRapidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuAcessoRapidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuAcessoRapidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRenovacao, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(btnRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPresenca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MenuAcessoRapidoLayout.setVerticalGroup(
            MenuAcessoRapidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuAcessoRapidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnRenovacao, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mnuMatricula.setText("Matrícula");
        BarraMenu.add(mnuMatricula);

        mnuCadastro.setText("Cadastro");

        jMenuItem1.setText("Usuário");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuCadastro.add(jMenuItem1);

        BarraMenu.add(mnuCadastro);

        mnuPresenca.setText("Presença");
        BarraMenu.add(mnuPresenca);

        mnuPlanoEnsino.setText("Plano de Ensino");
        BarraMenu.add(mnuPlanoEnsino);

        mnuRelatorios.setText("Relatórios");
        BarraMenu.add(mnuRelatorios);

        mnuAjuda.setText("Ajuda");
        BarraMenu.add(mnuAjuda);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuAcessoRapido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AreaPrincipalDesktopPane1)
                .addContainerGap())
            .addComponent(DadosUsuarioLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AreaPrincipalDesktopPane1))
                    .addComponent(MenuAcessoRapido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DadosUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRenovacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenovacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRenovacaoActionPerformed

    private void btnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculaActionPerformed
        ResultadoBuscaAlunoJInternalFrame cadastroAlunoJInternalFrame = null;

        cadastroAlunoJInternalFrame = new ResultadoBuscaAlunoJInternalFrame();
        cadastroAlunoJInternalFrame.setVisible(true);
        centralizaForm(cadastroAlunoJInternalFrame);
        cadastroAlunoJInternalFrame.toFront();
        AreaPrincipalDesktopPane1.add(cadastroAlunoJInternalFrame);
    }//GEN-LAST:event_btnMatriculaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //metodo que seta a horaNow e data atual no sistema(Na barra de status)

        this.setExtendedState(MAXIMIZED_BOTH);

        Date DataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        txtData.setText(formato.format(DataSistema));

        Timer timer = new Timer(1000, new horaNow());
        timer.start();


    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// Menu - Cadastro > ItemMenu - Departamento 
        //Instancia uma tela de cadastro de Departamento se o usuario que esta logado for Um diretor;
        //caso não seja um diretor é exibida uma mensagem de ao usuario do sistema.
        //Obs: Somente diretor pode cadastrar departamento
        if (usuarioLogado.getNivelUsuario() != 1) {

            CadastroUsuarioJInternalFrame cadastroUsuarioJInternalFrame = null;

            cadastroUsuarioJInternalFrame = new CadastroUsuarioJInternalFrame();
            cadastroUsuarioJInternalFrame.setVisible(true);
            centralizaForm(cadastroUsuarioJInternalFrame);
            cadastroUsuarioJInternalFrame.toFront();
            AreaPrincipalDesktopPane1.add(cadastroUsuarioJInternalFrame);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n"
                    + "a Tela de Cadastros de Departamentos!!!", "Cadastro de Departamentos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipalJFrame(usuarioLogado).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane AreaPrincipalDesktopPane1;
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JPanel DadosUsuarioLogado;
    private javax.swing.JPanel MenuAcessoRapido;
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JButton btnPresenca;
    private javax.swing.JButton btnRelatorios;
    private javax.swing.JButton btnRenovacao;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNivelAcessoUsuario;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu mnuAjuda;
    private javax.swing.JMenu mnuCadastro;
    private javax.swing.JMenu mnuMatricula;
    private javax.swing.JMenu mnuPlanoEnsino;
    private javax.swing.JMenu mnuPresenca;
    private javax.swing.JMenu mnuRelatorios;
    private javax.swing.JLabel txtData;
    private javax.swing.JLabel txtHora;
    private javax.swing.JLabel txtNivelAcessoUsuario;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables

    class horaNow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            txtHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }
}
