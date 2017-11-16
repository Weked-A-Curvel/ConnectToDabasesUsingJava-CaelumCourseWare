package br.com.caelum.jdbc;

import java.util.List;

public class TestaLista {
	public static void main(String []args) {
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereco: " + contato.getEndereço());
			System.out.println("Data de Nascimento: " + 
								contato.getDataNascimento().getTime()+"\n");
			
		}
	}
}
