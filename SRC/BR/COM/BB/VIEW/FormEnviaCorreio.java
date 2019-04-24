/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela F8369196 - Rafael Shimabukro Borba F8772071 -
 * Roney Pereira da Costa
 *
 */
package br.com.bb.view;

import br.com.bb.conexao.InterfacePool;
import br.com.bb.conexao.Pool;
import br.com.bb.model.Notificado;
import br.com.bb.model.Usuario;
import br.com.bb.model.command.InterfaceCommand;
import br.com.bb.model.command.ListarProcuradorias;
import br.com.bb.model.dao.ProcuradoriaDAO;
import br.com.bb.sisbb.Atualizador;
import br.com.bb.sisbb.Sisbb;
import br.com.bb.strategy.Robo;
import br.com.bb.strategy.RoboCorreio;
import br.com.bb.strategy.RoboCorreioEdital;
import br.com.bb.strategy.RoboEnderecoADM;
import br.com.bb.suporte.ArrumaTabela;
import br.com.bb.suporte.Atraso;
import br.com.bb.suporte.tabelas.TabelaNotificadoModel;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Equipe Flash Monitoria
 * @date 17/06/2014
 */
public class FormEnviaCorreio extends javax.swing.JFrame {

    TabelaNotificadoModel tabelaNotificado;
    Sisbb sis2 = new Sisbb();
    Thread thread2;

    /**
     * Creates new form FormPesa
     */
    public FormEnviaCorreio() {
        
        sis2.start("B");
        sis2.waitFor("SISBB");

        initComponents();
        Atualizador at2 = new Atualizador(sis2, jTextArea2);
        at2.atualiza();
        Usuario.setChave("F2872117");
        Usuario.setSenha("12541254");

    }

   private TabelaNotificadoModel getTableModel() {
        if (tabelaNotificado == null) {
            InterfacePool pool = new Pool();
            InterfaceCommand comando = new ListarProcuradorias(new ProcuradoriaDAO(pool));
            Collection<Notificado> listaNotificado = new ArrayList<Notificado>();
            Notificado n1 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", true);
            Notificado n2 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", false);
            Notificado n3 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", true);
            Notificado n4 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", true);
            Notificado n5 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", false);
            Notificado n6 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", false);
            listaNotificado.add(n1);
            listaNotificado.add(n2);
            listaNotificado.add(n3);
            listaNotificado.add(n4);
            listaNotificado.add(n5);
            listaNotificado.add(n6);
            tabelaNotificado = new TabelaNotificadoModel(new ArrayList<>(listaNotificado));
            
            
        } else {
            jTable1.repaint();
            InterfacePool pool = new Pool();
//            InterfaceCommand comando = new ListarProcuradorias(new ProcuradoriaDAO(pool));
//            Collection<Procuradoria> listaProcuradorias = comando.executeColection();
//            tabelaNotificado = new TabelaProcuradoriaModel(new ArrayList<>(listaProcuradorias));
            Collection<Notificado> listaNotificado = new ArrayList<Notificado>();
            Notificado n1 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", true);
            Notificado n2 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", false);
            Notificado n3 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", true);
            Notificado n4 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", true);
            Notificado n5 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", false);
            Notificado n6 = new Notificado("FERNANDO RIBAS TAQUES", "I", "00015911764920", "MUTUÁRIO PRINCIPAL", false);
            listaNotificado.add(n1);
            listaNotificado.add(n2);
            listaNotificado.add(n3);
            listaNotificado.add(n4);
            listaNotificado.add(n5);
            listaNotificado.add(n6);
            tabelaNotificado = new TabelaNotificadoModel(new ArrayList<>(listaNotificado));
            
            this.repaint();
        }

        return tabelaNotificado;
    }
   
   
   private ArrayList<Notificado> carregaJtableNotificados(JTable jTable){
       this.jTable1 = jTable;
       
       
       ArrayList<Notificado> listaNotificados = new ArrayList<>();       
       
       for (int i = 0; i < jTable.getRowCount(); i++) {
            if (jTable.getValueAt(i, 0) != null && jTable.getValueAt(i, 1) != null && jTable.getValueAt(i, 0) != null) {

                Notificado notificado = new Notificado(jTable.getValueAt(i, 0).toString().trim(),
                        jTable.getValueAt(i, 1).toString().trim(),
                jTable.getValueAt(i, 2).toString().trim(),
                jTable.getValueAt(i, 3).toString().trim(),
                (boolean)jTable.getValueAt(i, 4));
                listaNotificados.add(notificado);
//                }
            }
        }
        for (Notificado notificado : listaNotificados) {
            System.out.println(">"+notificado.getNotificado() + " - "+notificado.isNotificar() );
       }
        
        return listaNotificados;
       
       
       
   }

    private void limpacampos(javax.swing.JPanel jPanel) {
        java.awt.Component[] components = panelSisbb.getComponents();
        javax.swing.JTextField textField = null;

        for (int i = 0; i < components.length; i++) {

            if (components[i] instanceof javax.swing.JTextField) {
                textField = (javax.swing.JTextField) components[i];
                textField.setText("");
            }
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
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextEndereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboUF = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jTextCEP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextCidade = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFAX = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextTelefone = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextProcuradoria = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextCargo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextProcurador = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextSigla = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        panelSisbb1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        btnLimpaCampos = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jdataModificacao = new javax.swing.JLabel();
        File arquivo = new File("M:\\PUBLICA\\BaseRiscoUniao\\NOTIFICAÇÃO-RISCO\\bbm.txt");
        DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatData.format(new Date(arquivo.lastModified()));
        jdataModificacao.setText(data);
        jLabel22 = new javax.swing.JLabel();
        jPanelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setTitle("ENVIA CORREIO");
        setIconImage(new ImageIcon("C:\\Program Files (x86)\\SisBB\\SisBB.gif").getImage());
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bb/imagens/FaixaBB-2.jpg"))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N

        panelSisbb.setBorder(javax.swing.BorderFactory.createTitledBorder("Procuradoria"));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Alterar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Endereço :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("UF :");

        jComboUF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "RJ", "RN", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("CEP :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Cidade :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("FAX :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Telefone :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("E-mail :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Procuradoria :");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Cargo :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Procurador :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Sigla :");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Excluir");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Novo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Limpar Campos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSisbbLayout = new javax.swing.GroupLayout(panelSisbb);
        panelSisbb.setLayout(panelSisbbLayout);
        panelSisbbLayout.setHorizontalGroup(
            panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSisbbLayout.createSequentialGroup()
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addGroup(panelSisbbLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jTextProcuradoria, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addGroup(panelSisbbLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(42, 42, 42)
                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelSisbbLayout.createSequentialGroup()
                                .addComponent(jTextSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextEndereco)
                            .addGroup(panelSisbbLayout.createSequentialGroup()
                                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextCEP, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(jTextFAX))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jComboUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel16)
                    .addGroup(panelSisbbLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(65, 65, 65)
                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextProcurador, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSisbbLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        panelSisbbLayout.setVerticalGroup(
            panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSisbbLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextProcuradoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jComboUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextProcurador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(101, 101, 101))
        );

        panelSisbb1.setBorder(javax.swing.BorderFactory.createTitledBorder("SISBB"));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setForeground(new java.awt.Color(0, 255, 0));

        jTextArea2.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea2.setColumns(81);
        jTextArea2.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(0, 255, 51));
        jTextArea2.setRows(24);
        jTextArea2.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea2);

        jButton6.setText("F3");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("F5");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("F7");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("F8");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("ENTER");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton18.setText("Cancelar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton11.setText("CAPTURAR");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("F12");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        btnLimpaCampos.setText("Limpar Tabela");
        btnLimpaCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaCamposActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("<html> <a href=''>Pasta Documentos</a> </html>");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Data de Atualização da Base:");

        jdataModificacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setText("<html> <a href=''>Tutorial da Aplicação:</a> </html>");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSisbb1Layout = new javax.swing.GroupLayout(panelSisbb1);
        panelSisbb1.setLayout(panelSisbb1Layout);
        panelSisbb1Layout.setHorizontalGroup(
            panelSisbb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSisbb1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(panelSisbb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSisbb1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7))
                    .addGroup(panelSisbb1Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9))
                    .addGroup(panelSisbb1Layout.createSequentialGroup()
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton18))
                    .addComponent(btnLimpaCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSisbb1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelSisbb1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSisbb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(panelSisbb1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdataModificacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(720, 720, 720))
        );

        panelSisbb1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLimpaCampos, jButton11});

        panelSisbb1Layout.setVerticalGroup(
            panelSisbb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSisbb1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSisbb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSisbb1Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelSisbb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSisbb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSisbb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12)
                            .addComponent(jButton18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpaCampos)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdataModificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(getTableModel());
        ArrumaTabela.dimensionaTabela(jTable1);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelTabelaLayout = new javax.swing.GroupLayout(jPanelTabela);
        jPanelTabela.setLayout(jPanelTabelaLayout);
        jPanelTabelaLayout.setHorizontalGroup(
            jPanelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanelTabelaLayout.setVerticalGroup(
            jPanelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelSisbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelSisbb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSisbb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSisbb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CONFIGURAÇÃO PROCURADORIA", jPanel1);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bb/imagens/FaixaRodape3.jpg"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(971, 39));
        jLabel3.setMinimumSize(new java.awt.Dimension(971, 39));
        jLabel3.setPreferredSize(new java.awt.Dimension(971, 39));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1694, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int opcao = JOptionPane.showConfirmDialog(this,
                "Deseja salvar as alterações desse cadastro?",
                "Alteração de cadastro", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_NO_OPTION) {

        }

//        Procuradoria proc = (Procuradoria) tabelaProcuradoria.getLinha(jTable1.getSelectedRow());
//
//        proc.setProcuradoria(jTextProcuradoria.getText());
//        proc.setSigla(jTextSigla.getText());
//        proc.setEndereco(jTextEndereco.getText());
//        proc.setCidade(jTextCidade.getText());
//        proc.setFax(jTextFAX.getText());
//        proc.setTelefone(jTextTelefone.getText());
//        proc.setCep(jTextCEP.getText());
//        proc.setEmail(jTextEmail.getText());
//        proc.setProcurador(jTextProcurador.getText());
//        proc.setCargo(jTextCargo.getText());
//        proc.setUf(jComboUF.getSelectedItem().toString());
//
//        InterfacePool pool = new Pool();
//        InterfaceCommand comando = new AtualizarProcuradoria(new ProcuradoriaDAO(pool));
//
//        JOptionPane.showMessageDialog(null, comando.execute(proc));
        jButton3.setEnabled(false);
        jButton1.setEnabled(false);
        jTable1.clearSelection();
        limpacampos(jPanel1);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir registro?",
                "Exclusao Cadastro", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
//            Procuradoria proc = (Procuradoria) tabelaProcuradoria.getLinha(jTable1.getSelectedRow());

//            InterfacePool pool = new Pool();
//            InterfaceCommand comando = new ExcluirProcuradoria(new ProcuradoriaDAO(pool));
//            JOptionPane.showMessageDialog(null, comando.execute(proc.getProcuradoria()));
//            tabelaProcuradoria.deleteRow(jTable1.getSelectedRow());
            jButton3.setEnabled(false);
            jButton1.setEnabled(false);
            ArrumaTabela.dimensionaTabela(jTable1);
            limpacampos(jPanel1);

        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        
        
        class executa implements Runnable {

            @Override
            public void run() {

                Robo robo = new RoboCorreio(sis2);
                robo.connect("B", sis2);
                Atraso.setAtraso(1);
                
                ArrayList<Notificado> listaNotificados = carregaJtableNotificados(jTable1);

//                Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
//                this.setCursor(cursor);
//
//                try {
//                    mostrarFormContrato();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    cursor = Cursor.getDefaultCursor();
//                    this.setCursor(cursor);
//                }

//                robo.performaceEntrar();
//                robo.performaceCapturar(listaDados);

                System.out.println("Final de processamento!");
                JOptionPane.showMessageDialog(null, "Processo finalizado !");

            }
        }

        thread2 = new Thread(new executa());
        thread2.start();
        
        
        ArrumaTabela.dimensionaTabela(jTable1);
        limpacampos(jPanel1);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        limpacampos(jPanel1);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        sis2.f3();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        sis2.f5();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        sis2.f7();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        sis2.f8();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        sis2.enter();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        thread2.stop();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        class executa implements Runnable {

            @Override
            public void run() {

                Robo robo = new RoboCorreioEdital(sis2);
                robo.connect("B", sis2);
                robo.performaceEntrar();
                robo.performaceCapturar();
                
                Atraso.setAtraso(1);

                
            
                System.out.println("Final de processamento!");
                JOptionPane.showMessageDialog(null, "Processo finalizado !");

            }
        }

        thread2 = new Thread(new executa());
        thread2.start();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        sis2.f12();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void btnLimpaCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaCamposActionPerformed

      
    }//GEN-LAST:event_btnLimpaCamposActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked

//        if (new File("G:\\INTERNA\\RISCO UNIAO\\EQUIPES DE PRODUÇAO\\RISCO10\\CAPTURARISCO\\" + System.getProperty("user.name")).exists()) {
//            try {
//                Runtime.getRuntime().exec("explorer.exe " + "G:\\INTERNA\\RISCO UNIAO\\EQUIPES DE PRODUÇAO\\RISCO10\\CAPTURARISCO\\" + System.getProperty("user.name"));
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            } else {
//                PreparaDeskTop.preparaPastasDesktop();
//                try {
//                    Runtime.getRuntime().exec("explorer.exe " + "G:\\INTERNA\\RISCO UNIAO\\EQUIPES DE PRODUÇAO\\RISCO10\\CAPTURARISCO\\" + System.getProperty("user.name"));
//
//                    } catch (IOException e1) {
//                        e1.printStackTrace();
//                    }
//                }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked

        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe", "\\\\172.18.246.87\\c$\\UTIL\\TutorialRobos\\FlashCorreioIDACripto\\TutorialFlashCorreioIDa.avi");
        try {
            Process start = pb.start();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Verifique se o VLC media player está instalado na sua máquina.");
            Logger.getLogger(FormContrFrameLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel22MouseClicked

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
            java.util.logging.Logger.getLogger(FormEnviaCorreio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEnviaCorreio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEnviaCorreio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEnviaCorreio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEnviaCorreio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpaCampos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTabela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextCEP;
    private javax.swing.JTextField jTextCargo;
    private javax.swing.JTextField jTextCidade;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextEndereco;
    private javax.swing.JTextField jTextFAX;
    private javax.swing.JTextField jTextProcurador;
    private javax.swing.JTextField jTextProcuradoria;
    private javax.swing.JTextField jTextSigla;
    private javax.swing.JTextField jTextTelefone;
    private javax.swing.JLabel jdataModificacao;
    private javax.swing.JPanel panelSisbb;
    private javax.swing.JPanel panelSisbb1;
    // End of variables declaration//GEN-END:variables
}
