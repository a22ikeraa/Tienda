package tienda;

import java.util.ArrayList;

public class LineaPedido {
	private int idPedido;
	private int idcliente;
	private int cantidad;
	public LineaPedido(int idPedido, int idcliente, int cantidad) {
		this.idPedido = idPedido;
		this.idcliente = idcliente;
		this.cantidad = cantidad;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
