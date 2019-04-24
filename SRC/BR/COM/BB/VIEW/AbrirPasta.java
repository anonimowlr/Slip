/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela
 *
 */
package br.com.bb.view;

import java.io.IOException;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date 07/12/2015
 */
public class AbrirPasta {

    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("explorer.exe " + "G:\\INTERNA\\");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
