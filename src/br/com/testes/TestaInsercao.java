package br.com.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.database.Database;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
			try (Connection connection = Database.getConnection()) {
			String sql = "insert into produtos (nome, descricao) values (?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				adiciona("TV LCD", "32 Polegadas", statement);
				adiciona("Blueray", "Full HDMI", statement);
			}
		}
	}

	public static void adiciona(String nome, String descricao, PreparedStatement statement) throws SQLException {
		if (nome.equals("Blueray")) {
	            throw new IllegalArgumentException("Problema ocorrido");
	    }
		statement.setString(1, nome);
		statement.setString(2, descricao);
		boolean result = statement.execute();
		System.out.println(result);
		try (ResultSet resultSet = statement.getGeneratedKeys()) {
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id"));
			}
		}
	}
	
}
