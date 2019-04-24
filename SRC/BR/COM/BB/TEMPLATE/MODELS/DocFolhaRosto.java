package br.com.bb.template.models;

import br.com.bb.model.Gerente;
import br.com.bb.suporte.TextoUtil;
import br.com.bb.template.DocumentoOffice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang3.StringUtils;

public class DocFolhaRosto extends DocumentoOffice {

    public DocFolhaRosto(String mciEmpresa) {
        this.arquivo = mciEmpresa;
    }

    public DocFolhaRosto() {
    }

    @Override
    public void criarDocumento() {
    }

    @Override
    public void carregarDadosEstatico() {
        try {

            String NOMEDEPENDENCIA = (String) parametros[0];
            String PREFIXODEP = (String) parametros[1];
            String ENDERECODEP = (String) parametros[2];
            String NOMEMUTUARIO = (String) parametros[3];
            String CPFCNPJ = (String) parametros[4];
            String ENDERECOMUTUARIO = (String) parametros[5];
            String NOMEMODALIDADE = (String) parametros[6];
            String OPERACAO = (String) parametros[7];
            String DATAENCAMINHAMENTO = (String) parametros[8];
            String VALORDIVIDA = (String) parametros[9];
            String NRPROCESSO = (String) parametros[10];
            Gerente gerente = (Gerente) parametros[11];
            CPFCNPJ = StringUtils.leftPad(CPFCNPJ, 11, "0");
            CPFCNPJ = new String(CPFCNPJ.substring(CPFCNPJ.length()-11, CPFCNPJ.length()));

            DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
            DocumentTemplate template = documentTemplateFactory.getTemplate(new File("TemplateRelatorio.odt"));
//            DocumentTemplate template = documentTemplateFactory.getTemplate(new InputStream());

            Map model = new HashMap();
            model.put("assunto", " DÍVIDA  ATIVA DA UNIÃO - DOCUMENTOS ENCAMINHADOS À PGFN");
//            model.put("NOMEDEPENDENCIA", WordUtils.capitalize(NOMEDEPENDENCIA.toLowerCase())); //Caixa Baixa
            model.put("NOMEDEPENDENCIA", NOMEDEPENDENCIA.toUpperCase()); //caixa alta
            model.put("PREFIXODEP", PREFIXODEP);
//            model.put("ENDERECODEP", TextoUtil.arrumarArtigos(WordUtils.capitalize(ENDERECODEP.toLowerCase()))); //Caixa Baixa
            model.put("ENDERECODEP", ENDERECODEP.toUpperCase()); // Caixa alta 
//            model.put("NOMEMUTUARIO", TextoUtil.arrumarArtigos(WordUtils.capitalize(NOMEMUTUARIO.toLowerCase()))); //Caixa Baixa
//            model.put("NOMEMUTUARIO", NOMEMUTUARIO);
            model.put("NOMEMUTUARIO", NOMEMUTUARIO.toUpperCase()); // Caixa alta
            try {
                model.put("CPFCNPJ", TextoUtil.formatarString(CPFCNPJ, "###.###.###-##"));
            } catch (ParseException ex) {
                Logger.getLogger(DocFolhaRosto.class.getName()).log(Level.SEVERE, null, ex);
            }
//            model.put("ENDERECOMUTUARIO", TextoUtil.arrumarArtigos(WordUtils.capitalize(ENDERECOMUTUARIO.toLowerCase())));
            model.put("ENDERECOMUTUARIO", ENDERECOMUTUARIO.toUpperCase());    //Caixa Alta
//            model.put("NOMEMODALIDADE", TextoUtil.arrumarArtigos(WordUtils.capitalize(NOMEMODALIDADE.toLowerCase())));
            model.put("NOMEMODALIDADE", NOMEMODALIDADE.toUpperCase());      // Caixa Alta
            model.put("OPERACAO", OPERACAO);
            model.put("DATAENCAMINHAMENTO", DATAENCAMINHAMENTO);
            model.put("VALORDIVIDA", VALORDIVIDA);
            model.put("NRPROCESSO", NRPROCESSO);
            model.put("gententeNome", gerente.getNome());
            model.put("gerenteCargo", gerente.getCargo());
            model.put("gerenteMatricula", gerente.getMatricula());

//            template.createDocument(model, new FileOutputStream("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\Ag"+dependencia.substring(dependencia.lastIndexOf("Prefixo: ")+9, dependencia.lastIndexOf("Prefixo: ")+12)+"_operacao"+operacao.substring(operacao.length()-18, operacao.length())+"_FolhaDeRosto.odt"));
            template.createDocument(model, new FileOutputStream("G:\\INTERNA\\RISCO UNIAO\\EQUIPES DE PRODUÇAO\\RISCO10\\CAPTURARISCO\\" + System.getProperty("user.name") + "\\FlashCorreioIDA\\FolhaDeRosto\\FolhaRost_" +NOMEMUTUARIO.trim()+" - "+OPERACAO+ ".odt"));

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar os documentos");
            e.printStackTrace();
        } catch (IOException | DocumentTemplateException ex) {
            Logger.getLogger(DocFolhaRosto.class.getName()).log(Level.SEVERE, null, ex);
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
