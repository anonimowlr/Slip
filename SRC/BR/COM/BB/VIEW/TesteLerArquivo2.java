/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.view;

import BR.com.bb.MODEL.DossieSlip;
import BR.com.bb.view.TesteLerArquivo;
import br.com.bb.model.CronogramaAmortizacao;
import br.com.bb.model.CronogramaUtilizacao;
import br.com.bb.model.LancamentoVariacao;
import br.com.bb.model.ProdutosDaVariacao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Adm
 */
public class TesteLerArquivo2 {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

            JFileChooser abrir = new JFileChooser();
// Definir Titulo da mensagem
            abrir.setDialogTitle("Selecione um arquivo BBM por Favor.");
// DEfinindo caminho padrão
//        String caminho_padrao = "Documents:"; //-> aqui vc define uma abertura pré definida ex. Desktop, C: 
            String caminho_padrao = "C:\\Users\\F2872117\\Documents\\DesenvolvimentoCenop\\Francine"; //-> aqui vc define uma abertura pré definida ex. Desktop, C: 
            File pathInicial = new File(caminho_padrao);
            abrir.setCurrentDirectory(pathInicial);//vai abrir direto no dir. 'H:\'
// Filtra só arquivos xml.
            FileNameExtensionFilter filtroxml = new FileNameExtensionFilter(".txt", "txt");
            abrir.addChoosableFileFilter(filtroxml);
            abrir.setAcceptAllFileFilterUsed(false);
            abrir.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            abrir.showDialog(null, "OK");

            File arquivo = abrir.getSelectedFile();
            FileReader reader = new FileReader(arquivo.getAbsolutePath());
            BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo.getAbsolutePath()), "Cp1252"));

            String linha;

            try {
                //                ========================= cria o diretório do arquivo a ser criado
                while ((linha = leitor.readLine()) != null) {
//                    if (linha.contains("11*")) {
                    if (linha.length() == 112) {
//                        System.out.println(linha.length() + " >>" + linha);
                        if (linha.substring(89, 99).matches("\\d{2}/\\d{2}/\\d{4}") && linha.substring(102, 112).matches("\\d{2}/\\d{2}/\\d{4}")) {
                            linha = metodoDeSetarCabecalho(leitor, linha);
                        }

                        if (linha.contains("PRODUTOS DA VARIACAO")) {
                            linha = metodoDeSetarProdutosVariacao(leitor);
                        }

                        if (linha.contains("CRONOGRAMA DE UTILIZACAO DA VARIACAO")) {
                            linha = setCronogramaVar(leitor);
                        }

                        if (linha.contains("CRONOGRAMA DE AMORTIZACAO DA VARIACAO")) {
                            linha = setCronogramaAmortVar(leitor);
                        }
                        if (linha.contains("LANCAMENTOS DA VARIACAO")) {
                            linha = setLancamentoVariacao(leitor);
                        }
//
//                        System.out.println("Sai do cabeçalho do documento");
                    } else {

                        if (linha.contains("PRODUTOS DA VARIACAO")) {
                            linha = metodoDeSetarProdutosVariacao(leitor);
                        }
////                        lembrar de colocar a condição de parada qualquer uma das palavras reservadas abaixo
//                        System.out.println("Linhazinha" + linha);
                        if (linha.contains("CRONOGRAMA DE UTILIZACAO DA VARIACAO")) {
                            linha = setCronogramaVar(leitor);
                        }
//                        
                        if (linha.contains("CRONOGRAMA DE AMORTIZACAO DA VARIACAO")) {
                            linha = setCronogramaAmortVar(leitor);
                        }
                        if (linha.contains("LANCAMENTOS DA VARIACAO")) {
                            linha = setLancamentoVariacao(leitor);
                        }
//                        System.out.println("linha>>" + linha);
                    }

                }

            } catch (IOException ex) {
                Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(">> 01");

    }

    public static String metodoDeSetarCabecalho(BufferedReader leitor, String linhaAtual) throws IOException {
        String linha = "";
        System.out.println("   ============================================                   CABEÇALHO               ====================================" );
        System.out.println("   ||                               todas as informações do cabeçalho foram setadas                                          ||");
        System.out.println("   ||                                         nesta parte compeltaremos os dados do contrato                                 ||");
        System.out.println("   ||                                                                                                                        ||");
        System.out.println("   ||                                                                                                                        ||");
        System.out.println("   ===========================================================================================================================" );

        int nrlinha = 3;

        DossieSlip slip = new DossieSlip();

        slip.setDcAgencia(linhaAtual.substring(6, 12).trim());
        slip.setDcNomeAgencia(linhaAtual.substring(13, 30).trim());
        slip.setDcNRContrato(linhaAtual.substring(31, 46).trim());
        slip.setDcPavan(linhaAtual.substring(47, 53).trim());
        slip.setDcDadosOrigemAg(linhaAtual.substring(54, 70).trim());
        slip.setDcTipo(linhaAtual.substring(71, 72).trim());
        slip.setDcContrato(linhaAtual.substring(73, 88).trim());
        slip.setDcDTContratacao(linhaAtual.substring(89, 99).trim());
        slip.setDcDTVencimento(linhaAtual.substring(102, 112).trim());

        while (!linha.contains("-7  PRODUTOS DA VARIACAO") && ((linha = leitor.readLine()) != null)) {

//            System.out.println("linha " + nrlinha + " - >" + linha);
            if (linha.length() == 2) {
//                System.out.println("não tem nada");
            } else {

                if (nrlinha == 4) {
//                    System.out.println(">>" + linha.length());
                    slip.setDcRFBacen(linha.substring(5, 15).trim());
                    slip.setDcVLROperacao(linha.substring(16, 42).trim());
                    slip.setDcNMMutuario(linha.substring(44, 109).trim());
                    slip.setDcTpMutuario(linha.substring(109, 110).trim());
                }
                if (nrlinha == 6) {
                    slip.setDcCPFMutuario(linha.substring(5, 25).trim());
                    slip.setDcAGMutuario(linha.substring(26, 37).trim());
                    slip.setDcCNTMutuario(linha.substring(38, 60).trim());
                    slip.setDcEndMutuario(linha.substring(60, linha.length()).trim());
                }

                if (nrlinha == 8) {
                    slip.setDcCEP(linha.substring(3, 16).trim());
                    slip.setDcCNDSeguro(linha.substring(17, 26).trim());
                    slip.setDcCNDIOF(linha.substring(27, 40).trim());
                    slip.setDcCNDAssTec(linha.substring(41, 55).trim());
                    slip.setDcNTOperacao(linha.substring(56, 77).trim());
                    slip.setDcFinalidade(linha.substring(78, 92).trim());
                    slip.setDcPerspectiva(linha.substring(93, 101).trim());
                    slip.setDcGarantia(linha.substring(102, linha.length()).trim());
                }

                if (nrlinha == 10) {
                    slip.setDcAjuizamento(linha.substring(3, 14).trim());
                    slip.setDcSolvencia(linha.substring(15, 27).trim());
                    slip.setDcSTOperacao(linha.substring(28, 37).trim());
                    slip.setDcMatricula(linha.substring(38, 60).trim());
                    slip.setDcEscalaoDef(linha.substring(61, 77).trim());
                    slip.setDcAreaPropria(linha.substring(78, 92).trim());
                    slip.setDcAreaTerceiros(linha.substring(92, linha.length()).trim());
                }
                if (nrlinha == 12) {
                    slip.setRecusPropAmp(linha.substring(7, 29).trim());
                    slip.setDcPorteMutuario(linha.substring(34, 37).trim());
                    slip.setDcClasseMutuario(linha.substring(46, 50).trim());
                    slip.setDcFampTipo(linha.substring(57, 60).trim());
                    slip.setDcFampValor(linha.substring(68, 86).trim());
                    slip.setDcFampData(linha.substring(88, 103).trim());
                    slip.setDcDistrito(linha.substring(104, linha.length()).trim());
                }
                if (nrlinha == 14) {
                    slip.setNrVariacao(linha.substring(9, 14).trim());
                    slip.setStVariacao(linha.substring(15, 32).trim());
                    slip.setEnqContabil(linha.substring(33, 50).trim());
                    slip.setEnqContabilAnt(linha.substring(51, 70).trim());
                    slip.setDtEnqAnt(linha.substring(75, 86).trim());
                    slip.setDtEnqAntCL(linha.substring(87, linha.length()).trim());
                }
                if (nrlinha == 16) {
                    slip.setDtTransfCL(linha.substring(5, 17).trim());
                    slip.setProAgro(linha.substring(25, 30).trim());
                    slip.setTxProAgro(linha.substring(30, 41).trim());
                    slip.setFaseProAgro(linha.substring(42, 48).trim());
                    slip.setRecusPropAmp(linha.substring(53, 76).trim());
                    slip.setPaCodig(linha.substring(80, 83).trim());
                    slip.setPaTxJuros(linha.substring(88, 94).trim());
                    slip.setPaTxCorr(linha.substring(95, 105).trim());
                    slip.setDiaBase(linha.substring(109, linha.length()).trim());

                }

                if (nrlinha == 18) {
                    slip.setTxJurosAnterior(linha.substring(9, 17).trim());
                    slip.setTxCorrecaoAnterior(linha.substring(23, 30).trim());
                    slip.setPeriodAnterior(linha.substring(35, 42).trim());
                    slip.setDtTrocaTaxas(linha.substring(51, 61).trim());
                    slip.setPercRebatJuros(linha.substring(65, 71).trim());
                    slip.setPercRebatCM(linha.substring(79, 85).trim());
                    slip.setDtIniCarencia(linha.substring(90, 100).trim());
                    slip.setDtFimCarencia(linha.substring(101, linha.length()).trim());
                }
                if (nrlinha == 20) {
                    slip.setPpiCodigo(linha.substring(7, 11).trim());
                    slip.setPpiTxJuros(linha.substring(15, 22).trim());
                    slip.setPpiTxCorrecao(linha.substring(25, 34).trim());
                    slip.setIndDebAutomatico(linha.substring(38, 42).trim());
                    slip.setModPagamento(linha.substring(52, 56).trim());
                    slip.setFundoPrograma(linha.substring(64, linha.length()).trim());

                }
                if (nrlinha == 22) {
                    slip.setVlrVariacao(linha.substring(10, 30).trim());
                    slip.setSldCapital(linha.substring(50, 70).trim());
                    slip.setSldTotalVariacao(linha.substring(85, linha.length()).trim());

                }
                if (nrlinha == 24) {
                    slip.setAssSldAssEfetivo(linha.substring(10, 30).trim());
                    slip.setAssSldAssApro(linha.substring(50, 70).trim());
                    slip.setAssSldAssTotal(linha.substring(85, linha.length()).trim());

                }
                if (nrlinha == 26) {
                    slip.setCmSldCorrMonEf(linha.substring(10, 30).trim());
                    slip.setCmSldCorrMonAP(linha.substring(50, 70).trim());
                    slip.setCmSldCorrMonTotal(linha.substring(85, linha.length()).trim());
                }

                if (nrlinha == 28) {
                    slip.setJrSldJurEf(linha.substring(10, 30).trim());
                    slip.setJrSldJurAprop(linha.substring(50, 70).trim());
                    slip.setJrSldJurTotal(linha.substring(85, linha.length()).trim());
                }

                if (nrlinha == 30) {
                    slip.setPrjProjAcess(linha.substring(10, 30).trim());
                    slip.setPrjProjJuros(linha.substring(50, 70).trim());
                    slip.setPrjProjCorr(linha.substring(85, linha.length()).trim());
                }

                if (nrlinha == 32) {
                    slip.setCampFinal1(linha.substring(4, 55).trim());
                    slip.setCampFinal2(linha.substring(56, linha.length()).trim());
                }

            }

//            System.out.println(linha.length() + "cabecalho ->" + linha);
            nrlinha++;
        }

//        System.out.println("=========== sai do metodo agora já posso sair com um objeto setado");
        return linha;
    }

    private static String metodoDeSetarProdutosVariacao(BufferedReader leitor) throws IOException {
        String linha = "";
        ProdutosDaVariacao produtosDaVariacao = new ProdutosDaVariacao();

        System.out.println("   =====================  PRODUTOS VARIAÇÃO   =============================================================");

//        Setar no documento a linha corrente
        while (!linha.contains("CRONOGRAMA DE UTILIZACAO DA VARIACAO") && ((linha = leitor.readLine()) != null)) {
//            System.out.println("Produtos>" + linha);

            if (linha.contains("CRONOGRAMA DE UTILIZACAO DA VARIACAO")) {
//                System.out.println(">>>>> não tem nada");
            } else {

                if (linha.substring(4, 13).trim().matches("\\d{6}-\\d{1}")) {
                    produtosDaVariacao.setCodigo(linha.substring(4, 13).trim());
                    produtosDaVariacao.setInsumo(linha.substring(14, 22).trim());
                    produtosDaVariacao.setArea(linha.substring(23, 28).trim());
                    produtosDaVariacao.setQuantidade(linha.substring(29, 70).trim());
                    produtosDaVariacao.setPrevisaoSafra(linha.substring(36, 89).trim());
                    produtosDaVariacao.setVlrItemFinaciado(linha.substring(90, linha.length()).trim());
                    System.out.println("Produtos Variaçao >>" + produtosDaVariacao.getCodigo() + "\t"
                            + produtosDaVariacao.getInsumo() + "\t"
                            + produtosDaVariacao.getArea() + "\t"
                            + produtosDaVariacao.getQuantidade() + "\t"
                            + produtosDaVariacao.getPrevisaoSafra() + "\t"
                            + produtosDaVariacao.getVlrItemFinaciado()
                    );
                }
            }

        }

//        System.out.println("============================================================ sai do metodo agora já posso sair com um objeto setado");
        return linha;
    }

    private static String setCronogramaVar(BufferedReader leitor) throws IOException {
        String linha = "";
        CronogramaUtilizacao cronogramaUtilizacao = new CronogramaUtilizacao();
        System.out.println("   =====================  CRONOGRAMA DE UTILIZAÇÃO DA VARIAÇÃO   =============================================================");

//        Setar no documento a linha corrente
        while (!linha.contains("CRONOGRAMA DE AMORTIZACAO DA VARIACAO") && ((linha = leitor.readLine()) != null)) {
            if (linha.contains("CRONOGRAMA DE AMORTIZACAO DA VARIACAO")) {
//                System.out.println(">>>>> não tem nada");
            } else {

                if (linha.substring(4, 15).trim().matches("\\d{2}/\\d{2}/\\d{4}")) {

                    cronogramaUtilizacao.setDtPrevisaoParcela(linha.substring(4, 15).trim());
                    cronogramaUtilizacao.setVlrPrevistoParcela(linha.substring(30, 46).trim());
                    cronogramaUtilizacao.setVlrRealizadoParcela(linha.substring(55, 74).trim());
                    cronogramaUtilizacao.setVlrRealizarParcela(linha.substring(85, 102).trim());
                    cronogramaUtilizacao.setEquivalProduto(linha.substring(110, linha.length()).trim());
                    System.out.println("CRONOGRAMA DE UTILIZAÇÃO DA VARIAÇÃO >>" + cronogramaUtilizacao.getDtPrevisaoParcela()
                            + "\t" + cronogramaUtilizacao.getVlrPrevistoParcela()
                            + "\t" + cronogramaUtilizacao.getVlrRealizadoParcela()
                            + "\t" + cronogramaUtilizacao.getVlrRealizarParcela()
                            + "\t" + cronogramaUtilizacao.getEquivalProduto()
                    );
                }
            }

        }

//        System.out.println("============================================================ sai do metodo agora já posso sair com um objeto setado");
        return linha;
    }

    private static String setLancamentoVariacao(BufferedReader leitor) throws IOException {
        String linha = "";
        LancamentoVariacao lancamentoVariacao = new LancamentoVariacao();
        
        System.out.println(" =====================  LANÇAMENTO DA VARIAÇÃO  =============================================================");

        while (!linha.contains("-------------------------------------------------------------------------------------------------------") && ((linha = leitor.readLine()) != null)) {
//            System.out.println("LANCAMENTOS DA VARIACAO>" + linha);
            if (linha.contains("-------------------------------------------------------------------------------------------------------")) {
//                System.out.println(">>>>> não tem nada");
            } else {

                if (linha.substring(4, 15).trim().matches("\\d{2}/\\d{2}/\\d{4}")) {
                    lancamentoVariacao.setLancamento(linha.substring(4, 15).trim());
                    lancamentoVariacao.setValorizacao(linha.substring(19, 29).trim());
                    lancamentoVariacao.setHistorico(linha.substring(30, 35).trim());
                    lancamentoVariacao.setLiteralHistorico(linha.substring(39, 60).trim());
                    if (linha.length() > 87) {
                        lancamentoVariacao.setVlrLancamento(linha.substring(61, 87).trim());
                        lancamentoVariacao.setSaldoData(linha.substring(90, linha.length()).trim());
                    } else {
                        lancamentoVariacao.setVlrLancamento(linha.substring(61, 87).trim());
                        lancamentoVariacao.setSaldoData("".trim());
                    }
//                    System.out.println("lancamento>>" + lancamentoVariacao.getLancamento() + "\t\t"
//                            + lancamentoVariacao.getVlrLancamento());
                    System.out.println("LANCAMENTOS DA VARIACAO>" + linha);
                    
                }

            }

        }

//        System.out.println("============================================================ sai do metodo agora já posso sair com um objeto setado");
        return linha;
    }

    private static String setCronogramaAmortVar(BufferedReader leitor) throws IOException {
        String linha = "";
//        Setar no documento a linha corrente
        CronogramaAmortizacao cronogramaAmortizacao = new CronogramaAmortizacao();
        System.out.println("   =====================  CRONOGRAMA DE AMORTIZACAO DA VARIAÇAO   =============================================================");
        while ((!linha.contains("LANCAMENTOS DA VARIACAO") && ((linha = leitor.readLine()) != null)) && !linha.contains("END;") && !linha.contains("XERF912;")) {
//            System.out.println("LANCAMENTOS DA VARIACAO ->" + linha);
            if (linha.contains("LANCAMENTOS DA VARIACAO") || linha.contains("XERF912")) {
//                System.out.println(">>>>> não tem nada");
            } else {

                if (linha.substring(4, 15).trim().matches("\\d{2}/\\d{2}/\\d{4}")) {
                    cronogramaAmortizacao.setDtPrevistaParcela(linha.substring(4, 15).trim());
                    cronogramaAmortizacao.setVlrPrevisto(linha.substring(18, 42).trim());
                    cronogramaAmortizacao.setVlrRealizado(linha.substring(44, 67).trim());
                    cronogramaAmortizacao.setVlrParcelaEquiv(linha.substring(70, 92).trim());
                    cronogramaAmortizacao.setProrrogacao(linha.substring(93, linha.length()));
//                    System.out.println("lancamento-" + cronogramaAmortizacao.getDtPrevistaParcela() + "\t"
//                            + cronogramaAmortizacao.getVlrParcelaEquiv());
                    System.out.println("CRONOGRAMA DE AMORTIZACAO DA VARIAÇAO >" +linha);
                }

            }

        }

//        System.out.println("============================================================ sai do metodo agora já posso sair com um objeto setado");
//        System.out.println(">>>>>" + linha);
        return linha;
    }

}
