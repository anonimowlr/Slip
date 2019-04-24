/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela
 *
 */
package br.com.bb.suporte.tabelas;

import br.com.bb.model.Envolvido;
import br.com.bb.model.Notificado;
import br.com.bb.model.Papeleta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date 29/09/2015
 */
public class TabelaPapeletaCorreio extends AbstractTableModel {

    private List<Envolvido> linhas;
    private Papeleta papeleta;
    private String[] colunas = new String[]{"NOME", "CPF/CNPJ", "PARTICIPACAO", "NºOPERAÇÃO", "PREFIXO", "MUNICIPIO", "TIPO", "DATA CONTRA.", "NR UNICO", "VALOR DA OPERAÇÃO", "TIP INADIMPLÊNCIA", "GSV", "ENVIADO"};
    private static final int NOME = 0;
    private static final int CPFCNPJ = 1;
    private static final int PARTICIPACAO = 2;
    private static final int NOPERACAO = 3;
    private static final int PREFIXO = 4;
    private static final int MUNICIPIO = 5;
    private static final int TIPO = 6;
    private static final int DATACONTRA = 7;
    private static final int NRUNICO = 8;
    private static final int VALOROPERACAO = 9;
    private static final int TIPINADIMPL = 10;
    private static final int GSV = 11;
    private static final int ENVIADO = 12;

    public TabelaPapeletaCorreio() {
    }

    public TabelaPapeletaCorreio(List<Envolvido> linhas) {
        this.linhas = linhas;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Envolvido envolvido = linhas.get(rowIndex);

        switch (columnIndex) {
            case NOME:
                return envolvido.getNOMEMUTUARIO();
            case CPFCNPJ:
                return envolvido.getCPFCNPJ();
            case PARTICIPACAO:
                return envolvido.getTIPPRCTMUT();
            case NOPERACAO:
                return envolvido.getOPERACAO();
            case PREFIXO:
                return envolvido.getPREFIXODEP();
            case MUNICIPIO:
                return papeleta.getMunicipio();
            case TIPO:
                return envolvido.getTIPPRCTMUT();
            case DATACONTRA:
                return papeleta.getDtContratacao();
            case NRUNICO:
                return envolvido.getPREFIXODEP();
            case VALOROPERACAO:
                return envolvido.getPREFIXODEP();
            case TIPINADIMPL:
                return envolvido.getPREFIXODEP();
            case GSV:
                return envolvido.getPREFIXODEP();
            case ENVIADO:
                return envolvido.getPREFIXODEP();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    public Object getLinha(int rowIndex) {
//        Notificado notificado = linhas.get(rowIndex);
//        return notificado;
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
//        switch (columnIndex) {
//            case NOTIFICADO:
//                return String.class;
//            case TIPO:
//                return String.class;
//            case CPFCNPJ:
//                return String.class;
//            case PARTICIPACAO:
//                return String.class;
//            case NOTIFICAR:
//                return Boolean.class;
//            default:
//                throw new IndexOutOfBoundsException("columnIndex out of bounds");
//        }
        return null;

    }

    public void setResult(List<Notificado> listaNotificado) {
//        linhas = listaNotificado;
//        fireTableStructureChanged();

    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void deleteRow(int row) {
        linhas.remove(row);
        fireTableStructureChanged();
    }

    public void setValueAt(Object value, int row, int col) {

//        Notificado notificado = linhas.get(row);
//        switch (col) {
//            case NOTIFICADO:
//                notificado.setNotificado((String) value);
//                break;
////                fireTableCellUpdated(row, col);
//            case TIPO:
//                notificado.setTipo((String) value);
//                break;
////                fireTableCellUpdated(row, col);
//            case CPFCNPJ:
//                notificado.setCpfcnpj((String) value);
//                break;
////                fireTableCellUpdated(row, col);
//            case PARTICIPACAO:
//                notificado.setParticipacao((String) value);
//                break;
////                fireTableCellUpdated(row, col);
//            case NOTIFICAR:
//                notificado.setNotificar((boolean) value);
//                break;
//            default:
//                throw new IndexOutOfBoundsException("columnIndex out of bounds");
//        }
        

    }

}
