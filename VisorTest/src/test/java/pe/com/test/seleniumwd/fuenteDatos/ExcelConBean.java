package pe.com.test.seleniumwd.fuenteDatos;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import pe.com.test.seleniumwd.fuenteDatos.bean.CategoriaBeanDataProvider;

public class ExcelConBean {

	
	public static Object[][] leerExcel(String rutaArchivo) {
		
		Object[][] lista = null;
		
		int fila = 0;
		
		try {


			FileInputStream archivo = new FileInputStream(new File(rutaArchivo));

			HSSFWorkbook archivoExcel = new HSSFWorkbook(archivo);

			HSSFSheet hojaExcel = archivoExcel.getSheetAt(0);

			Iterator<Row> filas = hojaExcel.iterator();

			filas.next();

			lista = new Object[hojaExcel.getLastRowNum()][1];

			while (filas.hasNext()) {

				Row filaActual = filas.next();

				Iterator<Cell> celdas = filaActual.cellIterator();
				
				CategoriaBeanDataProvider categoriaBean = new CategoriaBeanDataProvider();
				categoriaBean.setUsuario(celdas.next().getStringCellValue());
				categoriaBean.setClave(celdas.next().getStringCellValue());
				categoriaBean.setNombre(celdas.next().getStringCellValue());
				categoriaBean.setValorEsperado(celdas.next().getStringCellValue());
				
				lista[fila][0] = categoriaBean;
				
				fila++;

			}

			archivoExcel.close();

			archivo.close();

			

		} catch (Exception e) {

			e.printStackTrace();

		} 
		return lista;
	}
}
