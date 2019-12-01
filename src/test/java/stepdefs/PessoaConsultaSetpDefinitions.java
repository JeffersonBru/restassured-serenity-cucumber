package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

import java.util.Random;

import cucumber.api.java.en.*;
import webEndPoints.WebEndPoints;


public class PessoaConsultaSetpDefinitions extends PessoaDef {

	private String situacaoCadastro;
	
	@Given("que o usuario deseja realizar uma consulta de pessoa (.*)")
	public void carregarPessoa(String situacaoCadastro) {
		this.situacaoCadastro = situacaoCadastro;
		setPessoa(pessoasCadastradas.get(0));
		if (situacaoCadastro.equalsIgnoreCase("nao cadastrada")) {
			String ddd = String.valueOf(new Random().nextInt(10));
			String telefone = String.valueOf(new Random().nextInt(990000000));
			getPessoa().getTelefones().get(0).setDdd(ddd);
			getPessoa().getTelefones().get(0).setDdd(telefone);
		}
		setRequest(given().pathParams("ddd", getPessoa().getTelefones().get(0).getDdd(), "telefone", getPessoa().getTelefones().get(0).getNumero()));
	}

	@When("for relalizado a consulta")
	public void realizarBusca() throws Exception {
		setResponse(getRequest().when().get(WebEndPoints.CONSULTAR_PESSOA.getUrl()));
		System.out.println("response: " + getResponse().prettyPrint());
	}

	@And("os dados retornados devem estar corretos casa esteja cadastrada")
	public void validarRetornoConsulta() {
		if(situacaoCadastro.equalsIgnoreCase("cadastrada")) {
			getJson().assertThat().body("nome", equalTo(getPessoa().getNome()), "cpf", equalTo(getPessoa().getCpf()));
			
			getPessoa().getTelefones().forEach(telefone -> {
				getJson().assertThat().body(
						"telefones.ddd", contains(telefone.getDdd()),
						"telefones.numero", contains(telefone.getNumero()));
			});
			
			getPessoa().getEnderecos().forEach(endereco -> {
				getJson().assertThat().body(
						"enderecos.bairro", contains(endereco.getBairro()),
						"enderecos.cidade", contains(endereco.getCidade()),
						"enderecos.complemento", contains(endereco.getComplemento()),
						"enderecos.estado", contains(endereco.getEstado()),
						"enderecos.logradouro", contains(endereco.getLogradouro()),
						"enderecos.numero", contains(endereco.getNumero()));
			});
		}

	}

}
