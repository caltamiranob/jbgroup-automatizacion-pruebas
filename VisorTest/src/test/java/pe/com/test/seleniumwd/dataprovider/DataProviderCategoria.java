package pe.com.test.seleniumwd.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import pe.com.test.seleniumwd.fuenteDatos.ExcelConArray;

public class DataProviderCategoria {

	@DataProvider(name="categoriaDataProvider")
    public static Object[][] getCasosPrueba(Method method) {       
		
		String archivoExcel = "C:\\Data\\DataCategoria.xls";
		
		switch (method.getName()) {
			case "insertarCategoria":
				return ExcelConArray.leerExcel(archivoExcel, 0); 
				
			case "editarCategoria":
				return ExcelConArray.leerExcel(archivoExcel, 1);				
	
			default:
				return null;
		}
		
    }   
	
}
