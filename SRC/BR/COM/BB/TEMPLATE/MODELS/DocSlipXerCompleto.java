package br.com.bb.template.models;

import br.com.bb.model.CronogramaAmortizacao;
import br.com.bb.model.CronogramaUtilizacao;
import br.com.bb.model.DossieSlipCompleto;
import br.com.bb.model.LancamentoVariacao;
import br.com.bb.model.ProdutosDaVariacao;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateFactory;

import br.com.bb.template.DocumentoOffice;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jooreports.templates.DocumentTemplateException;
import org.odftoolkit.odfdom.dom.element.style.StyleParagraphPropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleTextPropertiesElement;
import org.odftoolkit.odfdom.dom.style.OdfStyleFamily;
import org.odftoolkit.odfdom.dom.style.props.OdfParagraphProperties;
import org.odftoolkit.odfdom.incubator.doc.office.OdfOfficeStyles;
import org.odftoolkit.odfdom.incubator.doc.style.OdfStyle;
import org.odftoolkit.odfdom.type.Color;
import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.style.Border;
import org.odftoolkit.simple.style.Font;
import org.odftoolkit.simple.style.StyleTypeDefinitions;
import org.odftoolkit.simple.style.StyleTypeDefinitions.HorizontalAlignmentType;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.Paragraph;

public class DocSlipXerCompleto extends DocumentoOffice {

    public DocSlipXerCompleto() {
    }

    @Override
    public void criarDocumento() {
        try {

            DossieSlipCompleto slip = (DossieSlipCompleto) parametros[0];
            int i = (int) parametros[1];

            TextDocument document2 = (TextDocument) TextDocument.loadDocument("modeloPivo.odt");
            OdfOfficeStyles style = document2.getOrCreateDocumentStyles();

            OdfStyle tituloSocios = style.newStyle("tituloProdutoVariacao", OdfStyleFamily.Paragraph);
            tituloSocios.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(8));
            tituloSocios.setProperty(StyleTextPropertiesElement.FontFamily, "Arial");
            tituloSocios.setProperty(StyleTextPropertiesElement.FontWeight, "bold");
            tituloSocios.setProperty(StyleParagraphPropertiesElement.TextAlign, "left");

            OdfStyle headerSocio = style.newStyle("headerSocio", OdfStyleFamily.Paragraph);
            headerSocio.setProperty(OdfParagraphProperties.BackgroundColor, "#FFC930");
            headerSocio.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(14));
            headerSocio.setProperty(StyleTextPropertiesElement.FontFamily, "Arial Black");
            headerSocio.setProperty(StyleTextPropertiesElement.FontWeight, "bold");
            headerSocio.setProperty(StyleParagraphPropertiesElement.TextAlign, "center");

            OdfStyle normal = style.newStyle("normal", OdfStyleFamily.Paragraph);
            normal.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(10));
            normal.setProperty(StyleTextPropertiesElement.FontFamily, "Arial");
            normal.setProperty(StyleParagraphPropertiesElement.TextAlign, "left");

            OdfStyle mensagemDocumento = style.newStyle("mensagemDocumento", OdfStyleFamily.Paragraph);
            mensagemDocumento.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(12));
            mensagemDocumento.setProperty(StyleTextPropertiesElement.FontFamily, "Arial");
            mensagemDocumento.setProperty(StyleTextPropertiesElement.FontWeight, "bold");
            mensagemDocumento.setProperty(StyleParagraphPropertiesElement.TextAlign, "center");

            Paragraph paragrafo = document2.getParagraphByReverseIndex(0, true);
//            HorizontalAlignmentType align = paragrafo.getHorizontalAlignment();
            paragrafo.setHorizontalAlignment(HorizontalAlignmentType.LEFT);
            document2.addParagraph("PRODUTOS DA VARIAÇÃO").getOdfElement().setStyleName("tituloProdutoVariacao");
            document2.addParagraph("");
//            paragrafo = document2.getParagraphByIndex(11, true);

            criaTabelaPrtodutosDaVariacao(document2, slip);
            document2.addParagraph("");
            criaTabelaCronogramaVariacao(document2, slip);
            document2.addParagraph("");
            criaTabelaCronogramaAmortizacao(document2, slip);
            document2.addParagraph("");
            criaTabelaLancamentoVariacao(document2, slip);

//
            if (!new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação").exists()) {
                new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação").mkdir();
            }
//
//            new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação\\" ;
//
            document2.save("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação\\documento" + i + ".odt");
//            System.out.println("Foi");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR: unable to create output file.");
        }

    }

    @Override
    public void carregarDadosEstatico() {
        try {

            DossieSlipCompleto slip = (DossieSlipCompleto) parametros[0];
            DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
            DocumentTemplate template = documentTemplateFactory.getTemplate(new File("TemplatePivoExtratoSlip.odt"));

            Map model = new HashMap();

            model.put("campo1", slip.getSlip().getDcAgencia());
            model.put("campo2", slip.getSlip().getDcNomeAgencia());
            model.put("campo3", slip.getSlip().getDcNRContrato());
            model.put("campo4", slip.getSlip().getDcPavan());
            model.put("campo5", slip.getSlip().getDcDadosOrigemAg());
            model.put("c6", slip.getSlip().getDcTipo());
            model.put("campo7", slip.getSlip().getDcContrato());
            model.put("campo8", slip.getSlip().getDcDTContratacao());
            model.put("campo9", slip.getSlip().getDcDTVencimento());
            model.put("campo10", slip.getSlip().getDcRFBacen());
            model.put("campo11", slip.getSlip().getDcVLROperacao());
            model.put("campo12", slip.getSlip().getDcNMMutuario());
            model.put("campo13", slip.getSlip().getDcTpMutuario());
            model.put("campo14", slip.getSlip().getDcCPFMutuario());
            model.put("campo15", slip.getSlip().getDcAGMutuario());
            model.put("campo16", slip.getSlip().getDcCNTMutuario());
            model.put("campo17", slip.getSlip().getDcEndMutuario());
            model.put("campo18", slip.getSlip().getDcCEP());
            model.put("campo19", slip.getSlip().getDcCNDSeguro());
            model.put("campo20", slip.getSlip().getDcCNDIOF());
            model.put("campo21", slip.getSlip().getDcCNDAssTec());
            model.put("campo22", slip.getSlip().getDcNTOperacao());
            model.put("campo23", slip.getSlip().getDcFinalidade());
            model.put("campo24", slip.getSlip().getDcPerspectiva());
            model.put("campo25", slip.getSlip().getDcGarantia());
            model.put("campo26", slip.getSlip().getDcAjuizamento());
            model.put("c27", slip.getSlip().getDcSolvencia());
            model.put("campo28", slip.getSlip().getDcSTOperacao());
            model.put("campo29", slip.getSlip().getDcMatricula());
            model.put("campo30", slip.getSlip().getDcEscalaoDef());
            model.put("campo31", slip.getSlip().getDcAreaPropria());
            model.put("campo32", slip.getSlip().getDcAreaTerceiros());
            model.put("campo33", slip.getSlip().getDcRecursosProprios());
            model.put("campo34", slip.getSlip().getDcPorteMutuario());
            model.put("campo35", slip.getSlip().getDcClasseMutuario());
            model.put("campo36", slip.getSlip().getDcFampTipo());
            model.put("campo37", slip.getSlip().getDcFampValor());
            model.put("campo38", slip.getSlip().getDcFampData());
            model.put("campo39", slip.getSlip().getDcDistrito());
            model.put("campo40", slip.getSlip().getNrVariacao());
            model.put("campo41", slip.getSlip().getStVariacao());
            model.put("campo42", slip.getSlip().getEnqContabil());
            model.put("campo43", slip.getSlip().getEnqContabilAnt());
            model.put("campo44", slip.getSlip().getDtEnqAnt());
            model.put("campo45", slip.getSlip().getDtEnqAntCL());
            model.put("campo46", slip.getSlip().getDtTransfCL());
            model.put("campo47", slip.getSlip().getProAgro());
            model.put("campo48", slip.getSlip().getTxProAgro());
            model.put("campo49", slip.getSlip().getFaseProAgro());
            model.put("campo50", slip.getSlip().getRecusPropAmp());
            model.put("c51", slip.getSlip().getPaCodig());
            model.put("campo52", slip.getSlip().getPaTxJuros());
            model.put("campo53", slip.getSlip().getPaTxCorr());
            model.put("campo54", slip.getSlip().getDiaBase());
            model.put("campo55", slip.getSlip().getTxJurosAnterior());
            model.put("campo56", slip.getSlip().getTxCorrecaoAnterior());
            model.put("campo57", slip.getSlip().getPeriodAnterior());
            model.put("campo58", slip.getSlip().getDtTrocaTaxas());
            model.put("campo59", slip.getSlip().getPercRebatJuros());
            model.put("campo60", slip.getSlip().getPercRebatCM());
            model.put("campo61", slip.getSlip().getDtIniCarencia());
            model.put("campo62", slip.getSlip().getDtFimCarencia());
            model.put("campo63", slip.getSlip().getPpiCodigo());
            model.put("campo64", slip.getSlip().getPpiTxJuros());
            model.put("campo65", slip.getSlip().getPpiTxCorrecao());
            model.put("campo66", slip.getSlip().getIndDebAutomatico());
            model.put("campo67", slip.getSlip().getModPagamento());
            model.put("campo68", slip.getSlip().getFundoPrograma());
            model.put("campo69", slip.getSlip().getVlrVariacao());
            model.put("campo70", slip.getSlip().getSldCapital());
            model.put("campo71", slip.getSlip().getSldTotalVariacao());
            model.put("campo72", slip.getSlip().getAssSldAssEfetivo());
            model.put("campo73", slip.getSlip().getAssSldAssApro());
            model.put("campo74", slip.getSlip().getAssSldAssTotal());
            model.put("campo75", slip.getSlip().getCmSldCorrMonEf());
            model.put("campo76", slip.getSlip().getCmSldCorrMonAP());
            model.put("campo77", slip.getSlip().getCmSldCorrMonTotal());
            model.put("campo78", slip.getSlip().getJrSldJurEf());
            model.put("campo79", slip.getSlip().getJrSldJurAprop());
            model.put("campo80", slip.getSlip().getJrSldJurTotal());
            model.put("campo81", slip.getSlip().getPrjProjJuros());
            model.put("campo82", slip.getSlip().getPrjProjAcess());
            model.put("campo83", slip.getSlip().getPrjProjCorr());
            model.put("campo84", slip.getSlip().getCampFinal1());
            model.put("campo85", slip.getSlip().getCampFinal2());
            
            
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

    private void criaTabelaPrtodutosDaVariacao(TextDocument document2, DossieSlipCompleto slip) {

        Font font = document2.getParagraphByReverseIndex(0, false).getFont();
        font.setFontStyle(StyleTypeDefinitions.FontStyle.BOLD);
        font.setFamilyName("Arial Black");
        font.setSize(7);

        Font fonteConteudo = new Font("Arial", StyleTypeDefinitions.FontStyle.REGULAR, 6, Color.BLACK);

        Table tabelaAnotacoes = document2.addTable(slip.getListaProdutosDaVariacaos().size() + 1, 7);

        Cell cellOperacao = tabelaAnotacoes.getCellByPosition(0, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);

//        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Código");
        cellOperacao = tabelaAnotacoes.getCellByPosition(1, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
//        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Insumo");

        cellOperacao = tabelaAnotacoes.getCellByPosition(2, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
//        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Área");

        cellOperacao = tabelaAnotacoes.getCellByPosition(3, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
//        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Nome");

        cellOperacao = tabelaAnotacoes.getCellByPosition(4, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
//        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Quantidade");

        cellOperacao = tabelaAnotacoes.getCellByPosition(5, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
//        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Previsão de Safra");

        cellOperacao = tabelaAnotacoes.getCellByPosition(6, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
//        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Valor do item financiado");

        int i = 1;

        for (ProdutosDaVariacao produtosDaVariacao : slip.getListaProdutosDaVariacaos()) {

            tabelaAnotacoes.getCellByPosition(0, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(0, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(0, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(0, i).setStringValue(produtosDaVariacao.getCodigo());

            tabelaAnotacoes.getCellByPosition(1, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(1, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(1, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(1, i).setStringValue(produtosDaVariacao.getInsumo());

            tabelaAnotacoes.getCellByPosition(2, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(2, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(2, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(2, i).setStringValue(produtosDaVariacao.getArea());

            tabelaAnotacoes.getCellByPosition(3, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(3, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(3, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(3, i).setStringValue(produtosDaVariacao.getNome());

            tabelaAnotacoes.getCellByPosition(4, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(4, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(4, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(4, i).setStringValue(produtosDaVariacao.getQuantidade());

            tabelaAnotacoes.getCellByPosition(5, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(5, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(5, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(5, i).setStringValue(produtosDaVariacao.getPrevisaoSafra());

            tabelaAnotacoes.getCellByPosition(6, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(6, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(6, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(6, i).setStringValue(produtosDaVariacao.getVlrItemFinaciado());

            i++;

        }

    }

    private void criaTabelaCronogramaVariacao(TextDocument document2, DossieSlipCompleto slip) {

        document2.addParagraph("CRONOGRAMA DE UTILIZACAO DA VARIACAO").getOdfElement().setStyleName("tituloProdutoVariacao");

        Font font = document2.getParagraphByReverseIndex(0, false).getFont();
        font.setFontStyle(StyleTypeDefinitions.FontStyle.BOLD);
        font.setFamilyName("Arial Black");
        font.setSize(7);

        Font fonteConteudo = new Font("Arial", StyleTypeDefinitions.FontStyle.REGULAR, 6, Color.BLACK);

        Table tabelaAnotacoes = document2.addTable(slip.getListaProdutosDaVariacaos().size() + 1, 5);

        Cell cellOperacao = tabelaAnotacoes.getCellByPosition(0, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Data previsão da parcela");
        cellOperacao = tabelaAnotacoes.getCellByPosition(1, 0);

        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Valor previsto da Parcela");
        cellOperacao = tabelaAnotacoes.getCellByPosition(2, 0);

        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Valor realizado da parcela");
        cellOperacao = tabelaAnotacoes.getCellByPosition(3, 0);

        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Valor a realizar da parcela");

        cellOperacao = tabelaAnotacoes.getCellByPosition(4, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Equiva. prod.");

        int i = 1;

        for (CronogramaUtilizacao cronogramaUtilizacao : slip.getListaCronogramaUtilizacaos()) {

//            if (anotacaoCadastral.getTipo().equals("IMPED")) {
//                cellOperacao = tabelaAnotacoes.getCellByPosition(1, i);
//                cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
//                cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#E10606"));
//                cellOperacao.setStringValue(anotacaoCadastral.getTipo());
//
//            }
            tabelaAnotacoes.getCellByPosition(0, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(0, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(0, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(0, i).setStringValue(cronogramaUtilizacao.getDtPrevisaoParcela());

            tabelaAnotacoes.getCellByPosition(1, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(1, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(1, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(1, i).setStringValue(cronogramaUtilizacao.getVlrPrevistoParcela());

            tabelaAnotacoes.getCellByPosition(2, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(2, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(2, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(2, i).setStringValue(cronogramaUtilizacao.getVlrRealizadoParcela());

            tabelaAnotacoes.getCellByPosition(3, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(3, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(3, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(3, i).setStringValue(cronogramaUtilizacao.getVlrRealizarParcela());

            tabelaAnotacoes.getCellByPosition(4, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(4, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(4, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(4, i).setStringValue(cronogramaUtilizacao.getEquivalProduto());

            i++;

        }

    }

    private void criaTabelaCronogramaAmortizacao(TextDocument document2, DossieSlipCompleto slip) {

        document2.addParagraph("CRONOGRAMA DE AMORTIZACAO DA VARIACAO").getOdfElement().setStyleName("tituloProdutoVariacao");
        Font font = document2.getParagraphByReverseIndex(0, false).getFont();
        font.setFontStyle(StyleTypeDefinitions.FontStyle.BOLD);
        font.setFamilyName("Arial Black");
        font.setSize(7);

        Font fonteConteudo = new Font("Arial", StyleTypeDefinitions.FontStyle.REGULAR, 6, Color.BLACK);

        Table tabelaAnotacoes = document2.addTable(slip.getListaProdutosDaVariacaos().size() + 1, 5);

        Cell cellOperacao = tabelaAnotacoes.getCellByPosition(0, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Data prevista da parcela");
        cellOperacao = tabelaAnotacoes.getCellByPosition(1, 0);

        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Valor previsto da Parcela");
        cellOperacao = tabelaAnotacoes.getCellByPosition(2, 0);

        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Valor realizado da parcela");
        cellOperacao = tabelaAnotacoes.getCellByPosition(3, 0);

        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Valor a realizar da parcela Equiva. prod.");

        cellOperacao = tabelaAnotacoes.getCellByPosition(4, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Prorrogacao");

        int i = 1;

        for (CronogramaAmortizacao cronogramaAmortizacao : slip.getListaCronogramaAmortizacaos()) {

            tabelaAnotacoes.getCellByPosition(0, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(0, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(0, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(0, i).setStringValue(cronogramaAmortizacao.getDtPrevistaParcela());

            tabelaAnotacoes.getCellByPosition(1, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(1, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(1, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(1, i).setStringValue(cronogramaAmortizacao.getVlrPrevisto());

            tabelaAnotacoes.getCellByPosition(2, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(2, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(2, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(2, i).setStringValue(cronogramaAmortizacao.getVlrRealizado());

            tabelaAnotacoes.getCellByPosition(3, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(3, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(3, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(3, i).setStringValue(cronogramaAmortizacao.getVlrParcelaEquiv());

            tabelaAnotacoes.getCellByPosition(4, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(4, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(4, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(4, i).setStringValue(cronogramaAmortizacao.getProrrogacao());
            
            i++;

        }

    }

    private void criaTabelaLancamentoVariacao(TextDocument document2, DossieSlipCompleto slip) {

        document2.addParagraph("LANCAMENTOS DA VARIACAO").getOdfElement().setStyleName("tituloProdutoVariacao");
        Font font = document2.getParagraphByReverseIndex(0, false).getFont();
        font.setFontStyle(StyleTypeDefinitions.FontStyle.BOLD);
        font.setFamilyName("Arial Black");
        font.setSize(7);

        Font fonteConteudo = new Font("Arial", StyleTypeDefinitions.FontStyle.REGULAR, 6, Color.BLACK);

        Table tabelaAnotacoes = document2.addTable(slip.getListaProdutosDaVariacaos().size() + 1, 6);

        Cell cellOperacao = tabelaAnotacoes.getCellByPosition(0, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Lancamento");
        cellOperacao = tabelaAnotacoes.getCellByPosition(1, 0);

        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Valorizacao");
        cellOperacao = tabelaAnotacoes.getCellByPosition(2, 0);

        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Historico");
        cellOperacao = tabelaAnotacoes.getCellByPosition(3, 0);

        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Literal historico");

        cellOperacao = tabelaAnotacoes.getCellByPosition(4, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Valor do lancamento d/c");

        cellOperacao = tabelaAnotacoes.getCellByPosition(5, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
        cellOperacao.setStringValue("Saldo na data");

        int i = 1;

        for (LancamentoVariacao lancamentoVariacao : slip.getListaLancamentoVariacaos()) {

            tabelaAnotacoes.getCellByPosition(0, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(0, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(0, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(0, i).setStringValue(lancamentoVariacao.getLancamento());

            tabelaAnotacoes.getCellByPosition(1, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(1, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(1, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(1, i).setStringValue(lancamentoVariacao.getValorizacao());

            tabelaAnotacoes.getCellByPosition(2, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(2, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(2, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(2, i).setStringValue(lancamentoVariacao.getHistorico());

            tabelaAnotacoes.getCellByPosition(3, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(3, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(3, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(3, i).setStringValue(lancamentoVariacao.getLiteralHistorico());

            tabelaAnotacoes.getCellByPosition(4, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(4, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(4, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(4, i).setStringValue(lancamentoVariacao.getValorizacao());
            
            tabelaAnotacoes.getCellByPosition(5, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(5, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(5, i).setBorders(StyleTypeDefinitions.CellBordersType.NONE, Border.NONE);
            tabelaAnotacoes.getCellByPosition(5, i).setStringValue(lancamentoVariacao.getSaldoData());
            

            i++;

        }

    }

}
