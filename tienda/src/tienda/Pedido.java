package tienda;

import java.util.ArrayList;

public class Pedido {
	private int id;
	private String fecha;
	private String dniCliente;
	private ArrayList<Producto> productosPedido;
	
	public Pedido(int id, String fecha, String dniCliente ,ArrayList<Producto> productosPedido ) {
		this.id = id;
		this.fecha = fecha;
		this.dniCliente = dniCliente;
		this.productosPedido = productosPedido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedidos del usuario con DN: " + dniCliente + "\t\tID Pedido: " + id+"\n");
		builder.append("Fecha de pedido: " + fecha+ "\n") ;
		builder.append("Productos: \n");
		for(Producto producto : productosPedido) {
			builder.append("\t" + producto.getNombre() + "\n");
		}
		
		return builder.toString();
	}
	
	

}
