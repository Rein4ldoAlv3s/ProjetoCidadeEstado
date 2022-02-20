package com.reinaldo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.domain.Cidade;
import com.reinaldo.domain.Endereco;
import com.reinaldo.domain.Estado;
import com.reinaldo.repositories.CidadeRepository;
import com.reinaldo.repositories.EnderecoRepository;
import com.reinaldo.repositories.EstadoRepository;

@SpringBootApplication
public class ProjetoCidadeEstadoApplication implements CommandLineRunner{

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoCidadeEstadoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estado est1 = new Estado(null, "Goiás");
		Cidade cid1 = new Cidade(null, "Goiânia", est1);
		
		est1.getCidades().add(cid1);
		
		estadoRepository.save(est1);
		cidadeRepository.save(cid1);
		
		Endereco end1 = new Endereco(null, "Av Papagaios 13", "492", "Qd. 33", "Cerejeiras", "74000000", cid1);
		
		enderecoRepository.save(end1);
	}

}
