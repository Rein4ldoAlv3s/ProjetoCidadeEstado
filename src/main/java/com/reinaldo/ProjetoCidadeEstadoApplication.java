package com.reinaldo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.domain.Cidade;
import com.reinaldo.domain.Estado;
import com.reinaldo.repositories.CidadeRepository;
import com.reinaldo.repositories.EstadoRepository;

@SpringBootApplication
public class ProjetoCidadeEstadoApplication implements CommandLineRunner{

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoCidadeEstadoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estado e1 = new Estado(null, "Goiás");
		Cidade c1 = new Cidade(null, "Goiânia", e1);
		Cidade c2 = new Cidade(null, "Pirenópolis", e1);
		
		estadoRepository.saveAll(Arrays.asList(e1));
		cidadeRepository.saveAll(Arrays.asList(c1, c2));
		
	}

}
