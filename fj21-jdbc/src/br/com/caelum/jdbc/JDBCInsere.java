package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;

public class JDBCInsere {
	public static void main(String []args) throws SQLException {
		String sql;
		Connection conexao = null;
		PreparedStatement stmt;
		
		try {
			//comando em sql
			sql = "insert into contatos" + "(nome,email,endereco,dataNascimento)"
					+ "values (?,?,?,?)";
			//abertura de conexao com o banco de dados utilizando o conectionfactory
			conexao = new ConnectionFactory().getConnection();
			
			//abrindo o banco pra a insercao de dados com o preparedstatement
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			
			//substituicao dos parametros ? do preparedStatament
			stmt.setString(1, "Caelum");
			stmt.setString(2, "contato@caelum.com.br");
			stmt.setString(3, "R. Vergueiro 3185 cj57");
			stmt.setDate(4, new java.sql.Date(
					Calendar.getInstance().getTimeInMillis()));
			
			//execucao
			stmt.execute();
			//fechamento
			stmt.close();
			
			System.out.println("Gravou!");
			
		}catch (SQLException e){
			System.out.println(e);
		}finally { //com o recurso de autocloseble este recurso pode ser excluido
			//fechamento da conexao com o banco de dados
			conexao.close();
		}
		
	}

}
