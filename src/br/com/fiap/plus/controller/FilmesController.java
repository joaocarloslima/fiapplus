package br.com.fiap.plus.controller;

import java.sql.SQLException;

import br.com.fiap.plus.dao.FilmesDao;
import br.com.fiap.plus.model.Filme;
import br.com.fiap.plus.view.PainelCadastrar;

public class FilmesController {
	
	private PainelCadastrar view;

	public FilmesController(PainelCadastrar view) {
		this.view = view;
	}

	public void inserir(Filme filme) throws SQLException {
		FilmesDao dao = new FilmesDao();
		dao.inserir(filme);
		view.mostrarMensagem("Filme cadastrado com sucesso");
	}

	
	
}
