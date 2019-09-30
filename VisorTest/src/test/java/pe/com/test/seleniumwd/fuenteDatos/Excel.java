package pe.com.test.seleniumwd.fuenteDatos;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Excel {

	
	public static String[][] leerExcel(String rutaArchivo) {
		String[][] lista = null;
		int numeroFila = 0;
		
		try {
			
			//1. Cargar el workbook
			HSSFWorkbook archivo = 
					new HSSFWorkbook(
						new FileInputStream(rutaArchivo)
					);
			
			//2. cargar la hoja
			HSSFSheet hojaExcel = archivo.getSheetAt(0);
			
			//3. Obtener iteradorFilas
			Iterator<Row> iteradorFilas = hojaExcel.rowIterator();
			iteradorFilas.next();
			
			//4. Generar arreglo bidimensional (lista)
			lista = new String[hojaExcel.getLastRowNum()][];
			
			//5. Iterar sobre las filas
			while( iteradorFilas.hasNext() ) {
				
				Row fila = iteradorFilas.next();
				
				Iterator<Cell> iteradorCeldas = fila.cellIterator();
				
				lista[numeroFila] = new String[fila.getLastCellNum()];
				
				int numeroColumna = 0;
				
				while( iteradorCeldas.hasNext() ) {
					
					Cell celda = iteradorCeldas.next();
					
					celda.setCellType(Cell.CELL_TYPE_STRING);
					
					lista[numeroFila][numeroColumna] = 
									celda.getStringCellValue();
					
					numeroColumna++;
					
				}
				
				numeroFila++;
				
			}
			
			archivo.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return lista;
	}
}




