package br.com.testes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.database.Database;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean result = statement.execute("insert into produtos (nome, descricao) values ('Notebook', 'Notebook i5')", statement.RETURN_GENERATED_KEYS);
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
