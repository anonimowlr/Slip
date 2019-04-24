/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela
 *
 */
package br.com.bb.suporte.tabelas;

import br.com.bb.model.Procuradoria;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author F2872117 - Equipe Flash Monitoria
 * @date 29/09/2015
 */
public class TabelaProcuradoriaModel extends AbstractTableModel {

    private List<Procuradoria> linhas;
    private String[] colunas = new String[]{"Procuradoria", "Sigla", "UF", "Cidade"};
    private static final int PROCURADORIA = 0;
    private static final int SIGLA = 1;
    private static final int UF = 2;
    private static final int CIDADE = 3;

    public TabelaProcuradoriaModel() {
    }

    public TabelaProcuradoriaModel(List<Procuradoria> linhas) {
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

        Procuradoria procuradoria = linhas.get(rowIndex);

        switch (columnIndex) {
            case PROCURADORIA:
                return procuradoria.getProcuradoria();
            case SIGLA:
                return procuradoria.getSigla();
            case UF:
                return procuradoria.getUf();
            case CIDADE:
                return procuradoria.getCidade();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }
    
    public Object getLinha(int rowIndex){
        Procuradoria procuradoria = linhas.get(rowIndex);
        return procuradoria;
    }
    
    

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case PROCURADORIA:
                return String.class;
            case SIGLA:
                return String.class;
            case UF:
                return String.class;
            case CIDADE:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
    }
    
    public void setResult(List<Procuradoria> listaProcuradorias){
        linhas = listaProcuradorias;
        fireTableStructureChanged();
        
    }
    
    public void deleteRow(int row){
        linhas.remove(row);
        fireTableStructureChanged();
    }
    
    
    
    

}
