package com.neyra.denunciaapi.service;

import java.awt.print.Pageable;
import java.util.List;

import com.neyra.denunciaapi.entity.Denuncia;

public interface DenunciaService {
	public List<Denuncia> findAll(Pageable page);
	public Denuncia findById(int id);
	public Denuncia findByTitulo(String nombre);
	public List<Denuncia> findByTituloContaining(String nombre, Pageable page);
	public Denuncia create(Denuncia obj);
	public Denuncia update(Denuncia obj);
	public int delete(int id);
	List<Denuncia> findByTituloContaining(String nombre, org.springframework.data.domain.Pageable page);
}
