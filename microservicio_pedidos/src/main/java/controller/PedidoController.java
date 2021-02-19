package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Pedido;
import service.PedidosService;

@CrossOrigin(origins = "*")
@RestController
public class PedidoController {

	@Autowired
	PedidosService service;
	
	@GetMapping(value = "pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pedido>> pedidos(){
		return new ResponseEntity<List<Pedido>>(service.pedidos(), null, HttpStatus.OK);
	}
	
	@PostMapping(value = "pedido", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> añadirPedido(@RequestBody Pedido p){
		HttpHeaders header = new HttpHeaders();
		header.add("PedidoAnadido", p.getCodigoProducto()+"");
		service.anadirPedido(p);
		return new ResponseEntity<Void>(null, header, HttpStatus.OK);
	}
}
