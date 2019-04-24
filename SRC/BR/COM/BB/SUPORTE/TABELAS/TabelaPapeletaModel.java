/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela
 *
 */
package br.com.bb.suporte.tabelas;

import br.com.bb.model.Papeleta2;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date 29/09/2015
 */
public class TabelaPapeletaModel extends AbstractTableModel {

    private List<Papeleta2> linhas;
    private String[] colunas = new String[]{"MUNICÍPIO UF", "TIPO NOTIFICAÇÃO", "TIPO OPERAÇÃO", "PREFIXO DEP", "OPERACAO", "PROTOCOLO", "NR ÚNICO", "MATRICULA", "NOTIFICAR"};
    private static final int MUNICIPIOUF = 0;
    private static final int TIPONOTIFICACAO = 1;
    private static final int TIPOOPERACAO = 2;
    private static final int PREFIXODEP = 3;
    private static final int OPERACAO = 4;
    private static final int PROTOCOLO = 5;
    private static final int NRUNICO = 6;
    private static final int MATRICULA = 7;
    private static final int NOTIFICAR = 8;

    public TabelaPapeletaModel() {
    }

    public TabelaPapeletaModel(List<Papeleta2> linhas) {
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

        Papeleta2 papeleta2 = linhas.get(rowIndex);

        switch (columnIndex) {
            case MUNICIPIOUF:
                return papeleta2.getMUNICIPIOUF();
            case TIPONOTIFICACAO:
                return papeleta2.getTIPONOTIFICACAO();
            case TIPOOPERACAO:
                return papeleta2.getNRMODALIDADE();
            case PREFIXODEP:
                return papeleta2.getPREFIXODEP();
            case OPERACAO:
                return papeleta2.getOPERACAO();
            case PROTOCOLO:
                return papeleta2.getGSV();
            case NRUNICO:
                return papeleta2.getNRUNICOOPERACAO();
            case MATRICULA:
                return papeleta2.getMATRICULA();
            case NOTIFICAR:
                return papeleta2.isNOTIFICAR();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    public Object getLinha(int rowIndex) {
        Papeleta2 papeleta2 = linhas.get(rowIndex);
        return papeleta2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case MUNICIPIOUF:
                return String.class;
            case TIPONOTIFICACAO:
                return String.class;
            case TIPOOPERACAO:
                return String.class;
            case PREFIXODEP:
                return String.class;
            case OPERACAO:
                return String.class;
            case PROTOCOLO:
                return String.class;
            case NRUNICO:
                return String.class;
            case MATRICULA:
                return String.class;
            case NOTIFICAR:
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

    }

    public void setResult(List<Papeleta2> listaNotificado) {
        linhas = listaNotificado;
        fireTableStructureChanged();

    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void deleteRow(int row) {
        linhas.remove(row);
        fireTableStructureChanged();
    }

    public void setValueAt(Object value, int row, int col) {

        Papeleta2 papeleta2 = linhas.get(row);
        switch (col) {
            case MUNICIPIOUF:
                papeleta2.setMUNICIPIOUF((String) value);
                break;
            case TIPONOTIFICACAO:
                papeleta2.setTIPONOTIFICACAO((String) value);
                break;
            case TIPOOPERACAO:
                papeleta2.setNRMODALIDADE((String) value);
                break;
            case PREFIXODEP:
                papeleta2.setPREFIXODEP((String) value);
                break;
            case PROTOCOLO:
                papeleta2.setGSV((String) value);
                break;
            case OPERACAO:
                papeleta2.setOPERACAO((String) value);
                break;
            case NRUNICO:
                papeleta2.setNRUNICOOPERACAO((String) value);
                break;
            case MATRICULA:
                papeleta2.setMATRICULA((String) value);
                break;
            case NOTIFICAR:
                papeleta2.setNotificar((boolean) value);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

    }
    
    public ArrayList<Papeleta2> getListaPapeleta(){
        ArrayList<Papeleta2> listaPapeleta2 = new ArrayList<>(this.linhas);
        return listaPapeleta2;
    }

}
