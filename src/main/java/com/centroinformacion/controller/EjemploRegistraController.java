package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Ejemplo;
import com.centroinformacion.service.EjemploService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/ejemplo")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EjemploRegistraController {

	
	@Autowired
	private EjemploService ejemploService;
	
	@GetMapping()
	public ResponseEntity<List<Ejemplo>> listaEjemplo(){
		List<Ejemplo> lstSalida = ejemploService.listaEjemplo();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody Ejemplo obj){
		HashMap<String, Object> salida = new HashMap<>();
		
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());
		obj.setEstado(AppSettings.ACTIVO);
		
		Ejemplo objSalida = ejemploService.insertaActualizaEjemplo(obj);
		if (objSalida == null) {
			salida.put("mensaje", "Error en el registro");
		}else {
			salida.put("mensaje", "Se registró el ejemplo con el ID >>> " + objSalida.getIdEjemplo());
		}
		
		return ResponseEntity.ok(salida);
	}
	
	
}



