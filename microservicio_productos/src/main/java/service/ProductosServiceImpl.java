package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Producto;
import repository.ProductosJpaRepository;

@Service
public class ProductosServiceImpl implements ProductosService {
	
	@Autowired
	ProductosJpaRepository repository;

	@Override
	public List<Producto> productos() {
		return repository.findAll();
	}

	@Override
	public double precioProducto(int codigo) {
		Producto p = repository.findById(codigo).orElse(new Producto());
		return p.getPrecioUnitario();
	}

	@Override
	public int actualizar(int codigo, int stock) {
		Producto p = repository.findById(codigo).orElse(new Producto());
		int res = 1;
		if (p.getStock() > stock) {
			p.setStock(p.getStock() - stock);
			repository.saveAndFlush(p);
			res = 0;
		}
		return res;
	}

	@Override
	public int añadir(Producto p) {
		Producto pro = repository.findById(p.getCodigoProducto()).orElse(null);
		int res = 1;
		if (pro == null) {
			repository.save(p);
			res = 0;
		}
		return res;
	}

}
