/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.view;

import org.odftoolkit.odfdom.dom.element.style.StyleParagraphPropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleTextPropertiesElement;
import org.odftoolkit.odfdom.dom.style.OdfStyleFamily;
import org.odftoolkit.odfdom.dom.style.props.OdfParagraphProperties;
import org.odftoolkit.odfdom.incubator.doc.office.OdfOfficeStyles;
import org.odftoolkit.odfdom.incubator.doc.style.OdfStyle;
import org.odftoolkit.simple.TextDocument;

import org.odftoolkit.simple.style.StyleTypeDefinitions;
import org.odftoolkit.simple.text.Paragraph;
import org.odftoolkit.simple.text.Section;
import sun.swing.SwingUtilities2;

/**
 *
 * @author F2872117
 */
public class TesteUnion {

    public static void main(String[] args) throws Exception {
        TextDocument document2 = (TextDocument) TextDocument.loadDocument("C:\\Users\\Adm\\Desktop\\RelatoriosContratação\\documento0.odt");
        TextDocument document3 = (TextDocument) TextDocument.loadDocument("C:\\Users\\Adm\\Desktop\\RelatoriosContratação\\documento1.odt");
        TextDocument document4 = (TextDocument) TextDocument.loadDocument("C:\\Users\\Adm\\Desktop\\RelatoriosContratação\\documento2.odt");
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
        paragrafo.setHorizontalAlignment(StyleTypeDefinitions.HorizontalAlignmentType.LEFT);
        
        document2.addParagraph("PRODUTOS DA VARIAÇÃO").getOdfElement().setStyleName("tituloProdutoVariacao");
        document2.addParagraph("");
         TextDocument document5 = (TextDocument) TextDocument.loadDocument("C:\\Users\\Adm\\Desktop\\RelatoriosContratação\\documento1.odt");
        document5.insertDocument(document4.get, documentPath);
        
        
        
        
        

    }
}
