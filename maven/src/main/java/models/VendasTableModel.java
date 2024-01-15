package models;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class VendasTableModel extends AbstractTableModel {
	
	private String[] colunas = {"VALOR", "DATA", "NOME CLIENTE"};
	private ArrayList<Venda> vendas;
	private final int COLUNA_VALOR = 0;
	private final int COLUNA_DATA = 1;
	private final int COLUNA_NOME_CLIENTE = 2;
	
	public VendasTableModel(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

	@Override
	public int getRowCount() {
		return vendas.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Venda venda = this.vendas.get(rowIndex);
		
		  switch (columnIndex) {
          case COLUNA_VALOR:
              return venda.getValor();
          
          case COLUNA_DATA:
              return venda.getData();
              
          case COLUNA_NOME_CLIENTE:
              return venda.getCliente().getNome();
              
         
      }
		  return null;
	}

	@Override
	public String getColumnName(int indice) {
		return colunas[indice];
	}


	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class retorno = null;
		switch(columnIndex) {
		case COLUNA_VALOR:
			retorno = double.class;
			break;
		case COLUNA_DATA: 
			retorno =  LocalDate.class;
			break;
		case COLUNA_NOME_CLIENTE:
			retorno =  String.class;
			break;
		}
		
		return retorno;
		
	}

	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		 Venda venda = this.vendas.get(rowIndex);
		 Cliente cliente = null;
		 
		 switch (columnIndex) {
         case COLUNA_VALOR:
             venda.setValor((double) aValue);
             break;
         case COLUNA_DATA:
             venda.setData((LocalDate) aValue);
             break;
         case COLUNA_NOME_CLIENTE:
             venda.setCliente(cliente = new Cliente( (String) aValue));
             break;
		 }
	}


	

}
