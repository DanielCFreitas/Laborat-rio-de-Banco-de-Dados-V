package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
