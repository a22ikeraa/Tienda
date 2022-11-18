package tienda;

public class Producto {
	private int id;
	private String descripcion;
	private double precio;
	private String nombre;
	
	public Producto(int id, String descripcion, double precio, String nombre) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
