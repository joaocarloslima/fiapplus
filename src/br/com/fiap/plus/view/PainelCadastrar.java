package br.com.fiap.plus.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.fiap.plus.controller.FilmesController;
import br.com.fiap.plus.model.Filme;

public class PainelCadastrar extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JTextField 		txtTitulo = new JTextField();
	private JTextField 		txtSinopse = new JTextField();
	private JTextField 		txtAno = new JTextField();
	private JTextField 		txtNota = new JTextField();
	private JCheckBox  		chkAssistido = new JCheckBox();
	private JRadioButton 	rdbNetflix = new JRadioButton("Netflix");
	private JRadioButton 	rdbAmazon = new JRadioButton("Amazon");
	private JRadioButton 	rdbDisney = new JRadioButton("Disney");
	private JButton			btnSalvar = new JButton("Salvar");
	private ButtonGroup 	ondeAssistir = new ButtonGroup();
	private JPanel			painelOndeAssistir = new JPanel();
	
	public PainelCadastrar() {
		setLayout(new GridLayout(7, 2));
		
		ondeAssistir.add(rdbNetflix);
		ondeAssistir.add(rdbAmazon);
		ondeAssistir.add(rdbDisney);
		
		painelOndeAssistir.add(rdbNetflix);
		painelOndeAssistir.add(rdbAmazon);
		painelOndeAssistir.add(rdbDisney);
		
		rdbNetflix.setActionCommand("Netflix");
		rdbAmazon.setActionCommand("Amazon");
		rdbDisney.setActionCommand("Disney");
		
		add(new JLabel("Título"));
		add(txtTitulo);
		add(new JLabel("Sinopse"));
		add(txtSinopse);
		add(new JLabel("Ano"));
		add(txtAno);
		add(new JLabel("Nota"));
		add(txtNota);
		add(new JLabel("Assistido"));
		add(chkAssistido);
		add(new JLabel("Onde assistir"));
		add(painelOndeAssistir);
		add(new JLabel());
		add(btnSalvar);
		
		btnSalvar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Filme filme = new Filme(
				txtTitulo.getText(), 
				txtSinopse.getText(), 
				Integer.parseInt(txtAno.getText()),
				Double.parseDouble(txtNota.getText()), 
				chkAssistido.isSelected(), 
				ondeAssistir.getSelection().getActionCommand()
			);
			
			FilmesController controller = new FilmesController(this);
			controller.inserir(filme);
			
		} catch (SQLException erro) {
			mostrarMensagem("Erro de SQL " + erro.getMessage());
			erro.printStackTrace();
		}catch (NumberFormatException erroDeConversao) {
			mostrarMensagem("Ano e Nota devem ser números");
		}
		
		
	}

	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
	

}
