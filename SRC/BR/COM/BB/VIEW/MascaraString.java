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
public class MascaraString {
    public static void main(String[] args) {
        
        int n1= 45;
        String n2 = "02458";
        System.out.println("n1> "+String.format("%09d", n1));
        System.out.println("n2> "+String.format("%09d", Integer.valueOf(n2)));
        
    }
    
}
