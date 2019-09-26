package pe.com.test.seleniumwd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CategoriaWebDriverTest_1 {

	private WebDriver driver;
	private String urlInicial = "http://localhost:8082/VisorWeb/";
	
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\ProgramasInstalados\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void insertarCategoria_FlujoBasico() throws Exception {
		try {
			String mensajeEsperado = "Se guardó de manera correcta la Categoría";
			
			//método get: abre una ventana con la URL indicada
			this.driver.get(urlInicial);
			
			this.driver.findElement(By.id("txtUsuario"))
											.sendKeys("admin");
			
			WebElement txtClave = 
					this.driver.findElement(By.id("txtClave"));
			txtClave.sendKeys("clave");
			
			this.driver.findElement(By.id("btnIniciarSesion")).click();
			
			Thread.sleep(2000);
			
			this.driver.findElement(
					By.xpath("/html/body/section/div[1]/div")
			).click();
			Thread.sleep(2000);
			
			this.driver.findElement(
					By.xpath("/html/body/section/div[1]/nav/ul/li/span")
			).click();
			Thread.sleep(2000);
			
			this.driver.findElement(
					By.linkText("Mnt. de Categoría")
			).click();
			Thread.sleep(2000);
			
			this.driver.findElement(By.id("btnNuevo")).click();
			
			this.driver.findElement(By.id("txtNombre"))
												.sendKeys("SWD Test");
			
			this.driver.findElement(By.id("btnGuardar")).click();
			
			Thread.sleep(2000);
			
			String mensajeObtenido = driver.findElement(By.id("messages")).getText();
			Assert.assertEquals(mensajeEsperado, mensajeObtenido);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"insertarCategoria_FlujoBasico"})
	public void insertarCategoria_FlujoAlternativo() throws Exception {
		try {
			String mensajeEsperado = "Nombre: Error de validación: se necesita un valor.";
			
			this.driver.get(urlInicial);
			
			this.driver.findElement(By.id("txtUsuario"))
											.sendKeys("admin");
			
			this.driver.findElement(By.id("txtClave"))
											.sendKeys("clave");
			
			this.driver.findElement(By.id("btnIniciarSesion"))
											.click();
			
			Thread.sleep(2000);
			this.driver.findElement(
					By.xpath("/html/body/section/div[1]/div")
			).click();
			
			
			Thread.sleep(2000);
			this.driver.findElement(
					By.xpath("/html/body/section/div[1]/nav/ul/li/span")
			).click();
			
			Thread.sleep(2000);
			this.driver.findElement(
					By.linkText("Mnt. de Categoría")
			).click();
			
			this.driver.findElement(By.id("btnNuevo")).click();
			
			this.driver.findElement(By.id("txtNombre")).clear();
			
			this.driver.findElement(By.id("btnGuardar")).click();
			
			Thread.sleep(2000);
			
			String mensajeObtenido = driver.findElement(By.id("messages")).getText();
			Assert.assertEquals(mensajeEsperado, mensajeObtenido);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.close();
	}
}
