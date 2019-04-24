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
public class Notificado {

    private String notificado;
    private String tipo;
    private String cpfcnpj;
    private String participacao;
    private boolean notificar = false;
    

    public Notificado(String notificado, String tipo, String cpfcnpj, String participacao, boolean notificar) {
        this.notificado = notificado;
        this.tipo = tipo;
        this.cpfcnpj = cpfcnpj;
        this.participacao = participacao;
        this.notificar = notificar;
    }

    public Notificado() {
    }

    public String getNotificado() {
        return notificado;
    }

    public void setNotificado(String notificado) {
        this.notificado = notificado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getParticipacao() {
        return participacao;
    }

    public void setParticipacao(String participacao) {
        this.participacao = participacao;
    }

    public boolean isNotificar() {
        return notificar;
    }

    public void setNotificar(boolean notificar) {
        this.notificar = notificar;
    }
    
    
    
    

}
