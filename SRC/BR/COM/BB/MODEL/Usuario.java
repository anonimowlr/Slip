/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA
 * F2872117 - Elton Macedo Castanho Portela
 * F8369196 - Rafael Shimabukro Borba
 * F8772071 Roney Pereira da Costa
 *
 */

package br.com.bb.model;

/**
 *
 * @author Equipe Flash Monitoria
 * @date 17/06/2014   
 */
public class Usuario {
    
     private static String chave;
    private static String senha;

    public static String getChave() {
        return chave;
    }

    public static void setChave(String chave) {
        Usuario.chave = chave;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        Usuario.senha = senha;
    }

}
