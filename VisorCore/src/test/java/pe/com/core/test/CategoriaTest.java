package pe.com.core.test;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pe.com.core.business.CategoriaBusiness;
import pe.com.core.entity.Categoria;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoriaTest {

	private final CategoriaBusiness categoriaBusiness = new CategoriaBusiness();
	private static Categoria categoria;

	@BeforeClass
	public static void inicioClase() {
		System.out.println("Inicio de la clase");
	}

	@AfterClass
	public static void finClase() {
		System.out.println("Fin de la clase");
	}

	@Before
	public void inicioMetodo() {
		System.out.println("Inicio Metodo");
	}

	@After
	public void finMetodo() {
		System.out.println("Fin Metodo");
	}

	@Test
	public void a_insertar() {
		try {
			System.out.println("Método Insertar");
			//TODO Completar metodo
			
			//instanciando una categoria
			categoria = new Categoria();
			
			//asignar un nombre de categoria
			categoria.setNombre("Categoria JUnit");
			
			//invocar al método
			categoriaBusiness.insertar(categoria);
			
			//Punto de verificación
			Assert.assertTrue(categoria.getIdCategoria() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void b_actualizar() {
		try {
			System.out.println("Método Actualiza");
			//TODO Completar metodo
			
			//modificar el nombre de la categoria
			categoria.setNombre("Categoria JUnit actualizada");
			
			//invocar al método actualizar
			categoriaBusiness.actualizar(categoria);
			
			//punto de verificación
			Assert.assertTrue(categoria.getIdCategoria() > 0);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void c_obtener() {
		try {
			System.out.println("Método Obtener");
			//TODO Completar metodo
			
			//invocar al método obtener
			Categoria categoriaBuscada =
					categoriaBusiness
						.obtener(categoria.getIdCategoria());
			
			//realizar el punto de verificación
			Assert.assertNotNull(categoriaBuscada);
			
			System.out.println("ID: " + categoriaBuscada.getIdCategoria());
			System.out.println("Nombre: " + categoriaBuscada.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void d_listar() {
		try {
			System.out.println("Método Listar");
			//TODO Completar metodo
			
			//invocar al método listar
			List<Categoria> lista = 
					categoriaBusiness.listar();
			
			//realizar punto de verificación
			Assert.assertTrue(lista.size() > 0);
			
			for (Categoria categoria : lista) {
				System.out.println("ID: " + categoria.getIdCategoria());
				System.out.println("Nombre: " + categoria.getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void e_eliminar() {
		try {
			System.out.println("Método Eliminar");
			//TODO Completar metodo
			
			//invocar al método eliminar
			categoriaBusiness.eliminar(categoria);
			
			Categoria categoriaBuscada =
					categoriaBusiness
						.obtener(categoria.getIdCategoria());
			
			//punto de verificación
			Assert.assertNull(categoriaBuscada);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
