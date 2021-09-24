package br.com.fiap.plus.view;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PainelListar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Tabela tabela;
	private JPanel menu;
	
	public PainelListar() {
		
		try {
			tabela = new Tabela();
			menu = new Menu(tabela);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setLayout(new BorderLayout());
		add(menu, BorderLayout.WEST);
		add(new JScrollPane(tabela), BorderLayout.CENTER);
	}
	
	

}
