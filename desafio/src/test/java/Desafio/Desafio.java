package Desafio;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Desafio {

	private WebDriver driver;
	private Metodos metodo;

	@Before
	public void inicializa() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
		metodo = new Metodos(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void Desafio_1() throws InterruptedException {
		metodo.selecionarCombo("switch-version-select", "Bootstrap V4 Theme");
		metodo.clicarBotaoLinkText("Add Record");
		metodo.escreveId("field-customerName", "Teste Mundo");
		metodo.escreveId("field-contactLastName", "Teste");
		metodo.escreveId("field-contactFirstName", "seu nome");
		metodo.escreveId("field-phone", "61 9999-9999");
		metodo.escreveId("field-addressLine1", "Av Brasil, 3970");
		metodo.escreveId("field-addressLine2", "Torre D");
		metodo.escreveId("field-city", "Grande Colorado");
		metodo.escreveId("field-state", "DF");
		metodo.escreveId("field-postalCode", "91000-000");
		metodo.escreveId("field-country", "Brasil");
		metodo.escreveId("field-salesRepEmployeeNumber", "1234");
		metodo.escreveId("field-creditLimit", "200");
		metodo.clicarBotaoId("form-button-save");
		metodo.aguardaElementoTelaCarregar(5, "/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]/p");
		WebElement caminhoTextoValidacao = metodo.capturaFraseIdEXpath("report-success",
				"/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]/p");
		String FraseCompletaValidacao = caminhoTextoValidacao.getText();
		metodo.imprimirNaTelaParaConferencia(FraseCompletaValidacao);
		metodo.validarFrase("Your data has been successfully stored into the database. Edit Record or Go back to list",
				FraseCompletaValidacao);
	}

	@Test
	public void Desafio_2() throws InterruptedException {
		metodo.selecionarCombo("switch-version-select", "Bootstrap V4 Theme");
		metodo.clicarBotaoLinkText("Add Record");
		metodo.escreveId("field-customerName", "Teste Mundo");
		metodo.escreveId("field-contactLastName", "Teste");
		metodo.escreveId("field-contactFirstName", "seu nome");
		metodo.escreveId("field-phone", "61 9999-9999");
		metodo.escreveId("field-addressLine1", "Av Brasil, 3970");
		metodo.escreveId("field-addressLine2", "Torre D");
		metodo.escreveId("field-city", "Grande Colorado");
		metodo.escreveId("field-state", "DF");
		metodo.escreveId("field-postalCode", "91000-000");
		metodo.escreveId("field-country", "Brasil");
		metodo.escreveId("field-salesRepEmployeeNumber", "1234");
		metodo.escreveId("field-creditLimit", "200");
		metodo.clicarBotaoId("form-button-save");
		metodo.aguardaElementoTelaCarregar(5, "/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]/p");
		WebElement caminhoTextoValidacao = metodo.capturaFraseIdEXpath("report-success",
				"/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]/p");
		String FraseCompletaValidacao = caminhoTextoValidacao.getText();
		metodo.imprimirNaTelaParaConferencia(FraseCompletaValidacao);
		metodo.validarFrase("Your data has been successfully stored into the database. Edit Record or Go back to list",
				FraseCompletaValidacao);
		metodo.clicarBotaoLinkText("Go back to list");
		metodo.esperaMilissegundos(3000);
		metodo.escreveName("customerName", "Teste Mundo");
		metodo.clicarBotaoXpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[1]/div/input");
		metodo.esperaMilissegundos(3000);
		metodo.clicarBotaoXpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[1]/div/input");
		metodo.clicarBotaoXpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[2]/div[1]/a");
		WebElement caminhoTextoValidacaoDois = metodo.capturaFraseClassNameEXpath("modal-body",
				"/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[1]");
		String FraseCompletaValidacaoDois = caminhoTextoValidacaoDois.getText();
		metodo.imprimirNaTelaParaConferencia(FraseCompletaValidacaoDois);
		metodo.validarFrase("Are you sure that you want to delete those 2 items?", FraseCompletaValidacaoDois);
		metodo.clicarBotaoXpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]");
		metodo.esperaMilissegundos(3000);
		WebElement mensagemPopUp = driver.findElement(
				By.xpath("//p[contains(., 'Your data has been successfully deleted from the database.')]"));
		String mensagemPopUpVerde = mensagemPopUp.getText();
		metodo.imprimirNaTelaParaConferencia(mensagemPopUpVerde);
		metodo.validarFrase("Your data has been successfully deleted from the database.", mensagemPopUpVerde);
	}						 

}
