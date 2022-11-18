package tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionarTienda {
	private Connection connection;

	public GestionarTienda() {}
	
	private void startConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/tienda" , "uadmin" , "abc123.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Cliente informacionCliente(String dni) {
		String query = "SELECT * FROM clientes WHERE dni = ?";
		String DNI =  " ";
		String name = " ";
		Cliente cliente  = new Cliente(DNI, name);
		
		startConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,dni);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				 DNI = resultSet.getString("dni");
				 name = resultSet.getString("nombre");
			}
			 cliente = new Cliente(DNI, name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		
		return cliente;
		
	}
	
	public  void pedidosCliente(String dni) {
		String queryConseguirIdProducto= "SELECT id FROM pedidos WHERE dniCliente = ? ";
		String queryConseguirIdPedido = "select distinct idProducto FROM lineaPedidos where idpedido = ?";
		String queryConsegirNombreProducto = "select nombre FROM producto where id = ?";
		
		ArrayList<Integer> idsProductos = new ArrayList<Integer>();
		ArrayList<Integer>idsPedido = new ArrayList<Integer>();
		ArrayList<String>NombreProductos = new ArrayList<String>();
		
		startConnection();
		
		try {
			//Consegir las ids de los productos
			PreparedStatement sentencia = connection.prepareStatement(queryConseguirIdProducto);
			sentencia.setString(1,dni);
			
			ResultSet resultSet = sentencia.executeQuery();
			
			//Almacenamos las ids
			while(resultSet.next()) {
				idsProductos.add(resultSet.getInt("id"));
			}
			
			sentencia = connection.prepareStatement(queryConseguirIdPedido);
			for(int i = 0 ; i < idsProductos.size() ; i++) {
				sentencia.setInt(i+1, idsProductos.get(i));
				
				resultSet = sentencia.executeQuery();
				//Almacenar las ids de los pedidos 
				while(resultSet.next()) {
					idsPedido.add(resultSet.getInt("idProducto"));
				}
			}
			
			sentencia = connection.prepareStatement(queryConsegirNombreProducto);
			for(int i = 0 ; i < idsProductos.size() ; i++) {
				sentencia.setInt(i+1,idsPedido.get(i));
				
				resultSet = sentencia.executeQuery();
				//Almacenar los nombres de los productos
				while(resultSet.next()) {
					NombreProductos.add(resultSet.getString("Nombre"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		
	}
}
