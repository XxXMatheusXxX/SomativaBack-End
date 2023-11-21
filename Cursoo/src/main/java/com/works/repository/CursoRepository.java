package com.works.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.works.entities.Curso;

public interface  CursoRepository extends JpaRepository<Curso,Long> {

}