package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class ContatoDao {
	private Connection conexao;
	
	public ContatoDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos" + "(nome,email,endereco,dataNascimento)"
					+ "values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereço());
			stmt.setDate(4, new Date(
					contato.getDataNascimento().getTimeInMillis()));
		
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista(){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = (PreparedStatement) this.conexao.prepareStatement("select*from contatod");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Contato contato = new Contato();
				
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereço(rs.getString("endereço"));
				
				//remontando a data a partir do banco
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			return contatos;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}