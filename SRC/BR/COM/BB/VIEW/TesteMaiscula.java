/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bb.view;

import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author F2872117
 */
public class TesteMaiscula {
    public static void main(String[] args) {
        
        String nome = "IVO LUIZ VARELA";
        StringBuilder nomeBulder = new StringBuilder(nome);
        System.out.println(">"+WordUtils.capitalize(nome.toLowerCase()));
        System.out.println(">"+WordUtils.capitalize(nome));
        System.out.println(">"+StringUtils.capitalize(nome));
        System.out.println(">"+WordUtils.capitalize(nomeBulder.toString()));
        System.out.println(">"+StringUtils.capitalize(nomeBulder.toString()));
    }
    
}
