/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.apresentacao;

import br.com.servirjanuaria.amauri.dataAccess.AlunoDAO;
import br.com.servirjanuaria.amauri.dataAccess.BairroDAO;
import br.com.servirjanuaria.amauri.dataAccess.CertidaoNascimentoDAO;
import br.com.servirjanuaria.amauri.dataAccess.DeficienciaDAO;
import br.com.servirjanuaria.amauri.dataAccess.EnderecoDAO;
import br.com.servirjanuaria.amauri.dataAccess.InformacoesDAO;
import br.com.servirjanuaria.amauri.dataAccess.MaeDAO;
import br.com.servirjanuaria.amauri.dataAccess.MatriculaDAO;
import br.com.servirjanuaria.amauri.dataAccess.PaiDAO;
import br.com.servirjanuaria.amauri.dataAccess.ProgramaSocialDAO;
import br.com.servirjanuaria.amauri.dataAccess.UnidadeEscolarDAO;
import br.com.servirjanuaria.amauri.domainModel.Aluno;
import br.com.servirjanuaria.amauri.domainModel.CertidaoNascimento;
import br.com.servirjanuaria.amauri.domainModel.Deficiencia;
import br.com.servirjanuaria.amauri.domainModel.Endereco;
import br.com.servirjanuaria.amauri.domainModel.Informacoes;
import br.com.servirjanuaria.amauri.domainModel.Mae;
import br.com.servirjanuaria.amauri.domainModel.Matricula;
import br.com.servirjanuaria.amauri.domainModel.Pai;
import br.com.servirjanuaria.amauri.domainModel.UnidadeEscolar;
import br.com.servirjanuaria.amauri.domainModel.repositorios.AlunoRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.BairroRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.CertidaoNascimentoRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.DeficienciaRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.EnderecoRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.InformacoesRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.MaeRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.MatriculaRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.PaiRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.ProgramaSocialRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.UnidadeEscolarRepositorio;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author amauri_pereira
 */
public class GestaoAlunoTela3JInternalFrame extends javax.swing.JInternalFrame {

    private static JDesktopPane painelPrincipal = null;

    static AlunoRepositorio alunos = new AlunoDAO();
    static CertidaoNascimentoRepositorio certidoes = new CertidaoNascimentoDAO();
    static EnderecoRepositorio enderecos = new EnderecoDAO();
    static BairroRepositorio bairros = new BairroDAO();
    static ProgramaSocialRepositorio programasSociais = new ProgramaSocialDAO();
    static UnidadeEscolarRepositorio unidadesEscolares = new UnidadeEscolarDAO();
    static MatriculaRepositorio matriculas = new MatriculaDAO();
    static PaiRepositorio pais = new PaiDAO();
    static MaeRepositorio maes = new MaeDAO();
    static DeficienciaRepositorio deficiencias = new DeficienciaDAO();
    static InformacoesRepositorio informacoes = new InformacoesDAO();

    Endereco endereco = new Endereco();
    CertidaoNascimento certidaoNascimento = new CertidaoNascimento();
    Aluno aluno = new Aluno();
    Pai pai = new Pai();
    Mae mae = new Mae();
    Matricula matricula = new Matricula();
    UnidadeEscolar unidadeEscolar = new UnidadeEscolar();
    Informacoes informacao = new Informacoes();

    /**
     * Creates new form GestaoAlunoTela3JInternalFrame
     *
     * @param painelPrincipal
     * @param aluno
     * @param certidaoNascimento
     * @param endereco
     * @param unidadeEscolar
     * @param matricula
     * @param mae
     * @param pai
     */
    public GestaoAlunoTela3JInternalFrame(JDesktopPane painelPrincipal, Aluno aluno, CertidaoNascimento certidaoNascimento, Endereco endereco, UnidadeEscolar unidadeEscolar, Matricula matricula, Mae mae, Pai pai) {
        initComponents();
        GestaoAlunoTela3JInternalFrame.painelPrincipal = painelPrincipal;
        this.pai = pai;
        this.mae = mae;
        this.aluno = aluno;
        this.certidaoNascimento = certidaoNascimento;
        this.endereco = endereco;
        this.matricula = matricula;
        this.unidadeEscolar = unidadeEscolar;

    }

    //Metodo que add todos os projetos cadastrados na ComboBoxBairro
    private void populaCmbDeficiencia() {

        Deficiencia deficiencia = new Deficiencia();
        cmbDeficiencia.removeAllItems();
        cmbDeficiencia.addItem("Selecione");

        for (Deficiencia deficienciaItem : deficiencias.buscar(deficiencia)) {
            cmbDeficiencia.addItem(deficienciaItem.getNome());
        }

    }

    private void captaInformacoesPessoais() {

        String restricaoAlimentar = txtRestricaoAlimentar.getText();
        String problemaSaude = txtProblemaSaude.getText();
        String outros = txtOutros.getText();
        String informacaoComplementar = txtInformacaoComplementar.getText();

        informacao.setRestricaoAlimentar(restricaoAlimentar);
        informacao.setProblemaSaude(problemaSaude);
        informacao.setOutros(outros);
        informacao.setInfoComplementar(informacaoComplementar);
        informacao.setAluno(aluno);        
        aluno.setStatus("Ativo");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnGeral = new javax.swing.JPanel();
        jpnDeficiencia = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDeficiencia = new javax.swing.JTable();
        lblDeficiencia = new javax.swing.JLabel();
        cmbDeficiencia = new javax.swing.JComboBox();
        btnAdicionarDeficiencia = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jpnInformacoes = new javax.swing.JPanel();
        lblInformacao1 = new javax.swing.JLabel();
        txtRestricaoAlimentar = new javax.swing.JTextField();
        lblInformacao2 = new javax.swing.JLabel();
        lblInformacao3 = new javax.swing.JLabel();
        txtProblemaSaude = new javax.swing.JTextField();
        txtOutros = new javax.swing.JTextField();
        jpnInformacaoComplementar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInformacaoComplementar = new javax.swing.JTextArea();
        btnFinalizar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Matrícula Aluno");

        jpnDeficiencia.setBorder(javax.swing.BorderFactory.createTitledBorder("Deficiência/Transtorno Globais de Desenvolvimento/Altas"));

        tblDeficiencia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDeficiencia);

        lblDeficiencia.setText("Deficiências:");

        cmbDeficiencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdicionarDeficiencia.setText("+");
        btnAdicionarDeficiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarDeficienciaActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");

        javax.swing.GroupLayout jpnDeficienciaLayout = new javax.swing.GroupLayout(jpnDeficiencia);
        jpnDeficiencia.setLayout(jpnDeficienciaLayout);
        jpnDeficienciaLayout.setHorizontalGroup(
            jpnDeficienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDeficienciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnDeficienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnDeficienciaLayout.createSequentialGroup()
                        .addGroup(jpnDeficienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDeficiencia)
                            .addGroup(jpnDeficienciaLayout.createSequentialGroup()
                                .addComponent(cmbDeficiencia, 0, 267, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdicionarDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnDeficienciaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemover)))
                .addContainerGap())
        );
        jpnDeficienciaLayout.setVerticalGroup(
            jpnDeficienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDeficienciaLayout.createSequentialGroup()
                .addGroup(jpnDeficienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnDeficienciaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDeficiencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnDeficienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionarDeficiencia)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemover))
        );

        jpnInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações pessoais sobre o aluno"));

        lblInformacao1.setText("Possui algum alimento que não possa ser ofertado ao aluno(a):");

        lblInformacao2.setText("Possui algum problema de saúde (Qual)?");

        lblInformacao3.setText("Outras observações sobre o aluno que o resposável ache importante");

        javax.swing.GroupLayout jpnInformacoesLayout = new javax.swing.GroupLayout(jpnInformacoes);
        jpnInformacoes.setLayout(jpnInformacoesLayout);
        jpnInformacoesLayout.setHorizontalGroup(
            jpnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRestricaoAlimentar)
                    .addComponent(txtProblemaSaude)
                    .addGroup(jpnInformacoesLayout.createSequentialGroup()
                        .addGroup(jpnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInformacao1)
                            .addComponent(lblInformacao2)
                            .addComponent(lblInformacao3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtOutros))
                .addContainerGap())
        );
        jpnInformacoesLayout.setVerticalGroup(
            jpnInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInformacao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRestricaoAlimentar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblInformacao2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProblemaSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblInformacao3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpnInformacaoComplementar.setBorder(javax.swing.BorderFactory.createTitledBorder("Informaçãoes complementares sobre o aluno"));

        txtInformacaoComplementar.setColumns(20);
        txtInformacaoComplementar.setRows(5);
        jScrollPane1.setViewportView(txtInformacaoComplementar);

        javax.swing.GroupLayout jpnInformacaoComplementarLayout = new javax.swing.GroupLayout(jpnInformacaoComplementar);
        jpnInformacaoComplementar.setLayout(jpnInformacaoComplementarLayout);
        jpnInformacaoComplementarLayout.setHorizontalGroup(
            jpnInformacaoComplementarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInformacaoComplementarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jpnInformacaoComplementarLayout.setVerticalGroup(
            jpnInformacaoComplementarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInformacaoComplementarLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");

        javax.swing.GroupLayout jpnGeralLayout = new javax.swing.GroupLayout(jpnGeral);
        jpnGeral.setLayout(jpnGeralLayout);
        jpnGeralLayout.setHorizontalGroup(
            jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnDeficiencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnInformacaoComplementar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnGeralLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpnGeralLayout.setVerticalGroup(
            jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnInformacaoComplementar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarDeficienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarDeficienciaActionPerformed
        this.populaCmbDeficiencia();
        CadastroDeficienciaJInternalFrame cadastroDeficienciaJInternalFrame = new CadastroDeficienciaJInternalFrame();
        cadastroDeficienciaJInternalFrame.setVisible(true);
        painelPrincipal.add(cadastroDeficienciaJInternalFrame);
        cadastroDeficienciaJInternalFrame.toFront();
    }//GEN-LAST:event_btnAdicionarDeficienciaActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        try {
            this.captaInformacoesPessoais();
            if (JOptionPane.showConfirmDialog(null, "Deseja savar os dados?", "Cadastro Aluno", JOptionPane.YES_NO_OPTION) == 0) {
                enderecos.salvar(endereco);
                certidoes.salvar(certidaoNascimento);
                maes.salvar(mae);
                pais.salvar(pai);
                alunos.salvar(aluno);
                unidadesEscolares.salvar(unidadeEscolar);
                matriculas.salvar(matricula);
                informacoes.salvar(informacao);
                this.dispose();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Cadastro informações complementares", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarDeficiencia;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbDeficiencia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpnDeficiencia;
    private javax.swing.JPanel jpnGeral;
    private javax.swing.JPanel jpnInformacaoComplementar;
    private javax.swing.JPanel jpnInformacoes;
    private javax.swing.JLabel lblDeficiencia;
    private javax.swing.JLabel lblInformacao1;
    private javax.swing.JLabel lblInformacao2;
    private javax.swing.JLabel lblInformacao3;
    private javax.swing.JTable tblDeficiencia;
    private javax.swing.JTextArea txtInformacaoComplementar;
    private javax.swing.JTextField txtOutros;
    private javax.swing.JTextField txtProblemaSaude;
    private javax.swing.JTextField txtRestricaoAlimentar;
    // End of variables declaration//GEN-END:variables
}
