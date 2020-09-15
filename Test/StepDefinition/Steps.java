package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class Steps {
	
	WebDriver driver;

	/* [ LOGIN SUCCESSFUL   ]  ────────────────────────────────────────────────────────────────────────────────────────── */
	@Given("Abrir Chrome Login Correcto")
	 public void chromeLoginSuccesfull() {
		 System.out.println("Ejecucion del navegador google chrome | Login Correcto");
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivan Castro\\Downloads\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://localhost:8080/ReservaHora/index.jsp");
	}
	 
	 @When("Ingresar username {string} y userpass {string} validos")
	 public void loginSuccessful(String string, String string2) {
		 System.out.println("Ingreso de credenciales de usuario validas");
		 driver.findElement(By.name("username")).sendKeys(string);
		 driver.findElement(By.name("userpass")).sendKeys(string2);
	 }

	 @Then("Inicio sesion satisfactiriamente")
	 public void submitLoginSuccessful() {
		 System.out.println("Submit con la data de archivo TestLoginCorrecto.feature");
		 driver.findElement(By.id("Login")).click();
	 }


	 /* [ LOGIN FAILED       ]  ────────────────────────────────────────────────────────────────────────────────────────── */	 
	 @Given("Abrir Chrome Login Incorrecto")
	 public void chromeLoginFailed() {
		 System.out.println("Ejecucion del navegador google chrome | Login Failed");
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivan Castro\\Downloads\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://localhost:8080/ReservaHora/index.jsp");
	}
	 
	 @When("Ingresar nombreUsuario {string} y userpass {string} invalidos")
	 public void loginFailed(String string, String string2) {
		 System.out.println("Ingreso de credenciales de usuario invalidas");
		 driver.findElement(By.name("nombreUsuario")).sendKeys(string);
		 driver.findElement(By.name("userpass")).sendKeys(string2);
	 }

	 @Then("Inicio sesion incorrecto")
	 public void submitLoginFailed() {
		 System.out.println("Submit con la data de archivo TestLoginIncorrecto.feature");
		 driver.findElement(By.id("Login")).click();
	 }
	
	
}
