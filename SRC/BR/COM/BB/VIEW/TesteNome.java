/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA
 * F2872117 - Elton Macedo Castanho Portela
 *
 */

package br.com.bb.view;

import br.com.bb.suporte.TextoUtil;
import org.apache.commons.lang.WordUtils;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date   23/11/2015
 */
public class TesteNome {
    
    public static void main(String[] args) {
        
        String nome = "José Dos Santos DE ALMEIDA DA CUNHA DASDORES";
        System.out.println(">"+TextoUtil.arrumarArtigos(nome));
        System.out.println(">"+WordUtils.capitalize(nome.toLowerCase()));
        System.out.println(">"+TextoUtil.arrumarArtigos(WordUtils.capitalize(nome.toLowerCase())));
        
        
    }
}
