package br.com.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.database.Database;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();
		String nome = "Notebook'i5";
		String descricao = ("Notebook i5' Dual'Core");
		String sql = "insert into produtos (nome, descricao) values (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, nome);
		statement.setString(2, descricao);
		boolean result = statement.execute();
		System.out.println(result);
		ResultSet resultSet = statement.getGeneratedKeys();
		while (resultSet.next()) {
			System.out.println(resultSet.getString("id"));
		}
        resultSet.close();	
		statement.close();
		connection.close();
	}
	
}
