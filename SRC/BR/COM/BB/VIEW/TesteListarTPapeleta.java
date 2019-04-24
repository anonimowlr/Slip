/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela
 *
 */
package br.com.bb.view;

import br.com.bb.conexao.InterfacePoolBase;
import br.com.bb.conexao.PoolBase;
import br.com.bb.model.Papeleta2;
import br.com.bb.model.command.InterfaceCommand;
import br.com.bb.model.command.ListarPapeletas2;
import br.com.bb.model.dao.Papeleta2DAO;
import br.com.bb.suporte.EscrevePapeletaXML;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date 24/11/2014
 */
public class TesteListarTPapeleta {

    public static void main(String[] args) {
        
        
        InterfacePoolBase pool = new PoolBase();
        InterfaceCommand comando = new ListarPapeletas2(new Papeleta2DAO(pool));
        Collection<Papeleta2> listaBbm = comando.executeColection();
//        Collection<BBMAtual> listaBbm = comando.executeColection(String.format("%04d",Integer.valueOf("5")),String.format("%09d",Integer.valueOf("500011")));
        
        for (Papeleta2 bbmdados : listaBbm) {
            System.out.println("========================================");
            System.out.println(">"+bbmdados.getCPFCNPJ());
            System.out.println(">"+bbmdados.getDATABAIXA());
            System.out.println(">"+bbmdados.getDATAPROTOCOLOPGFN());
            System.out.println(">"+bbmdados.getCPFCNPJ());
            System.out.println(">"+bbmdados.getNOMEDEPENDENCIA());
            System.out.println(">"+bbmdados.getNOMEMODALIDADE());
            System.out.println(">"+bbmdados.getNRUNICOOPERACAO());
            System.out.println(">"+bbmdados.getDATAAPURACAODVD());
            System.out.println(">"+bbmdados.getDATABAIXA());
            System.out.println(">"+bbmdados.getDATANOTVENCANTECIPADO());
            System.out.println(">"+bbmdados.getDATAREGINSTCREDITO());
            System.out.println(">"+bbmdados.getROTEIRO());
            System.out.println("inteiro >"+Integer.valueOf(bbmdados.getROTEIRO().trim()));
            
            
            System.out.println("========================================");
        }
        
        
        new EscrevePapeletaXML().escreveSalvaPapeletaXML((ArrayList<Papeleta2>) listaBbm);
        
    }

}
