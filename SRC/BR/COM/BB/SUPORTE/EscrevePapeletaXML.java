/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bb.suporte;

import br.com.bb.model.Envolvido2;
import br.com.bb.model.Papeleta2;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author F2872117
 */
public class EscrevePapeletaXML {
    
    public void escreveSalvaPapeletaXML(ArrayList<Papeleta2> listaPapeleta){
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("listaEnvolvidos", List.class);
        xStream.alias("Envolvido", Envolvido2.class);
        
        try {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        File arquivo = new File("M:\\PUBLICA\\ApoioRobos\\TransactionsBKP\\"+System.getProperty("user.name")+"-Salvar-Papeleta-Transaction"+fmt.format(new Date())+".xml");
        FileOutputStream gravar;
        gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(listaPapeleta).getBytes());
            gravar.close();
        
        } catch (UnknownHostException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escrevePesquisaPapeletaXML(ArrayList<Papeleta2> listaPapeleta){
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("listaEnvolvidos", List.class);
        xStream.alias("Envolvido", Envolvido2.class);
        
        try {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        File arquivo = new File("M:\\PUBLICA\\ApoioRobos\\TransactionsBKP\\"+System.getProperty("user.name")+"-Pesquisa-Papeleta-Transaction"+fmt.format(new Date())+".xml");
        FileOutputStream gravar;
        gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(listaPapeleta).getBytes());
            gravar.close();
        
        } catch (UnknownHostException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escrevePesquisaEnvolvidosXML(ArrayList<Envolvido2> listaEnvolvidos){
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("listaEnvolvidos", List.class);
//        xStream.alias("Envolvido", Envolvido2.class);
        
        try {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        File arquivo = new File("M:\\PUBLICA\\ApoioRobos\\TransactionsBKP\\"+System.getProperty("user.name")+"-Pesquisa-Envolvidos-Transaction"+fmt.format(new Date())+".xml");
        FileOutputStream gravar;
        gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(listaEnvolvidos).getBytes());
            gravar.close();
        
        } catch (UnknownHostException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escreveAtualizaEnvolvidosXML(ArrayList<Envolvido2> listaEnvolvidos){
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("listaEnvolvidos", List.class);
//        xStream.alias("Envolvido", Envolvido2.class);
        
        try {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        File arquivo = new File("M:\\PUBLICA\\ApoioRobos\\TransactionsBKP\\"+System.getProperty("user.name")+"-Atualiza-Envolvidos-Transaction"+fmt.format(new Date())+".xml");
        FileOutputStream gravar;
        gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(listaEnvolvidos).getBytes());
            gravar.close();
        
        } catch (UnknownHostException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void escreveCorreioEnvolvidosXML(ArrayList<Envolvido2> listaEnvolvidos){
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("listaEnvolvidos", List.class);
//        xStream.alias("Envolvido", Envolvido2.class);
        
        try {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        File arquivo = new File("M:\\PUBLICA\\ApoioRobos\\TransactionsBKP\\"+System.getProperty("user.name")+"-Correio-Envolvidos-Transaction"+fmt.format(new Date())+".xml");
        FileOutputStream gravar;
        gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(listaEnvolvidos).getBytes());
            gravar.close();
        
        } catch (UnknownHostException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escreveCorreioPapeletaXML(ArrayList<Papeleta2> listaPapeleta){
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("listaEnvolvidos", List.class);
        xStream.alias("Envolvido", Envolvido2.class);
        
        try {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
//        File arquivo = new File("M:\\PUBLICA\\ApoioRobos\\TransactionsBKP\\"+System.getProperty("user.name")+"-Origem-"+java.net.InetAddress.getLocalHost().toString()+"Transaction"+fmt.format(new Date())+".xml");
        File arquivo = new File("M:\\PUBLICA\\ApoioRobos\\TransactionsBKP\\"+System.getProperty("user.name")+"-Correio-Papeleta-Transaction"+fmt.format(new Date())+".xml");
        FileOutputStream gravar;
        gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(listaPapeleta).getBytes());
            gravar.close();
        
        } catch (UnknownHostException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscrevePapeletaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
