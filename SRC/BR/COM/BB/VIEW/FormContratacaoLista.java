/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela 
 *
 */
package br.com.bb.view;

import br.com.bb.conexao.InterfacePool;
import br.com.bb.conexao.Pool;
import br.com.bb.model.Dados;
import br.com.bb.model.Procuradoria;
import br.com.bb.model.Usuario;
import br.com.bb.model.command.InterfaceCommand;
import br.com.bb.model.command.ListarProcuradorias;
import br.com.bb.model.dao.ProcuradoriaDAO;
import br.com.bb.sisbb.Atualizador;
import br.com.bb.sisbb.Sisbb;
import br.com.bb.strategy.Robo;
import br.com.bb.strategy.RoboCorreio;
import br.com.bb.strategy.RoboEndereco;
import br.com.bb.suporte.Atraso;
import br.com.bb.suporte.ExcelAdapter;
import br.com.bb.suporte.PreparaDeskTop;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Equipe Flash Monitoria
 * @date 17/06/2014
 */
public class FormContratacaoLista extends javax.swing.JFrame {

    Sisbb sis2 = new Sisbb();
    Thread thread2;

    /**
     * Creates new form FormPesa
     */
    public FormContratacaoLista() {

        sis2.start("B");
        sis2.waitFor("SISBB");

        initComponents();
        Atualizador at2 = new Atualizador(sis2, jTextArea2);
        at2.atualiza();
        Atraso.setAtraso(500);
        ExcelAdapter myad = new ExcelAdapter(jTable1);

        jTextACCorreio.setVisible(false);
        jTextAgenciaCorreio.setVisible(false);
        jTextGerenteArea.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jTable1.getTableHeader().setFont(new Font("Arial Black", Font.ITALIC, 12));
    }

    public void limpaTabela() {

        int linhas = 0;
        int colunas = 0;
        String zer = null;

        for (linhas = 0; linhas <= jTable1.getRowCount() - 1; linhas++) {
            for (colunas = 0; colunas <= jTable1.getColumnCount() - 1; colunas++) {
                jTable1.setValueAt(zer, linhas, colunas);
            }
        }
    }

    public void limpaCampos(JTable jTable) {
        this.jTable1.clearSelection();

    }

    public ArrayList<Dados> carregaListaDados(JTable jTable) {
        this.jTable1 = jTable;

        ArrayList<Dados> listDados = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (jTable.getValueAt(i, 0) != null && jTable.getValueAt(i, 1) != null && jTable.getValueAt(i, 0) != null) {
//                if (jTable.getValueAt(i, 1).toString().length() < 9) {
//                    JOptionPane.showMessageDialog(rootPane, "Informe corretamente o nº da operação com o dígito verificador Ex.: XXXXXXX-X");
//                    System.exit(0);
//                } else {
                Dados dados = new Dados();
                dados.setAgencia(jTable.getValueAt(i, 0).toString().trim());
                dados.setContrato(jTable.getValueAt(i, 1).toString().trim());
                dados.setGsv(jTable.getValueAt(i, 2).toString().trim());

                listDados.add(dados);
//                }
            }
        }
        return listDados;
    }
    
    public String carregaListaGSVS(JTable jTable) {
        this.jTable1 = jTable;

        String listaGSV = "2016/";
        for (int i = 0; i < 100; i++) {
            if (jTable.getValueAt(i, 0) != null && jTable.getValueAt(i, 1) != null && jTable.getValueAt(i, 0) != null) {
                listaGSV = listaGSV + jTable.getValueAt(i, 2).toString().trim()+"- 2016/";
            }
        }
        return listaGSV;
    }
    
    

    private void carregaCombo() {
        //assim como é feito numa JTable, temos o DefaultComboBoxModel que é o model do JComboBox
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) jComboProcuradoria.getModel();
        //removendo todos os elementos do combo
        comboModel.removeAllElements();
        //cria a lista: java.util.List
        InterfacePool pool = new Pool();
        InterfaceCommand comando = new ListarProcuradorias(new ProcuradoriaDAO(pool));

        try {
            Collection<Procuradoria> listaProcuradoria = comando.executeColection();

            for (Procuradoria procuradoria : listaProcuradoria) {
                comboModel.addElement(procuradoria.getCidade() + " - " + procuradoria.getUf());
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        panelSisbb = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnLimpaCampos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel4 = new javax.swing.JLabel();
        jdataModificacao = new javax.swing.JLabel();
        File arquivo = new File("M:\\PUBLICA\\BaseRiscoUniao\\NOTIFICAÇÃO-RISCO\\bbm.txt");
        DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatData.format(new Date(arquivo.lastModified()));
        jdataModificacao.setText(data);
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painelManual = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboProcuradoria = new javax.swing.JComboBox();
        carregaCombo();
        jCheckCorreio = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextAgenciaCorreio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextACCorreio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextGerenteArea = new javax.swing.JTextField();
        jCheckTermo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        setTitle("CAPTURA DE INFORMAÇÕES DE CONTRATO");
        setIconImage(new ImageIcon("C:\\Program Files (x86)\\SisBB\\SisBB.gif").getImage());
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bb/imagens/FaixaBB-2.jpg"))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N

        panelSisbb.setBorder(javax.swing.BorderFactory.createTitledBorder("SISBB"));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setForeground(new java.awt.Color(0, 255, 0));

        jTextArea2.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea2.setColumns(81);
        jTextArea2.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(0, 255, 51));
        jTextArea2.setRows(24);
        jTextArea2.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea2);

        jButton2.setText("F3");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setText("F5");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setText("F7");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("F8");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("ENTER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton18.setText("Cancelar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("CAPTURAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton8.setText("F12");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnLimpaCampos.setText("Limpar Tabela");
        btnLimpaCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaCamposActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("<html> <a href=''>Pasta Documentos</a> </html>");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Data de Atualização da Base:");

        jdataModificacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("<html> <a href=''>Tutorial da Aplicação:</a> </html>");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSisbbLayout = new javax.swing.GroupLayout(panelSisbb);
        panelSisbb.setLayout(panelSisbbLayout);
        panelSisbbLayout.setHorizontalGroup(
            panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSisbbLayout.createSequentialGroup()
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSisbbLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSisbbLayout.createSequentialGroup()
                                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSisbbLayout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6))
                                    .addGroup(panelSisbbLayout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4))
                                    .addComponent(jButton8))
                                .addGap(17, 17, 17))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelSisbbLayout.createSequentialGroup()
                                    .addComponent(jButton5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton18))
                                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(btnLimpaCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(10, 10, 10))
                    .addGroup(panelSisbbLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdataModificacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        panelSisbbLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButton6, jButton8});

        panelSisbbLayout.setVerticalGroup(
            panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSisbbLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSisbbLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelSisbbLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton18))
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpaCampos)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdataModificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        painelManual.setBorder(javax.swing.BorderFactory.createTitledBorder("Insira a(s) agências e a(s) operação(ções). (Limite 100 registros)"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cidade Procuradoria:");

        jComboProcuradoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckCorreio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (jCheckCorreio.isSelected()) {
                    jTextACCorreio.setVisible(true);
                    jTextAgenciaCorreio.setVisible(true);
                    jTextGerenteArea.setVisible(true);
                    jLabel7.setVisible(true);
                    jLabel8.setVisible(true);
                    jLabel9.setVisible(true);

                }else{
                    jTextACCorreio.setVisible(false);
                    jTextAgenciaCorreio.setVisible(false);
                    jTextGerenteArea.setVisible(false);
                    jLabel7.setVisible(false);
                    jLabel8.setVisible(false);
                    jLabel9.setVisible(false);
                }
            }
        });
        jCheckCorreio.setText("Gerar Correio SISBB");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Agência", "Contrato", "GSV"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Agencia para Correio :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("A/C para Correio :");

        jTextACCorreio.setText("Admin/Plane");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Gerente de Área :");

        jTextGerenteArea.setText("Lídia Maria Evangelista");

        jCheckCorreio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (jCheckCorreio.isSelected()) {
                    jTextACCorreio.setVisible(true);
                    jTextAgenciaCorreio.setVisible(true);
                    jTextGerenteArea.setVisible(true);
                    jLabel7.setVisible(true);
                    jLabel8.setVisible(true);
                    jLabel9.setVisible(true);

                }else{
                    jTextACCorreio.setVisible(false);
                    jTextAgenciaCorreio.setVisible(false);
                    jTextGerenteArea.setVisible(false);
                    jLabel7.setVisible(false);
                    jLabel8.setVisible(false);
                    jLabel9.setVisible(false);
                }
            }
        });
        jCheckTermo.setText("Gerar Termo Confidencialidade");

        javax.swing.GroupLayout painelManualLayout = new javax.swing.GroupLayout(painelManual);
        painelManual.setLayout(painelManualLayout);
        painelManualLayout.setHorizontalGroup(
            painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelManualLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jComboProcuradoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelManualLayout.createSequentialGroup()
                                .addGroup(painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextACCorreio)
                                    .addComponent(jTextGerenteArea, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                            .addGroup(painelManualLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextAgenciaCorreio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelManualLayout.createSequentialGroup()
                        .addComponent(jCheckCorreio)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckTermo)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelManualLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        painelManualLayout.setVerticalGroup(
            painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelManualLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboProcuradoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckCorreio)
                    .addComponent(jCheckTermo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextAgenciaCorreio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextACCorreio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextGerenteArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
            .addGroup(painelManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelManualLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(210, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelSisbb, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSisbb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelManual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CAPTURA CONTRATO", jPanel1);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bb/imagens/FaixaRodape3.jpg"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(971, 39));
        jLabel3.setMinimumSize(new java.awt.Dimension(971, 39));
        jLabel3.setPreferredSize(new java.awt.Dimension(971, 39));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        if (new File("G:\\INTERNA\\RISCO UNIAO\\EQUIPES DE PRODUÇAO\\RISCO10\\CAPTURARISCO\\" + System.getProperty("user.name")).exists()) {
            try {
                Runtime.getRuntime().exec("explorer.exe " + "G:\\INTERNA\\RISCO UNIAO\\EQUIPES DE PRODUÇAO\\RISCO10\\CAPTURARISCO\\" + System.getProperty("user.name"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            PreparaDeskTop.preparaPastasDesktop();
            try {
                Runtime.getRuntime().exec("explorer.exe " + "G:\\INTERNA\\RISCO UNIAO\\EQUIPES DE PRODUÇAO\\RISCO10\\CAPTURARISCO\\" + System.getProperty("user.name"));
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnLimpaCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaCamposActionPerformed

        limpaTabela();

    }//GEN-LAST:event_btnLimpaCamposActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        sis2.f12();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        class executa implements Runnable {

            @Override
            public void run() {

                //                Robo robo = new RoboFolhaRosto();
                Robo robo = new RoboEndereco();
                robo.connect("B", sis2);
//                robo.connectSemCic("B", sis2);
                Atraso.setAtraso(1);

                ArrayList<Dados> listaDados = carregaListaDados(jTable1);
                String listaGSVs = carregaListaGSVS(jTable1);
                
                
                robo.performaceEntrar();
                for (Dados dados : listaDados) {
                    robo.performaceCapturar(String.format("%04d", Integer.valueOf(dados.getAgencia())),
                            String.format("%09d", Integer.valueOf(dados.getContrato())),
                            jComboProcuradoria.getSelectedItem().toString().substring(0, jComboProcuradoria.getSelectedItem().toString().indexOf("-") - 1),
                            dados.getGsv(),
                            jCheckTermo.isSelected(),
                            listaGSVs);
                }
                sis2.waitSystem();
                sis2.f5();
                sis2.waitSystem();
                sis2.f5();
                sis2.waitSystem();
                sis2.f3();
                sis2.waitSystem();
                sis2.f5();
                sis2.waitSystem();
                sis2.f5();
                sis2.f5();

                if (jCheckCorreio.isSelected()) {
                    robo = new RoboCorreio(sis2);
                    robo.connect("B", sis2);
                    robo.performaceEntrar();
                    robo.performaceCapturar(jTextAgenciaCorreio.getText(), jComboProcuradoria.getSelectedItem().toString().substring(0, jComboProcuradoria.getSelectedItem().toString().indexOf("-") - 1), jTextGerenteArea.getText(), jTextACCorreio.getText(), jTable1.getValueAt(0, 2).toString(), jTable1.getValueAt(0, 1).toString()); //meramente ilustrativo
                }

                sis2.waitSystem();
                sis2.f3();
                sis2.waitSystem();
                sis2.f5();
                sis2.waitSystem();
                sis2.f5();
                sis2.waitSystem();
                sis2.f5();
                sis2.waitSystem();
                sis2.f5();
                sis2.waitSystem();
                

                System.out.println("Final de processamento!");
                JOptionPane.showMessageDialog(null, "Processo finalizado !");

            }
        }

        thread2 = new Thread(new executa());
        thread2.start();

    }//GEN-LAST:event_jButton1ActionPerformed

    @Deprecated
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        thread2.stop();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        sis2.enter();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        sis2.f8();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        sis2.f7();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        sis2.f5();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        sis2.f3();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe", "\\\\172.18.246.87\\c$\\UTIL\\TutorialRobos\\FlashCorreioIDACripto\\TutorialFlashCorreioIDa.avi");
        try {
            Process start = pb.start();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Verifique se o VLC media player está instalado na sua máquina.");
            Logger.getLogger(FormContratacaoLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormContratacaoLista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormContratacaoLista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormContratacaoLista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormContratacaoLista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormContratacaoLista().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpaCampos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckCorreio;
    private javax.swing.JCheckBox jCheckTermo;
    private javax.swing.JComboBox jComboProcuradoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextACCorreio;
    private javax.swing.JTextField jTextAgenciaCorreio;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextGerenteArea;
    private javax.swing.JLabel jdataModificacao;
    private javax.swing.JPanel painelManual;
    private javax.swing.JPanel panelSisbb;
    // End of variables declaration//GEN-END:variables
}
