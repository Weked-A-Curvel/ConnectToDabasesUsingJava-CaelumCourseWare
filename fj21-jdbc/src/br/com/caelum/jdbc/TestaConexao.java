package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
	public static void main (String []args) throws SQLException {
		
		Connection conexao = new ConnectionFactory().getConnection();
		
		System.out.println("Conexao aberta com Sucesso!");
		
		conexao.close();
	}
}
