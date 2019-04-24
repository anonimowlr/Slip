/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela
 *
 */
package br.com.bb.suporte.tabelas;

import br.com.bb.model.Notificado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date 29/09/2015
 */
public class TabelaNotificadoModel extends AbstractTableModel {

    private List<Notificado> linhas;
    private String[] colunas = new String[]{"NOTIFICADO(S)", "TIPO", "CPF/CNPJ", "PARTICIPAÇÃO", "NOTIFICAR"};
    private static final int NOTIFICADO = 0;
    private static final int TIPO = 1;
    private static final int CPFCNPJ = 2;
    private static final int PARTICIPACAO = 3;
    private static final int NOTIFICAR = 4;

    public TabelaNotificadoModel() {
    }

    public TabelaNotificadoModel(List<Notificado> linhas) {
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

        Notificado notificado = linhas.get(rowIndex);

        switch (columnIndex) {
            case NOTIFICADO:
                return notificado.getNotificado();
            case TIPO:
                return notificado.getTipo();
            case CPFCNPJ:
                return notificado.getCpfcnpj();
            case PARTICIPACAO:
                return notificado.getParticipacao();
            case NOTIFICAR:
                return notificado.isNotificar();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    public Object getLinha(int rowIndex) {
        Notificado notificado = linhas.get(rowIndex);
        return notificado;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case NOTIFICADO:
                return String.class;
            case TIPO:
                return String.class;
            case CPFCNPJ:
                return String.class;
            case PARTICIPACAO:
                return String.class;
            case NOTIFICAR:
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

    }

    public void setResult(List<Notificado> listaNotificado) {
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
        
        Notificado notificado = linhas.get(row);    
        switch (col) {
            case NOTIFICADO:
                 notificado.setNotificado((String) value);
                break;
//                fireTableCellUpdated(row, col);
            case TIPO:
                 notificado.setTipo((String) value);
                break;
//                fireTableCellUpdated(row, col);
            case CPFCNPJ:
                notificado.setCpfcnpj((String) value);
                break;
//                fireTableCellUpdated(row, col);
            case PARTICIPACAO:
                notificado.setParticipacao((String) value);
                break;
//                fireTableCellUpdated(row, col);
            case NOTIFICAR:
                notificado.setNotificar((boolean) value);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        
  }    

}
