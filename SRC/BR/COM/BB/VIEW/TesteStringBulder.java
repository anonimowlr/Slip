/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA
 * F2872117 - Elton Macedo Castanho Portela
 *
 */

package br.com.bb.view;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date   31/08/2015
 */
public class TesteStringBulder {
    
    public static void main(String[] args) {
        
        String dependencia = "Nome: AGRESTINA Prefixo: 196 Endereço: R.CEL.MANOEL ALVES,68 CENTRO AGRESTINA-PE ";
        
        StringBuilder stringBuilder = new StringBuilder(dependencia);
            stringBuilder.insert(dependencia.indexOf("Endereço"), "\r\n");
            System.out.println(">"+stringBuilder);
            System.out.println(">"+stringBuilder.toString());
        
        
    }

}
