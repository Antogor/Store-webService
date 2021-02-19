package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductosService;

@CrossOrigin(origins = "*")
@RestController
public class ProductoController {

	@Autowired
	ProductosService service;
	
	@GetMapping(value = "productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> productos(){
		return new ResponseEntity<List<Producto>>(service.productos(), null, HttpStatus.OK);
	}
	
	@GetMapping(value = "producto/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> precioProducto(@PathVariable("codigo")int codigo){
		return new ResponseEntity<Double>(service.precioProducto(codigo), null, HttpStatus.OK);
	}
	
	@PutMapping(value = "producto/{codigo}/{unidades}")
	public ResponseEntity<Void> actualizar(@PathVariable("codigo")int codigo, @PathVariable("unidades")int unidades){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Actualizacion", service.actualizar(codigo, unidades) == 0? "actualizacion completada": "no hay stock suficiente");
		return new ResponseEntity<Void>(null, headers, HttpStatus.OK);
	}
	
	@PostMapping(value = "producto", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> añadir(@RequestBody Producto p) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("AnadirProducto", service.añadir(p) == 0?"producto añadido":"el producto ya existe");
		return new ResponseEntity<Void>(null, headers, HttpStatus.OK);
	}
}
