package br.com.fiap.plus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.plus.model.Filme;

public class FilmesDao {

	/**
	 * 
	 * @param filme - filme a ser inserido
	 * @return quantidade de linhas inseridas no banco (0 ou 1)
	 * @throws SQLException
	 */
	public int inserir(Filme filme) throws SQLException {
		 Connection con = ConnectionFactory.getConnection();
		 
		 String sql = "INSERT INTO filmes VALUES (0, ?, ?, ?, ?, ?, ?)";
		 
		 PreparedStatement ps = con.prepareStatement(sql);
		 ps.setString(1, filme.getTitulo());
		 ps.setString(2, filme.getSinopse());
		 ps.setInt(3, filme.getAno());
		 ps.setDouble(4, filme.getNota());
		 ps.setBoolean(5, filme.isAssistido());
		 ps.setString(6, filme.getOndeAssistir());
		 
		 return ps.executeUpdate();
	}

	public List<Filme> buscar(Criterio criterio) throws SQLException {
		 List<Filme> filmes = new ArrayList<>();
		 
		 Connection con = ConnectionFactory.getConnection();
		 PreparedStatement ps = con.prepareStatement(getSql(criterio));
		 ResultSet rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 Filme filme = new Filme(
					 rs.getLong("id"), 
					 rs.getString("titulo"), 
					 rs.getString("sinopse"), 
					 rs.getInt("ano"), 
					 rs.getDouble("nota"), 
					 rs.getBoolean("assistido"), 
					 rs.getString("onde_assistir")
				);
			 
			 filmes.add(filme);	 
		 }
		 
		 return filmes;
		 
	}

	private String getSql(Criterio criterio) {
		if (criterio == Criterio.TODOS) return "SELECT * FROM filmes";
		if (criterio == Criterio.MELHORES) return "SELECT * FROM filmes ORDER By nota DESC";
		if (criterio == Criterio.LANCAMENTOS) return "SELECT * FROM filmes ORDER By ano DESC";
		if (criterio == Criterio.ASSISTIDOS) return "SELECT * FROM filmes WHERE assistido = 1";
		if (criterio == Criterio.NAO_ASSISTIDOS) return "SELECT * FROM filmes WHERE assistido = 0";
		if (criterio == Criterio.AMAZON) return "SELECT * FROM filmes WHERE onde_assistir = 'Amazon'";
		
		return null;
		
	}

	
	
	

}
