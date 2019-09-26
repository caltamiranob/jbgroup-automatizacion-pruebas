package pe.com.test.seleniumwd.page;

import org.openqa.selenium.WebDriver;

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
	
	public CategoriaPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String insertar(String nombre) throws Exception {
		
		Thread.sleep(2000);
		this.webDriver.findElement(linkMenu).click();
		
		Thread.sleep(2000);
		this.webDriver.findElement(linkModAlmacen).click();
		
		Thread.sleep(2000);
		this.webDriver.findElement(linkMntCategoria).click();
		
		this.webDriver.findElement(botonNuevo).click();
		
		this.webDriver.findElement(cajaNombre).clear();
		this.webDriver.findElement(cajaNombre).sendKeys(nombre);
		
		this.webDriver.findElement(botonGuardar).click();
		
		Thread.sleep(2000);
		
		return webDriver.findElement(mensajeRespuesta).getText();
	}
	
	public void cerrarPagina(){
		VisorDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}

}
