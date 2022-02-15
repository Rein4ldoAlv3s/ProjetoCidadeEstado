package com.reinaldo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.domain.Endereco;
import com.reinaldo.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco listar(Integer id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);
		return obj.orElse(null);
	}
}
