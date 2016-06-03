package br.com.testes;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.database.ConnectionPool;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionPool.getConnection();
		Statement stmt = connection.createStatement();
		stmt.execute("delete from produtos where id > 9");
		int count = stmt.getUpdateCount();
        System.out.println(count + " linhas atualizadas");
		stmt.close();
		connection.close();
	}
}
