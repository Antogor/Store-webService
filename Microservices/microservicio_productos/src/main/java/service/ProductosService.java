package service;

import java.util.List;

import model.Producto;

public interface ProductosService {
	
	List<Producto> productos();
	double precioProducto(int codigo);
	int actualizar(int codigo, int stock);
	int añadir(Producto p);

}
