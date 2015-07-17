/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.apresentacao;

import br.com.servirjanuaria.amauri.dataAccess.AlunoDAO;
import br.com.servirjanuaria.amauri.dataAccess.BairroDAO;
import br.com.servirjanuaria.amauri.dataAccess.CertidaoNascimentoDAO;
import br.com.servirjanuaria.amauri.dataAccess.EnderecoDAO;
import br.com.servirjanuaria.amauri.dataAccess.MaeDAO;
import br.com.servirjanuaria.amauri.dataAccess.MatriculaDAO;
import br.com.servirjanuaria.amauri.dataAccess.PaiDAO;
import br.com.servirjanuaria.amauri.dataAccess.ProgramaSocialDAO;
import br.com.servirjanuaria.amauri.dataAccess.UnidadeEscolarDAO;
import br.com.servirjanuaria.amauri.domainModel.Aluno;
import br.com.servirjanuaria.amauri.domainModel.CertidaoNascimento;
import br.com.servirjanuaria.amauri.domainModel.Endereco;
import br.com.servirjanuaria.amauri.domainModel.Mae;
import br.com.servirjanuaria.amauri.domainModel.Matricula;
import br.com.servirjanuaria.amauri.domainModel.Pai;
import br.com.servirjanuaria.amauri.domainModel.ProgramaSocial;
import br.com.servirjanuaria.amauri.domainModel.UnidadeEscolar;
import br.com.servirjanuaria.amauri.domainModel.repositorios.AlunoRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.BairroRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.CertidaoNascimentoRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.EnderecoRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.MaeRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.MatriculaRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.PaiRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.ProgramaSocialRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.UnidadeEscolarRepositorio;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amauri_pereira
 */
public class GestaoAlunoTela2JInternalFrame extends javax.swing.JInternalFrame {

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
    Endereco endereco = new Endereco();
    CertidaoNascimento certidaoNascimento = new CertidaoNascimento();
    Aluno aluno = new Aluno();
    Pai pai = new Pai();
    Mae mae = new Mae();
    Matricula matricula = new Matricula();
    UnidadeEscolar unidadeEscolar = new UnidadeEscolar();
    static int i = 0;

    List<ProgramaSocial> ListaProgramaSocial = new ArrayList<>();

    /**
     * Creates new form GestaoAlunoTela2JInternalFrame
     *
     * @param painelPrincipal
     * @param aluno
     * @param certidaoNascimento
     * @param endereco
     */
    public GestaoAlunoTela2JInternalFrame(JDesktopPane painelPrincipal, Aluno aluno, CertidaoNascimento certidaoNascimento, Endereco endereco) {
        initComponents();
        GestaoAlunoTela2JInternalFrame.painelPrincipal = painelPrincipal;
        this.aluno = aluno;
        this.endereco = endereco;
        this.certidaoNascimento = certidaoNascimento;
        populaCmbProgramasSociais();
        configuraTabelaProgramaSocial();

    }

    //Metodo que add todos os projetos cadastrados na ComboBoxBairro
    private void populaCmbProgramasSociais() {

        ProgramaSocial programaSocial = new ProgramaSocial();
        cmbProgramasSociais.removeAllItems();
        cmbProgramasSociais.addItem("Selecione");

        for (ProgramaSocial programaSocialItem : programasSociais.buscar(programaSocial)) {
            cmbProgramasSociais.addItem(programaSocialItem.getNome());
        }

    }

    //Metodo que add os programas sociais selecionado na comboboxProgramaSocial para a JTable
    private void populaTblProgramasSociais() {

        String programaSocialEscolhido = cmbProgramasSociais.getSelectedItem().toString();

        ProgramaSocial programaSocial = new ProgramaSocial();
        programaSocial.setNome(programaSocialEscolhido);

        for (ProgramaSocial programaSocialItem : programasSociais.buscar(programaSocial)) {

            ProgramaSocial pgrSocial = new ProgramaSocial();

            if (!ListaProgramaSocial.isEmpty()) {

                if (ComparaDadosLista(programaSocialItem.getNome())) {
                    DefaultTableModel tableModel = (DefaultTableModel) tblProgramasSociais.getModel();
                    tableModel.setNumRows(0);
                } else {
                    ListaProgramaSocial.add(i, programaSocialItem);
                    i++;
                    DefaultTableModel tableModel = (DefaultTableModel) tblProgramasSociais.getModel();
                    tableModel.setNumRows(0);
                }
            } else {
                ListaProgramaSocial.add(i, programaSocialItem);
                i++;
            }
            Iterator<ProgramaSocial> iteratorProgramaSocial = ListaProgramaSocial.iterator();
            while (iteratorProgramaSocial.hasNext()) {
                pgrSocial = iteratorProgramaSocial.next();
                DefaultTableModel defaultTableModel = (DefaultTableModel) tblProgramasSociais.getModel();
                defaultTableModel.addRow(new Object[]{pgrSocial.getId(), pgrSocial.getNome()});
            }

        }
    }

    //metodo para capturar a data do sistema
    private static Date getDataAtual() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        String dataFormatada = dateFormat.format(calendar.getTime());
        return dateFormat.parse(dataFormatada);
    }

    public static String getAnoMatricula() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        String dataFormatada = dateFormat.format(calendar.getTime());
        String ano = (dataFormatada.substring(0, 4));
        return ano;
    }

    private void captaDadosEscola() throws ParseException, Exception {
        //Captando dados escola
        String nomeEscola = txtNomeEscola.getText();
        String enderecoEscola = txtEnderecoEscola.getText();
        String telefoneEscola = txtTelefoneEscola.getText();

        //Capta dados do aluno referente a escola
        String serie = cmbSerie.getSelectedItem().toString();
        String turno = cmbTurno.getSelectedItem().toString();
        String egressoRede = txtEgressoRede.getText();

        unidadeEscolar.setNome(nomeEscola);
        unidadeEscolar.setContato(enderecoEscola);
        unidadeEscolar.setTelefone(telefoneEscola);

        matricula.setEgressoRede(egressoRede);
        matricula.setSerie(serie);
        matricula.setTurno(turno);

        matricula.setAno(getAnoMatricula());
        matricula.setDataMatricula(getDataAtual());
        matricula.setUnidadeEscolar(unidadeEscolar);
        matricula.setAluno(aluno);

    }

    private void captaDadosFormularioFiliacao() {

        //capta dados pai
        String nomePai = txtNomePai.getText();
        String rgPai = txtRgPai.getText();
        String cpfPai = txtCpfPai.getText();
        String telefonePai = txtTelefonePai.getText();
        String localTrabalhoPai = txtLocalTrabahoPai.getText();

        pai.setNome(nomePai);
        pai.setCpf(cpfPai);
        pai.setRg(rgPai);
        pai.setTelefone(telefonePai);
        pai.setLocalTrabalho(localTrabalhoPai);
        pai.setPessoa(pai);

        //capta dados Mae
        String nomeMae = txtNomeMae.getText();
        String rgMae = txtRgMae.getText();
        String cpfMae = txtCpfMae.getText();
        String telefoneMae = txtTelefoneMae.getText();
        String localTrabalhoMae = txtLocalTrabalhoMae.getText();

        mae.setNome(nomeMae);
        mae.setRg(rgMae);
        mae.setCpf(cpfMae);
        mae.setTelefone(telefoneMae);
        mae.setLocalTrabalho(localTrabalhoMae);
        mae.setPessoa(mae);

        // filiação do aluno
        aluno.setPai(pai);
        aluno.setMae(mae);
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
        jpnFotoGeral = new javax.swing.JPanel();
        btnUploadFoto = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        btnRemoverFoto = new javax.swing.JButton();
        jpnProgramasSociais = new javax.swing.JPanel();
        cmbProgramasSociais = new javax.swing.JComboBox();
        btnAddProgramaSocial = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProgramasSociais = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        jpnDadosEscolares = new javax.swing.JPanel();
        jpnEscola = new javax.swing.JPanel();
        lblNomeEscola = new javax.swing.JLabel();
        txtNomeEscola = new javax.swing.JTextField();
        lblEnderecoEscola = new javax.swing.JLabel();
        txtEnderecoEscola = new javax.swing.JTextField();
        lblTelefoneEscola = new javax.swing.JLabel();
        txtTelefoneEscola = new javax.swing.JFormattedTextField();
        lblTurno = new javax.swing.JLabel();
        cmbTurno = new javax.swing.JComboBox();
        lblSerie = new javax.swing.JLabel();
        cmbSerie = new javax.swing.JComboBox();
        lblEgressoRede = new javax.swing.JLabel();
        txtEgressoRede = new javax.swing.JTextField();
        jpnFiliacao = new javax.swing.JPanel();
        jpnMae = new javax.swing.JPanel();
        lblNomeMae = new javax.swing.JLabel();
        txtNomeMae = new javax.swing.JTextField();
        lblRgMae = new javax.swing.JLabel();
        txtRgMae = new javax.swing.JTextField();
        lblLocalTrabalhoMae = new javax.swing.JLabel();
        txtLocalTrabalhoMae = new javax.swing.JTextField();
        lblCpfMae = new javax.swing.JLabel();
        lblTelefoneMae = new javax.swing.JLabel();
        txtCpfMae = new javax.swing.JFormattedTextField();
        txtTelefoneMae = new javax.swing.JFormattedTextField();
        jpnPai = new javax.swing.JPanel();
        lblNomePai = new javax.swing.JLabel();
        txtNomePai = new javax.swing.JTextField();
        lblRgPai = new javax.swing.JLabel();
        txtRgPai = new javax.swing.JTextField();
        lblLocalTrabalhoPai = new javax.swing.JLabel();
        txtLocalTrabahoPai = new javax.swing.JTextField();
        lblCpfPai = new javax.swing.JLabel();
        lblTelefonePai = new javax.swing.JLabel();
        txtCpfPai = new javax.swing.JFormattedTextField();
        txtTelefonePai = new javax.swing.JFormattedTextField();
        btnFinalizar = new javax.swing.JButton();
        btnAvancar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Matricula Aluno");

        jpnFotoGeral.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto do Aluno"));

        btnUploadFoto.setText("Upload");
        btnUploadFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadFotoActionPerformed(evt);
            }
        });

        btnRemoverFoto.setText("Excuir");
        btnRemoverFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnFotoGeralLayout = new javax.swing.GroupLayout(jpnFotoGeral);
        jpnFotoGeral.setLayout(jpnFotoGeralLayout);
        jpnFotoGeralLayout.setHorizontalGroup(
            jpnFotoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFotoGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFotoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUploadFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoverFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnFotoGeralLayout.setVerticalGroup(
            jpnFotoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFotoGeralLayout.createSequentialGroup()
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUploadFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemoverFoto)
                .addGap(6, 6, 6))
        );

        jpnProgramasSociais.setBorder(javax.swing.BorderFactory.createTitledBorder("Programas Sociais"));

        cmbProgramasSociais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProgramasSociais.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbProgramasSociaisFocusGained(evt);
            }
        });
        cmbProgramasSociais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProgramasSociaisActionPerformed(evt);
            }
        });

        btnAddProgramaSocial.setText("+");
        btnAddProgramaSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProgramaSocialActionPerformed(evt);
            }
        });

        tblProgramasSociais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cod.", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProgramasSociais.setFillsViewportHeight(true);
        tblProgramasSociais.setFocusCycleRoot(true);
        tblProgramasSociais.setPreferredSize(new java.awt.Dimension(100, 64));
        jScrollPane1.setViewportView(tblProgramasSociais);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnProgramasSociaisLayout = new javax.swing.GroupLayout(jpnProgramasSociais);
        jpnProgramasSociais.setLayout(jpnProgramasSociaisLayout);
        jpnProgramasSociaisLayout.setHorizontalGroup(
            jpnProgramasSociaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnProgramasSociaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnProgramasSociaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnProgramasSociaisLayout.createSequentialGroup()
                        .addGroup(jpnProgramasSociaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnProgramasSociaisLayout.createSequentialGroup()
                                .addComponent(cmbProgramasSociais, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddProgramaSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpnProgramasSociaisLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(btnRemover)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnProgramasSociaisLayout.setVerticalGroup(
            jpnProgramasSociaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnProgramasSociaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnProgramasSociaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProgramasSociais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddProgramaSocial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnRemover)
                .addContainerGap())
        );

        jpnDadosEscolares.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Escolares"));

        jpnEscola.setBorder(javax.swing.BorderFactory.createTitledBorder("Escola"));

        lblNomeEscola.setText("Nome da Escola:");

        lblEnderecoEscola.setText("Endereco:");

        lblTelefoneEscola.setText("Telefone:");

        try {
            txtTelefoneEscola.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jpnEscolaLayout = new javax.swing.GroupLayout(jpnEscola);
        jpnEscola.setLayout(jpnEscolaLayout);
        jpnEscolaLayout.setHorizontalGroup(
            jpnEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnEscolaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeEscola)
                    .addGroup(jpnEscolaLayout.createSequentialGroup()
                        .addGroup(jpnEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEnderecoEscola)
                            .addComponent(lblNomeEscola)
                            .addComponent(txtEnderecoEscola))
                        .addGap(18, 18, 18)
                        .addGroup(jpnEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnEscolaLayout.createSequentialGroup()
                                .addComponent(lblTelefoneEscola)
                                .addGap(46, 46, 46))
                            .addComponent(txtTelefoneEscola))))
                .addContainerGap())
        );
        jpnEscolaLayout.setVerticalGroup(
            jpnEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnEscolaLayout.createSequentialGroup()
                .addComponent(lblNomeEscola)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnderecoEscola)
                    .addComponent(lblTelefoneEscola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnderecoEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefoneEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        lblTurno.setText("Turno:");

        cmbTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Matutino", "Vespertino", "Noturno" }));

        lblSerie.setText("Serie:");

        cmbSerie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        lblEgressoRede.setText("Egresso Rede:");

        javax.swing.GroupLayout jpnDadosEscolaresLayout = new javax.swing.GroupLayout(jpnDadosEscolares);
        jpnDadosEscolares.setLayout(jpnDadosEscolaresLayout);
        jpnDadosEscolaresLayout.setHorizontalGroup(
            jpnDadosEscolaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnEscola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnDadosEscolaresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnDadosEscolaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnDadosEscolaresLayout.createSequentialGroup()
                        .addGroup(jpnDadosEscolaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnDadosEscolaresLayout.createSequentialGroup()
                                .addComponent(lblTurno)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnDadosEscolaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSerie)
                            .addComponent(cmbSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnDadosEscolaresLayout.createSequentialGroup()
                        .addComponent(lblEgressoRede)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtEgressoRede))
                .addContainerGap())
        );
        jpnDadosEscolaresLayout.setVerticalGroup(
            jpnDadosEscolaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDadosEscolaresLayout.createSequentialGroup()
                .addComponent(jpnEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnDadosEscolaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTurno)
                    .addComponent(lblSerie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnDadosEscolaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEgressoRede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEgressoRede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jpnFiliacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Filiação"));

        jpnMae.setBorder(javax.swing.BorderFactory.createTitledBorder("Mãe"));

        lblNomeMae.setText("Nome:");

        lblRgMae.setText("RG:");

        lblLocalTrabalhoMae.setText("Local de Trabalho:");

        lblCpfMae.setText("CPF:");

        lblTelefoneMae.setText("Telefone:");

        try {
            txtCpfMae.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfMaeActionPerformed(evt);
            }
        });

        try {
            txtTelefoneMae.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jpnMaeLayout = new javax.swing.GroupLayout(jpnMae);
        jpnMae.setLayout(jpnMaeLayout);
        jpnMaeLayout.setHorizontalGroup(
            jpnMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMaeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLocalTrabalhoMae)
                    .addComponent(txtNomeMae)
                    .addGroup(jpnMaeLayout.createSequentialGroup()
                        .addGroup(jpnMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeMae)
                            .addComponent(lblLocalTrabalhoMae))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnMaeLayout.createSequentialGroup()
                        .addGroup(jpnMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRgMae)
                            .addComponent(txtRgMae, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnMaeLayout.createSequentialGroup()
                                .addComponent(lblCpfMae)
                                .addGap(0, 86, Short.MAX_VALUE))
                            .addComponent(txtCpfMae))
                        .addGap(18, 18, 18)
                        .addGroup(jpnMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnMaeLayout.createSequentialGroup()
                                .addComponent(lblTelefoneMae)
                                .addGap(43, 43, 43))
                            .addComponent(txtTelefoneMae))))
                .addContainerGap())
        );
        jpnMaeLayout.setVerticalGroup(
            jpnMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMaeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeMae)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRgMae)
                    .addComponent(lblCpfMae)
                    .addComponent(lblTelefoneMae))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRgMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpfMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefoneMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLocalTrabalhoMae)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalTrabalhoMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jpnPai.setBorder(javax.swing.BorderFactory.createTitledBorder("Pai"));

        lblNomePai.setText("Nome:");

        lblRgPai.setText("RG:");

        lblLocalTrabalhoPai.setText("Local de Trabalho:");

        lblCpfPai.setText("CPF:");

        lblTelefonePai.setText("Telefone:");

        try {
            txtCpfPai.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfPaiActionPerformed(evt);
            }
        });

        try {
            txtTelefonePai.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jpnPaiLayout = new javax.swing.GroupLayout(jpnPai);
        jpnPai.setLayout(jpnPaiLayout);
        jpnPaiLayout.setHorizontalGroup(
            jpnPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLocalTrabahoPai)
                    .addComponent(txtNomePai)
                    .addGroup(jpnPaiLayout.createSequentialGroup()
                        .addGroup(jpnPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomePai)
                            .addComponent(lblLocalTrabalhoPai))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnPaiLayout.createSequentialGroup()
                        .addGroup(jpnPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRgPai, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRgPai))
                        .addGap(18, 18, 18)
                        .addGroup(jpnPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnPaiLayout.createSequentialGroup()
                                .addComponent(txtCpfPai)
                                .addGap(18, 18, 18))
                            .addGroup(jpnPaiLayout.createSequentialGroup()
                                .addComponent(lblCpfPai)
                                .addGap(101, 101, 101)))
                        .addGroup(jpnPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefonePai, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addGroup(jpnPaiLayout.createSequentialGroup()
                                .addComponent(lblTelefonePai, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jpnPaiLayout.setVerticalGroup(
            jpnPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomePai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRgPai)
                    .addComponent(lblCpfPai)
                    .addComponent(lblTelefonePai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCpfPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefonePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtRgPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLocalTrabalhoPai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalTrabahoPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnFiliacaoLayout = new javax.swing.GroupLayout(jpnFiliacao);
        jpnFiliacao.setLayout(jpnFiliacaoLayout);
        jpnFiliacaoLayout.setHorizontalGroup(
            jpnFiliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFiliacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnFiliacaoLayout.setVerticalGroup(
            jpnFiliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFiliacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFiliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnMae, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnAvancar.setText("Avançar");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnGeralLayout = new javax.swing.GroupLayout(jpnGeral);
        jpnGeral.setLayout(jpnGeralLayout);
        jpnGeralLayout.setHorizontalGroup(
            jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnFiliacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnGeralLayout.createSequentialGroup()
                        .addComponent(jpnFotoGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnProgramasSociais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnDadosEscolares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnGeralLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpnGeralLayout.setVerticalGroup(
            jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnDadosEscolares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnProgramasSociais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnFotoGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnFiliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar)
                    .addComponent(btnAvancar)
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

    private void btnUploadFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadFotoActionPerformed

    }//GEN-LAST:event_btnUploadFotoActionPerformed

    private void btnRemoverFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverFotoActionPerformed
        //lblFoto.setText("");
    }//GEN-LAST:event_btnRemoverFotoActionPerformed

    private void cmbProgramasSociaisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbProgramasSociaisFocusGained
        populaCmbProgramasSociais();
    }//GEN-LAST:event_cmbProgramasSociaisFocusGained

    private void btnAddProgramaSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProgramaSocialActionPerformed
        this.populaCmbProgramasSociais();
        CadastroProgramaSocialJInternalFrame cadastroProgramaSocialJInternalFrame = new CadastroProgramaSocialJInternalFrame(painelPrincipal);
        cadastroProgramaSocialJInternalFrame.setVisible(true);
        painelPrincipal.add(cadastroProgramaSocialJInternalFrame);
        cadastroProgramaSocialJInternalFrame.toFront();
    }//GEN-LAST:event_btnAddProgramaSocialActionPerformed

    private void txtCpfMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfMaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfMaeActionPerformed

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        try {
            this.captaDadosEscola();
            this.captaDadosFormularioFiliacao();
            GestaoAlunoTela3JInternalFrame gestaoAlunoTela3JInternalFrame = new GestaoAlunoTela3JInternalFrame(painelPrincipal, aluno, certidaoNascimento, endereco, unidadeEscolar, matricula, mae, pai);
            gestaoAlunoTela3JInternalFrame.setVisible(true);
            painelPrincipal.add(gestaoAlunoTela3JInternalFrame);
            gestaoAlunoTela3JInternalFrame.toFront();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Tela 2", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?", "Cadastro Bairro", JOptionPane.YES_NO_OPTION) == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        try {
            this.captaDadosEscola();
            this.captaDadosFormularioFiliacao();
            enderecos.salvar(endereco);
            certidoes.salvar(certidaoNascimento);
            maes.salvar(mae);
            pais.salvar(pai);
            alunos.salvar(aluno);
            unidadesEscolares.salvar(unidadeEscolar);
            matriculas.salvar(matricula);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Filiação", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void txtCpfPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfPaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfPaiActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed

    }//GEN-LAST:event_btnRemoverActionPerformed

    private void cmbProgramasSociaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProgramasSociaisActionPerformed
        /*cmbProgramasSociais.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
         if (e.getStateChange() == ItemEvent.SELECTED) {
         populaTblProgramasSociais();
         }
         }
         }
         );*/

        /* cmbProgramasSociais.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         populaTblProgramasSociais();
         }
         });*/
        /* cmbProgramasSociais.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent arg0) {
         if (arg0.getStateChange() == ItemEvent.SELECTED) {
         Object item = arg0.getItem();
         populaTblProgramasSociais();
         }
         }
         }
         );*/
        cmbProgramasSociais.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    populaTblProgramasSociais();
                }
            }
        });


    }//GEN-LAST:event_cmbProgramasSociaisActionPerformed

    static private String selectedString(ItemSelectable is) {
        Object selected[] = is.getSelectedObjects();
        return ((selected.length == 0) ? "null" : (String) selected[0]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProgramaSocial;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnRemoverFoto;
    private javax.swing.JButton btnUploadFoto;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbProgramasSociais;
    private javax.swing.JComboBox cmbSerie;
    private javax.swing.JComboBox cmbTurno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnDadosEscolares;
    private javax.swing.JPanel jpnEscola;
    private javax.swing.JPanel jpnFiliacao;
    private javax.swing.JPanel jpnFotoGeral;
    private javax.swing.JPanel jpnGeral;
    private javax.swing.JPanel jpnMae;
    private javax.swing.JPanel jpnPai;
    private javax.swing.JPanel jpnProgramasSociais;
    private javax.swing.JLabel lblCpfMae;
    private javax.swing.JLabel lblCpfPai;
    private javax.swing.JLabel lblEgressoRede;
    private javax.swing.JLabel lblEnderecoEscola;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblLocalTrabalhoMae;
    private javax.swing.JLabel lblLocalTrabalhoPai;
    private javax.swing.JLabel lblNomeEscola;
    private javax.swing.JLabel lblNomeMae;
    private javax.swing.JLabel lblNomePai;
    private javax.swing.JLabel lblRgMae;
    private javax.swing.JLabel lblRgPai;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JLabel lblTelefoneEscola;
    private javax.swing.JLabel lblTelefoneMae;
    private javax.swing.JLabel lblTelefonePai;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JTable tblProgramasSociais;
    private javax.swing.JFormattedTextField txtCpfMae;
    private javax.swing.JFormattedTextField txtCpfPai;
    private javax.swing.JTextField txtEgressoRede;
    private javax.swing.JTextField txtEnderecoEscola;
    private javax.swing.JTextField txtLocalTrabahoPai;
    private javax.swing.JTextField txtLocalTrabalhoMae;
    private javax.swing.JTextField txtNomeEscola;
    private javax.swing.JTextField txtNomeMae;
    private javax.swing.JTextField txtNomePai;
    private javax.swing.JTextField txtRgMae;
    private javax.swing.JTextField txtRgPai;
    private javax.swing.JFormattedTextField txtTelefoneEscola;
    private javax.swing.JFormattedTextField txtTelefoneMae;
    private javax.swing.JFormattedTextField txtTelefonePai;
    // End of variables declaration//GEN-END:variables

    private void configuraTabelaProgramaSocial() {

        tblProgramasSociais.setModel(
                new javax.swing.table.DefaultTableModel(
                        new Object[][]{},
                        new String[]{"Cod.", "Nome"}
                ) {
                });
        tblProgramasSociais.getColumnModel().getColumn(0).setPreferredWidth(5);

    }

    private boolean ComparaDadosLista(String nomePrograma) {

        Iterator<ProgramaSocial> ProgSocialAsIterator = ListaProgramaSocial.iterator();

        while (ProgSocialAsIterator.hasNext()) {
            ProgramaSocial progSocial = ProgSocialAsIterator.next();

            if (progSocial.getNome().equals(nomePrograma)) {
                return true;
            }
        }
        return false;
    }
}
