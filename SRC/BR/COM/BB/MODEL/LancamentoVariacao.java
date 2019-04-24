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
public class LancamentoVariacao {
    
    
    private String lancamento;
    private String valorizacao;
    private String historico;
    private String literalHistorico;
    private String vlrLancamento;
    private String saldoData;

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public String getValorizacao() {
        return valorizacao;
    }

    public void setValorizacao(String valorizacao) {
        this.valorizacao = valorizacao;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getLiteralHistorico() {
        return literalHistorico;
    }

    public void setLiteralHistorico(String literalHistorico) {
        this.literalHistorico = literalHistorico;
    }

    public String getVlrLancamento() {
        return vlrLancamento;
    }

    public void setVlrLancamento(String vlrLancamento) {
        this.vlrLancamento = vlrLancamento;
    }

    public String getSaldoData() {
        return saldoData;
    }

    public void setSaldoData(String saldoData) {
        this.saldoData = saldoData;
    }
    
}
