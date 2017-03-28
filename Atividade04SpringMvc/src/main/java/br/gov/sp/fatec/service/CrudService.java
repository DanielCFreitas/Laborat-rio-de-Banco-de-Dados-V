package br.gov.sp.fatec.service;

import java.util.List;

public interface CrudService<Entity> {

	public void salvar(Entity entity);

	public Entity buscarPorId(Long id);

	public List<Entity> buscarTodos();

	public void deletar(Long id);

}
