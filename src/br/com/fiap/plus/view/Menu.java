package br.com.fiap.plus.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.fiap.plus.dao.Criterio;

public class Menu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton btnTodos = new JButton("Todos");
	private JButton btnBuscar = new JButton("Buscar");
	private JButton btnMelhores = new JButton("Melhores");
	private JButton btnLancamentos = new JButton("Lançamentos");
	private JButton btnNaoAssistidos = new JButton("Não assistidos");
	private JButton btnAssistidos = new JButton("Assistidos");
	private JButton btnNetflix = new JButton("Netflix");
	private JButton btnAmazon = new JButton("Amazon");
	private JButton btnDisney = new JButton("Disney");

	private Tabela tabela;

	public Menu(Tabela tabela) {
		this.tabela = tabela;
		setPreferredSize(new Dimension(150, 600));

		add(btnTodos);
		add(btnBuscar);
		add(btnMelhores);
		add(btnLancamentos);
		add(btnNaoAssistidos);
		add(btnAssistidos);
		add(btnNetflix);
		add(btnAmazon);
		add(btnDisney);

		addListeners();

	}

	private void addListeners() {
		btnTodos.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnMelhores.addActionListener(this);
		btnLancamentos.addActionListener(this);
		btnNaoAssistidos.addActionListener(this);
		btnAssistidos.addActionListener(this);
		btnNetflix.addActionListener(this);
		btnAmazon.addActionListener(this);
		btnDisney.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnTodos) 		tabela.carregar(Criterio.TODOS);
			if (e.getSource() == btnMelhores) 	tabela.carregar(Criterio.MELHORES);
			if (e.getSource() == btnNaoAssistidos) 	tabela.carregar( Criterio.NAO_ASSISTIDOS);
			if (e.getSource() == btnAssistidos) 	tabela.carregar( Criterio.ASSISTIDOS);
			if (e.getSource() == btnLancamentos) 	tabela.carregar( Criterio.LANCAMENTOS);
			if (e.getSource() == btnAmazon) 	tabela.carregar( Criterio.AMAZON);

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this, "Erro ao buscar");
			e1.printStackTrace();
		}

	}

}
