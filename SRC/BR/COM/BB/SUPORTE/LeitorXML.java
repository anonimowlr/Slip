/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela
 *
 */
package br.com.bb.suporte;

import br.com.bb.model.Consumidor;
import br.com.bb.model.Usuario;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date 01/12/2014
 */
public class LeitorXML {

    public static void lerXMLListaUsuario(String arquivoUsuario) {
        try {
            XStream xStream = new XStream(new DomDriver());
            xStream.alias("consumidores", ArrayList.class);
            xStream.processAnnotations(Usuario.class);
            File file = new File(arquivoUsuario);
            BufferedReader input = new BufferedReader(new FileReader(file));
            List<Consumidor> consumidores = (List) xStream.fromXML(input);
            input.close();
            System.out.println("#### LISTA DE USUÁRIOS #### ");
            for (Consumidor consumidor : consumidores) {
                System.out.println("Nome: " + consumidor.getNome() + " - " + "Email:" + consumidor.getIp() + " - " + "Matricula:" + consumidor.isAcesso());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static List<Consumidor> lerXMLListaConsumidores(String arquivoUsuario) {
        try {
            XStream xStream = new XStream(new DomDriver());
            xStream.alias("consumidores", ArrayList.class);
            xStream.processAnnotations(Usuario.class);
            
            if (new File(arquivoUsuario).exists()) {
                File file = new File(arquivoUsuario);
                BufferedReader input = new BufferedReader(new FileReader(file));
                List<Consumidor> consumidores = (List) xStream.fromXML(input);
                input.close();
                return consumidores;
            } else if (new File(new URI("file://///172.18.246.32/util/consumidores/Consumidores.xml")).exists()) {
                File file = new File(new URI("file://///172.18.246.32/util/consumidores/Consumidores.xml"));
                BufferedReader input = new BufferedReader(new FileReader(file));
                List<Consumidor> consumidores = (List) xStream.fromXML(input);
                input.close();
                return consumidores;
            } else {
                return null;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (URISyntaxException ex) {
            Logger.getLogger(LeitorXML.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
