/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bb.model;

import java.util.ArrayList;

/**
 *
 * @author F2872117
 */
public class Papeleta2 extends BBMAtual{
    
    
    private String TIPONOTIFICACAO;
    private String GSV;
    private String EQUIPE;
    private String DATACONTRATACAO;
    private String MUNICIPIOUF;
    private String TIPOINADIMPLENCIA;
    private String MATRICULA;
    private boolean NOTIFICAR;
    ArrayList<Envolvido2> listaEnvolvidos;

    public String getTIPONOTIFICACAO() {
        return TIPONOTIFICACAO;
    }

    public void setTIPONOTIFICACAO(String TIPONOTIFICACAO) {
        this.TIPONOTIFICACAO = TIPONOTIFICACAO;
    }

    public String getGSV() {
        return GSV;
    }

    public void setGSV(String GSV) {
        this.GSV = GSV;
    }

    public String getEQUIPE() {
        return EQUIPE;
    }

    public void setEQUIPE(String EQUIPE) {
        this.EQUIPE = EQUIPE;
    }

    public String getDATACONTRATACAO() {
        return DATACONTRATACAO;
    }

    public void setDATACONTRATACAO(String DATACONTRATACAO) {
        this.DATACONTRATACAO = DATACONTRATACAO;
    }

    public String getMUNICIPIOUF() {
        return MUNICIPIOUF;
    }

    public void setMUNICIPIOUF(String MUNICIPIOUF) {
        this.MUNICIPIOUF = MUNICIPIOUF;
    }

    public String getTIPOINADIMPLENCIA() {
        return TIPOINADIMPLENCIA;
    }

    public void setTIPOINADIMPLENCIA(String TIPOINADIMPLENCIA) {
        this.TIPOINADIMPLENCIA = TIPOINADIMPLENCIA;
    }

    public String getMATRICULA() {
        return MATRICULA;
    }

    public void setMATRICULA(String MATRICULA) {
        this.MATRICULA = MATRICULA;
    }

    public boolean isNotificar() {
        return NOTIFICAR;
    }

    public void setNotificar(boolean NOTIFICAR) {
        this.NOTIFICAR = NOTIFICAR;
    }

    public boolean isNOTIFICAR() {
        return NOTIFICAR;
    }

    public void setNOTIFICAR(boolean NOTIFICAR) {
        this.NOTIFICAR = NOTIFICAR;
    }

    public ArrayList<Envolvido2> getListaEnvolvidos() {
        return listaEnvolvidos;
    }

    public void setListaEnvolvidos(ArrayList<Envolvido2> listaEnvolvidos) {
        this.listaEnvolvidos = listaEnvolvidos;
    }
    
    
    
}
