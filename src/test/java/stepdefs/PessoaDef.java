package stepdefs;

import java.util.ArrayList;
import java.util.List;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import model.Pessoa;

public class PessoaDef {
	
	public static List<Pessoa> pessoasCadastradas = new ArrayList<>();
	private static Pessoa pessoa;
	private static Response response;

	private static ValidatableResponse json;
	private RequestSpecification request;
	
	
	public static Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		PessoaDef.response = response;
	}
	public static ValidatableResponse getJson() {
		return json;
	}
	public void setJson(ValidatableResponse json) {
		PessoaDef.json = json;
	}
	public RequestSpecification getRequest() {
		return request;
	}
	public void setRequest(RequestSpecification request) {
		this.request = request;
	}
	public static Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		PessoaDef.pessoa = pessoa;
	}

}
