package pe.com.test.seleniumwd;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pe.com.test.seleniumwd.page.CategoriaPage;
import pe.com.test.seleniumwd.page.IniciarSesionPage;



public class CategoriaWebDriverTest {

	private String urlInicial = "http://localhost:8082/VisorWeb/";
	private CategoriaPage categoriaPage;
	private IniciarSesionPage iniciarSesionPage;
	
	@BeforeTest
	@Parameters({"navegador", "remoto"})
	public void inicioClase(String navegador, int remoto) throws Exception {
		
		this.iniciarSesionPage = 
			new IniciarSesionPage(navegador, urlInicial, false);
		
		this.categoriaPage =
			new CategoriaPage(this.iniciarSesionPage.getWebDriver());
		
		
		
	}
	
	
	@Test
	public void insertarCategoria_FlujoBasico() throws Exception {
		try {
			
			this.iniciarSesionPage.iniciarSesion("admin", "clave");
			
			String valorObtenido = this.categoriaPage.insertar("SWD POM");
			
			String valorEsperado = "Se guardó de manera correcta la Categoría";
			
			Assert.assertEquals(valorEsperado , valorObtenido);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"insertarCategoria_FlujoBasico"})
	public void insertarCategoria_FlujoAlternativo() throws Exception {
		try {
			
			this.iniciarSesionPage.iniciarSesion("admin", "clave");
			
			String valorObtenido = this.categoriaPage.insertar(""); 
			
			String valorEsperado = "Nombre: Error de validación: se necesita un valor.";
			
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		categoriaPage.cerrarPagina();
	}
	
}

