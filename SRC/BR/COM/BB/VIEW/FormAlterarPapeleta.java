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
import br.com.bb.model.Procuradoria;
import br.com.bb.model.Usuario;
import br.com.bb.model.command.AtualizarPapeleta2;
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
public class FormAlterarPapeleta extends javax.swing.JFrame {

    TabelaPapeletaModel tabelaPapeleta;
    ArrayList<Papeleta2> listaPapeleta2;
    ArrayList<Papeleta2> listaTodosPapeleta;

    /**
     * Creates new form FormPesa
     */
    public FormAlterarPapeleta() {
        initComponents();

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

    private void atualizaTabelas() {

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
        java.awt.Component[] components = jPanel.getComponents();
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
        panelPapeleta = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextProtocolo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextNrOperacao = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextDataPrescricao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextNrUnico = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextDataContratacao = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextPrefixoDepAlt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextTPNotificacao1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextMunicipioAlt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextTPOperacao = new javax.swing.JTextField();
        jButtonAlterar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jTextEquipe = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextValorOperacao = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextTPInadimplencia = new javax.swing.JTextField();
        jPanelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setTitle("ALTERAR INFORMAÇÕES PAPELETA");
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
                        .addComponent(jButton5)
                        .addGap(63, 63, 63)))
                .addContainerGap(59, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSisbbLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jTextTPNotificacao});

        panelSisbbLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jTextMunicipio});

        panelSisbbLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton13, jButton3, jTextPrefixDep});

        panelPapeleta.setBorder(javax.swing.BorderFactory.createTitledBorder("Papeleta-Alterar"));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Protocolo :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("nº Operação:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Data Prescrição:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Nr único:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Data Contratação:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Prefixo/Nome dep");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Tipo de Notificação:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Municipio");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Tipo de Operação:");

        jButtonAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAlterar.setText("Alterar Papeleta");
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("Limpar Campos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Equipe");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("VLR Op.");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Tipo de Inadimplência:");

        javax.swing.GroupLayout panelPapeletaLayout = new javax.swing.GroupLayout(panelPapeleta);
        panelPapeleta.setLayout(panelPapeletaLayout);
        panelPapeletaLayout.setHorizontalGroup(
            panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPapeletaLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPapeletaLayout.createSequentialGroup()
                            .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextTPOperacao)
                                .addComponent(jTextTPNotificacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelPapeletaLayout.createSequentialGroup()
                            .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPapeletaLayout.createSequentialGroup()
                                        .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))
                                        .addGap(57, 57, 57)
                                        .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextDataPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextDataContratacao, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel12)
                                    .addComponent(jTextPrefixoDepAlt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelPapeletaLayout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(102, 102, 102)
                                    .addComponent(jTextMunicipioAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel13)
                                .addGroup(panelPapeletaLayout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextTPInadimplencia, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel11)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextValorOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextNrUnico, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextNrOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelPapeletaLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButtonAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        panelPapeletaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextMunicipioAlt, jTextPrefixoDepAlt, jTextTPInadimplencia});

        panelPapeletaLayout.setVerticalGroup(
            panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPapeletaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextTPNotificacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextTPOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jTextEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextDataPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextNrOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextNrUnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextDataContratacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextPrefixoDepAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jTextValorOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextMunicipioAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextTPInadimplencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(getTableModel());
        ArrumaTabela.dimensionaTabela(jTable1);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelSisbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelPapeleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPapeleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        limpacampos(panelSisbb);
        this.repaint();


    }//GEN-LAST:event_jButton5ActionPerformed

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

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

        int opcao = JOptionPane.showConfirmDialog(this,
                "Deseja salvar as alterações desse cadastro?",
                "Alteração de cadastro", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_NO_OPTION) {

            Papeleta2 papeleta2 = (Papeleta2) tabelaPapeleta.getLinha(jTable1.getSelectedRow());
            papeleta2.setTIPONOTIFICACAO(jTextTPNotificacao1.getText());
            papeleta2.setTIPONOTIFICACAO(jTextTPNotificacao1.getText());
            papeleta2.setNOMEPRODUTO(jTextTPOperacao.getText());
            papeleta2.setGSV(jTextProtocolo.getText());
            papeleta2.setEQUIPE(jTextEquipe.getText());
            papeleta2.setDTAPRESCRICAO(jTextDataPrescricao.getText());
            papeleta2.setOPERACAO(jTextNrOperacao.getText());
            papeleta2.setDATANOTVENCANTECIPADO(jTextDataContratacao.getText());
            papeleta2.setNRUNICOOPERACAO(jTextNrUnico.getText());
            papeleta2.setPREFIXODEP(jTextPrefixoDepAlt.getText());
            papeleta2.setMUNICIPIOUF(jTextMunicipioAlt.getText());
            papeleta2.setFORMANOTVENCANTECIPADO(jTextValorOperacao.getText());
            papeleta2.setTIPOINADIMPLENCIA(jTextTPInadimplencia.getText());
            papeleta2.setMATRICULA(System.getProperty("user.name"));
            
            InterfacePoolBase pool = new PoolBase();
            InterfaceCommand comando = new AtualizarPapeleta2(new Papeleta2DAO(pool));
            comando.execute(papeleta2);
                  

           

        }

        ArrumaTabela.dimensionaTabela(jTable1);
        jButtonAlterar.setEnabled(false);
        jTable1.clearSelection();


    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        limpacampos(panelPapeleta);
        this.repaint();
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        System.out.println(">> passar a informação para os campos");
        Papeleta2 papeleta2 = (Papeleta2) tabelaPapeleta.getLinha(jTable1.getSelectedRow());

        jTextTPNotificacao1.setText(papeleta2.getTIPONOTIFICACAO());
        jTextTPOperacao.setText(papeleta2.getNOMEPRODUTO());
        jTextProtocolo.setText(papeleta2.getGSV());
        jTextEquipe.setText(papeleta2.getEQUIPE());
        jTextDataPrescricao.setText(papeleta2.getDTAPRESCRICAO());
        jTextNrOperacao.setText(papeleta2.getOPERACAO());
        jTextDataContratacao.setText(papeleta2.getDATANOTVENCANTECIPADO());
        jTextNrUnico.setText(papeleta2.getNRUNICOOPERACAO());
        jTextPrefixoDepAlt.setText(papeleta2.getPREFIXODEP());
        jTextMunicipioAlt.setText(papeleta2.getMUNICIPIOUF());
        jTextValorOperacao.setText(papeleta2.getFORMANOTVENCANTECIPADO());
        jTextTPInadimplencia.setText(papeleta2.getTIPOINADIMPLENCIA());
        this.repaint();

        jButtonAlterar.setEnabled(true);


    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(FormAlterarPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAlterarPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAlterarPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAlterarPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAlterarPapeleta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTabela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextDataContratacao;
    private javax.swing.JTextField jTextDataPrescricao;
    private javax.swing.JTextField jTextEquipe;
    private javax.swing.JTextField jTextMatricula;
    private javax.swing.JTextField jTextMunicipio;
    private javax.swing.JTextField jTextMunicipioAlt;
    private javax.swing.JTextField jTextNrOperacao;
    private javax.swing.JTextField jTextNrUnico;
    private javax.swing.JTextField jTextPrefixDep;
    private javax.swing.JTextField jTextPrefixoDepAlt;
    private javax.swing.JTextField jTextProtocolo;
    private javax.swing.JTextField jTextTPInadimplencia;
    private javax.swing.JTextField jTextTPNotificacao;
    private javax.swing.JTextField jTextTPNotificacao1;
    private javax.swing.JTextField jTextTPOperacao;
    private javax.swing.JTextField jTextValorOperacao;
    private javax.swing.JLabel jlTPOperacao;
    private javax.swing.JLabel jlTPOperacao1;
    private javax.swing.JLabel jlTPOperacao2;
    private javax.swing.JPanel panelPapeleta;
    private javax.swing.JPanel panelSisbb;
    // End of variables declaration//GEN-END:variables
}
