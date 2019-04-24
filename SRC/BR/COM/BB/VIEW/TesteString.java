/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.view;

/**
 *
 * @author User
 */
public class TesteString {
    
    public static void main(String args[]) {
        
        String titulo = String.format("%-10s", "essa é um teste de string");
        System.out.println(titulo.format("%5s", titulo));
        System.out.println(titulo.format("%5s", titulo));
        System.out.println(titulo.format("%5s", titulo));
                
        
        
    }
    
}
