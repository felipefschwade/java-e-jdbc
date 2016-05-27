package br.com.testes;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.database.Database;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();
		Statement stmt = connection.createStatement();
		stmt.execute("delete from produtos where id > 3");
		int count = stmt.getUpdateCount();
        System.out.println(count + " linhas atualizadas");
		stmt.close();
		connection.close();
	}
}
