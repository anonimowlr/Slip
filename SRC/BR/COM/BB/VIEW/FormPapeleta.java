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
import br.com.bb.model.command.CadastrarEnvolvido2;
import br.com.bb.model.command.CadastrarPapeleta2;
import br.com.bb.model.command.InterfaceCommand;
import br.com.bb.model.dao.Envolvido2DAO;
import br.com.bb.model.dao.Papeleta2DAO;
import br.com.bb.suporte.ArrumaTabela;
import br.com.bb.suporte.TextoUtil;
import br.com.bb.suporte.tabelas.TabelaNotificadoModel;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author Equipe Flash Monitoria
 * @date 17/06/2014
 */
public class FormPapeleta extends javax.swing.JFrame {

    TabelaNotificadoModel tabelaNotificado;
    Collection<Envolvido2> listaEnvolvidos;
    Papeleta2 papeleta;

    /**
     * Creates new form FormPesa
     */
    public FormPapeleta() {

        initComponents();

    }

    public FormPapeleta(Papeleta2 papeleta, Collection<Envolvido2> listaEnvolvidos) {
        this.listaEnvolvidos = listaEnvolvidos;
        this.papeleta = papeleta;
        initComponents();
        jTextTPNotificacao.setText(papeleta.getTIPONOTIFICACAO());
        jTextTPOperacao.setText(papeleta.getNOMEPRODUTO());
        jTextProtocolo.setText(papeleta.getGSV());
        jTextDataPrescricao.setText(papeleta.getDTAPRESCRICAO());
        jTextDataContratacao.setText(papeleta.getDATANOTVENCANTECIPADO());
        jTextNrUnico.setText(papeleta.getNRUNICOOPERACAO());
        jTextNrOperacao.setText(papeleta.getOPERACAO());
        jTextPrefixo.setText(papeleta.getPREFIXODEP() + " - "+papeleta.getNOMEDEPENDENCIA());
        jTextMatricula.setText(System.getProperty("user.name"));
        jTextMunicipio.setText(papeleta.getMUNICIPIOUF());
        jTextValorOperacao.setText(papeleta.getFORMANOTVENCANTECIPADO());
        jTextTPInadimplencia.setText("FINANCEIRA");

        jTextEquipe.setText("RISCO UNIÃO");
        papeleta.setMATRICULA(System.getProperty("user.name"));

    }

    private TabelaNotificadoModel getTableModel() {
        try {
            if (tabelaNotificado == null) {
                Collection<Notificado> listaNotificado = new ArrayList<Notificado>();
                for (Envolvido2 envolvido : listaEnvolvidos) {
                    Notificado notificado;

                    notificado = new Notificado(envolvido.getNOMEMUTUARIO(),
                            envolvido.getTIPPRCTMUT().trim(),
                            TextoUtil.formatarString(envolvido.getCPFCNPJ(), "###.###.###.###-##"),
                            getMutuario( Integer.parseInt(envolvido.getTIPPRCTMUT().trim()) ),
                            envolvido.isNOTIFICAR());

                    listaNotificado.add(notificado);

                }

                tabelaNotificado = new TabelaNotificadoModel(new ArrayList<>(listaNotificado));

            } else {
                jTable1.repaint();
                Collection<Notificado> listaNotificado = new ArrayList<Notificado>();
                for (Envolvido2 envolvido : listaEnvolvidos) {
                    Notificado notificado = new Notificado(envolvido.getNOMEMUTUARIO(),
                            envolvido.getTIPPRCTMUT().trim(),
                            TextoUtil.formatarString(envolvido.getCPFCNPJ(), "###.###.###.###-##"),
                            getMutuario( Integer.parseInt(envolvido.getTIPPRCTMUT().trim()) ),
                            envolvido.isNOTIFICAR());
                    listaNotificado.add(notificado);

                }

                tabelaNotificado = new TabelaNotificadoModel(new ArrayList<>(listaNotificado));

                this.repaint();
            }
        } catch (ParseException ex) {
            Logger.getLogger(FormPapeleta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tabelaNotificado;
    }

    private ArrayList<Notificado> carregaJtableNotificados(JTable jTable) {
        this.jTable1 = jTable;

        ArrayList<Notificado> listanotificados = new ArrayList<>();

        for (int i = 0; i < jTable.getRowCount(); i++) {
            if (jTable.getValueAt(i, 0) != null && jTable.getValueAt(i, 1) != null && jTable.getValueAt(i, 0) != null) {

                Notificado notificado = new Notificado(jTable.getValueAt(i, 0).toString().trim(),
                        jTable.getValueAt(i, 1).toString().trim(),
                        jTable.getValueAt(i, 2).toString().trim(),
                        jTable.getValueAt(i, 3).toString().trim(),
                        (boolean) jTable.getValueAt(i, 4));
                listanotificados.add(notificado);
//                }
            }
        }
        return listanotificados;

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
    
    
    public String getMutuario(int tipParticipMut){
        String participMutuario = null;
        switch (tipParticipMut) {
            case 1:
                participMutuario = "MUTUARIO PRINCIPAL";
                break;
            case 2:
                participMutuario = "MUTUARIO";
                break;
            case 3:
                participMutuario = "COOBRIGADO";
                break;
            case 4:
                participMutuario = "AVALISTA";
                break;
            case 5:
                participMutuario = "FIADOR";
                break;
            case 6:
                participMutuario = "CÔNJUGE AVALISTA";
                break;
            case 7:
                participMutuario = "CÔNJUGE FIADOR";
                break;
            case 8:
                participMutuario = "DEVEDOR SOLIDÁRIO";
            case 9:
                participMutuario = "COOBRIGADO";
                break;
            case 10:
                participMutuario = "CONFIENTE DEVEDOR";
                break;
            case 11:
                participMutuario = "COOBRIGADO (INDEFINIDO)";
            break;
            default:
                participMutuario = "Cod. Não Encontrado";
                break;
        }

        return participMutuario;
        
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
        jTextPrefixo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextTPNotificacao = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextMatricula = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextMunicipio = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextTPOperacao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jTextEquipe = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextValorOperacao = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextTPInadimplencia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setTitle("CAPTURA DE INFORMAÇÕES DE CONTRATO");
        setIconImage(new ImageIcon("C:\\Program Files (x86)\\SisBB\\SisBB.gif").getImage());
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bb/imagens/FaixaBB-2.jpg"))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N

        panelSisbb.setBorder(javax.swing.BorderFactory.createTitledBorder("Procuradoria"));

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

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Tipo de Notificação:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Matricula :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Municipio");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Tipo de Operação:");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(getTableModel());
        ArrumaTabela.dimensionaTabela(jTable1);
        jScrollPane1.setViewportView(jTable1);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Salvar");
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

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Equipe");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("VLR Op.");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Tipo de Inadimplência:");

        javax.swing.GroupLayout panelSisbbLayout = new javax.swing.GroupLayout(panelSisbb);
        panelSisbb.setLayout(panelSisbbLayout);
        panelSisbbLayout.setHorizontalGroup(
            panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSisbbLayout.createSequentialGroup()
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelSisbbLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(panelSisbbLayout.createSequentialGroup()
                                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextTPOperacao)
                                    .addComponent(jTextTPNotificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextPrefixo, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSisbbLayout.createSequentialGroup()
                                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelSisbbLayout.createSequentialGroup()
                                                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10))
                                                .addGap(57, 57, 57)
                                                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextProtocolo, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                                    .addComponent(jTextDataPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextDataContratacao)))
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextNrUnico, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextNrOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelSisbbLayout.createSequentialGroup()
                                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelSisbbLayout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSisbbLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jTextMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextValorOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelSisbbLayout.createSequentialGroup()
                                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextTPInadimplencia, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelSisbbLayout.createSequentialGroup()
                                        .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(66, 66, 66)
                                        .addComponent(jButton5)))))
                        .addGap(0, 164, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelSisbbLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextEquipe, jTextNrOperacao, jTextNrUnico, jTextProtocolo});

        panelSisbbLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextDataContratacao, jTextMunicipio, jTextTPInadimplencia});

        panelSisbbLayout.setVerticalGroup(
            panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSisbbLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextTPNotificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextTPOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jTextEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextDataPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextNrOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextNrUnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextDataContratacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextPrefixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextValorOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextTPInadimplencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelSisbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelSisbbLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton4, jButton5});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSisbb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSisbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        limpacampos(jPanel1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        ArrayList<Notificado> listaNotificadosGravar = carregaJtableNotificados(jTable1);
        ArrayList<Envolvido2> listaEnvolvidosGravar = new ArrayList<>(listaEnvolvidos);
        InterfacePoolBase pool = new PoolBase();
        papeleta.setNOTIFICAR(true);
        papeleta.setTIPONOTIFICACAO(jTextTPNotificacao.getText());
        papeleta.setDTAPRESCRICAO(jTextDataPrescricao.getText());
        papeleta.setEQUIPE(jTextEquipe.getText());
        papeleta.setGSV(jTextProtocolo.getText());
        papeleta.setDATACONTRATACAO(jTextDataContratacao.getText());
        papeleta.setMUNICIPIOUF(jTextMunicipio.getText());
        papeleta.setTIPOINADIMPLENCIA(jTextTPInadimplencia.getText());
        
        InterfaceCommand comando = new CadastrarPapeleta2(new Papeleta2DAO(pool));
        System.out.println("Comando de salvar "+comando.execute(papeleta));
        System.out.println("> Simulação de salvar a papeleta");
        System.out.println(papeleta.getNOMEMUTUARIO());
        System.out.println(">" + papeleta.getFORMANOTVENCANTECIPADO());
        System.out.println(">" + papeleta.getDATANOTVENCANTECIPADO());
        System.out.println("==========================================");
        
        

        for (int i = 0; i < listaNotificadosGravar.size(); i++) {
            if (listaNotificadosGravar.get(i).isNotificar()) {
                System.out.println("Sujeito Helps>" + listaNotificadosGravar.get(i).getNotificado());
                System.out.println("notificar>" + listaNotificadosGravar.get(i).isNotificar());
                listaEnvolvidosGravar.get(i).setNOTIFICAR(listaNotificadosGravar.get(i).isNotificar());
                comando = new CadastrarEnvolvido2(new Envolvido2DAO(pool));
                System.out.println("Gravando os envolvidos "+comando.execute(listaEnvolvidosGravar.get(i)));;
            }

        }
        
        System.out.println(">simulação de Salvar as informações no Banco de Dados!");
        
        ArrumaTabela.dimensionaTabela(jTable1);
        limpacampos(jPanel1);
        dispose();

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(FormPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPapeleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPapeleta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextDataContratacao;
    private javax.swing.JTextField jTextDataPrescricao;
    private javax.swing.JTextField jTextEquipe;
    private javax.swing.JTextField jTextMatricula;
    private javax.swing.JTextField jTextMunicipio;
    private javax.swing.JTextField jTextNrOperacao;
    private javax.swing.JTextField jTextNrUnico;
    private javax.swing.JTextField jTextPrefixo;
    private javax.swing.JTextField jTextProtocolo;
    private javax.swing.JTextField jTextTPInadimplencia;
    private javax.swing.JTextField jTextTPNotificacao;
    private javax.swing.JTextField jTextTPOperacao;
    private javax.swing.JTextField jTextValorOperacao;
    private javax.swing.JPanel panelSisbb;
    // End of variables declaration//GEN-END:variables
}
