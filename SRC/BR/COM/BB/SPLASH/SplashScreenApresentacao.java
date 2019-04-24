/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA
 * F2872117 - Elton Macedo Castanho Portela
 *
 */

package br.com.bb.splash;

import java.awt.*;
import javax.swing.*;

public class SplashScreenApresentacao extends JWindow {
    
    private int duration;
    
    public SplashScreenApresentacao(int d) {
        duration = d;
    }
    
// Este é um método simples para mostrar uma tela de apresentção

// no centro da tela durante a quantidade de tempo passada no construtor

    public void showSplash() {
        
        JPanel content = (JPanel)getContentPane();
        setBackground(new Color(0,0,0,0));
//        content.setOpaque(false);
        
        
        // Configura a posição e o tamanho da janela
        int width = 719;
        int height =299;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
        
        // Constrói o splash screen
        JLabel label = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/br/com/bb/imagens/segundaLogo.png")));
        content.add(label, BorderLayout.CENTER);
        
        // Torna visível
        setVisible(true);
        
        // Espera ate que os recursos estejam carregados       
    }
    
    public void showSplashAndExit() {        
        showSplash();
    }
    
    public void disposeSplash() {
        dispose();
    }
    
}


