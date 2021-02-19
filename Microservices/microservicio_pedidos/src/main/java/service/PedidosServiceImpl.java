package service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Pedido;
import repository.PedidosJpaRepository;

@Service
public class PedidosServiceImpl implements PedidosService {
	private String url="http://servicio-productos/producto/";
	
	@Autowired
	PedidosJpaRepository repository;
	
	@Autowired
	RestTemplate template;
	

	@Override
	public List<Pedido> pedidos() {
		return repository.findAll();
	}

	@Override
	public void anadirPedido(Pedido p) {
		//template.put(url+p.getCodigoProducto()+"/"+p.getUnidades(), Pedido.class);
		double precio = template.getForObject(url+"{codigo}", Double.class, p.getCodigoProducto());
		p.setTotal(precio * p.getUnidades());
		p.setFechaPedido(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
		
		template.put(url+"/{codigo}/{unidades}", null, p.getCodigoProducto(), p.getUnidades());		
		repository.save(p);
	}

}
