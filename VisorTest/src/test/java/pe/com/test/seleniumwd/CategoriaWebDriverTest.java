package pe.com.test.seleniumwd;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pe.com.test.seleniumwd.fuenteDatos.Excel;
import pe.com.test.seleniumwd.fuenteDatos.MySql;
import pe.com.test.seleniumwd.page.CategoriaPage;
import pe.com.test.seleniumwd.page.IniciarSesionPage;

public class CategoriaWebDriverTest {

	private String urlInicial = "http://localhost:8082/VisorWeb/";
	private CategoriaPage categoriaPage;
	private IniciarSesionPage iniciarSesionPage;

	@BeforeTest
	@Parameters({ "navegador", "remoto" })
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
		this.categoriaPage = new CategoriaPage(this.iniciarSesionPage.getWebDriver());
	}

	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados(ITestContext context) {
		Object[][] datos = null;
		
		String fuenteDatos = 
				context
					.getCurrentXmlTest()
						.getParameter("fuenteDatos");
		
		String rutaArchivo =
				context
					.getCurrentXmlTest()
						.getParameter("rutaArchivo");
		
		
		switch (fuenteDatos) {
			case "BD":
				datos = MySql.leerCategoriaMysql();
				break;
	
			case "Excel":
				datos = Excel.leerExcel(rutaArchivo);
				break;
		}
		
		
		return datos;
	}

	@Test(dataProvider = "datosEntrada")
	public void insertarCategoria(String usuario, String clave, String nombre, String valorEsperado) throws Exception {
		try {
			iniciarSesionPage.iniciarSesion(usuario, clave);
			String valorObtenido = categoriaPage.insertar(nombre.trim());
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
