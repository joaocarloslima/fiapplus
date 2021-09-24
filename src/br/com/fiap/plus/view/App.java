package br.com.fiap.plus.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class App extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JTabbedPane abas = new JTabbedPane();
	private JPanel abaListar = new PainelListar();
	private JPanel abaCadastrar = new PainelCadastrar();
	
	public App() {
				
		abas.add(abaListar, "Listar");
		abas.add(abaCadastrar, "Cadastrar");
		
		add(abas);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Fiap +");
		setSize(800, 600);
		setVisible(true);
	}
	
	
}
