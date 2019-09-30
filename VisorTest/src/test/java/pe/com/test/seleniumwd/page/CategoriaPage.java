package pe.com.test.seleniumwd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pe.com.test.seleniumwd.driver.VisorDriver;
import pe.com.test.seleniumwd.menu.CategoriaOpciones;
import pe.com.test.seleniumwd.menu.MenuOpciones;

public class CategoriaPage extends MenuOpciones implements CategoriaOpciones {

//	private By linkMenu = By.xpath("/html/body/section/div[1]/div");
//	private By linkModAlmacen = By.xpath("/html/body/section/div[1]/nav/ul/li/span");
//	private By linkMntCategoria = By.linkText("Mnt. de Categoría");
//	private By botonNuevo = By.id("btnNuevo");
//	private By cajaNombre = By.id("txtNombre");
//	private By botonGuardar = By.id("btnGuardar");
//	private By mensajeRespuesta = By.id("messages");
	private WebDriver webDriver = null;
	
	private WebDriverWait webDriverWait = null;

	public CategoriaPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.webDriverWait = new WebDriverWait(this.webDriver, 20);
	}

	public String insertar(String nombre) throws Exception {

		this.webDriver.findElement(linkMenu).click();
		
		this.webDriver.findElement(linkModAlmacen).click();
		
		this.webDriver.findElement(linkMntCategoria).click();
		
		this.webDriver.findElement(botonNuevo).click();
		
		this.webDriver.findElement(cajaNombre).clear();
		this.webDriver.findElement(cajaNombre).sendKeys(nombre);
		
		this.webDriver.findElement(botonGuardar).click();
		
		return this.webDriverWait.until(
			ExpectedConditions
					.visibilityOfElementLocated(mensajeRespuesta)
		).getText();
		
		
//		return webDriver.findElement(mensajeRespuesta).getText();
		
		
//		return this.webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(mensajeRespuesta)).getText();
	}
	
	public void cerrarPagina(){
		VisorDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}

}
