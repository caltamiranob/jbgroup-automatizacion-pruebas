package pe.com.test.seleniumwd.fuenteDatos.bean;

public class CategoriaBeanDataProvider {

	private String usuario;
	
	private String clave;
	
	private String nombre;
	
	private String valorEsperado;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValorEsperado() {
		return valorEsperado;
	}

	public void setValorEsperado(String valorEsperado) {
		this.valorEsperado = valorEsperado;
	}

	@Override
	public String toString() {
		return "CategoriaBeanDataProvider [usuario=" + usuario + ", clave=" + clave + ", nombre=" + nombre
				+ ", valorEsperado=" + valorEsperado + "]";
	}
	
}
