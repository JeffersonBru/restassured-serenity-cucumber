package model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

	private Long codigo;

	private String nome;

	private String cpf;

	private List<Endereco> enderecos = new ArrayList<Endereco>();

	private List<Telefone> telefones = new ArrayList<Telefone>();

	public Pessoa(String nome, String cpf, List<Endereco> enderecos, List<Telefone> telefones) {
		this.nome = nome;
		this.cpf = cpf;
		this.enderecos = enderecos;
		this.telefones = telefones;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public String getNome() {
		return nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}
	
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
