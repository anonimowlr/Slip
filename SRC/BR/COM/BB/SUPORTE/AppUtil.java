/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.suporte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author F2872117
 */
public class AppUtil {

    public static void copyFile(File source, File destination) throws IOException {
        if (destination.exists()) {
            destination.delete();
        }
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {

            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen()) {
                sourceChannel.close();
            }
            if (destinationChannel != null && destinationChannel.isOpen()) {
                destinationChannel.close();
            }
        }
    }

    public static void preparaPastas() {
        if (!new File("Config").exists()) {
            new File("Config").mkdirs();
        }
    }

//    public void copia() {
//        InputStream source = getClass().getResourceAsStream("br/com/bb/suporte/sisbb.jks");
//        File file = new File("\\Config\\sisbb.jks");
//        try {
//            FileUtils.copyInputStreamToFile(source, file);
//        } catch (IOException e1) {
//            throw new RuntimeException(e1);
//        }
//    }

    public void copyFileJar(String arquivo, File destination) throws IOException, URISyntaxException {
        if (destination.exists()) {
            destination.delete();
        }

        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        FileInputStream fis = null;
        try {
//            System.out.println(">>" + this.getClass().getResource("\\" + arquivo).toString());
            fis = new FileInputStream(new File(getClass().getResource("\\" + arquivo).toURI()));

            sourceChannel = fis.getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen()) {
                sourceChannel.close();
            }
            if (destinationChannel != null && destinationChannel.isOpen()) {
                destinationChannel.close();
            }
        }
    }

}
