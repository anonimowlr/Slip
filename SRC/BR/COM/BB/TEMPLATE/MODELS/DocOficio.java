package br.com.bb.template.models;

import br.com.bb.model.Gerente;
import br.com.bb.model.Procuradoria;
import br.com.bb.suporte.TextoUtil;
import br.com.bb.template.DocumentoOffice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class DocOficio extends DocumentoOffice {

    public DocOficio(String mciEmpresa) {
        this.arquivo = mciEmpresa;
    }

    public DocOficio() {
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
            Procuradoria procuradoria = (Procuradoria) parametros[4];
            Gerente gerente = (Gerente) parametros[5];
            String gsv = (String) parametros[6];
            String nomeRoteiro = (String) parametros[7];
            cpfcnpj = StringUtils.leftPad(cpfcnpj, 11, "0");
            System.out.println(">"+cpfcnpj.length());
            System.out.println(">"+cpfcnpj.substring(cpfcnpj.length()-11, cpfcnpj.length()));
            cpfcnpj = new String(cpfcnpj.substring(cpfcnpj.length()-11, cpfcnpj.length()));
            

            Calendar c = Calendar.getInstance();
            Date data = c.getTime();
            DateFormat dfmt = new SimpleDateFormat("d 'de' MMMM 'de' yyyy");
            System.out.println(">" + dfmt.format(data));

            DateFormat dataFormatada = new SimpleDateFormat("d 'de' MMM 'de' YYYY");
            Calendar calendario = Calendar.getInstance();
            Date data1 = calendario.getTime();

            DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
            DocumentTemplate template = documentTemplateFactory.getTemplate(new File("oficioModel.odt"));

            Map model = new HashMap();
            model.put("data", dfmt.format(data));
            model.put("gsv", String.valueOf(calendario.get(Calendar.YEAR)) + "/" + gsv);
            model.put("NRPROCESSO", numProcesso);
            model.put("OPERACAO", numOperacao);
            try {
                model.put("CPFCNPJ", TextoUtil.formatarString(cpfcnpj, "###.###.###-##"));
            } catch (ParseException ex) {
                Logger.getLogger(DocOficio.class.getName()).log(Level.SEVERE, null, ex);
            }

            model.put("NOMEMUTUARIO", TextoUtil.arrumarArtigos(WordUtils.capitalize(devedorPrincipal.toLowerCase())));
            model.put("gententeNome", gerente.getNome());
            model.put("gerenteCargo", gerente.getCargo());
            model.put("procurador", procuradoria.getProcurador());
            model.put("cargo", TextoUtil.arrumarArtigos(WordUtils.capitalize(procuradoria.getCargo().toLowerCase())));
            model.put("procuradoria", TextoUtil.arrumarArtigos(WordUtils.capitalize(procuradoria.getProcuradoria().toLowerCase())));
            model.put("sigla", procuradoria.getSigla());
            model.put("endereco", procuradoria.getEndereco());
            model.put("cidade", procuradoria.getCidade());
            model.put("UF", procuradoria.getUf());
            model.put("cep", procuradoria.getCep());
            model.put("NOMEMODALIDADE", nomeRoteiro.toUpperCase());
            
//            model.put("telefone", procuradoria.getTelefone() + " / " + procuradoria.getFax());

//            template.createDocument(model, new FileOutputStream("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\" + devedorPrincipal + "_" + numOperacao.substring(0, 9).replaceAll("[^0-9]", "") + "_" + numProcesso + "Oficio.odt"));
            template.createDocument(model, new FileOutputStream("G:\\INTERNA\\RISCO UNIAO\\EQUIPES DE PRODUÇAO\\RISCO10\\CAPTURARISCO\\"+ System.getProperty("user.name")+"\\FlashCorreioIDA\\Oficios\\Oficio_" + devedorPrincipal.trim() +" - "+numOperacao+  ".odt"));
//            JOptionPane.showMessageDialog(null, "Documentos gerados na área de trabalho");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar os documentos");
        } catch (IOException | DocumentTemplateException ex) {
            Logger.getLogger(DocOficio.class.getName()).log(Level.SEVERE, null, ex);
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
