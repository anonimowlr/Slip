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
public class TesteNumeros {
    
    public static void main(String[] args) {
        
        int total = 443;
        System.out.println(">>"+total);
        System.out.println(">>"+(total%8));
        System.out.println(">>"+(total/8));

        for (int i = 0; i < (total/8); i++) {
            System.out.println(i);
        }
        
        for (int i = 0; i < (total%8); i++) {
            System.out.println("->"+(total-i));
        }
        
        
        
        
        
    }
            
    
    
}
