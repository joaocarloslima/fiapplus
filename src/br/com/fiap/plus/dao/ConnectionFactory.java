package br.com.fiap.plus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/fiapplus";
		String usuario = "root";
		String senha = "";
		Connection connection = DriverManager.getConnection(url, usuario, senha);
		
		return connection;
	}
	
}
