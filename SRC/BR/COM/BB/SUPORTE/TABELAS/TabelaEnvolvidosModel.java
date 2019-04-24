/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela
 *
 */
package br.com.bb.suporte.tabelas;

import br.com.bb.model.Envolvido2;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date 29/09/2015
 */
public class TabelaEnvolvidosModel extends AbstractTableModel {

    private List<Envolvido2> linhas;
    private String[] colunas = new String[]{"NOME NOTIFICADO", "TIPO", "CPF/CNPJ", "PARTICIPAÇÃO", "NOTIFICAR"};
    private static final int NOMENOFIFICADO = 0;
    private static final int TIPO = 1;
    private static final int CPFCNPJ = 2;
    private static final int PARTICIPACAO = 3;
    private static final int NOTIFICAR = 4;

    public TabelaEnvolvidosModel() {
    }

    public TabelaEnvolvidosModel(List<Envolvido2> linhas) {
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

        Envolvido2 envolvido2 = linhas.get(rowIndex);

        switch (columnIndex) {
            case NOMENOFIFICADO:
                return envolvido2.getNOMEMUTUARIO();
            case TIPO:
                return envolvido2.getROTEIRO();
            case CPFCNPJ:
                return envolvido2.getCPFCNPJ();
            case PARTICIPACAO:
                return envolvido2.getPARTICIPACAO();
            case NOTIFICAR:
                return envolvido2.isNOTIFICAR();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    public Object getLinha(int rowIndex) {
        Envolvido2 envolvido2 = linhas.get(rowIndex);
        return envolvido2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case NOMENOFIFICADO:
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

    public void setResult(List<Envolvido2> listaNotificado) {
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

        Envolvido2 envolvido2 = linhas.get(row);
        switch (col) {
            case NOMENOFIFICADO:
                envolvido2.setNOMEMUTUARIO((String) value);
                break;
            case TIPO:
                envolvido2.setROTEIRO((String) value);
                break;
            case CPFCNPJ:
                envolvido2.setNRMODALIDADE((String) value);
                break;
            case PARTICIPACAO:
                envolvido2.setPREFIXODEP((String) value);
                break;
            case NOTIFICAR:
                envolvido2.setNOTIFICAR((boolean) value);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

    }

}
