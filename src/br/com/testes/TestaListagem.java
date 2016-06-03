package br.com.testes;

import java.sql.Statement;

import br.com.database.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionPool.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from Produtos");
		ResultSet resultSet = (statement).getResultSet();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("descricao");
			System.out.println(id + nome + descricao);
		}
		resultSet.close();
		statement.close();
		connection.close();
	}

}
