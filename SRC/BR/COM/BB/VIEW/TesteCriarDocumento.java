/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.view;

import br.com.bb.template.DocumentoOffice;
import br.com.bb.template.models.DocEmpresa;
import br.com.bb.template.models.DocSlipXer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author F2872117
 */
public class TesteCriarDocumento {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

            JFileChooser abrir = new JFileChooser();
// Definir Titulo da mensagem
            abrir.setDialogTitle("Selecione um arquivo BBM por Favor.");
// DEfinindo caminho padrão
//        String caminho_padrao = "Documents:"; //-> aqui vc define uma abertura pré definida ex. Desktop, C: 
            String caminho_padrao = "C:\\Users\\F2872117\\Documents\\DesenvolvimentoCenop\\Francine"; //-> aqui vc define uma abertura pré definida ex. Desktop, C: 
            File pathInicial = new File(caminho_padrao);
            abrir.setCurrentDirectory(pathInicial);//vai abrir direto no dir. 'H:\'
// Filtra só arquivos xml.
            FileNameExtensionFilter filtroxml = new FileNameExtensionFilter(".txt", "txt");
            abrir.addChoosableFileFilter(filtroxml);
            abrir.setAcceptAllFileFilterUsed(false);
            abrir.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            abrir.showDialog(null, "OK");

            File arquivo = abrir.getSelectedFile();
            FileReader reader = new FileReader(arquivo.getAbsolutePath());
            BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo.getAbsolutePath()), "Cp1252"));

            String linha;

            DocumentoOffice documento = new DocSlipXer();
            documento.elaborarDocumento(arquivo.getAbsolutePath());

        } catch (Exception e) {

        }

    }

}
