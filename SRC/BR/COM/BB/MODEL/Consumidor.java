/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA
 * F2872117 - Elton Macedo Castanho Portela
 *
 */

package br.com.bb.model;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date   01/12/2014
 */
public class Consumidor {
    
    private String nome;
    private String ip;
    private boolean acesso;
    private String ipPublico;
    private String latitude;
    private String longitude;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }

    public String getIpPublico() {
        return ipPublico;
    }

    public void setIpPublico(String ipPublico) {
        this.ipPublico = ipPublico;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    
    
    

}
