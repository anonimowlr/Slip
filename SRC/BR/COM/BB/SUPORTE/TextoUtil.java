/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.suporte;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author User
 */
public class TextoUtil {

    public static String formatarString(String texto, String mascara) throws ParseException {
        MaskFormatter mf = new MaskFormatter(mascara);
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(texto);
    }

    public static String arrumarArtigos(String texto) {
        String textoArtigos = texto;
        if (texto.contains(" Da ")) {
            textoArtigos = textoArtigos.replaceAll(" Da ", " da ");
        }
        if (texto.contains(" Do ")) {
            textoArtigos = textoArtigos.replaceAll(" Do ", " do ");
        }
        if (texto.contains(" De ")) {
            textoArtigos = textoArtigos.replaceAll(" De ", " de ");
        }
        if (texto.contains(" Das ")) {
            textoArtigos = textoArtigos.replaceAll(" Das ", " das ");
        }
        if (texto.contains(" Dos ")) {
            textoArtigos = textoArtigos.replaceAll(" Dos ", " dos ");
        }
        if (texto.contains(" Des ")) {
            textoArtigos = textoArtigos.replaceAll(" Des ", " des ");
        }
        if (texto.contains("- Ac")) {
            textoArtigos = textoArtigos.replaceAll(" Ac", "AC");
        }
        if (texto.contains("- Al")) {
            textoArtigos = textoArtigos.replaceAll(" Al", "AL");
        }
        if (texto.contains("- Ap")) {
            textoArtigos = textoArtigos.replaceAll(" Ap", "AP");
        }
        if (texto.contains("- Am")) {
            textoArtigos = textoArtigos.replaceAll(" Am", "AM");
        }
        if (texto.contains("- Ba")) {
            textoArtigos = textoArtigos.replaceAll(" Ba", "BA");
        }
        if (texto.contains("- Ce")) {
            textoArtigos = textoArtigos.replaceAll(" Ce", "CE");
        }
        if (texto.contains("- Df")) {
            textoArtigos = textoArtigos.replaceAll(" Df", "DF");
        }
        if (texto.contains("- Es")) {
            textoArtigos = textoArtigos.replaceAll(" Es", "ES");
        }
        if (texto.contains("- Go")) {
            textoArtigos = textoArtigos.replaceAll(" Go", "GO");
        }
        if (texto.contains("- Ma")) {
            textoArtigos = textoArtigos.replaceAll(" Ma", "MA");
        }
        if (texto.contains("- Mt")) {
            textoArtigos = textoArtigos.replaceAll(" Mt", "MT");
        }
        if (texto.contains("- Ms")) {
            textoArtigos = textoArtigos.replaceAll(" Ms", "MS");
        }
        if (texto.contains("- Mg")) {
            textoArtigos = textoArtigos.replaceAll(" Mg", "MG");
        }
        if (texto.contains("- Pa")) {
            textoArtigos = textoArtigos.replaceAll(" Pa", "PA");
        }
        if (texto.contains("- Pb")) {
            textoArtigos = textoArtigos.replaceAll(" Pb", "PB");
        }
        if (texto.contains("- Pr")) {
            textoArtigos = textoArtigos.replaceAll(" Pr", "PR");
        }
        if (texto.contains("- Pe")) {
            textoArtigos = textoArtigos.replaceAll(" Pe", "PE");
        }
        if (texto.contains("- Pi")) {
            textoArtigos = textoArtigos.replaceAll(" Pi", "PI");
        }
        if (texto.contains("- Rj")) {
            textoArtigos = textoArtigos.replaceAll(" Rj", "RJ");
        }
        if (texto.contains("- Rn")) {
            textoArtigos = textoArtigos.replaceAll(" Rn", "RN");
        }
        if (texto.contains("- Rs")) {
            textoArtigos = textoArtigos.replaceAll(" Rs", "RS");
        }
        if (texto.contains("- Ro")) {
            textoArtigos = textoArtigos.replaceAll(" Ro", "RO");
        }
        if (texto.contains("- Rr")) {
            textoArtigos = textoArtigos.replaceAll(" Rr", "RR");
        }
        if (texto.contains("- Sc")) {
            textoArtigos = textoArtigos.replaceAll(" Sc", "SC");
        }
        if (texto.contains("- Sp")) {
            textoArtigos = textoArtigos.replaceAll(" Sp", "SP");
        }
        if (texto.contains("- Se")) {
            textoArtigos = textoArtigos.replaceAll(" Se", "SE");
        }
        if (texto.contains("- To")) {
            textoArtigos = textoArtigos.replaceAll(" To", "TO");
        }
        
        if (texto.contains("BAirro")) {
            textoArtigos = textoArtigos.replaceAll("BAirro", "Bairro");
        }

        
         
        return textoArtigos;
    }

}
