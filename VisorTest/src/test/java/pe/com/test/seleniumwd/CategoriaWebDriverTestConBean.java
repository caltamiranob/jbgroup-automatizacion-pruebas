package pe.com.test.seleniumwd;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pe.com.test.seleniumwd.fuenteDatos.ExcelConBean;
import pe.com.test.seleniumwd.fuenteDatos.bean.CategoriaBeanDataProvider;
import pe.com.test.seleniumwd.page.CategoriaPage;
import pe.com.test.seleniumwd.page.IniciarSesionPage;



public class CategoriaWebDriverTestConBean {

	private String urlInicial = "http://localhost:8082/VisorWeb/";
	private CategoriaPage categoriaPage;
	private IniciarSesionPage iniciarSesionPage;
	
	@BeforeTest
	@Parameters({"navegador", "remoto"})
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
		this.categoriaPage = new CategoriaPage(this.iniciarSesionPage.getWebDriver());
	}
	
	
	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados(ITestContext context) {
		return ExcelConBean.leerExcel(context.getCurrentXmlTest().getParameter("rutaArchivo"));
	}
	
	
	@Test(dataProvider = "datosEntrada")
	public void insertarCategoria(CategoriaBeanDataProvider categoriaBean) throws Exception {
		try {
			
			iniciarSesionPage.iniciarSesion(categoriaBean.getUsuario(), categoriaBean.getClave());

			String valorObtenido = categoriaPage.insertar(categoriaBean.getNombre().trim());
			
			Assert.assertEquals(valorObtenido, categoriaBean.getValorEsperado());
			
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

