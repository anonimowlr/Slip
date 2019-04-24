package br.com.bb.template.models;

import br.com.bb.conexao.InterfacePoolBase;
import br.com.bb.conexao.PoolBase;
import br.com.bb.model.ARDigital;
import br.com.bb.model.Envolvido2;
import br.com.bb.model.Papeleta2;
import br.com.bb.model.command.AtualizarEnvolvido2;
import br.com.bb.model.command.AtualizarPapeleta2;
import br.com.bb.model.command.InterfaceCommand;
import br.com.bb.model.command.ListarGetARDigital;
import br.com.bb.model.command.ListarGetPapeleta2NRUnico;
import br.com.bb.model.dao.ARDigitalDAO;
import br.com.bb.model.dao.Envolvido2DAO;
import br.com.bb.model.dao.Papeleta2DAO;
import br.com.bb.sisbb.Sisbb;
import br.com.bb.suporte.EscrevePapeletaXML;
import br.com.bb.suporte.TextoUtil;
import br.com.bb.template.DocumentoCorreioSisbb;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

public class DocCorreioEdital extends DocumentoCorreioSisbb {

    public DocCorreioEdital(String mciEmpresa) {
        this.arquivo = mciEmpresa;
    }

    public DocCorreioEdital() {
    }

    @Override
    public void criarDocumento() {
    }

    @Override
    public void carregarDadosEstatico() {
        try {

            Sisbb sis = (Sisbb) parametros[0];
            String tituloCorreio = (String) parametros[1];

            ArrayList<Object> listDados = new ArrayList<>(Arrays.asList(parametros[2]));
            ArrayList<Papeleta2> listaPapeleta = (ArrayList<Papeleta2>) listDados.get(0);
            ArrayList<Envolvido2> listaEnvolvidos = new ArrayList<>();
            ArrayList<Envolvido2> listaEnviados = new ArrayList<>();

            for (Papeleta2 papeleta2 : listaPapeleta) {
                listaEnvolvidos.addAll(papeleta2.getListaEnvolvidos());
            }
            int totalEnvolvidos = listaEnvolvidos.size();
            int contador = 0;
            int totalPapeleta = listaPapeleta.size();

            System.out.println("" + totalEnvolvidos);
            System.out.println("" + (totalEnvolvidos / 8));
            System.out.println("" + (totalEnvolvidos % 8));

            for (int i = 0; i < (totalEnvolvidos / 8); i++) {

//                sis.set("EDITAL - DAU - " + listaPapeleta.get(0).getTIPONOTIFICACAO(), 4, 26);
                sis.set(tituloCorreio, 4, 26);

                Papeleta2 papeletaCorreio = getPapeletaFromArrayList(listaPapeleta, listaEnvolvidos.get(i).getNRUNICOOPERACAO());
                sis.set("DE  :1903-CENOP BRASÍLIA-DF/OPERAÇÕES RISCO UNIÃO DF #ULTRACONFIDENCIAL", 7, 9);
                sis.set("PARA: 1903-CENOP BRASÍLIA / SERVIÇOS ESSPECIALIZADOS DF", 8, 9);

                sis.set("NOTIFICAÇÃO POR EDITAL - OPERAÇÃO COM RISCO DA UNIÃO - Solicitamos,", 10, 9);
                sis.set("publicar no Diário Oficial da União - DOU e no jornal da respecti-", 11, 9);
                sis.set("va cidade, as comunicações de vencimento de dívida, inscrição", 12, 9);
                sis.set("no CADIN e de alteração de credor, na forma de Portaria MINIFAZ nº 202,", 13, 9);
                sis.set("de 21.07.2004, aos devedores abaixo relacionados, tendo em vista a", 14, 9);
                sis.set("não localização dos mesmos nos endereços declarados junto ao Banco.", 15, 9);

                sis.set("Produto", 17, 9);
                sis.set("( ) Crédito Rural Fundiário", 18, 9);
                sis.set("( ) Funcafé – Dação em Pagamento", 19, 9);
                sis.set("( ) Pesa", 20, 9);
                sis.set("( ) Pesa-Cacau", 21, 9);
                sis.set("( ) Pronaf", 22, 9);
                sis.set("( ) Recoop", 23, 9);
                sis.set("( ) Securitização", 24, 9);

//                sis.set("1) preencher para todos os produtos:", 24, 9);
//                sis.set("    a) mutuário falecido: ___ (“sim” ou “não”)", 24, 9);
//                sis.set("    b) no caso de mutuário falecido (“sim”):", 24, 9);
//                sis.set("        Herdeiros identificados e localizados:", 24, 9);
//                sis.set("        (“sim”, “não” ou “XXX”, se não for o caso)", 24, 9);
//                
//                
//                sis.set("2) preencher no caso de “Crédito Rural Fundiário”:", 24, 9);
//                sis.set("    a) mutuário notificado por AR: ___ (“sim” ou “não”)", 24, 9);
//                sis.set("    b) no caso de mutuário notificado por AR (“sim”):", 24, 9);
//                sis.set("        mutuário localizado: ___ (“sim” ou “não”)", 24, 9);
                for (int j = 0; j < 8; j++) {
                    sis.f8();
//                    pesquisa qual papeleta trata-se esse Envolvido
                    Papeleta2 papeleta2 = getPapeletaFromArrayList(listaPapeleta, listaEnvolvidos.get(contador + j).getNRUNICOOPERACAO());
                    sis.set("Nome: " + listaEnvolvidos.get(contador + j).getNOMEMUTUARIO(), 9, 9);
                    sis.set("CPF/CNPJ    : " + TextoUtil.formatarString(listaEnvolvidos.get(contador + j).getCPFCNPJ(), "###.###.###.###-##"), 10, 9);
                    sis.set("PARTICIPAÇAO: " + listaEnvolvidos.get(contador + j).getPARTICIPACAO(), 11, 9);
                    sis.set("Nº OPERACÃO : " + listaEnvolvidos.get(contador + j).getOPERACAO(), 12, 9);
                    sis.set("PREFIXO DA DEPENDÊNCIA : " + listaEnvolvidos.get(contador + j).getPREFIXODEP(), 13, 9);
                    sis.set("MUNICIPIO UF : " + papeleta2.getMUNICIPIOUF(), 14, 9);
                    sis.set("TIPO : " + listaEnvolvidos.get(contador + j).getCODMUTUARIO(), 15, 9);
                    sis.set("DATA DA CONTRATAÇÃO : " + papeleta2.getDATACONTRATACAO(), 16, 9);
                    sis.set("Nº UNICO BB : " + listaEnvolvidos.get(contador + j).getNRUNICOOPERACAO(), 17, 9);
                    sis.set("VALOR DA OPERACAO : " + papeleta2.getFORMANOTVENCANTECIPADO(), 18, 9);
                    sis.set("TIPO DE INADIMPLÊNCIA : " + papeleta2.getTIPOINADIMPLENCIA(), 19, 9);
                    sis.set("GSV : " + papeleta2.getGSV(), 20, 9);
                    sis.set("-------------------------------------------", 21, 9);
                    sis.setCursor(20, 9);
                    listaEnviados.add(listaEnvolvidos.get(contador + j));

                }
                System.out.println(">Terminei por aqui de escrever");
                System.out.println(sis.get(23, 3, 80));

                sis.f2();
                System.out.println(sis.get(23, 3, 80));
                sis.f3();

                sis.waitSystem();
                sis.waitFor("COEM0015", 1, 3);
                sis.set("01", 21, 18);
                sis.enter();
                sis.waitFor("COEM1010", 1, 3);
                contador = contador + 8;

            }

            if ((totalEnvolvidos % 8) != 0) {

                sis.set(tituloCorreio, 4, 26);
                sis.set("DE  :1903-CENOP BRASÍLIA-DF/OPERAÇÕES RISCO UNIÃO DF #ULTRACONFIDENCIAL", 7, 9);
                sis.set("PARA: 1903-CENOP BRASÍLIA / SERVIÇOS ESPECIALIZADOS DF", 8, 9);

                sis.set("NOTIFICAÇÃO POR EDITAL - OPERAÇÃO COM RISCO DA UNIÃO - Solicitamos,", 10, 9);
                sis.set("publicar no Diário Oficial da União - DOU e no jornal da respecti-", 11, 9);
                sis.set("va cidade, as comunicações de vencimento de dívida, inscrição", 12, 9);
                sis.set("no CADIN e de alteração de credor, na forma de Portaria MINIFAZ nº 202,", 13, 9);
                sis.set("de 21.07.2004, aos devedores abaixo relacionados, tendo em vista a", 14, 9);
                sis.set("não localização dos mesmos nos endereços declarados junto ao Banco.", 15, 9);


                for (int j = 0; ((j < 8) && (j < (totalEnvolvidos % 8))); j++) {
                    sis.f8();
//                    pesquisa qual papeleta trata-se esse Envolvido
                    Papeleta2 papeleta2 = getPapeletaFromArrayList(listaPapeleta, listaEnvolvidos.get(totalEnvolvidos - j - 1).getNRUNICOOPERACAO());
                    String cpfcnpj = papeleta2.getCPFCNPJ();
                    cpfcnpj = StringUtils.leftPad(cpfcnpj, 11, "0");
                    cpfcnpj = new String(cpfcnpj.substring(cpfcnpj.length() - 11, cpfcnpj.length()));

                    sis.set("Nome: " + listaEnvolvidos.get(totalEnvolvidos - j - 1).getNOMEMUTUARIO(), 9, 9);
                    try {
                        sis.set("CPF/CNPJ    : " + TextoUtil.formatarString(cpfcnpj, "###.###.###-##"), 10, 9);
                    } catch (ParseException ex) {
                        Logger.getLogger(DocOficio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    sis.set("PARTICIPAÇAO: " + listaEnvolvidos.get(totalEnvolvidos - j - 1).getPARTICIPACAO(), 11, 9);
                    sis.set("Nº OPERACÃO : " + listaEnvolvidos.get(totalEnvolvidos - j - 1).getOPERACAO(), 12, 9);
                    sis.set("PREFIXO DA DEPENDÊNCIA : " + listaEnvolvidos.get(totalEnvolvidos - j - 1).getPREFIXODEP(), 13, 9);
                    sis.set("MUNICIPIO UF : " + papeleta2.getMUNICIPIOUF(), 14, 9);
                    sis.set("TIPO : " + listaEnvolvidos.get(totalEnvolvidos - j - 1).getCODMUTUARIO(), 15, 9);
                    sis.set("DATA DA CONTRATAÇÃO : " + papeleta2.getDATACONTRATACAO(), 16, 9);
                    sis.set("Nº UNICO BB : " + listaEnvolvidos.get(totalEnvolvidos - j - 1).getNRUNICOOPERACAO(), 17, 9);
                    sis.set("VALOR DA OPERACAO : " + papeleta2.getFORMANOTVENCANTECIPADO(), 18, 9);
                    sis.set("TIPO DE INADIMPLÊNCIA : " + papeleta2.getTIPOINADIMPLENCIA(), 19, 9);
                    sis.set("GSV : " + papeleta2.getGSV(), 20, 9);
                    sis.set("-------------------------------------------", 21, 9);
                    sis.setCursor(20, 9);
                    listaEnviados.add(listaEnvolvidos.get(totalEnvolvidos - j - 1));

                }

//                posso fazer uma função aqui para preencher os valores do correio
                System.out.println(">Terminei por aqui de escrever");
                System.out.println(sis.get(23, 3, 80));
                Papeleta2 papeleta2 = getPapeletaFromArrayList(listaPapeleta, listaEnvolvidos.get(0).getNRUNICOOPERACAO());
                cadastraAnexoIN(sis, papeleta2);

                sis.f2();
                System.out.println(sis.get(23, 3, 80));
                sis.f3();

                sis.waitSystem();
                sis.waitFor("COEM0015", 1, 3);

            }

            for (Papeleta2 papeleta2 : listaPapeleta) {
                try {
                    InterfacePoolBase pool = new PoolBase();
                    InterfaceCommand comando = new AtualizarPapeleta2(new Papeleta2DAO(pool));
                    papeleta2.setNOTIFICAR(false);
                    comando.execute(papeleta2);
                } catch (Exception e) {
                }
            }

            for (Envolvido2 envolvido2 : listaEnvolvidos) {
                try {
                    InterfacePoolBase pool = new PoolBase();
                    InterfaceCommand comando = new AtualizarEnvolvido2(new Envolvido2DAO(pool));
                    envolvido2.setNOTIFICAR(false);
                    comando.execute(envolvido2);
                } catch (Exception e) {
                }
            }

            sis.f3();
            sis.wait();
            sis.f5();
            sis.estabiliza();
            sis.f3();
            sis.f5();
            sis.estabiliza();
            sis.wait();
            sis.f3();
            sis.f5();

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro ao gerar o Correio SISBB!");
            e.printStackTrace();
        }

        System.out.println(">>>Acabouzinho");

    }

    @Override
    public void criarTemplate() {
    }

    @Override
    public boolean trabalhoPrecisaCarregarDados() {
        return true;
    }

    public Papeleta2 getPapeletaFromArrayList(ArrayList<Papeleta2> listaPapeleta, String campoPesquisa) {
        Papeleta2 papeleta2 = new Papeleta2();
        for (Papeleta2 papeleta : listaPapeleta) {
            if (papeleta.getNRUNICOOPERACAO().equals(campoPesquisa)) {
                papeleta2 = papeleta;
            }

        }
        return papeleta2;
    }

    void cadastraAnexoIN(Sisbb sis, Papeleta2 papeleta2) {
        InterfacePoolBase pool = new PoolBase();
        InterfaceCommand comando = new ListarGetARDigital(new ARDigitalDAO(pool));

        while (!sis.get(3, 80, 1).equals("1")) {
            sis.f7();
        }

        sis.f11();
        sis.set("i20", 16, 3);
        sis.enter();
        sis.f11();
        sis.setCursor(15, 9);
        sis.f8();

        sis.set("Produto :", 9, 9);
        sis.set("( ) Crédito Rural Fundiário", 10, 9);
        sis.set("( ) Funcafé – Dação em Pagamento", 11, 9);
        sis.set("( ) Pesa", 12, 9);
        sis.set("( ) Pesa-Cacau", 13, 9);
        sis.set("( ) Pronaf", 14, 9);
        sis.set("( ) Recoop", 15, 9);
        sis.set("( ) Securitização", 16, 9);

        if (papeleta2.getNOMEMODALIDADE().contains("PRONAF")) {
            sis.set("                                   ", 14, 9);
            sis.set("(X) Pronaf", 14, 9);

        } else {
            if (papeleta2.getNOMEMODALIDADE().contains("PESA CACAU")) {
                sis.set("                                   ", 13, 9);
                sis.set("(X) Pesa-Cacau", 13, 9);
            } else {
                if (papeleta2.getNOMEMODALIDADE().contains("PES")) {
                    sis.set("                                   ", 12, 9);
                    sis.set("(X) Pesa", 12, 9);
                } else {
                    if (papeleta2.getNOMEMODALIDADE().contains("FUNCAFE")) {
                        sis.set("                                   ", 11, 9);
                        sis.set("(X) Funcafé – Dação em Pagamento", 11, 9);
                    } else {
                        if (papeleta2.getNOMEMODALIDADE().contains("COMBATE A POBREZA") || papeleta2.getNOMEMODALIDADE().contains("CONSOLIDACAO DA") || papeleta2.getNOMEMODALIDADE().contains("PROJETO CREDITO FUNDIARIO")) {
                            sis.set("                                   ", 10, 9);
                            sis.set("(X) Crédito Rural Fundiário", 10, 9);
                        } else {
                            if (papeleta2.getNOMEMODALIDADE().contains("SECURITIZACAO")) {
                                sis.set("                                   ", 16, 9);
                                sis.set("(X) Securitização", 16, 9);
                            } else {
                                sis.set("                                   ", 15, 9);
                                sis.set("(X) Recoop", 15, 9);
                            }
                        }
                    }
                }

            }
        }

        System.out.println(">>" + papeleta2.getNOMEMUTUARIO());
        if (papeleta2.getNOMEMUTUARIO().contains("ESPOLIO")) {
            sis.set("1) preencher para todos os produtos:", 18, 9);
            sis.set("    a) mutuário falecido: SIM (“sim” ou “não”)", 19, 9);
            sis.set("    b) no caso de mutuário falecido (“sim”):", 20, 9);
            sis.set("        Herdeiros identificados e localizados:", 21, 9);
            sis.f8();
            sis.set("        (“sim”, “não” ou “XXX”, se não for o caso)", 8, 9);
        } else {
            sis.set("1) preencher para todos os produtos:", 18, 9);
            sis.set("    a) mutuário falecido: NÂO (“sim” ou “não”)", 19, 9);
            sis.set("    b) no caso de mutuário falecido (“sim”):", 20, 9);
            sis.set("        Herdeiros identificados e localizados:", 21, 9);
            sis.f8();
            sis.set("        (“sim”, “não” ou “XXX”, se não for o caso)", 8, 9);
        }

        Collection<ARDigital> listaARD = comando.executeColection(papeleta2.getPREFIXODEP(), String.valueOf(Integer.valueOf(papeleta2.getOPERACAO())));
        ARDigital arDigital = new ARDigital();
        for (ARDigital aRDigital : listaARD) {
            arDigital = aRDigital;
        }

        if (arDigital.getNOMEMUTUARIO()==null) {
            sis.set("2) preencher no caso de “Crédito Rural Fundiário”:", 9, 9);
            sis.set("    a) mutuário notificado por AR: NÃO (“sim” ou “não”)", 10, 9);
            sis.set("    b) no caso de mutuário notificado por AR (“sim”):", 11, 9);
            sis.set("        mutuário localizado: ___ (“sim” ou “não”)", 12, 9);
        } else {
            sis.set("2) preencher no caso de “Crédito Rural Fundiário”:", 9, 9);
            sis.set("    a) mutuário notificado por AR: ___ (“sim” ou “não”)", 10, 9);
            sis.set("    b) no caso de mutuário notificado por AR (“sim”):", 11, 9);
            sis.set("        mutuário localizado: ___ (“sim” ou “não”)", 12, 9);

        }

       

    }

    public String getResumo(String nomeProduto) {

        String nomeAbrev;
        switch (nomeProduto.trim()) {
            case "ADMINISTRACAO CREDITOS BAIXADOS RECURSOS TERCEIROS":
                nomeAbrev = "A.C.B.R.T";
                break;
            case "ADMINISTRACAO CREDITOS CEDIDOS AO TESOURO NACIONAL":
                nomeAbrev = "A.C.C.T.N";
                break;
            case "BANCO DA TERRA":
                nomeAbrev = "B.T";
                break;
            case "CREDITO FUNDIARIO":
                nomeAbrev = "C.F";
                break;
            case "FUNCAFE RESPONSABILIDADE DO FUNDO":
                nomeAbrev = "FUNCAFE";
                break;
            case "PROCERA":
                nomeAbrev = "PROCERA";
                break;
            case "PROGRAMA RECUPERACAO LAVOURA CACAUEIRA BAIANA":
                nomeAbrev = "P.R.L.C.B";
                break;
            case "PRONAF AGRICULTURA FAMILIAR":
                nomeAbrev = "PRONAF";
                break;
            case "PRONAF REFORMA AGRARIA":
                nomeAbrev = "PRONAF REF.";
                break;
            case "PRONAF REFORMA AGRARIA PLANTA BRASIL":
                nomeAbrev = "PRONAF PLAN.";
                break;
            case "REESTRUTURACAO DE ATIVOS INTERESSE GOVERNAMENTAL":
                nomeAbrev = "R.A.I.G.";
                break;
            case "SECURITIZACAO":
                nomeAbrev = "SEC.";
                break;

            default:
                nomeAbrev = "";
                break;

        }
        return nomeAbrev;

    }

}
