/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bb.view;

/**
 *
 * @author F2872117
 */
public class RegexTeste {
    public static void main(String[] args) {
        
        String teste = "123321-0";
        
        if (teste.matches("\\d{6}-\\d{1}")) {
            System.out.println(">>>>>   passou");
        }
        
        
    }
    
    
}
