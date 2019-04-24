/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BR.com.bb.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Adm
 */
public class TesteLerArquivo {

    public static String metodoDeSetarCabecalho(BufferedReader leitor) throws IOException {
        String linha = "";
        while (!linha.contains("-7  PRODUTOS DA VARIACAO") && ((linha = leitor.readLine()) != null)) {
            System.out.println("cabecalho ->" + linha);
        }

        System.out.println("=========== sai do metodo agora já posso sair com um objeto setado");
        return linha;
    }

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

            try {
                //                ========================= cria o diretório do arquivo a ser criado
                while ((linha = leitor.readLine()) != null) {
//                    System.out.println(">>" + linha);
//                    if (linha.contains("11*")) {
                    
                    if (linha.contains("11*")) {
                        try {
                            System.out.println("subtring"+linha.substring(90, 100));
                        } catch (Exception e) {
                            System.out.println("Não tem campo");
                        }
                        
                        
                        
                        System.out.println("começou a ler as coisas");
                        if (!linha.contains("-7  PRODUTOS DA VARIACAO") && ((linha = leitor.readLine()) != null)) {
                            linha = metodoDeSetarCabecalho(leitor);
                        }
//                        System.out.println("lendo por linha 32__" + (String) FileUtils.readLines(arquivo).get(33));
                        System.out.println("Linhazinha" + linha);
                        if (linha.contains("PRODUTOS DA VARIACAO")) {
                            linha = metodoDeSetarProdutosVariacao(leitor);
                        }
//                        lembrar de colocar a condição de parada qualquer uma das palavras reservadas abaixo
                        System.out.println("Linhazinha" + linha);
                        if (linha.contains("CRONOGRAMA DE UTILIZACAO DA VARIACAO")) {
                            linha = setCronogramaVar(leitor);
                        }
                        
                        System.out.println("Linhazinha" + linha);
                        if (linha.contains("CRONOGRAMA DE UTILIZACAO DA VARIACAO")) {
                            linha = setLancamentoVariacao(leitor);
                        }

                        System.out.println("Sai do cabeçalho do documento");

                    } else {
                        System.out.println(">>não é o começo de um cabeçalho!");
                    }

                }

            } catch (IOException ex) {
                Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TesteLerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static String metodoDeSetarProdutosVariacao(BufferedReader leitor) throws IOException {
        String linha = "";
//        Setar no documento a linha corrente
        while (!linha.contains("CRONOGRAMA DE UTILIZACAO DA VARIACAO") && ((linha = leitor.readLine()) != null)) {
            System.out.println("Produtos>" + linha);
        }

        System.out.println("=========== sai do metodo agora já posso sair com um objeto setado");
        return linha;
    }

    private static String setCronogramaVar(BufferedReader leitor) throws IOException {
        String linha = "";
//        Setar no documento a linha corrente
        while (!linha.contains("CRONOGRAMA DE AMORTIZACAO DA VARIACAO") && ((linha = leitor.readLine()) != null)) {
            System.out.println("Variação Amortização>" + linha);
        }

        System.out.println("=========== sai do metodo agora já posso sair com um objeto setado");
        return linha;
    }

    private static String setLancamentoVariacao(BufferedReader leitor) throws IOException {
        String linha = "";
//        Setar no documento a linha corrente
        while (!linha.contains("LANCAMENTOS DA VARIACAO") && ((linha = leitor.readLine()) != null)) {
            System.out.println("LançamentoVariação>" + linha);
        }

        System.out.println("=========== sai do metodo agora já posso sair com um objeto setado");
        return linha;
    }

   

}
