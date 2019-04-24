/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BR.COM.BB.VIEW;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Adm
 */
public class EscolheDiretorio {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(new File(".")) {
            public void approveSelection() {
                if (getSelectedFile().isFile()) {
                    // beep
                    System.out.println("aqui nao");
                    return;
                } else {
                    super.approveSelection();
                    System.out.println("passei por aqui");
                }
            }
        };

    }

}
