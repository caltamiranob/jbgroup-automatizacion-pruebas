package pe.com.test.seleniumwd;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pe.com.test.seleniumwd.dataprovider.DataProviderCategoria;
import pe.com.test.seleniumwd.fuenteDatos.ExcelConBean;
import pe.com.test.seleniumwd.fuenteDatos.bean.CategoriaBeanDataProvider;
import pe.com.test.seleniumwd.page.CategoriaPage;
import pe.com.test.seleniumwd.page.IniciarSesionPage;



public class CategoriaWebDriverTestConArray {

	private String urlInicial = "http://localhost:8082/VisorWeb/";
	private CategoriaPage categoriaPage;
	private IniciarSesionPage iniciarSesionPage;
	
	@BeforeTest
	@Parameters({"navegador", "remoto"})
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
		this.categoriaPage = new CategoriaPage(this.iniciarSesionPage.getWebDriver());
	}
	
	
	@Test(dataProvider = "categoriaDataProvider", dataProviderClass = DataProviderCategoria.class)
	public void insertarCategoria(String usuario, String clave, String nombre, String valorEsperado) throws Exception {
		try {
			
			iniciarSesionPage.iniciarSesion(usuario, clave);

			String valorObtenido = categoriaPage.insertar(nombre.trim());
			
			Assert.assertEquals(valorObtenido, valorEsperado);
			
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dataProvider = "categoriaDataProvider", 
		  dataProviderClass = DataProviderCategoria.class)
	public void editarCategoria(String apellidos, String nombres) throws Exception {
		try {
			
			System.out.println(apellidos + " - " + nombres);
			
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		categoriaPage.cerrarPagina();
	}
	
}

