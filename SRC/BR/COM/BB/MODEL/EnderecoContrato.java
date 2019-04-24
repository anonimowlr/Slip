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
public class EnderecoContrato {

    private String tipoEndereco = null;
    private String dtAtlz = null;
    private String logr = null;
    private String comp = null;
    private String bairro = null;
    private String cep = null;
    private String municipio = null;

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getDtAtlz() {
        return dtAtlz;
    }

    public void setDtAtlz(String dtAtlz) {
        this.dtAtlz = dtAtlz;
    }

    public String getLogr() {
        return logr;
    }

    public void setLogr(String logr) {
        this.logr = logr;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    

}
