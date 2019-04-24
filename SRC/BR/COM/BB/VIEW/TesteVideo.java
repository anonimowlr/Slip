/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author F2872117
 */
public class TesteVideo {

    public static void main(String[] args) {

//        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe", "C:\\Users\\F2872117.DF\\Videos\\Teste.avi");
        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe", "\\\\172.18.246.87\\c$\\UTIL\\TutorialRobos\\FlashCorreioIDACripto\\TutorialFlashCorreioIDa.avi");
        try {
            Process start = pb.start();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Verifique se o VLC media player está instalado na sua máquina.");
            Logger.getLogger(TesteVideo.class.getName()).log(Level.SEVERE, null, ex);
        }

//        try {
////            Runtime.getRuntime().exec("C:\\Windows\\default_player_name.exe -param_name D:\\file_name.mpg");
////            Runtime.getRuntime().exec("C:\\Windows\\default_player_name.exe -param_name C:\\Users\\F2872117.DF\\Videos\\Teste.avi");
//            Runtime.getRuntime().exec("C:/Program Files/Windows Media Player/wmplayer /play C:\\Users\\F2872117.DF\\Videos\\Teste.avi");
//        } catch (IOException ex) {
//            Logger.getLogger(TesteVideo.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
