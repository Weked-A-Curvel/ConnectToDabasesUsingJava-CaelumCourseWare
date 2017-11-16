package br.com.caelum.jdbc;

import java.util.Calendar;

public class TesteInsere {
	public static void main(String []args) {
		Contato contato = new Contato();
		
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereço("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Gravado com Sucesso!");
	}
}
