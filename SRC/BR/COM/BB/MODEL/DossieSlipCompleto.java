/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.model;

import java.util.ArrayList;

/**
 *
 * @author Adm
 */
public class DossieSlipCompleto{
    
    
    
    private BR.com.bb.MODEL.DossieSlip slip;
    private ArrayList<br.com.bb.model.CronogramaUtilizacao>listaCronogramaUtilizacaos;
    private ArrayList<br.com.bb.model.LancamentoVariacao>listaLancamentoVariacaos;
    private ArrayList<br.com.bb.model.CronogramaAmortizacao>listaCronogramaAmortizacaos;
    private ArrayList<br.com.bb.model.ProdutosDaVariacao>listaProdutosDaVariacaos;
    private String linha;
    

    public ArrayList<br.com.bb.model.CronogramaUtilizacao> getListaCronogramaUtilizacaos() {
        return listaCronogramaUtilizacaos;
    }

    public void setListaCronogramaUtilizacaos(ArrayList<br.com.bb.model.CronogramaUtilizacao> listaCronogramaUtilizacaos) {
        this.listaCronogramaUtilizacaos = listaCronogramaUtilizacaos;
    }

    public ArrayList<br.com.bb.model.LancamentoVariacao> getListaLancamentoVariacaos() {
        return listaLancamentoVariacaos;
    }

    public void setListaLancamentoVariacaos(ArrayList<br.com.bb.model.LancamentoVariacao> listaLancamentoVariacaos) {
        this.listaLancamentoVariacaos = listaLancamentoVariacaos;
    }

    public ArrayList<br.com.bb.model.CronogramaAmortizacao> getListaCronogramaAmortizacaos() {
        return listaCronogramaAmortizacaos;
    }

    public void setListaCronogramaAmortizacaos(ArrayList<br.com.bb.model.CronogramaAmortizacao> listaCronogramaAmortizacaos) {
        this.listaCronogramaAmortizacaos = listaCronogramaAmortizacaos;
    }

    public ArrayList<br.com.bb.model.ProdutosDaVariacao> getListaProdutosDaVariacaos() {
        return listaProdutosDaVariacaos;
    }

    public void setListaProdutosDaVariacaos(ArrayList<br.com.bb.model.ProdutosDaVariacao> listaProdutosDaVariacaos) {
        this.listaProdutosDaVariacaos = listaProdutosDaVariacaos;
    }

    public BR.com.bb.MODEL.DossieSlip getSlip() {
        return slip;
    }

    public void setSlip(BR.com.bb.MODEL.DossieSlip slip) {
        this.slip = slip;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }
    
    
}
