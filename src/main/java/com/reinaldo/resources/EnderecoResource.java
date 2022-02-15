package com.reinaldo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinaldo.domain.Endereco;
import com.reinaldo.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		Endereco obj = enderecoService.listar(id);
		return ResponseEntity.ok().body(obj);
	}
}
