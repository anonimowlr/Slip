/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela F8369196 - Rafael Shimabukro Borba F8772071 -
 * Roney Pereira da Costa
 *
 */
package br.com.bb.view;

import br.com.bb.conexao.InterfacePoolBase;
import br.com.bb.conexao.PoolBase;
import br.com.bb.model.Envolvido2;
import br.com.bb.model.Notificado;
import br.com.bb.model.Papeleta2;
import br.com.bb.model.Usuario;
import br.com.bb.model.command.InterfaceCommand;
import br.com.bb.model.command.ListarGetEnvolvidoPapeleta;
import br.com.bb.model.command.ListarPapeletas2;
import br.com.bb.model.dao.Envolvido2DAO;
import br.com.bb.model.dao.Papeleta2DAO;
import br.com.bb.sisbb.Atualizador;
import br.com.bb.sisbb.Sisbb;
import br.com.bb.strategy.Robo;
import br.com.bb.strategy.RoboCorreioEdital;
import br.com.bb.suporte.ArrumaTabela;
import br.com.bb.suporte.Atraso;
import br.com.bb.suporte.tabelas.TabelaPapeletaModel;
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
public class FormEnviaCorreioPapeleta extends javax.swing.JFrame {

    TabelaPapeletaModel tabelaPapeleta;
    ArrayList<Papeleta2> listaPapeleta2;
    ArrayList<Papeleta2> listaTodosPapeleta;

    Sisbb sis2 = new Sisbb();
    Thread thread2;

    /**
     * Creates new form FormPesa
     */
    public FormEnviaCorreioPapeleta() {

        sis2.start("B");
        sis2.waitFor("SISBB");

        initComponents();
        Atualizador at2 = new Atualizador(sis2, jTextArea2);
        at2.atualiza();
        

    }

    private TabelaPapeletaModel getTableModel() {
        if (tabelaPapeleta == null) {
            jTable1.repaint();
            InterfacePoolBase pool = new PoolBase();
            InterfaceCommand comando = new ListarPapeletas2(new Papeleta2DAO(pool));
            Collection<Papeleta2> listaPapeleta = comando.executeColection();
            listaPapeleta2 = new ArrayList<>(listaPapeleta);
            tabelaPapeleta = new TabelaPapeletaModel(listaPapeleta2);
            listaTodosPapeleta = new ArrayList<>(listaPapeleta2);
            this.repaint();

        } else {

            InterfacePoolBase pool = new PoolBase();
            InterfaceCommand comando = new ListarPapeletas2(new Papeleta2DAO(pool));
            Collection<Papeleta2> listaNotificado = comando.executeColection();
            listaPapeleta2 = new ArrayList<>(listaNotificado);
            tabelaPapeleta = new TabelaPapeletaModel(listaPapeleta2);

            this.repaint();
        }

        return tabelaPapeleta;
    }

    private int limpaTabela(JTable jTable, TabelaPapeletaModel tabelaLimpar) {
        while (jTable.getRowCount() > 0) {
            for (int i = 0; i < jTable.getRowCount(); i++) {
                tabelaLimpar.deleteRow(i);
            }
        }
        return 1;

    }

    private ArrayList<Papeleta2> carregaJtablePapeleta2(JTable jTable) {
        this.jTable1 = jTable;
        InterfacePoolBase pool = new PoolBase();
        InterfaceCommand comando = new ListarGetEnvolvidoPapeleta(new Envolvido2DAO(pool));
        ArrayList<Envolvido2> listaEnvolvido;

        ArrayList<Papeleta2> listagetJtable = new ArrayList<>();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if ((boolean) jTable1.getValueAt(i, 8)) {
                Papeleta2 papeleta2 = tabelaPapeleta.getListaPapeleta().get(i);
                listaEnvolvido = new ArrayList<>(comando.executeColection(papeleta2.getPREFIXODEP(), papeleta2.getOPERACAO()));
                papeleta2.setListaEnvolvidos(listaEnvolvido);
                listagetJtable.add(papeleta2);
            }
        }
        return listagetJtable;

    }
    
    private void atualizaTabelas(){
        
        this.repaint();
    }
    

    private ArrayList<Notificado> carregaJtableNotificados(JTable jTable) {
        this.jTable1 = jTable;

        ArrayList<Notificado> listaNotificados = new ArrayList<>();

        for (int i = 0; i < jTable.getRowCount(); i++) {
            if (jTable.getValueAt(i, 0) != null && jTable.getValueAt(i, 1) != null && jTable.getValueAt(i, 0) != null) {

                Notificado notificado = new Notificado(jTable.getValueAt(i, 0).toString().trim(),
                        jTable.getValueAt(i, 1).toString().trim(),
                        jTable.getValueAt(i, 2).toString().trim(),
                        jTable.getValueAt(i, 3).toString().trim(),
                        (boolean) jTable.getValueAt(i, 4));
                listaNotificados.add(notificado);
            }
        }
        for (Notificado notificado : listaNotificados) {
            System.out.println(">" + notificado.getNotificado() + " - " + notificado.isNotificar());
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
        jLabel14 = new javax.swing.JLabel();
        jTextTPNotificacao = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jlTPOperacao = new javax.swing.JLabel();
        jTextMunicipio = new javax.swing.JTextField();
        jlTPOperacao1 = new javax.swing.JLabel();
        jTextPrefixDep = new javax.swing.JTextField();
        jlTPOperacao2 = new javax.swing.JLabel();
        jTextMatricula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jTextTituloCorreio = new javax.swing.JTextField();
        jlTPOperacao3 = new javax.swing.JLabel();
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
        jLabel21 = new javax.swing.JLabel();
        jdataModificacao = new javax.swing.JLabel();
        File arquivo = new File("M:\\PUBLICA\\ApoioRobos\\FlashBaseRisco\\bbm.txt");
        DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatData.format(new Date(arquivo.lastModified()));
        jdataModificacao.setText(data);
        jLabel22 = new javax.swing.JLabel();
        jPanelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setTitle("ENVIA CORREIO ");
        setIconImage(new ImageIcon("C:\\Program Files (x86)\\SisBB\\SisBB.gif").getImage());
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bb/imagens/FaixaBB-2.jpg"))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N

        panelSisbb.setBorder(javax.swing.BorderFactory.createTitledBorder("Procuradoria"));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("TIPO NOTIFICAÇÃO:");

        jTextTPNotificacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Limpar Filtros");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jlTPOperacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlTPOperacao.setText("MUNICÍPIO/UF:");

        jTextMunicipio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlTPOperacao1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlTPOperacao1.setText("PREFIXO DEP :");

        jTextPrefixDep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlTPOperacao2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlTPOperacao2.setText("MATRICULA :");

        jTextMatricula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Filtrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Filtrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton13.setText("Filtrar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jTextTituloCorreio.setText(" - EDITAL - DAU - C A F");

        jlTPOperacao3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlTPOperacao3.setText("Título Correio :");

        javax.swing.GroupLayout panelSisbbLayout = new javax.swing.GroupLayout(panelSisbb);
        panelSisbb.setLayout(panelSisbbLayout);
        panelSisbbLayout.setHorizontalGroup(
            panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSisbbLayout.createSequentialGroup()
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jlTPOperacao)
                    .addComponent(jlTPOperacao1)
                    .addComponent(jlTPOperacao2))
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSisbbLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextMatricula)
                            .addComponent(jTextPrefixDep)
                            .addComponent(jTextMunicipio)
                            .addComponent(jTextTPNotificacao))
                        .addGap(18, 18, 18)
                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSisbbLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jTextTituloCorreio, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(panelSisbbLayout.createSequentialGroup()
                .addComponent(jlTPOperacao3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSisbbLayout.setVerticalGroup(
            panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSisbbLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jTextTPNotificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTPOperacao)
                    .addComponent(jTextMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTPOperacao1)
                    .addComponent(jTextPrefixDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTPOperacao2)
                    .addComponent(jTextMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTituloCorreio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTPOperacao3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSisbbLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jTextTPNotificacao});

        panelSisbbLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jTextMunicipio});

        panelSisbbLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton13, jButton3, jTextPrefixDep});

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
                .addContainerGap()
                .addGroup(panelSisbb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdataModificacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10)
                    .addGroup(panelSisbb1Layout.createSequentialGroup()
                        .addComponent(jButton12)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18))
                    .addGroup(panelSisbb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSisbb1Layout.createSequentialGroup()
                            .addComponent(jButton8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSisbb1Layout.createSequentialGroup()
                            .addComponent(jButton6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7))
                        .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(btnLimpaCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpaCampos)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdataModificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(18, 18, 18)
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
                .addGap(24, 24, 24)
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
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        limpaTabela(jTable1, tabelaPapeleta);

        InterfacePoolBase pool = new PoolBase();
        InterfaceCommand comando = new ListarPapeletas2(new Papeleta2DAO(pool));
        listaTodosPapeleta = (ArrayList<Papeleta2>) comando.executeColection();
        ArrayList<Papeleta2> listaFiltro = new ArrayList<>(listaTodosPapeleta);
        tabelaPapeleta = new TabelaPapeletaModel(listaFiltro);
        jTable1.setModel(tabelaPapeleta);
        ArrumaTabela.dimensionaTabela(jTable1);
        limpacampos(jPanel1);
        this.repaint();


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

//                ArrayList<Papeleta2> listaNotificar = tabelaPapeleta.getListaPapeleta();
                ArrayList<Papeleta2> listaNotificar = carregaJtablePapeleta2(jTable1);

                Robo robo = new RoboCorreioEdital(sis2);
                robo.connect("B", sis2);
                robo.performaceEntrar();
                robo.performaceCapturar( jTextTituloCorreio.getText().trim(), listaNotificar);
                sis2.f3();
                sis2.f5();
                sis2.f3();
                sis2.f5();
                sis2.f5();
                sis2.f5();
                

                Atraso.setAtraso(1);

                System.out.println("Final de processamento!");
                JOptionPane.showMessageDialog(null, "Processo finalizado !");
                getTableModel();

                ArrumaTabela.dimensionaTabela(jTable1);
                InterfacePoolBase pool = new PoolBase();
                InterfaceCommand comando = new ListarPapeletas2(new Papeleta2DAO(pool));
                listaTodosPapeleta = (ArrayList<Papeleta2>) comando.executeColection();
                ArrayList<Papeleta2> listaFiltro = new ArrayList<>(listaTodosPapeleta);
                tabelaPapeleta = new TabelaPapeletaModel(listaFiltro);
                jTable1.setModel(tabelaPapeleta);
                ArrumaTabela.dimensionaTabela(jTable1);
                atualizaTabelas();
                limpacampos(jPanel1);
                

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        limpaTabela(jTable1, tabelaPapeleta);
        ArrayList<Papeleta2> listaFiltro = new ArrayList<>();

        for (Papeleta2 papeleta2 : listaTodosPapeleta) {
            if (papeleta2.getMUNICIPIOUF().contains(jTextMunicipio.getText())) {
                listaFiltro.add(papeleta2);
            }
        }

        tabelaPapeleta = new TabelaPapeletaModel(listaFiltro);
        jTable1.setModel(tabelaPapeleta);
        ArrumaTabela.dimensionaTabela(jTable1);
        limpacampos(jPanel1);
        this.repaint();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        limpaTabela(jTable1, tabelaPapeleta);
        ArrayList<Papeleta2> listaFiltro = new ArrayList<>();

        for (Papeleta2 papeleta2 : listaTodosPapeleta) {
            if (papeleta2.getMATRICULA().contains(jTextPrefixDep.getText())) {
                listaFiltro.add(papeleta2);
            }
        }

        tabelaPapeleta = new TabelaPapeletaModel(listaFiltro);
        jTable1.setModel(tabelaPapeleta);
        ArrumaTabela.dimensionaTabela(jTable1);
        limpacampos(jPanel1);
        this.repaint();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        limpaTabela(jTable1, tabelaPapeleta);
        ArrayList<Papeleta2> listaFiltro = new ArrayList<>();

        for (Papeleta2 papeleta2 : listaTodosPapeleta) {
            if (papeleta2.getPREFIXODEP().contains(jTextPrefixDep.getText())) {
                listaFiltro.add(papeleta2);
            }
        }

        tabelaPapeleta = new TabelaPapeletaModel(listaFiltro);
        jTable1.setModel(tabelaPapeleta);
        ArrumaTabela.dimensionaTabela(jTable1);
        limpacampos(jPanel1);
        this.repaint();


    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        limpaTabela(jTable1, tabelaPapeleta);
        ArrayList<Papeleta2> listaFiltro = new ArrayList<>();

        for (Papeleta2 papeleta2 : listaTodosPapeleta) {
            if (papeleta2.getTIPONOTIFICACAO().contains(jTextTPNotificacao.getText())) {
                listaFiltro.add(papeleta2);
            }
        }

        tabelaPapeleta = new TabelaPapeletaModel(listaFiltro);
        jTable1.setModel(tabelaPapeleta);
        ArrumaTabela.dimensionaTabela(jTable1);
        limpacampos(jPanel1);
        this.repaint();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked

        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe", "\\\\172.18.246.87\\c$\\UTIL\\TutorialRobos\\FrameRiscoCripto\\TutorialFrameRisco.avi");
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
            java.util.logging.Logger.getLogger(FormEnviaCorreioPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEnviaCorreioPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEnviaCorreioPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEnviaCorreioPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEnviaCorreioPapeleta().setVisible(true);
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
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTabela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextMatricula;
    private javax.swing.JTextField jTextMunicipio;
    private javax.swing.JTextField jTextPrefixDep;
    private javax.swing.JTextField jTextTPNotificacao;
    private javax.swing.JTextField jTextTituloCorreio;
    private javax.swing.JLabel jdataModificacao;
    private javax.swing.JLabel jlTPOperacao;
    private javax.swing.JLabel jlTPOperacao1;
    private javax.swing.JLabel jlTPOperacao2;
    private javax.swing.JLabel jlTPOperacao3;
    private javax.swing.JPanel panelSisbb;
    private javax.swing.JPanel panelSisbb1;
    // End of variables declaration//GEN-END:variables
}
