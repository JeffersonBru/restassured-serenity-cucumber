package runner;

import org.junit.Before;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
		glue = {"stepdefs"},
		features = {"src/test/resources/features"})
public class CucumberTests {
	
	@Before
	public void apagarBaseDeDados() {
		//metodo para trabalhar pre-condicao de massa de dados
	}
}
