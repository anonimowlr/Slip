/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author F2872117
 */
public class TesteEscolhaTXT {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        System.out.println(">>>>>>>");
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Selecione um bloco tratado pelo aplicativo FastJudBloc");
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Arquivos de Texto (*.txt)", "txt"));
        fc.setAcceptAllFileFilterUsed(false);
        fc.setMultiSelectionEnabled(false);
        fc.showDialog(null, "OK");
        System.out.println(">>" + fc.getSelectedFile().getAbsolutePath());

        File arquivo = fc.getSelectedFile();
        FileReader reader = new FileReader(arquivo.getAbsolutePath());
        BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo.getAbsolutePath()), "Cp1252"));
        String linha;
        
        while ((linha = leitor.readLine()) != null) {
            
            if (linha.contains("11*")) {
                System.out.println("============= início de um bloco de documento ===============");
                
            } else {
                System.out.println("->"+linha );
            }
            
            
            
        }

    }

}
