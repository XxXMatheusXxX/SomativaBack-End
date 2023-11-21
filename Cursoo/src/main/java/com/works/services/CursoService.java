package com.works.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.works.entities.Curso;
import com.works.repository.CursoRepository;

@Service
public class CursoService {
	private final CursoRepository CursoRepository;
	

	@Autowired
	public CursoService(CursoRepository CursoRepository) {
		this.CursoRepository = CursoRepository;
	}

	public List<Curso> getAllCursos() {
		return CursoRepository.findAll();
	}

	public Curso getCursoById(Long id) {
		Optional<Curso> Curso = CursoRepository.findById(id);
		return Curso.orElse(null);
	}

	public Curso saveCurso(Curso Curso) {
		return CursoRepository.save(Curso);
	}

	public Curso changeCurso(Long id, Curso changeU) {
		Optional<Curso> existeCurso = CursoRepository.findById(id);
		if (existeCurso.isPresent()) {
			changeU.setId(id);
			return CursoRepository.save(changeU);
		}
		return null;
	}

	public boolean deleteCurso(Long id) {
		Optional<Curso> existeCurso= CursoRepository.findById(id);
		if (existeCurso.isPresent()) {
			CursoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}

