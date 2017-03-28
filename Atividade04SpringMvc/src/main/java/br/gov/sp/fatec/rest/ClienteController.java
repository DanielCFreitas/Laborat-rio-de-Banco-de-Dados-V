package br.gov.sp.fatec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.service.CrudService;
import br.gov.sp.fatec.view.View;

@RestController
public class ClienteController {

	@Autowired
	private CrudService<Cliente> clienteService;

	public void setClienteService(CrudService<Cliente> clienteService) {
		this.clienteService = clienteService;
	}

	@RequestMapping(name = "/cliente/add", method = RequestMethod.POST)
	public ResponseEntity<Void> addCliente(@RequestBody Cliente cliente, UriComponentsBuilder uCompBuilder) {
		clienteService.salvar(cliente);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uCompBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(name = "/cliente/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@JsonView(View.Main.class)
	public ResponseEntity<List<Cliente>> allCliente() {
		List<Cliente> listaDeClientes = clienteService.buscarTodos();

		if (listaDeClientes.isEmpty()) {
			
			return new ResponseEntity<List<Cliente>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Cliente>>(listaDeClientes, HttpStatus.OK);
	}
}
