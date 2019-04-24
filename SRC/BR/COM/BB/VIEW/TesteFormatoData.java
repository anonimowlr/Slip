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
public class TesteFormatoData {
    
    public static void main(String[] args) {
        
        String teste = "30/09/1993";
        
        if (teste.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("é data");
        }else{
            System.out.println("não é data");
        }
            
 
        
    }
    
}
