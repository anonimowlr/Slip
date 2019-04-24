package br.com.bb.template.models;

import br.com.bb.conexao.InterfacePool;
import br.com.bb.conexao.Pool;
import br.com.bb.model.Gerente;
import br.com.bb.model.Mutuario;
import br.com.bb.model.Procuradoria;
import br.com.bb.model.command.InterfaceCommand;
import br.com.bb.model.command.ListarGerentes;
import br.com.bb.model.command.ListarGetProcuradoria;
import br.com.bb.model.dao.GerenteDAO;
import br.com.bb.model.dao.ProcuradoriaDAO;
import br.com.bb.sisbb.Sisbb;
import br.com.bb.template.DocumentoCorreioSisbb;
import java.util.Calendar;
import java.util.Collection;
import javax.swing.JOptionPane;

public class DocCorreioIDA extends DocumentoCorreioSisbb {

    public DocCorreioIDA(String mciEmpresa) {
        this.arquivo = mciEmpresa;
    }

    public DocCorreioIDA() {
    }

    @Override
    public void criarDocumento() {
    }

    @Override
    public void carregarDadosEstatico() {
        try {

            Sisbb sis = (Sisbb) parametros[0];
            String agenciaCorreio = (String) parametros[1];
            String cidadeProcuradoria = (String) parametros[2];
            String gerenteArea = (String) parametros[3];
            String ac = (String) parametros[4];
            String oficio = (String) parametros[5];
            String operacao = (String) parametros[6];
            Calendar calendario = Calendar.getInstance();


            InterfacePool pool = new Pool();
            InterfaceCommand comando = new ListarGetProcuradoria(new ProcuradoriaDAO(pool));
            Collection<Procuradoria> listaProcuradoria = comando.executeColection(cidadeProcuradoria);
            Procuradoria procuradoria = new Procuradoria();

            for (Procuradoria procuradoria1 : listaProcuradoria) {
                procuradoria = procuradoria1;
            }

            comando = new ListarGerentes(new GerenteDAO(pool));
            Collection<Gerente> listaGerente = comando.executeColection();
            Gerente ger = new Gerente();
            for (Gerente gerente : listaGerente) {
                ger = gerente;
            }

//            Titulo do Correio 
            sis.set("Risco União - Entrega à " + procuradoria.getSigla(), 4, 26);

            sis.set("De  : 1903 - CENOP BRASÍLIA - DF/RISCO UNIÃO      #ULTRACONFIDENCIAL", 7, 9);
            sis.set("Para: "+agenciaCorreio, 8, 9);
            sis.set("A/C : "+ac, 9, 9);

            sis.set("Sr. Gerente,", 11, 9);
            sis.set("Enviamos, via malote, dossiê de Inscrição em Dívida Ativa da União,", 13, 14);
            sis.set("que pedimos as seguintes providências:", 14, 9);
            sis.set("a) confirmar o recebimento, mesma via;", 16, 9);
//            colocar o endereço do lugar aqui - 2 linhas colocar no nome do Lugar 
            sis.set("b) encaminhar à Procuradoria Regional da Fazenda Nacional, localizada na", 18, 9);
            if (procuradoria.getEndereco().length() >= 72) {
                sis.set(String.format("%-72s", procuradoria.getEndereco())+".", 19, 9);
            } else {
                sis.set(procuradoria.getEndereco() + " - " + procuradoria.getCidade() + " - " + procuradoria.getUf()+".", 19, 9);
            }
            sis.set("c) entregar o dossiê e acolher o protocolo de recebimento do ofício", 21, 9);
            sis.f8();
            sis.set("naquela Procuradoria;", 8, 9);
            sis.set("d) após a entrega, encaminhar a este Centro a via do ofício protocolada", 10, 9);
            sis.set("pela "+procuradoria.getSigla()+", primeiro por meio digital e depois enviar o documento físico.", 11, 9);
            sis.set("2. Dossiê encaminhado:", 13, 9);
            
//            2015/numeroGSV operação devedor fazer a tabela
//            Formatar o numero da operação como XX/XXXXX-X
            sis.set("Ofício              Operação            Mutuário", 15, 9);
            sis.set(String.valueOf(calendario.get(Calendar.YEAR))+"/"+oficio+"          "+operacao+"          "+Mutuario.getNomeMutuario(), 16, 9);

            sis.set(String.format("%-39s", gerenteArea), 19, 9);
            sis.set(String.format("%-41s", ger.getNome()), 19, 47);
            sis.set("Gerente de Área                       " + ger.getCargo(), 20, 9);
            sis.f2();
            sis.get(23, 3, 50);
            System.out.println(">" + sis.get(23, 3, 50));

            sis.f3();
            sis.f5();
            sis.f3();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o Correio SISBB!");
            e.printStackTrace();
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
