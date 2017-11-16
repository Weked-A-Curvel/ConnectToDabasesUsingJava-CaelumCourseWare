package br.com.caelum.jdbc;

import java.util.Calendar;

//classe java beans
public class Contato {
	private Long id;
	private String nome;
	private String email;
	private String endereço;
	private Calendar dataNascimento;
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereço() {
		return this.endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public Calendar getDataNascimento() {
		return this.dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}		
}
