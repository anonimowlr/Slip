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
public class Envolvido  extends BbmDados{
    
    private boolean notificar = false;
    private String GSV;

    public Envolvido() {
    }

    public boolean isNotificar() {
        return notificar;
    }

    public void setNotificar(boolean notificar) {
        this.notificar = notificar;
    }

    public String getGSV() {
        return GSV;
    }

    public void setGSV(String GSV) {
        this.GSV = GSV;
    }
    
    
    
    

    
    
    
    
    
    
    
}
