/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.view;

import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author F2872117
 */
public class TesteTabelaBBM {

    public static void main(String[] args) {
        //BBM

//        try {
//            Table table = DatabaseBuilder.open(new File("M:\\PUBLICA\\BaseRiscoUniao\\NOTIFICAÇÃO-RISCO\\BASE_NOTIFICAÇÃO_ATUAL.mdb")).getTable("BBM");
//            int i = 0;
//            for (Row row : table) {
//                System.out.println("==========================================================");
//                System.out.println(row.get("SISTEMA").toString());
//                System.out.println(row.get("OPERACAO").toString());
//                System.out.println(row.get("PREFIXO-DEP").toString());
//                System.out.println("i > " + i);
//                i++;
//            }
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        File arquivo = new File("M:\\PUBLICA\\BaseRiscoUniao\\NOTIFICAÇÃO-RISCO\\BASE_NOTIFICAÇÃO_ATUAL.mdb");
        DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatData.format(new Date(arquivo.lastModified()));
        System.out.println("data de modificação : "+data);

    }
}
