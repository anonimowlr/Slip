package br.com.bb.template.models;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateFactory;
import java.util.Collection;
import br.com.bb.conexao.InterfacePool;
import br.com.bb.conexao.Pool;
import br.com.bb.model.AnotacaoCadastral;
import br.com.bb.model.DadosProfissionais;
import br.com.bb.model.Empresa;
import br.com.bb.model.Endereco;
import br.com.bb.model.Operacoes;
import br.com.bb.model.Poderes;
import br.com.bb.model.Representante;
import br.com.bb.model.Socios;
import br.com.bb.model.command.InterfaceCommand;
import br.com.bb.model.command.ListarGetAnotacao;
import br.com.bb.model.command.ListarGetEmpresa;
import br.com.bb.model.command.ListarGetEndereco;
import br.com.bb.model.command.ListarGetOperacoes;
import br.com.bb.model.command.ListarGetPoderes;
import br.com.bb.model.command.ListarGetProfissao;
import br.com.bb.model.command.ListarGetReprentantes;
import br.com.bb.model.command.ListarGetSocio;
import br.com.bb.model.dao.AnotacaoCaDAO;
import br.com.bb.model.dao.DadosProfDAO;
import br.com.bb.model.dao.EmpresaDAO;
import br.com.bb.model.dao.EnderecoDAO;
import br.com.bb.model.dao.OperacoesDAO;
import br.com.bb.model.dao.PoderesDAO;
import br.com.bb.model.dao.RepresentanteDAO;
import br.com.bb.model.dao.SociosDAO;
import br.com.bb.suporte.TextoUtil;
import org.apache.commons.lang3.text.WordUtils;
import org.odftoolkit.odfdom.dom.element.style.StyleParagraphPropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleTextPropertiesElement;
import org.odftoolkit.odfdom.dom.style.OdfStyleFamily;
import org.odftoolkit.odfdom.dom.style.props.OdfParagraphProperties;
import org.odftoolkit.odfdom.incubator.doc.office.OdfOfficeStyles;
import org.odftoolkit.odfdom.incubator.doc.style.OdfStyle;
import org.odftoolkit.odfdom.type.Color;
import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.style.Font;
import org.odftoolkit.simple.style.StyleTypeDefinitions;
import org.odftoolkit.simple.style.StyleTypeDefinitions.HorizontalAlignmentType;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.Paragraph;

import br.com.bb.template.DocumentoOffice;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jooreports.templates.DocumentTemplateException;

public class DocEmpresa extends DocumentoOffice {

    public DocEmpresa(String mciEmpresa) {
        this.arquivo = mciEmpresa;
    }

    public DocEmpresa() {
    }

    @Override
    public void criarDocumento() {
        try {
            TextDocument document2 = (TextDocument) TextDocument.loadDocument("modeloPivo.odt");

            OdfOfficeStyles style = document2.getOrCreateDocumentStyles();
            OdfStyle titulo = style.newStyle("titulo", OdfStyleFamily.Paragraph);
            titulo.setProperty(OdfParagraphProperties.BackgroundColor, "#7696FD");
            titulo.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(12));
            titulo.setProperty(StyleTextPropertiesElement.FontFamily, "Arial");
            titulo.setProperty(StyleTextPropertiesElement.FontWeight, "bold");
            titulo.setProperty(StyleParagraphPropertiesElement.TextAlign, "left");

            OdfStyle tituloSocios = style.newStyle("tituloSocios", OdfStyleFamily.Paragraph);
            tituloSocios.setProperty(OdfParagraphProperties.BackgroundColor, "#FFFA9F");
            tituloSocios.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(12));
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
            HorizontalAlignmentType align = paragrafo.getHorizontalAlignment();
            paragrafo.setHorizontalAlignment(HorizontalAlignmentType.LEFT);
            document2.addParagraph("Operações").getOdfElement().setStyleName("titulo");
            document2.addParagraph("");
            paragrafo = document2.getParagraphByIndex(11, true);
            paragrafo.getOdfElement().setStyleName("titulo");
            
            InterfacePool pool = new Pool();
            InterfaceCommand comando = new ListarGetEmpresa(new EmpresaDAO(pool));
            Collection<Empresa> listaEmpresa = comando.executeColection(arquivo);
            Empresa empresa = new Empresa();
            for (Empresa emp : listaEmpresa) {
                empresa = emp;
            }

//            ===============================      DOCUMENTO COMEÇA AQUI          ===========================================================================
            criarTabelaEmpresaOperacoes(document2, this.arquivo,empresa.getAgenciaCadastro());

            // add table
            document2.addParagraph("");
            document2.addParagraph("Anotações Cadastrais").getOdfElement().setStyleName("titulo");
            document2.addParagraph("");
            

            
            
            criaTabelaAnotaCadastral(document2, arquivo);

            document2.addParagraph("");
            document2.addParagraph("Pessoa Física (F10)").getOdfElement().setStyleName("titulo");
            document2.addParagraph("");
            
//            ========================   representantes   ============================================================
            
           
            
            
            Paragraph paragraph = document2.getParagraphByReverseIndex(0, false);
            align = paragraph.getHorizontalAlignment();
            paragraph.setHorizontalAlignment(HorizontalAlignmentType.LEFT);

//            InterfacePool pool = new Pool();
//            InterfaceCommand comando = new ListarGetEmpresa(new EmpresaDAO(pool));
//            Collection<Empresa> listaEmpresa = comando.executeColection(arquivo);
//            Empresa empresa = new Empresa();
//            for (Empresa emp : listaEmpresa) {
//                empresa = emp;
//            }
            
            comando = new ListarGetSocio(new SociosDAO(pool));
            Collection<Socios> listaSocios = comando.executeColection(empresa.getCnpj());
            for (Socios socios : listaSocios) {
                paragraph = document2.getParagraphByReverseIndex(0, false);
                document2.addParagraph("");
                paragraph.appendTextContent("NOME DO SÓCIO: ");
                paragraph.appendTextContent(WordUtils.capitalize(socios.getNome().toLowerCase()));
                criaTabelaAnotaCadastral(document2, socios.getMci());
                document2.addParagraph("");
                
                
            }
            
            

            comando = new ListarGetPoderes(new PoderesDAO(pool));
            Collection<Poderes> listaPoderes = comando.executeColection(empresa.getCnpj());
            for (Poderes poderes : listaPoderes) {
                poderes.getMciRepresentante();

                document2.addParagraph("");
                document2.addParagraph("Sócios").getOdfElement().setStyleName("headerSocio");
                document2.addParagraph("");

                addInformaçoesSocio(document2, poderes.getMciRepresentante());

                document2.addParagraph("");
                document2.addParagraph("Endereço").getOdfElement().setStyleName("tituloSocios");
                document2.addParagraph("");

                addEndereco(document2, poderes.getMciRepresentante());

                document2.addParagraph("");
                document2.addParagraph("Poderes").getOdfElement().setStyleName("tituloSocios");
                document2.addParagraph("");

                addPoderes(document2, empresa.getCnpj(), poderes.getMciRepresentante());

                document2.addParagraph("");
                document2.addParagraph("Anotações Cadastrais").getOdfElement().setStyleName("tituloSocios");
                document2.addParagraph("");

                criaTabelaAnotaCadastral(document2, poderes.getMciRepresentante());

            }
            String pasta = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação";

            if (!new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação").exists()) {
                new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação").mkdir();
            }

            new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação\\" + empresa.getMci()).mkdir();

            document2.save("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\RelatoriosContratação\\" + empresa.getMci() + "\\Relatorio-" + empresa.getNome().replaceAll("[^0-9a-zA-Z]", "") + ".odt");
            System.out.println("Foi");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR: unable to create output file.");
        }

    }

    @Override
    public void carregarDadosEstatico() {
        try {
            InterfacePool pool = new Pool();
            InterfaceCommand comando = new ListarGetEmpresa(new EmpresaDAO(pool));
            Collection<Empresa> listaEmpresa = comando.executeColection(arquivo);
            Empresa emp = new Empresa();
            for (Empresa empresa : listaEmpresa) {
                emp = empresa;
            }

            DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
            DocumentTemplate template = documentTemplateFactory.getTemplate(new File("TemplateRelatorio.odt"));

            Map model = new HashMap();
            model.put("empresaNome", WordUtils.capitalize(emp.getNome().toLowerCase()));
            model.put("emrpesaCnpj", TextoUtil.formatarString(emp.getCnpj(), "##.###.###/####-##"));
            model.put("empresaMCI", emp.getMci());
            model.put("agenciaCadastro", WordUtils.capitalize(emp.getAgenciaCadastro().toLowerCase()));
            model.put("empresaSitContratacao", emp.getSitContratacao());

            if (emp.getTelaLoja().contains("Empresa sem loja cadastrada")) {
                model.put("empresaTelaLoja", "Empresa sem loja cadastrada"); //modificar segundo a regra de negócio
            } else {
                try {
                    model.put("empresaTelaLoja", emp.getTelaLoja().substring(345, 355).trim()); //modificar segundo a regra de negócio
                } catch (Exception e) {
                    model.put("empresaTelaLoja", "ERRO AO CADASTRAR");
                }

            }
            model.put("empresaSitLimite", emp.getLimiteCredito());
            model.put("GestorProspecRede", emp.getGestorProspecRede());
            model.put("TipoRede", emp.getTipoRede());
            model.put("empresaRiscoAtribuido", emp.getRiscoAtribuido());
            model.put("empresaGestorRede", emp.getGestorRede());
            model.put("empresaSituacao", emp.getSituaçãoRede());

            comando = new ListarGetEndereco(new EnderecoDAO(pool));
            Collection<Endereco> listaEnderecos = comando.executeColection(arquivo);
            Endereco endereco = new Endereco();
            for (Endereco end : listaEnderecos) {
                endereco = end;
            }

            model.put("empresaEnderecoTipo", WordUtils.capitalize(endereco.getTipo().toLowerCase()));
            model.put("empresaEnderecoLogradouro", WordUtils.capitalize(endereco.getLogradouro().toLowerCase()));
            model.put("empresaEnderecoComplemento", WordUtils.capitalize(endereco.getComplemento().toLowerCase()));
            model.put("empresaEnderecoDtAtual", endereco.getDt_atual());
            model.put("empresaEnderecoBairro", WordUtils.capitalize(endereco.getBairro().toLowerCase()));
            model.put("empresaCEP", endereco.getCep());
            model.put("empresaMunicipio", WordUtils.capitalize(endereco.getMunicipio().toLowerCase()));

            template.createDocument(model, new FileOutputStream("modeloPivo.odt"));

        } catch (FileNotFoundException e) {
        } catch (ParseException | IOException | DocumentTemplateException ex) {
            Logger.getLogger(DocEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void criarTemplate() {
    }

    @Override
    public boolean trabalhoPrecisaCarregarDados() {
        return true;
    }

    /**
     * Cria tabela no documento a partir do MCI do envolvido. Esta
     * funcionalidade pode ser usada tanto para empresa quanto para envolvidos
     *
     * @param document2
     * @param mciEmpresa
     */
    private void criarTabelaEmpresaOperacoes(TextDocument document2, String mciEmpresa, String agenciaCadastro) {

        Font font = document2.getParagraphByReverseIndex(0, false).getFont();
        font.setFontStyle(StyleTypeDefinitions.FontStyle.BOLD);
        font.setFamilyName("Arial Black");
        font.setSize(10);
        Font fonteConteudo = new Font("Arial", StyleTypeDefinitions.FontStyle.REGULAR, 10, Color.BLACK);

        InterfacePool pool = new Pool();
        InterfaceCommand comando = new ListarGetOperacoes(new OperacoesDAO(pool));
        Collection<Operacoes> listaOperacoes = comando.executeColection(mciEmpresa);

        Table tabelaOperacoes = document2.addTable(listaOperacoes.size() + 1, 6);
        Cell cellOperacao = tabelaOperacoes.getCellByPosition(0, 0);
        cellOperacao.setFont(font);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setStringValue("Produto");

        cellOperacao = tabelaOperacoes.getCellByPosition(1, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Nr Operação");

        cellOperacao = tabelaOperacoes.getCellByPosition(2, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Titular");

        cellOperacao = tabelaOperacoes.getCellByPosition(3, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("GS");

        cellOperacao = tabelaOperacoes.getCellByPosition(4, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Agência");

        cellOperacao = tabelaOperacoes.getCellByPosition(5, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Situação");
        
        
        /**
         * Refazer este metodo para mostrar todas as agências e contas que foram capturadas
         */
        

        int i = 1;
        for (Operacoes operacoes : listaOperacoes) {
            
            if (operacoes.getAgencia().contains(agenciaCadastro.subSequence(0, 4))) {
                cellOperacao = tabelaOperacoes.getCellByPosition(4, i);
                cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
                cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#E10606"));
                cellOperacao.setStringValue(operacoes.getAgencia());
            }
            
            tabelaOperacoes.getCellByPosition(0, i).setFont(fonteConteudo);
            tabelaOperacoes.getCellByPosition(0, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaOperacoes.getCellByPosition(0, i).setStringValue(operacoes.getProduto());
            tabelaOperacoes.getCellByPosition(1, i).setFont(fonteConteudo);
            tabelaOperacoes.getCellByPosition(1, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaOperacoes.getCellByPosition(1, i).setStringValue(operacoes.getNrOperacao());
            tabelaOperacoes.getCellByPosition(2, i).setFont(fonteConteudo);
            tabelaOperacoes.getCellByPosition(2, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaOperacoes.getCellByPosition(2, i).setStringValue(operacoes.getTitular());
            tabelaOperacoes.getCellByPosition(3, i).setFont(fonteConteudo);
            tabelaOperacoes.getCellByPosition(3, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaOperacoes.getCellByPosition(3, i).setStringValue(operacoes.getGs());
            tabelaOperacoes.getCellByPosition(4, i).setFont(fonteConteudo);
            tabelaOperacoes.getCellByPosition(4, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaOperacoes.getCellByPosition(4, i).setStringValue(operacoes.getAgencia());
            tabelaOperacoes.getCellByPosition(5, i).setFont(fonteConteudo);
            tabelaOperacoes.getCellByPosition(5, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaOperacoes.getCellByPosition(5, i).setStringValue(operacoes.getSituacao());
            i++;
        }

    }

    private void criaTabelaAnotaCadastral(TextDocument document2, String mci) {

        Font font = document2.getParagraphByReverseIndex(0, false).getFont();
        font.setFontStyle(StyleTypeDefinitions.FontStyle.BOLD);
        font.setFamilyName("Arial Black");
        font.setSize(10);

        Font fonteConteudo = new Font("Arial", StyleTypeDefinitions.FontStyle.REGULAR, 10, Color.BLACK);

        InterfacePool pool = new Pool();
        InterfaceCommand comando = new ListarGetAnotacao(new AnotacaoCaDAO(pool));
        Collection<AnotacaoCadastral> listaAnotacoes = comando.executeColection(mci);

        Table tabelaAnotacoes = document2.addTable(listaAnotacoes.size() + 1, 6);

        Cell cellOperacao = tabelaAnotacoes.getCellByPosition(0, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));

        cellOperacao.setStringValue("Anotação");

        cellOperacao = tabelaAnotacoes.getCellByPosition(1, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));

        cellOperacao.setStringValue("Tipo");

        cellOperacao = tabelaAnotacoes.getCellByPosition(2, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));

        cellOperacao.setStringValue("Data Ocorrência");

        cellOperacao = tabelaAnotacoes.getCellByPosition(3, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));

        cellOperacao.setStringValue("Responsável");

        cellOperacao = tabelaAnotacoes.getCellByPosition(4, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("Data Baixa");

        cellOperacao = tabelaAnotacoes.getCellByPosition(5, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));
        cellOperacao.setStringValue("OBS");

        int i = 1;
        for (AnotacaoCadastral anotacaoCadastral : listaAnotacoes) {

            if (anotacaoCadastral.getTipo().equals("IMPED")) {
                cellOperacao = tabelaAnotacoes.getCellByPosition(1, i);
                cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
                cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#E10606"));
                cellOperacao.setStringValue(anotacaoCadastral.getTipo());

            }

            tabelaAnotacoes.getCellByPosition(0, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(0, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(0, i).setStringValue(anotacaoCadastral.getAnotacao());
            tabelaAnotacoes.getCellByPosition(1, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(1, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(1, i).setStringValue(anotacaoCadastral.getTipo());
            tabelaAnotacoes.getCellByPosition(2, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(2, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(2, i).setStringValue(anotacaoCadastral.getDtOcorrencia());
            tabelaAnotacoes.getCellByPosition(3, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(3, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(3, i).setStringValue(anotacaoCadastral.getResponsaval());
            tabelaAnotacoes.getCellByPosition(4, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(4, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(4, i).setStringValue(anotacaoCadastral.getDtBaixa());
            tabelaAnotacoes.getCellByPosition(5, i).setFont(fonteConteudo);
            tabelaAnotacoes.getCellByPosition(5, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaAnotacoes.getCellByPosition(5, i).setStringValue(anotacaoCadastral.getObs());

            i++;

        }

    }

    private void addInformaçoesSocio(TextDocument document2, String mciSocio) {
        OdfOfficeStyles style = document2.getOrCreateDocumentStyles();
        OdfStyle normal = style.newStyle("normal", OdfStyleFamily.Paragraph);
        normal.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(10));
        normal.setProperty(StyleTextPropertiesElement.FontFamily, "Arial");
        normal.setProperty(StyleParagraphPropertiesElement.TextAlign, "left");

        InterfacePool pool = new Pool();
        InterfaceCommand comando = new ListarGetReprentantes(new RepresentanteDAO(pool));
        Collection<Representante> listaRepresentantes = comando.executeColection(mciSocio);

        for (Representante representante : listaRepresentantes) {
            comando = new ListarGetProfissao(new DadosProfDAO(pool));
            Collection<DadosProfissionais> listaProfissão = comando.executeColection(representante.getMci());
            DadosProfissionais profissao = new DadosProfissionais();
            for (DadosProfissionais dadosProfissionais : listaProfissão) {
                if (dadosProfissionais.getPricipal().equals("S")) {
                    profissao = dadosProfissionais;
                }
            }

            Paragraph paragraph = document2.getParagraphByReverseIndex(0, false);
            paragraph.getOdfElement().setStyleName("normal");
            paragraph.setHorizontalAlignment(HorizontalAlignmentType.LEFT);
            paragraph.appendTextContent("NOME: ");
            paragraph.appendTextContent(WordUtils.capitalize(representante.getNome().toLowerCase()));
            paragraph.appendTextContent("\nCPF: ");
            try {
                paragraph.appendTextContent(TextoUtil.formatarString(representante.getCpf(), "###.###.###-##"));
            } catch (ParseException ex) {
                Logger.getLogger(DocEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
            paragraph.appendTextContent("\t\tMCI: ");
            paragraph.appendTextContent(representante.getMci());
            paragraph.appendTextContent("\nRG: ");
            paragraph.appendTextContent(representante.getRg());
            paragraph.appendTextContent("\t\tÓRGÃO EXPEDITOR: ");
            paragraph.appendTextContent(WordUtils.capitalize(representante.getOrgao().toLowerCase()));
            paragraph.appendTextContent("\nNACIONALIDADE : ");
            paragraph.appendTextContent(representante.getNacionalidade());
            paragraph.appendTextContent("\t\tESTADO CIVIL: ");
            paragraph.appendTextContent(WordUtils.capitalize(representante.getEstadoCivil().toLowerCase()));
            paragraph.appendTextContent("\nOCUPAÇÃO : ");
            paragraph.appendTextContent(WordUtils.capitalize(profissao.getOcupacao().toLowerCase()));
            paragraph.appendTextContent("\t\tNATUREZA : ");
            paragraph.appendTextContent(WordUtils.capitalize(profissao.getNatOcupacao().toLowerCase()));
            paragraph.appendTextContent("\nPRINCIPAL : ");
            paragraph.appendTextContent(profissao.getPricipal());
            paragraph.appendTextContent("\t\t\tCARGO : ");
            paragraph.appendTextContent(WordUtils.capitalize(profissao.getCargo().toLowerCase()));
        }

    }

    private void addEndereco(TextDocument document2, String mciEndereco) {
        OdfOfficeStyles style = document2.getOrCreateDocumentStyles();
        OdfStyle normal = style.newStyle("normal", OdfStyleFamily.Paragraph);
        normal.setProperty(StyleTextPropertiesElement.FontSize, Integer.toString(10));
        normal.setProperty(StyleTextPropertiesElement.FontFamily, "Arial");
        normal.setProperty(StyleParagraphPropertiesElement.TextAlign, "left");

        InterfacePool pool = new Pool();
        InterfaceCommand comando = new ListarGetEndereco(new EnderecoDAO(pool));
        Collection<Endereco> listaEnderecos = comando.executeColection(mciEndereco);

        for (Endereco endereco : listaEnderecos) {
            Paragraph paragraph = document2.getParagraphByReverseIndex(0, false);
            paragraph = document2.getParagraphByReverseIndex(0, false);
            paragraph.setHorizontalAlignment(HorizontalAlignmentType.LEFT);
            paragraph.getOdfElement().setStyleName("normal");
            paragraph.appendTextContent("TIPO: ");
            paragraph.appendTextContent(WordUtils.capitalize(endereco.getTipo().toLowerCase()));
            paragraph.appendTextContent("\t\tLOGRADOURO: ");
            paragraph.appendTextContent(WordUtils.capitalize(endereco.getLogradouro().toLowerCase()));
            paragraph.appendTextContent("\nCOMPLEMENTO: ");
            paragraph.appendTextContent(WordUtils.capitalize(endereco.getComplemento().toLowerCase()));
            paragraph.appendTextContent("\nDATA DE ATUALIZAÇAO: ");
            paragraph.appendTextContent(WordUtils.capitalize(endereco.getDt_atual().toLowerCase()));
            paragraph.appendTextContent("\t\tBAIRRO: ");
            paragraph.appendTextContent(WordUtils.capitalize(endereco.getBairro().toLowerCase()));
            paragraph.appendTextContent("\nCEP: ");
            paragraph.appendTextContent(endereco.getCep());
            paragraph.appendTextContent("\t\tMUNICIPIO: ");
            paragraph.appendTextContent(WordUtils.capitalize(endereco.getMunicipio().toLowerCase()));
        }

    }

    private void addPoderes(TextDocument document2, String cnpjEmpresa, String mciRepresentante) {

        InterfacePool pool = new Pool();
        InterfaceCommand comando = new ListarGetPoderes(new PoderesDAO(pool));
        Collection<Poderes> listaPodereses = comando.executeColection(cnpjEmpresa);
        ArrayList<Poderes> listaPoderEnvolvido = new ArrayList<>();

        for (Poderes poderes : listaPodereses) {
            if (poderes.getMciRepresentante().equals(mciRepresentante)) {
                listaPoderEnvolvido.add(poderes);
            }
        }

        Font font = document2.getParagraphByReverseIndex(0, false).getFont();
        font.setFontStyle(StyleTypeDefinitions.FontStyle.BOLD);
        font.setFamilyName("Arial");
        font.setSize(10);

        Font fonteConteudo = new Font("Arial", StyleTypeDefinitions.FontStyle.REGULAR, 10, Color.BLACK);

        Table tabelaPoderes = document2.addTable(listaPoderEnvolvido.size() + 1, 5);

        Cell cellOperacao = tabelaPoderes.getCellByPosition(0, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));

        cellOperacao.setStringValue("Documento");

        cellOperacao = tabelaPoderes.getCellByPosition(1, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));

        cellOperacao.setStringValue("Descrição");

        cellOperacao = tabelaPoderes.getCellByPosition(2, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));

        cellOperacao.setStringValue("Tipo");

        cellOperacao = tabelaPoderes.getCellByPosition(3, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));

        cellOperacao.setStringValue("Nº Assinaturas");

        cellOperacao = tabelaPoderes.getCellByPosition(4, 0);
        cellOperacao.setFont(font);
        cellOperacao.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
        cellOperacao.setCellBackgroundColor(Color.toSixDigitHexRGB("#9BA3B2"));

        cellOperacao.setStringValue("Ass. Obrigatoria");

        int i = 1;
        for (Poderes poderes : listaPoderEnvolvido) {
            tabelaPoderes.getCellByPosition(0, i).setFont(fonteConteudo);
            tabelaPoderes.getCellByPosition(0, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaPoderes.getCellByPosition(0, i).setStringValue(poderes.getDocumento());
            tabelaPoderes.getCellByPosition(1, i).setFont(fonteConteudo);
            tabelaPoderes.getCellByPosition(1, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaPoderes.getCellByPosition(1, i).setStringValue(poderes.getDescPoder());
            tabelaPoderes.getCellByPosition(2, i).setFont(fonteConteudo);
            tabelaPoderes.getCellByPosition(2, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaPoderes.getCellByPosition(2, i).setStringValue(poderes.getTipo());
            tabelaPoderes.getCellByPosition(3, i).setFont(fonteConteudo);
            tabelaPoderes.getCellByPosition(3, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaPoderes.getCellByPosition(3, i).setStringValue(poderes.getNmAssinaturas());
            tabelaPoderes.getCellByPosition(4, i).setFont(fonteConteudo);
            tabelaPoderes.getCellByPosition(4, i).setHorizontalAlignment(HorizontalAlignmentType.CENTER);
            tabelaPoderes.getCellByPosition(4, i).setStringValue(poderes.getAssObrigatoria());
            i++;
        }

    }
}
