package com.neyra.denunciaapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neyra.denunciaapi.entity.Denuncia;
import com.neyra.denunciaapi.repository.DenunciaRepository;
import com.neyra.denunciaapi.service.DenunciaService;


@Service
public class DenunciaServiceImpl implements DenunciaService {

	
	@Autowired
	private DenunciaRepository repository;
	
	

	@Override
	@Transactional(readOnly = true)
	public Denuncia findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Denuncia findByTitulo(String nombre) {
		try {
			return repository.findByTitulo(nombre);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	@Override
	@Transactional
	public Denuncia create(Denuncia obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	@Override
	@Transactional
	public Denuncia update(Denuncia obj) {
		try {
			Denuncia denunciaDb=repository.findById(obj.getId()).orElse(null);
			if(denunciaDb==null) {
				return null;
			}
			denunciaDb.setTitulo(obj.getTitulo());
		    //docenteDb.setApellidopaterno(obj.getApellidopaterno());
			//docenteDb.setApellidomaterno(obj.getApellidomaterno());
			
			return repository.save(denunciaDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Denuncia denunciaDb=repository.findById(id).orElse(null);
			if(denunciaDb==null) {
				return 0;
			}else {
				repository.delete(denunciaDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<Denuncia> findAll(java.awt.print.Pageable page) {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Denuncia> findByTituloContaining(String nombre, java.awt.print.Pageable page) {
		try {
			return repository.findByTituloContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	

	

	

}