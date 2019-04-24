
package br.com.bb.model;

import java.util.ArrayList;

/**
 *
 * @author F2872117
 */
public class Papeleta extends BbmDados{
    
    private String tipoNotificacao;
    private String tipoOperacao;
    private String dataDescricao;
    private String equipe;
    private ArrayList<Envolvido> listaEnvolvidos;
    private String numOperacao;
    private String dtContratacao;
    private String nmUnico;
    private String prefDepe;
    private String vlrOperacao;
    private String municipio;
    private String matricula;
    private String tipoInadimplencia;
    private String protocolo;

    public String getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(String tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String getDataDescricao() {
        return dataDescricao;
    }

    public void setDataDescricao(String dataDescricao) {
        this.dataDescricao = dataDescricao;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public ArrayList<Envolvido> getListaEnvolvidos() {
        return listaEnvolvidos;
    }

    public void setListaEnvolvidos(ArrayList<Envolvido> listaEnvolvidos) {
        this.listaEnvolvidos = listaEnvolvidos;
    }

    public String getNumOperacao() {
        return numOperacao;
    }

    public void setNumOperacao(String numOperacao) {
        this.numOperacao = numOperacao;
    }

    public String getDtContratacao() {
        return dtContratacao;
    }

    public void setDtContratacao(String dtContratacao) {
        this.dtContratacao = dtContratacao;
    }

    public String getNmUnico() {
        return nmUnico;
    }

    public void setNmUnico(String nmUnico) {
        this.nmUnico = nmUnico;
    }

    public String getPrefDepe() {
        return prefDepe;
    }

    public void setPrefDepe(String prefDepe) {
        this.prefDepe = prefDepe;
    }

    public String getVlrOperacao() {
        return vlrOperacao;
    }

    public void setVlrOperacao(String vlrOperacao) {
        this.vlrOperacao = vlrOperacao;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipoInadimplencia() {
        return tipoInadimplencia;
    }

    public void setTipoInadimplencia(String tipoInadimplencia) {
        this.tipoInadimplencia = tipoInadimplencia;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }
    
    
    
}
