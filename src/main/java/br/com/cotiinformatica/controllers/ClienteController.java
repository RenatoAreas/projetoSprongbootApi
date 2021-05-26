package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dto.ClienteCadastroDTO;
import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.repositories.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@RequestMapping(value = "/api/cliente", method = RequestMethod.POST)
	public String cadastroCliente(@RequestBody ClienteCadastroDTO dto) {
		
		try {
			
			Cliente cliente = new Cliente();
			
			cliente.setNome(dto.getNome());
			cliente.setEmail(dto.getEmail());
			cliente.setCpf(dto.getCpf());
			
			repository.saveOrUpdate(cliente);
			
			return "Cliente cadastrado com sucesso !";
		}
		catch(Exception e){
			
			return "Erro" + e.getMessage();
			
		}
	}

}
