/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela
 *
 */
package br.com.bb.suporte;

import br.com.bb.model.Consumidor;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date 01/12/2014
 */
public class EscreveXML {

    public int geraXML(List<Consumidor> consumidores) {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("consumidores", List.class);

        File arquivo = new File("M:\\PUBLICA\\BaseIAT\\Consumidores\\Consumidores.xml");
        FileOutputStream gravar;
        try {
            gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(consumidores).getBytes());
            gravar.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscreveXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscreveXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 1;
    }
    
    
    

}
