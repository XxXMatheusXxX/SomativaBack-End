package com.works.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.works.entities.Curso;
import com.works.services.CursoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Curso", description = "API REST DE GERENCIAMENTO DE CURSOS")
@RestController
@RequestMapping("/Curso")

public class CursoController {

	private final CursoService CursoService;

	@Autowired
	public CursoController(CursoService CursoService) {
		this.CursoService = CursoService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Curso por ID")
	public ResponseEntity<Curso> buscaCursoControlId(@PathVariable Long id) {
		Curso Curso = CursoService.getCursoById(id);
		if (Curso != null) {
			return ResponseEntity.ok(Curso);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "apresenta todos os Cursos")
	public ResponseEntity<List<Curso>> buscaTodasLigacoesControl() {
		List<Curso> Curso = CursoService.getAllCursos();
		return ResponseEntity.ok(Curso);
	}

	@PostMapping
	@Operation(summary = "cadastra os Cursos")
	public ResponseEntity<Curso> saveCursoControl(@RequestBody @Valid Curso Curso) {
		Curso saveCurso = CursoService.saveCurso(Curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCurso);
	}

	@PutMapping("/{id}")
	@Operation(summary = "altera os Cursos")
	public ResponseEntity<Curso> alteraCursoControl(@PathVariable Long id, @RequestBody @Valid Curso Curso) {
		Curso alteraCurso = CursoService.changeCurso(id, Curso);

		if (alteraCurso != null) {
			return ResponseEntity.ok(Curso);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "deleta os Cursos")
	public ResponseEntity<String> deleteCursoControl(@PathVariable Long id) {
		boolean delete = CursoService.deleteCurso(id);
		if (delete) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}

