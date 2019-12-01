package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import model.Endereco;
import model.Pessoa;
import model.Telefone;
import webEndPoints.WebEndPoints;

public class PessoaIncluirStepDefinitions extends PessoaDef {

	@Given("que os usuarios devem realizar acoes no sistema$")
	public void carregarPessoa(DataTable dataTable) {
		setPessoa(dataTable.asList(Pessoa.class).get(0));
	}

	@And("possuem o numeros de telefone$")
	public void carregarTelefone(DataTable dataTable) {
		List<Telefone> telefones = dataTable.asList(Telefone.class);
		getPessoa().setTelefones(telefones);
	}

	@And("os enderecos$")
	public void carregarEndereco(DataTable dataTable) {
		List<Endereco> enderecos = dataTable.asList(Endereco.class);
		getPessoa().setEnderecos(enderecos);
	}

	@When("for submetido o cadastro dos dados")
	public void cadastrarUsuario() throws Exception {
		setRequest(given().body(new Gson().toJsonTree(getPessoa())));
		getRequest().contentType(ContentType.JSON);
		setResponse(getRequest().when().post(WebEndPoints.INCLUIR_PESSOA.getUrl()));
		System.out.println("response: " + getResponse().prettyPrint());
	}

	@Then("o status de resposta deve ser (\\d+)")
	public void verificarStatusCode(int statusCode) {
		setJson(getResponse().then().statusCode(statusCode));
	}

	@And("sera apresentado mensagem (.*)")
	public void verificarMensagem(String msgResult) {
		if (!msgResult.isEmpty()) {
			List<String> msg = new ArrayList<String>();
			if (msgResult.toLowerCase().contains("cpf")) {
				msg.add(String.format(msgResult, getPessoa().getCpf()));
			} else if (msgResult.toLowerCase().contains("telefone")) {
				getPessoa().getTelefones().forEach(telefone -> {
					msg.add(String.format(msgResult, telefone.getDdd(), telefone.getNumero()));
				});
			}
			getJson().assertThat().body("erro", is(in(msg)));
		} else {
			pessoasCadastradas.add(getPessoa());
		}
	}

}
