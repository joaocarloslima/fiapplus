package br.com.fiap.plus.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.plus.dao.Criterio;
import br.com.fiap.plus.dao.FilmesDao;
import br.com.fiap.plus.model.Filme;

public class Tabela extends JTable {

	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel model = new DefaultTableModel();
	
	public Tabela() throws SQLException {
		model.addColumn("id");
		model.addColumn("título");
		model.addColumn("sinopse");
		model.addColumn("ano");
		model.addColumn("nota");
		model.addColumn("assistido");
		model.addColumn("onde assistir");
		setModel(model);
		
		carregar( Criterio.TODOS);
		
	}

	public void carregar(Criterio criterio) throws SQLException {
		model.setNumRows(0);
		FilmesDao dao = new FilmesDao();
		List<Filme> lista = dao.buscar(criterio);
		
		lista.forEach(filme -> model.addRow(filme.toArray()) );
	}


}
