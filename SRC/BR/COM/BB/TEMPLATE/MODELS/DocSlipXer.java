package br.com.bb.template.models;

import BR.com.bb.MODEL.DossieSlip;
import BR.com.bb.view.TesteLerArquivo;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateFactory;
import org.odftoolkit.simple.TextDocument;

import br.com.bb.template.DocumentoOffice;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jooreports.templates.DocumentTemplateException;

public class DocSlipXer extends DocumentoOffice {

    static DossieSlip slip;

    public DocSlipXer(String mciEmpresa) {
        this.arquivo = mciEmpresa;
    }

    public DocSlipXer() {
    }

    @Override
    public void criarDocumento() {
        try {
//            TextDocument document2 = (TextDocument) TextDocument.loadDocument("modeloPivo.odt");
//
//            OdfOfficeStyles style = document2.getOrCreateDocumentStyles();
//            OdfStyle titulo = style.newStyle("titulo", OdfStyleFamily.Paragraph);
//            titulo.setProperty(OdfParagraphProperties.BackgroundColor, "#7696FD");
//            titulo.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(12));
//            titulo.setProperty(StyleTextPropertiesElement.FontFamily, "Arial");
//            titulo.setProperty(StyleTextPropertiesElement.FontWeight, "bold");
//            titulo.setProperty(StyleParagraphPropertiesElement.TextAlign, "left");
//
//            OdfStyle tituloSocios = style.newStyle("tituloSocios", OdfStyleFamily.Paragraph);
//            tituloSocios.setProperty(OdfParagraphProperties.BackgroundColor, "#FFFA9F");
//            tituloSocios.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(12));
//            tituloSocios.setProperty(StyleTextPropertiesElement.FontFamily, "Arial");
//            tituloSocios.setProperty(StyleTextPropertiesElement.FontWeight, "bold");
//            tituloSocios.setProperty(StyleParagraphPropertiesElement.TextAlign, "left");
//
//            OdfStyle headerSocio = style.newStyle("headerSocio", OdfStyleFamily.Paragraph);
//            headerSocio.setProperty(OdfParagraphProperties.BackgroundColor, "#FFC930");
//            headerSocio.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(14));
//            headerSocio.setProperty(StyleTextPropertiesElement.FontFamily, "Arial Black");
//            headerSocio.setProperty(StyleTextPropertiesElement.FontWeight, "bold");
//            headerSocio.setProperty(StyleParagraphPropertiesElement.TextAlign, "center");
//
//            OdfStyle normal = style.newStyle("normal", OdfStyleFamily.Paragraph);
//            normal.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(10));
//            normal.setProperty(StyleTextPropertiesElement.FontFamily, "Arial");
//            normal.setProperty(StyleParagraphPropertiesElement.TextAlign, "left");
//
//            OdfStyle mensagemDocumento = style.newStyle("mensagemDocumento", OdfStyleFamily.Paragraph);
//            mensagemDocumento.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(12));
//            mensagemDocumento.setProperty(StyleTextPropertiesElement.FontFamily, "Arial");
//            mensagemDocumento.setProperty(StyleTextPropertiesElement.FontWeight, "bold");
//            mensagemDocumento.setProperty(StyleParagraphPropertiesElement.TextAlign, "center");
//
//            Paragraph paragrafo = document2.getParagraphByReverseIndex(0, true);
//            HorizontalAlignmentType align = paragrafo.getHorizontalAlignment();
//            paragrafo.setHorizontalAlignment(HorizontalAlignmentType.LEFT);
//            document2.addParagraph("Operações").getOdfElement().setStyleName("titulo");
//            document2.addParagraph("");
//            paragrafo = document2.getParagraphByIndex(11, true);
//            paragrafo.getOdfElement().setStyleName("titulo");
//
//            InterfacePool pool = new Pool();
//            InterfaceCommand comando = new ListarGetEmpresa(new EmpresaDAO(pool));
//            Collection<Empresa> listaEmpresa = comando.executeColection(arquivo);
//            Empresa empresa = new Empresa();
//            for (Empresa emp : listaEmpresa) {
//                empresa = emp;
//            }
//
////            ===============================      DOCUMENTO COMEÇA AQUI          ===========================================================================
//            criarTabelaEmpresaOperacoes(document2, this.arquivo, empresa.getAgenciaCadastro());
//
//            // add table
//            document2.addParagraph("");
//            document2.addParagraph("Anotações Cadastrais").getOdfElement().setStyleName("titulo");
//            document2.addParagraph("");
//
//            criaTabelaAnotaCadastral(document2, arquivo);
//
//            document2.addParagraph("");
//            document2.addParagraph("Pessoa Física (F10)").getOdfElement().setStyleName("titulo");
//            document2.addParagraph("");
//
////            ========================   representantes   ============================================================
//            Paragraph paragraph = document2.getParagraphByReverseIndex(0, false);
//            align = paragraph.getHorizontalAlignment();
//            paragraph.setHorizontalAlignment(HorizontalAlignmentType.LEFT);
//
//
//            comando = new ListarGetSocio(new SociosDAO(pool));
//            Collection<Socios> listaSocios = comando.executeColection(empresa.getCnpj());
//            for (Socios socios : listaSocios) {
//                paragraph = document2.getParagraphByReverseIndex(0, false);
//                document2.addParagraph("");
//                paragraph.appendTextContent("NOME DO SÓCIO: ");
//                paragraph.appendTextContent(WordUtils.capitalize(socios.getNome().toLowerCase()));
//                criaTabelaAnotaCadastral(document2, socios.getMci());
//                document2.addParagraph("");
//
//            }
//
//            comando = new ListarGetPoderes(new PoderesDAO(pool));
//            Collection<Poderes> listaPoderes = comando.executeColection(empresa.getCnpj());
//            for (Poderes poderes : listaPoderes) {
//                poderes.getMciRepresentante();
//
//                document2.addParagraph("");
//                document2.addParagraph("Sócios").getOdfElement().setStyleName("headerSocio");
//                document2.addParagraph("");
//
//                addInformaçoesSocio(document2, poderes.getMciRepresentante());
//
//                document2.addParagraph("");
//                document2.addParagraph("Endereço").getOdfElement().setStyleName("tituloSocios");
//                document2.addParagraph("");
//
//                addEndereco(document2, poderes.getMciRepresentante());
//
//                document2.addParagraph("");
//                document2.addParagraph("Poderes").getOdfElement().setStyleName("tituloSocios");
//                document2.addParagraph("");
//
//                addPoderes(document2, empresa.getCnpj(), poderes.getMciRepresentante());
//
//                document2.addParagraph("");
//                document2.addParagraph("Anotações Cadastrais").getOdfElement().setStyleName("tituloSocios");
//                document2.addParagraph("");
//
//                criaTabelaAnotaCadastral(document2, poderes.getMciRepresentante());
//
//            }
//            String pasta = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação";
//
//            if (!new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação").exists()) {
//                new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação").mkdir();
//            }
//
//            new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação\\" + empresa.getMci()).mkdir();
//
//            document2.save("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação\\" + empresa.getMci() + "\\Relatorio-" + empresa.getNome().replaceAll("[^0-9a-zA-Z]", "") + ".odt");
//            System.out.println("Foi");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR: unable to create output file.");
        }

    }

    @Override
    public void carregarDadosEstatico() {
        try {

            carregaDadosTXT();
            DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
            DocumentTemplate template = documentTemplateFactory.getTemplate(new File("TemplatePivoExtratoSlip.odt"));

            Map model = new HashMap();
          model.put("campo1", slip.getDcAgencia().toString());
            model.put("campo1", slip.getDcAgencia().toString());
            model.put("campo2", slip.getDcNomeAgencia().toString());
            model.put("campo3", slip.getDcNRContrato().toString());
            model.put("campo4", slip.getDcPavan().toString());
            model.put("campo5", slip.getDcDadosOrigemAg().toString());
            model.put("c6", slip.getDcTipo().toString());
            model.put("campo7", slip.getDcContrato().toString());
            model.put("campo8", slip.getDcDTContratacao().toString());
            model.put("campo9", slip.getDcDTVencimento().toString());
            model.put("campo10", slip.getDcRFBacen().toString());
            model.put("campo11", slip.getDcVLROperacao().toString());
            model.put("campo12", slip.getDcNMMutuario().toString());
            model.put("campo13", slip.getDcTpMutuario().toString());
            model.put("campo14", slip.getDcCPFMutuario().toString());
            model.put("campo15", slip.getDcAGMutuario().toString());
            model.put("campo16", slip.getDcCNTMutuario().toString());
            model.put("campo17", slip.getDcEndMutuario().toString());
            model.put("campo18", slip.getDcCEP().toString());
            model.put("campo19", slip.getDcCNDSeguro().toString());
            model.put("campo20", slip.getDcCNDIOF().toString());
            model.put("campo21", slip.getDcCNDAssTec().toString());
            model.put("campo22", slip.getDcNTOperacao().toString());
            model.put("campo23", slip.getDcFinalidade().toString());
            model.put("campo24", slip.getDcPerspectiva().toString());
            model.put("campo25", slip.getDcGarantia().toString());
            model.put("campo26", slip.getDcAjuizamento().toString());
            model.put("c27", slip.getDcSolvencia());
            model.put("campo28", slip.getDcSTOperacao());
            model.put("campo29", slip.getDcMatricula());
            model.put("campo30", slip.getDcEscalaoDef());
            model.put("campo31", slip.getDcAreaPropria());
            model.put("campo32", slip.getDcAreaTerceiros());
            model.put("campo33", slip.getDcRecursosProprios());
            model.put("campo34", slip.getDcPorteMutuario());
            model.put("campo35", slip.getDcClasseMutuario());
            model.put("campo36", slip.getDcFampTipo());
            model.put("campo37", slip.getDcFampValor());
            model.put("campo38", slip.getDcFampData());
            model.put("campo39", slip.getDcDistrito());
            model.put("campo40", slip.getNrVariacao());
            model.put("campo41", slip.getStVariacao());
            model.put("campo42", slip.getEnqContabil());
            model.put("campo43", slip.getEnqContabilAnt());
            model.put("campo44", slip.getDtEnqAnt());
            model.put("campo45", slip.getDtEnqAntCL());
            model.put("campo46", slip.getDtTransfCL());
            model.put("campo47", slip.getProAgro());
            model.put("campo48", slip.getTxProAgro());
            model.put("campo49", slip.getFaseProAgro());
            model.put("campo50", slip.getRecusPropAmp());
            model.put("c51", slip.getPaCodig());
            model.put("campo52", slip.getPaTxJuros());
            model.put("campo53", slip.getPaTxCorr());
            model.put("campo54", slip.getDiaBase());
            model.put("campo55", slip.getTxJurosAnterior());
            model.put("campo56", slip.getTxCorrecaoAnterior());
            model.put("campo57", slip.getPeriodAnterior());
            model.put("campo58", slip.getDtTrocaTaxas());
            model.put("campo59", slip.getPercRebatJuros());
            model.put("campo60", slip.getPercRebatCM());
            model.put("campo61", slip.getDtIniCarencia());
            model.put("campo62", slip.getDtFimCarencia());
            model.put("campo63", slip.getPpiCodigo());
            model.put("campo64", slip.getPpiTxJuros());
            model.put("campo65", slip.getPpiTxCorrecao());
            model.put("campo66", slip.getIndDebAutomatico());
            model.put("campo67", slip.getModPagamento());
            model.put("campo68", slip.getFundoPrograma());
            model.put("campo69", slip.getVlrVariacao());
            model.put("campo70", slip.getSldCapital());
            model.put("campo71", slip.getSldTotalVariacao());
            model.put("campo72", slip.getAssSldAssEfetivo());
            model.put("campo73", slip.getAssSldAssApro());
            model.put("campo74", slip.getAssSldAssTotal());
            model.put("campo75", slip.getCmSldCorrMonEf());
            model.put("campo76", slip.getCmSldCorrMonAP().toString());
            model.put("campo77", slip.getCmSldCorrMonTotal().toString());
            model.put("campo78", slip.getJrSldJurEf().toString());
            model.put("campo79", slip.getJrSldJurAprop().toString());
            model.put("campo80", slip.getJrSldJurTotal().toString());
            model.put("campo81", slip.getPrjProjJuros().toString());
            model.put("campo82", slip.getPrjProjAcess().toString());
            model.put("campo83", slip.getPrjProjCorr().toString());
            model.put("campo84", slip.getCampFinal1().toString());
            model.put("campo85", slip.getCampFinal2().toString());
            

            template.createDocument(model, new FileOutputStream("modeloPivo.odt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null, "O arquivo está aberto.");
        } catch (IOException ex) {
            Logger.getLogger(DocSlipXer.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("mala direta escrita errado");
        } catch (DocumentTemplateException ex) {
            Logger.getLogger(DocSlipXer.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }

    @Override
    public void criarTemplate() {
    }

    @Override
    public boolean trabalhoPrecisaCarregarDados() {
        return true;
    }

    public void carregaDadosTXT() {

        try {
            File arquivo = new File(parametros[0].toString());
            FileReader reader = new FileReader(arquivo.getAbsolutePath());
            BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo.getAbsolutePath()), "Cp1252"));

            String linha;

            //                ========================= cria o diretório do arquivo a ser criado
            while ((linha = leitor.readLine()) != null) {
                if (linha.length() == 112) {
                    if (linha.substring(89, 99).matches("\\d{2}/\\d{2}/\\d{4}") && linha.substring(102, 112).matches("\\d{2}/\\d{2}/\\d{4}")) {
                        linha = metodoDeSetarCabecalho(leitor, linha);
                        break;
                    }

//                        if (linha.contains("PRODUTOS DA VARIACAO")) {
//                            linha = metodoDeSetarProdutosVariacao(leitor);
//                        }
//
//                        if (linha.contains("CRONOGRAMA DE UTILIZACAO DA VARIACAO")) {
//                            linha = setCronogramaVar(leitor);
//                        }
//
//                        if (linha.contains("CRONOGRAMA DE AMORTIZACAO DA VARIACAO")) {
//                            linha = setCronogramaAmortVar(leitor);
//                        }
//                        if (linha.contains("LANCAMENTOS DA VARIACAO")) {
//                            linha = setLancamentoVariacao(leitor);
//                        }
//
//                        System.out.println("Sai do cabeçalho do documento");
                } else {

//                        if (linha.contains("PRODUTOS DA VARIACAO")) {
//                            linha = metodoDeSetarProdutosVariacao(leitor);
//                        }
//////                        lembrar de colocar a condição de parada qualquer uma das palavras reservadas abaixo
////                        System.out.println("Linhazinha" + linha);
//                        if (linha.contains("CRONOGRAMA DE UTILIZACAO DA VARIACAO")) {
//                            linha = setCronogramaVar(leitor);
//                        }
////                        
//                        if (linha.contains("CRONOGRAMA DE AMORTIZACAO DA VARIACAO")) {
//                            linha = setCronogramaAmortVar(leitor);
//                        }
//                        if (linha.contains("LANCAMENTOS DA VARIACAO")) {
//                            linha = setLancamentoVariacao(leitor);
//                        }
////                        System.out.println("linha>>" + linha);
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String metodoDeSetarCabecalho(BufferedReader leitor, String linhaAtual) throws IOException {
        String linha = "";
        System.out.println("   ============================================                   CABEÇALHO               ====================================");
        System.out.println("   ||                               todas as informações do cabeçalho foram setadas                                          ||");
        System.out.println("   ||                                         nesta parte compeltaremos os dados do contrato                                 ||");
        System.out.println("   ||                                                                                                                        ||");
        System.out.println("   ||                                                                                                                        ||");
        System.out.println("   ===========================================================================================================================");

        int nrlinha = 3;

        slip = new DossieSlip();

        slip.setDcAgencia(linhaAtual.substring(6, 12).trim());
        slip.setDcNomeAgencia(linhaAtual.substring(13, 30).trim());
        slip.setDcNRContrato(linhaAtual.substring(31, 46).trim());
        slip.setDcPavan(linhaAtual.substring(47, 55).trim());
        slip.setDcDadosOrigemAg(linhaAtual.substring(55, 70).trim());
        slip.setDcTipo(linhaAtual.substring(70, 74).trim());
        slip.setDcContrato(linhaAtual.substring(75, 88).trim());
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
                    slip.setDcRecursosProprios(linha.substring(7, 29).trim());
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

}
