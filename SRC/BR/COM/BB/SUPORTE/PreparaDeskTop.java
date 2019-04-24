/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA
 * F2872117 - Elton Macedo Castanho Portela
 *
 */

package br.com.bb.suporte;

import java.io.File;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date   24/11/2015
 */
public class PreparaDeskTop {
    
    public static void preparaPastasDesktop(){
        
        String pasta = "G:\\INTERNA\\RISCO UNIAO\\EQUIPES DE PRODUÇAO\\RISCO10\\CAPTURARISCO\\"+ System.getProperty("user.name") ;
        
        if (!new File(pasta).exists()) {
            new File(pasta).mkdirs();
            new File(pasta+"\\FlashCorreioIDA\\FolhaDeRosto").mkdirs();
            new File(pasta+"\\FlashCorreioIDA\\Oficios").mkdir();
        }else{
            System.out.println(">"+"Diretórios já existem");
        }
        
        
    }
    

}
