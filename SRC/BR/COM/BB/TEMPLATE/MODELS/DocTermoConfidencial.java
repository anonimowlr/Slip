package br.com.bb.template.models;

import br.com.bb.model.Gerente;
import br.com.bb.model.Procuradoria;
import br.com.bb.template.DocumentoOffice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;

public class DocTermoConfidencial extends DocumentoOffice {

    public DocTermoConfidencial(String mciEmpresa) {
        this.arquivo = mciEmpresa;
    }

    public DocTermoConfidencial() {
    }

    @Override
    public void criarDocumento() {
    }

    @Override
    public void carregarDadosEstatico() {
        try {
            
            String numProcesso = (String) parametros[0];
            String numOperacao = (String) parametros[1];
            String cpfcnpj = (String) parametros[2];
            String devedorPrincipal = (String) parametros[3];
            Procuradoria procuradoria = (Procuradoria)parametros[4];
            Gerente gerente = (Gerente) parametros[5];
            String gsv = (String) parametros[6];
            DateFormat dataFormatada = new SimpleDateFormat("dd-MMM-YYYY");
            String data = dataFormatada.format(new Date());

            DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
            DocumentTemplate template = documentTemplateFactory.getTemplate(new File("termoTemplate.odt"));

            Map model = new HashMap();
            model.put("gsv", gsv);
            model.put("gententeNome", gerente.getNome());
            model.put("gerenteCargo", gerente.getCargo());
            model.put("procurador", procuradoria.getProcurador());
            model.put("cargo", procuradoria.getCargo());
            model.put("procuradoria", procuradoria.getProcuradoria());
            model.put("sigla", procuradoria.getSigla());
            model.put("endereco", procuradoria.getEndereco());
            model.put("cidade", procuradoria.getCidade());
            model.put("UF", procuradoria.getUf());
            model.put("cep", procuradoria.getCep());
            model.put("cep", procuradoria.getCep());
            
//            template.createDocument(model, new FileOutputStream("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\"+devedorPrincipal+"_"+"TermoConfidencial.odt"));
            template.createDocument(model, new FileOutputStream("G:\\INTERNA\\RISCO UNIAO\\EQUIPES DE PRODUÇAO\\RISCO10\\CAPTURARISCO\\"+ System.getProperty("user.name")+"\\FlashCorreioIDA\\TermoConfidencial.odt"));

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar os documentos");
        } catch (IOException | DocumentTemplateException ex) {
            Logger.getLogger(DocTermoConfidencial.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar os documentos");
        }

    }

    @Override
    public void criarTemplate() {
    }

    @Override
    public boolean trabalhoPrecisaCarregarDados() {
        return true;
    }
    


   

    
}
