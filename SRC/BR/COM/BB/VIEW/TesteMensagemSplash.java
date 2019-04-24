/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.view;

import br.com.bb.splash.SplashScreenApresentacao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author F2872117
 */
public class TesteMensagemSplash {

    public static void main(String[] args) {

        SplashScreenApresentacao apresentacao = new SplashScreenApresentacao(500);
        apresentacao.showSplash();
        try {
            Thread.sleep(5000);
            apresentacao.disposeSplash();
        } catch (InterruptedException ex) {
//            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
