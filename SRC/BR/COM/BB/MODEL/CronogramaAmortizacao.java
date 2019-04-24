/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bb.model;

/**
 *
 * @author F2872117
 */
public class CronogramaAmortizacao {
    
    
    private String dtPrevistaParcela;
    private String vlrPrevisto;
    private String vlrRealizado;
    private String vlrParcelaEquiv;
    private String prorrogacao;

    public String getDtPrevistaParcela() {
        return dtPrevistaParcela;
    }

    public void setDtPrevistaParcela(String dtPrevistaParcela) {
        this.dtPrevistaParcela = dtPrevistaParcela;
    }

    public String getVlrPrevisto() {
        return vlrPrevisto;
    }

    public void setVlrPrevisto(String vlrPrevisto) {
        this.vlrPrevisto = vlrPrevisto;
    }

    public String getVlrRealizado() {
        return vlrRealizado;
    }

    public void setVlrRealizado(String vlrRealizado) {
        this.vlrRealizado = vlrRealizado;
    }

    public String getVlrParcelaEquiv() {
        return vlrParcelaEquiv;
    }

    public void setVlrParcelaEquiv(String vlrParcelaEquiv) {
        this.vlrParcelaEquiv = vlrParcelaEquiv;
    }

    public String getProrrogacao() {
        return prorrogacao;
    }

    public void setProrrogacao(String prorrogacao) {
        this.prorrogacao = prorrogacao;
    }
    
    
}
