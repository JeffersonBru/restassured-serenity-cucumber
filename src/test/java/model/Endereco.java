package model;

public class Endereco {

	private String logradouro;

	private Integer numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private String estado;

	public Endereco(String logradouro, Integer numero, String complemento, String bairro, String cidade, String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getComplemento() {
		return complemento;
	}

}
