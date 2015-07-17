/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.apresentacao;

import br.com.servirjanuaria.amauri.dataAccess.AlunoDAO;
import br.com.servirjanuaria.amauri.dataAccess.MatriculaDAO;
import br.com.servirjanuaria.amauri.dataAccess.PessoaDAO;
import br.com.servirjanuaria.amauri.domainModel.Aluno;
import br.com.servirjanuaria.amauri.domainModel.Matricula;
import br.com.servirjanuaria.amauri.domainModel.Pessoa;
import br.com.servirjanuaria.amauri.domainModel.repositorios.MatriculaRepositorio;
import br.com.servirjanuaria.amauri.domainModel.repositorios.PessoaRepositorio;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Amauri
 */
public class ResultadoBuscaAlunoJInternalFrame extends javax.swing.JInternalFrame {

    private static JDesktopPane painelPrincipal = null;
    static PessoaRepositorio alunos = new PessoaDAO();
    //Pessoa aluno = new Pessoa();

    /**
     * Creates new form CadastroAlunoJInternalFrame
     *
     * @param painelPrincipal
     */
    public ResultadoBuscaAlunoJInternalFrame(JDesktopPane painelPrincipal) {
        initComponents();
        ResultadoBuscaAlunoJInternalFrame.painelPrincipal = painelPrincipal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //metodo para buscar aluno
    public void BuscarAluno() {

        //variáveis que ira reeceber o texto do campo txtBuscaAluno;
        String nome = txtBuscaAluno.getText();

        Pessoa pessoaAluno = new Aluno();
        pessoaAluno.setNome(nome);

        try {

            // if (alunos.buscarWhereDtype(nome, "Aluno") != null) {
            if (alunos.buscar(pessoaAluno) != null) {
                for (Pessoa alunoAux : alunos.buscar(pessoaAluno)) {

                    Aluno alunoBuscado = (Aluno) alunoAux;

                    txtNome.setText(alunoBuscado.getNome());
                    cmbSexo.setSelectedItem(alunoBuscado.getSexo());

                    String dataNascimento = formataData(alunoBuscado.getDataNascimento().toString());
                    txtDataNascimetno.setText(dataNascimento);
                    //txtEndereco.setText(alunoBuscado.getEndereco().getEnderecoCompleto());
                    txtCidade.setText(alunoBuscado.getEndereco().getCidade());
                    txtEstado.setText(alunoBuscado.getEstado());
                    String idAluno = String.valueOf(alunoBuscado.getId());
                    txtCodigo.setText(idAluno);

                    System.err.println(alunoBuscado.getPai());
                    // PaiRepositorio pais = new PaiDAO();
                    // for (Pai pai : pais.buscarPorCodigo(alunoBuscado.getPai().getId())) {
                    //   txtNomePai.setText(pai.getNome());
                    // PaiRepositorio pais = new PaiDAO();
                    //  }

                    /* MaeRepositorio maes = new MaeDAO();
                     for (Mae mae : maes.buscarPorCodigo(alunoBuscado.getId())) {
                     txtNomePai.setText(pai.getNome());

                     }*/
                    //txtNomeMae.setText(alunoBuscado.getMae().getNome());
                    MatriculaRepositorio matriculas = new MatriculaDAO();
                    for (Matricula matricula : matriculas.buscarPorAluno(alunoBuscado.getId())) {

                        txtDataMatricula.setText(formataData(matricula.getDataMatricula().toString()));
                        txtNomeEscola.setText(matricula.getUnidadeEscolar().getNome());
                    }

                    System.out.println(alunoAux.getId() + " - " + alunoAux.getNome() + " - " + alunoAux.getCpf() + " - " + alunoAux.getDataNascimento());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.err.println("Buscar aluno: " + e);
            JOptionPane.showMessageDialog(null, "Buscar aluno: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static Date formatData(String dataString) throws Exception {
        if (dataString == null || dataString.equals("")) {
            return null;
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(dateFormat.parse(dataString).getTime());

        return data;
    }

    public static String formataData(String dataString) throws Exception {
        String ano = (dataString.substring(0, 4));
        String mes = (dataString.substring(5, 7));
        String dia = (dataString.substring(8, 10));

        String DataCompleta = (dia + "/" + mes + "/" + ano);
        return DataCompleta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnGeral = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBuscaAluno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jpnResultadoBusca = new javax.swing.JPanel();
        jpnDadosAluno = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblDataMatricula = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDataMatricula = new javax.swing.JTextField();
        lblDataNascimento = new javax.swing.JLabel();
        txtDataNascimetno = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        cmbSexo = new javax.swing.JComboBox();
        txtNome = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblEscola = new javax.swing.JLabel();
        txtNomeEscola = new javax.swing.JTextField();
        lblNomePai = new javax.swing.JLabel();
        txtNomePai = new javax.swing.JTextField();
        lblNomeMae = new javax.swing.JLabel();
        txtNomeMae = new javax.swing.JTextField();
        jpnFoto = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        btnAtivar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();
        btnNovaMatricula = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tela de Busca: Aluno");
        setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Aluno"));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel12.setText("Nome do Aluno:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnResultadoBusca.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado da busca"));

        jpnDadosAluno.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Aluno"));

        lblNome.setText("Nome:");

        lblCodigo.setText("Código:");

        lblSexo.setText("Sexo:");

        lblDataMatricula.setText("Data de Matricula:");

        txtDataMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataMatriculaActionPerformed(evt);
            }
        });

        lblDataNascimento.setText("Data de Nascimento:");

        lblCidade.setText("Cidade:");

        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino ", "Feminino" }));

        lblEstado.setText("Estado");

        lblEndereco.setText("Endereço:");

        lblEscola.setText("Escola:");

        lblNomePai.setText("Nome do Pai:");

        lblNomeMae.setText("Nome da Mãe:");

        javax.swing.GroupLayout jpnDadosAlunoLayout = new javax.swing.GroupLayout(jpnDadosAluno);
        jpnDadosAluno.setLayout(jpnDadosAlunoLayout);
        jpnDadosAlunoLayout.setHorizontalGroup(
            jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                        .addComponent(lblNomeMae)
                        .addGap(168, 168, 168))
                    .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                        .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNomeMae, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomePai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(lblNomePai, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                        .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDataNascimetno)
                                    .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                                        .addComponent(lblDataNascimento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))
                                .addGap(24, 24, 24)
                                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCodigo)))
                            .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSexo)
                                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDataMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDataMatricula))
                                .addGap(18, 18, 18)
                                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                                        .addComponent(lblEndereco)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtEndereco)))
                            .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCidade)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstado)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                                        .addComponent(lblEscola)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtNomeEscola))))
                        .addContainerGap())))
        );
        jpnDadosAlunoLayout.setVerticalGroup(
            jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblCodigo)
                    .addComponent(lblDataNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNascimetno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                        .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataMatricula)
                            .addComponent(lblSexo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                        .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCidade)
                            .addComponent(lblEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnDadosAlunoLayout.createSequentialGroup()
                        .addComponent(lblEscola)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNomePai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblNomeMae)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnFoto.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto"));

        javax.swing.GroupLayout jpnFotoLayout = new javax.swing.GroupLayout(jpnFoto);
        jpnFoto.setLayout(jpnFotoLayout);
        jpnFotoLayout.setHorizontalGroup(
            jpnFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );
        jpnFotoLayout.setVerticalGroup(
            jpnFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnAtivar.setText("Ativar");

        btnInativar.setText("Inativar");

        javax.swing.GroupLayout jpnResultadoBuscaLayout = new javax.swing.GroupLayout(jpnResultadoBusca);
        jpnResultadoBusca.setLayout(jpnResultadoBuscaLayout);
        jpnResultadoBuscaLayout.setHorizontalGroup(
            jpnResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnResultadoBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnResultadoBuscaLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnAtivar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInativar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVisualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar))
                    .addComponent(jpnDadosAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpnResultadoBuscaLayout.setVerticalGroup(
            jpnResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnResultadoBuscaLayout.createSequentialGroup()
                .addGroup(jpnResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnDadosAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnVisualizar)
                    .addComponent(btnInativar)
                    .addComponent(btnAtivar))
                .addContainerGap())
        );

        btnNovaMatricula.setText("Nova Matrícula");
        btnNovaMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaMatriculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnGeralLayout = new javax.swing.GroupLayout(jpnGeral);
        jpnGeral.setLayout(jpnGeralLayout);
        jpnGeralLayout.setHorizontalGroup(
            jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnResultadoBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnGeralLayout.createSequentialGroup()
                        .addComponent(btnNovaMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnGeralLayout.setVerticalGroup(
            jpnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGeralLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnNovaMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jpnResultadoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtDataMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataMatriculaActionPerformed

    private void btnNovaMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaMatriculaActionPerformed

        GestaoAlunoTela1JInternalFrame gestaoAlunoTela1JInternalFrame = new GestaoAlunoTela1JInternalFrame(painelPrincipal);
        gestaoAlunoTela1JInternalFrame.setVisible(true);
        painelPrincipal.add(gestaoAlunoTela1JInternalFrame);
        gestaoAlunoTela1JInternalFrame.toFront();

    }//GEN-LAST:event_btnNovaMatriculaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        BuscarAluno();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        GestaoAlunoTela1JInternalFrame gestaoAlunoTela1JInternalFrame = new GestaoAlunoTela1JInternalFrame(painelPrincipal);
        gestaoAlunoTela1JInternalFrame.setVisible(true);
        painelPrincipal.add(gestaoAlunoTela1JInternalFrame);
        gestaoAlunoTela1JInternalFrame.toFront();
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        GestaoAlunoTela1JInternalFrame gestaoAlunoTela1JInternalFrame = new GestaoAlunoTela1JInternalFrame(painelPrincipal);
        gestaoAlunoTela1JInternalFrame.setVisible(true);
        painelPrincipal.add(gestaoAlunoTela1JInternalFrame);
        gestaoAlunoTela1JInternalFrame.toFront();
    }//GEN-LAST:event_btnAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtivar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInativar;
    private javax.swing.JButton btnNovaMatricula;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox cmbSexo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpnDadosAluno;
    private javax.swing.JPanel jpnFoto;
    private javax.swing.JPanel jpnGeral;
    private javax.swing.JPanel jpnResultadoBusca;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDataMatricula;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEscola;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeMae;
    private javax.swing.JLabel lblNomePai;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JTextField txtBuscaAluno;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDataMatricula;
    private javax.swing.JTextField txtDataNascimetno;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeEscola;
    private javax.swing.JTextField txtNomeMae;
    private javax.swing.JTextField txtNomePai;
    // End of variables declaration//GEN-END:variables

}
